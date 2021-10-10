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

import com.cityclassifiedandsearch.bean.CityDetails;
import com.cityclassifiedandsearch.service.CityDetailsService;
import com.cityclassifiedandsearch.service.UserServiceImpl;

@Controller
public class CityDetailsController {
	@Autowired
	private CityDetailsService cityDetailsService;
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@GetMapping("/index2")
	public String index2(Model model) {
		model.addAttribute("cityDetails", cityDetailsService.getAllCityDetails());
		return "index2";
	}
	
	@GetMapping("/viewcitydetails/{cityId}")
	public String viewcityDetails(Model model, @PathVariable("cityId") int cityId) {
		CityDetails cityDetails = cityDetailsService.getCityDetailsById(cityId);
		model.addAttribute("cityDetails", cityDetails);
		model.addAttribute("userDetails", userServiceImpl.getUserById(cityDetails.getUserId()));
		return "viewcitydetails";
	}
	
	@GetMapping("/postcitydetails")
	public String postCityDetailsForm() {
		return "postcitydetails";
	}
	
	@PostMapping("/admin/postcitydetails")
	public String postCityDetails(@RequestParam("category")String category,
			@RequestParam("name")String name,
			@RequestParam("address")String address,
			@RequestParam("cityName")String cityName,
			@RequestParam("link")String link,
			@RequestParam("file") MultipartFile image) throws IOException {
		cityDetailsService.createOrUpdateCityDetails(category,name,address,cityName,link,image);
		return "redirect:/editcitydetails?success";
	}
	
	@GetMapping("/editcitydetails")
	public String editCityDetailsForm() {
		return "editcitydetails";
	}
	
	@PutMapping("/admin/editcitydetails")
	public String editCityDetails(@RequestParam("category")String category,
			@RequestParam("name")String name,
			@RequestParam("address")String address,
			@RequestParam("cityName")String cityName,
			@RequestParam("link")String link,
			@RequestParam("file") MultipartFile image) throws IOException {
		cityDetailsService.createOrUpdateCityDetails(category,name,address,cityName,link,image);
		return "redirect:/editcitydetails?success";
	}
	@DeleteMapping("/deletecitydetails/{id}")
	public void deleteCityDetails(@PathVariable("id")int cityId) {
		cityDetailsService.deleteCityDetailsById(cityId);
	}
}
