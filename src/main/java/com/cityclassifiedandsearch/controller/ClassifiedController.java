package com.cityclassifiedandsearch.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.cityclassifiedandsearch.bean.Classified;
import com.cityclassifiedandsearch.service.ClassifiedService;
import com.cityclassifiedandsearch.service.UserServiceImpl;

@Controller
public class ClassifiedController {
	@Autowired
	private ClassifiedService classifiedService;
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@GetMapping("/index")
	public String index(Model model) {
		model.addAttribute("classifieds", classifiedService.getAllClassifieds());
		return "index";
	}
	
	@GetMapping("/viewclassified/{classifiedId}")
	public String viewClassified(Model model, @PathVariable("classifiedId") int classifiedId) {
		Classified classified = classifiedService.getClassifiedById(classifiedId);
		model.addAttribute("classified", classified);
		model.addAttribute("userdetails", userServiceImpl.getUserById(classified.getUserId()));
		return "viewclassified";
	}
	
	@GetMapping("/user/postclassified")
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
	
	@GetMapping("/user/editclassified")
	public String editClassifiedForm() {
		return "editclassified";
	}
	
	@PutMapping("/user/editclassified/{id}")
	public String editClassified(@PathVariable("id") int classifiedId,@RequestParam("classifiedCategory")String classifiedCategory,
			@RequestParam("classifiedTitle")String classifiedTitle,
			@RequestParam("description")String description,
			@RequestParam("file") MultipartFile image) throws IOException {
		classifiedService.UpdateClassified(classifiedId,classifiedCategory,classifiedTitle,description,image);
		return "redirect:/editclassified?success";
	}
	
	@DeleteMapping("/deleteclassified/{id}")
	public void deleteCityDetails(@PathVariable("id")int classifiedId) {
		classifiedService.deleteClassifiedById(classifiedId);
	}
  
	@GetMapping("/admin/approve")
	public String classifiedApproval() {
		return "approve";
	}
	
	@PutMapping("/admin/approve/{id}")
	public String approval(@PathVariable("id") int classifiedId) {
		classifiedService.approve(classifiedId);
		return "redirect:/approve?success";	
	}
}
