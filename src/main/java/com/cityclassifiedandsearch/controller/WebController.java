package com.cityclassifiedandsearch.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {
	@GetMapping("/template")
	public String template() {
		return "template";
	}
}
