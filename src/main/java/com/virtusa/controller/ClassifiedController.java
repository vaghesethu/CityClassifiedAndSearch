package com.virtusa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.virtusa.bean.Classified;
import com.virtusa.service.ClassifiedService;

@Controller
public class ClassifiedController {
	private ClassifiedService classifiedService;
	
	public ClassifiedController(ClassifiedService classifiedService) {
		super();
		this.classifiedService = classifiedService;
	}
	
	@GetMapping("/postclassified")
	public String postClassifiedForm() {
		return "postclassified";
	}
	
	@PostMapping("/postclassified")
	public String postClassified(@ModelAttribute("classified") Classified classified) {
		classifiedService.createOrUpdateClassified(classified);
		return "redirect:/postclassified?success";
	}
	
	@GetMapping("/editclassified")
	public String editClassifiedForm() {
		return "editclassified";
	}
	
	@PostMapping("/editclassified")
	public String editClassified(@ModelAttribute("classified") Classified classified) {
		classifiedService.createOrUpdateClassified(classified);
		return "redirect:/editclassified?success";
	}
	
	//test
	@GetMapping("test")
	public String test() {
		System.out.println(classifiedService.getClassifiedByUserId(1));
		return "index";
	}
}
