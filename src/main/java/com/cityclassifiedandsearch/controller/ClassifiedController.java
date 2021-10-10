package com.cityclassifiedandsearch.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.cityclassifiedandsearch.repo.ClassifiedRepository;
import com.cityclassifiedandsearch.service.ClassifiedService;

@Controller
public class ClassifiedController {
	@Autowired
	private ClassifiedService classifiedService;
	@Autowired
	ClassifiedRepository classifiedrepository;
	
	public ClassifiedController(ClassifiedService classifiedService) {
		super();
		this.classifiedService = classifiedService;
	}
	
	@GetMapping("/postclassified")
	public String postClassifiedForm() {
		return "postclassified";
	}
	
	@PostMapping("/user/postclassified")
	public String postClassified(@RequestParam("classifiedCategory")String classifiedCategory,
			@RequestParam("classifiedTitle")String classifiedTitle,
			@RequestParam("description")String description,
			@RequestParam("file") MultipartFile image) {
		try {
			classifiedService.createClassified(classifiedCategory,classifiedTitle,description,image);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "welcome";
	}
	
	@GetMapping("/editclassified")
	public String editClassifiedForm() {
		return "editclassified";
	}
	
	@PutMapping("/user/editclassified/{id}")
	public String editClassified(@PathVariable("id") int classifiedId,@RequestParam("classifiedCategory")String classifiedCategory,
			@RequestParam("classifiedTitle")String classifiedTitle,
			@RequestParam("description")String description,
			@RequestParam("file") MultipartFile image) throws IOException {
		classifiedService.UpdateClassified(classifiedId,classifiedCategory,classifiedTitle,description,image);
		return "myclassified";
	}
	
	@DeleteMapping("/deleteclassified/{id}")
	public void deleteCityDetails(@PathVariable("id")int classifiedId) {
		classifiedService.deleteClassifiedById(classifiedId);
	}
	
	@PutMapping("/admin/approve/{id}")
	public String approval(@PathVariable("id") int classifiedId) {
		classifiedService.approve(classifiedId);
		return "redirect:/approve?success";	
	}
	
	//test
	@GetMapping("test")
	public String test() {
		System.out.println(classifiedService.getClassifiedByUserId(1));
		return "index";
	}
}
