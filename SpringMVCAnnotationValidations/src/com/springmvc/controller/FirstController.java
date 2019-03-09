package com.springmvc.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.ui.Model;

@Controller
public class FirstController {

	@RequestMapping(value = {"/", "/first"}, method = RequestMethod.GET)
	public String FirstHello(Model model)
	{
		model.addAttribute("message", "Hello first controller");
		
		return "firsthello";
	}
}
