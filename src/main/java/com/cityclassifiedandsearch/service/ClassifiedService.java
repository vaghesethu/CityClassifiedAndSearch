package com.cityclassifiedandsearch.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.cityclassifiedandsearch.bean.Classified;
import com.cityclassifiedandsearch.repo.ClassifiedRepository;

@Service
public class ClassifiedService {
	@Autowired
	private ClassifiedRepository classifiedRepository;
	
	public ClassifiedService(ClassifiedRepository classifiedRepository) {
		super();
		this.classifiedRepository = classifiedRepository;
	}
	
   public List<Classified> getAllClassifieds() {
		List<Classified> classifieds = classifiedRepository.findAll();
		if(classifieds.size() > 0) {
			Collections.reverse(classifieds);
			return classifieds;
		} else {
		    return new ArrayList<Classified>(); //replace with custom exception(RecordNotFoundException)
		}
    }
	
   public Classified getClassifiedById(int classifiedId) {
	   Optional<Classified> classified = classifiedRepository.findById(classifiedId);
	   if(classified.isPresent()) {
		   return classified.get();
	   }
	   else {
		   return null; //replace with custom exception(RecordNotFoundException)
	   }
   }
   
   public List<Classified> getClassifiedByUserId(int userId) {
	   List<Classified> classifieds = classifiedRepository.findByUserId(userId);
		if(classifieds.size() > 0) {
			Collections.reverse(classifieds);
			return classifieds;
		} else {
		    return new ArrayList<Classified>(); //replace with custom exception(RecordNotFoundException)
		}
   }
   
   
   public Classified createOrUpdateClassified(String classifiedCategory,
			String classifiedTitle,String description,MultipartFile image) throws IOException {
       	   Classified newClassified = new Classified();
    	   newClassified.setUserId(1);
    	   newClassified.setClassifiedTitle(classifiedTitle);
    	   newClassified.setClassifiedCatgory(classifiedCategory);
    	   newClassified.setDescription(description);
    	   String filename=StringUtils.cleanPath(image.getOriginalFilename());
    	   if(filename.contains(".."))
    		   System.out.println("not a valid file");
   		   newClassified.setClassifiedimage(Base64.getEncoder().encodeToString(image.getBytes()));
    	  
           return classifiedRepository.save(newClassified);
     
   }
   
   public void deleteClassifiedById(int classifiedId) {
       Optional<Classified> classified = classifiedRepository.findById(classifiedId);
       if(classified.isPresent()) {
           classifiedRepository.deleteById(classifiedId);
       }
       else {
           return; // replace with custom exception(RecordNotFoundException)
       }
   } 
}
