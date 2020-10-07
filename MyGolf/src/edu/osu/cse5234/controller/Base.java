package edu.osu.cse5234.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class Base {

	@RequestMapping(method = RequestMethod.GET)
	public String forwardHome(HttpServletRequest request, HttpServletResponse response) {
		return "Home";
	}
	
	@RequestMapping(path = "/about", method = RequestMethod.GET)
	public String forwardAboutUs(HttpServletRequest request, HttpServletResponse response) {
		return "AboutUs";
	}
	
	@RequestMapping(path = "/contact", method = RequestMethod.GET)
	public String forwardContactUs(HttpServletRequest request, HttpServletResponse response) {
		return "ContactUs";
	}	
}