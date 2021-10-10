

package com.cityclassifiedandsearch.service;
import com.cityclassifiedandsearch.controller.EmailController;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.cityclassifiedandsearch.bean.CityDetails;
import com.cityclassifiedandsearch.repo.CityDetailsRepository;

@Service
public class CityDetailsService {
	private CityDetailsRepository cityDetailsRepository;
  private EmailController email; 
	
	public CityDetailsService(CityDetailsRepository cityDetailsRepository) {
		super();
		this.cityDetailsRepository = cityDetailsRepository;
	}
	
   public List<CityDetails> getAllCityDetails() {
		List<CityDetails> cityDetails = cityDetailsRepository.findAll();
		if(cityDetails.size() > 0) {
			Collections.reverse(cityDetails);
			return cityDetails;
		} else {
		    return new ArrayList<CityDetails>(); //replace with custom exception(RecordNotFoundException)
		}
    }
	
   public CityDetails getCityDetailsById(int cityDetailsId) {
	   Optional<CityDetails> cityDetails = cityDetailsRepository.findById(cityDetailsId);
	   if(cityDetails.isPresent()) {
		   return cityDetails.get();
	   }
	   else {
		   return null; //replace with custom exception(RecordNotFoundException)
	   }
   }
   
   public List<CityDetails> getCityDetailsByUserId(int userId) {
	   List<CityDetails> cityDetails = cityDetailsRepository.findByUserId(userId);
		if(cityDetails.size() > 0) {
			Collections.reverse(cityDetails);
			return cityDetails;
		} else {
		    return new ArrayList<CityDetails>(); //replace with custom exception(RecordNotFoundException)
		}
   }
   
   public CityDetails createCityDetails(String category,String name,String address,String cityName,String link,MultipartFile image) throws IOException {
          	   CityDetails newCityDetails = new CityDetails();
    	   newCityDetails.setUserId(1);//UserServiceImpl.getCurrentUser().getUserId());
    	   newCityDetails.setName(name);
    	   newCityDetails.setCity(cityName);
    	   newCityDetails.setCategory(category);
    	   newCityDetails.setAddress(address);
    	   newCityDetails.setLink(link);
    	   String filename=StringUtils.cleanPath(image.getOriginalFilename());
    	   if(filename.contains(".."))
    		   System.out.println("not a valid file");
   		   newCityDetails.setCityimage(Base64.getEncoder().encodeToString(image.getBytes()));
        // Call the method EmailSubscription using the private variable "email" mentioned in line 22. eg.: email.EmailSubscription("cityname","address");
    	   return cityDetailsRepository.save(newCityDetails);


      
   }
   
   public void deleteCityDetailsById(int cityDetailsId) {
       Optional<CityDetails> cityDetails = cityDetailsRepository.findById(cityDetailsId);
       if(cityDetails.isPresent()) {
           cityDetailsRepository.deleteById(cityDetailsId);
       }
       else {
           return; // replace with custom exception(RecordNotFoundException)
       }
   }


public CityDetails UpdateCityDetails(int cityId, String category, String name, String address, String cityName, String link,
		MultipartFile image) throws IOException {
	Optional<CityDetails> exist=cityDetailsRepository.findById(cityId);
	if(exist.isPresent()) {
		CityDetails update=exist.get();
		update.setAddress(address);
		update.setName(name);
		update.setCategory(category);
		update.setCity(cityName);
		update.setLink(link);
		update.setCityimage(Base64.getEncoder().encodeToString(image.getBytes()));
		return cityDetailsRepository.save(update);
	}
	return null;
	
}
}
