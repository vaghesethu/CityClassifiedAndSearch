package com.cityclassifiedandsearch.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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
