package com.cityclassifiedandsearch.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
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
	
	@PostMapping("/postclassified")
	public String postClassified(@RequestParam("classifiedCategory")String classifiedCategory,
			@RequestParam("classifiedTitle")String classifiedTitle,
			@RequestParam("description")String description,
			@RequestParam("file") MultipartFile image) {
		try {
			classifiedService.createOrUpdateClassified(classifiedCategory,classifiedTitle,description,image);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "redirect:/postclassified?success";
	}
	
	@GetMapping("/editclassified")
	public String editClassifiedForm() {
		return "editclassified";
	}
	
	/*@PutMapping("/editclassified")
	public String editClassified(@ModelAttribute("classified") Classified classified) {
		classifiedService.createOrUpdateClassified(classified);
		return "redirect:/editclassified?success";
	}*/
	
	//test
	@GetMapping("test")
	public String test() {
		System.out.println(classifiedService.getClassifiedByUserId(1));
		return "index";
	}
}
