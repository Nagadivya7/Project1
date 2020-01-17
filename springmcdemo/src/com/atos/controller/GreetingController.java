package com.atos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GreetingController {
	
	@RequestMapping("/")
	public String greet()
	{
		return "index";
	}
	@RequestMapping("/homepage")
	public String home()
	{
		return "home";
	}
	@RequestMapping("/finalpage")
	public String finalpage()
	{
		return "final";
	}
}
