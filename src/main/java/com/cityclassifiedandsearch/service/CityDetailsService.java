package com.cityclassifiedandsearch.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cityclassifiedandsearch.bean.CityDetails;
import com.cityclassifiedandsearch.repo.CityDetailsRepository;

@Service
public class CityDetailsService {
	private CityDetailsRepository cityDetailsRepository;
	
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
   
   public CityDetails createOrUpdateCityDetails(CityDetails cityDetails) {
       Optional<CityDetails> cityDetailsExists = cityDetailsRepository.findById(cityDetails.getCityId());
       if(cityDetailsExists.isPresent()) {
    	   CityDetails newCityDetails = cityDetailsExists.get();
    	   newCityDetails.setName(cityDetails.getName());
    	   newCityDetails.setCity(cityDetails.getCity());
    	   newCityDetails.setCategory(cityDetails.getCategory());
    	   newCityDetails.setAddress(cityDetails.getAddress());
    	   newCityDetails.setLink(cityDetails.getLink());
    	   return cityDetailsRepository.save(newCityDetails);
       }
       else {
           return cityDetailsRepository.save(cityDetails);
       }
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
}
