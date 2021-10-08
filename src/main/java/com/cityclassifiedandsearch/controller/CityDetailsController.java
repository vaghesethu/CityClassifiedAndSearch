package com.cityclassifiedandsearch.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.cityclassifiedandsearch.bean.CityDetails;
import com.cityclassifiedandsearch.service.CityDetailsService;

@Controller
public class CityDetailsController {
	private CityDetailsService cityDetailsService;
	
	public CityDetailsController(CityDetailsService cityDetailsService) {
		super();
		this.cityDetailsService = cityDetailsService;
	}
	
	@GetMapping("/postcitydetails")
	public String postCityDetailsForm() {
		return "postcitydetails";
	}
	
	@PostMapping("/postcitydetails")
	public String postCityDetails(@ModelAttribute("cityDetails") CityDetails cityDetails) {
		cityDetailsService.createOrUpdateCityDetails(cityDetails);
		return "redirect:/postcitydetails?success";
	}
	
	@GetMapping("/editcitydetails")
	public String editCityDetailsForm() {
		return "editcitydetails";
	}
	
	@PostMapping("/editcitydetails")
	public String editCityDetails(@ModelAttribute("cityDetails") CityDetails cityDetails) {
		cityDetailsService.createOrUpdateCityDetails(cityDetails);
		return "redirect:/editcitydetails?success";
	}
}
