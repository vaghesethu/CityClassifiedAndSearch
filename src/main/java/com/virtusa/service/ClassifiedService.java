package com.virtusa.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.virtusa.bean.Classified;
import com.virtusa.repo.ClassifiedRepository;

@Service
public class ClassifiedService {
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
   
   
   public Classified createOrUpdateClassified(Classified classified) {
       Optional<Classified> classifiedExists = classifiedRepository.findById(classified.getClassifiedId());
       if(classifiedExists.isPresent()) {
    	   Classified newClassified = classifiedExists.get();
    	   newClassified.setClassifiedTitle(classified.getClassifiedTitle());
    	   newClassified.setClassifiedCatgory(classified.getClassifiedCatgory());
    	   newClassified.setDescription(classified.getClassifiedCatgory());
    	   return classifiedRepository.save(newClassified);
       }
       else {
           return classifiedRepository.save(classified);
       }
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
