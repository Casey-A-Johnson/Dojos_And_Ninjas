package com.caseyjohnson.dojosandninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.hibernate.engine.jdbc.spi.ResultSetReturn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.caseyjohnson.dojosandninjas.models.Dojo;
import com.caseyjohnson.dojosandninjas.models.Ninja;
import com.caseyjohnson.dojosandninjas.services.DojoService;

@Controller
public class HomeController {
	
	@Autowired
	private DojoService dojoService;
	
	@RequestMapping("/")
	public String index(@ModelAttribute("dojo") Dojo dojo, Model model) {
		List<Dojo> allDojos = dojoService.allDojos();
		model.addAttribute("dojoList", allDojos);
//		model.addAttribute("dojo", new Dojo());
		System.out.println("random string");
		return "dashboard.jsp";
	}
	
	@PostMapping("/add/dojo")
	public String createDojo(
			@Valid
			@ModelAttribute("dojo") Dojo dojo,
			BindingResult result,
			Model model
			) {
		if(result.hasErrors()) {
			List<Dojo> allDojos = dojoService.allDojos();
			model.addAttribute("dojoList", allDojos);
			return "dashboard.jsp";
		} else {
			dojoService.createDojo(dojo);
			return "redirect:/";
		}
	}
	
	@RequestMapping("/add/ninja")
	public String renderCreateNinja(@ModelAttribute("ninja")Ninja ninja, Model model) {
		List<Dojo> allDojos = dojoService.allDojos();
		model.addAttribute("dojoList", allDojos);
		return "createNinja.jsp";
	}
	
	@PostMapping("/add/ninja")
	public String createNinja(
			@Valid
			@ModelAttribute("ninja") Ninja ninja,
			BindingResult result,
			Model model
			) {
		if(result.hasErrors()) {
			List<Dojo> allDojos = dojoService.allDojos();
			model.addAttribute("dojoList", allDojos);
			return "createNinja.jsp";
		} else {
			dojoService.createNinja(ninja);
			return "redirect:/";
		}
	}
	
	@RequestMapping("/dojos/{id}")
	public String oneDojo(@PathVariable("id")Long id,Model model) {
		Dojo foundDojo = dojoService.oneDojo(id);
		model.addAttribute("oneDojo", foundDojo);
		return "details.jsp";
	}
	
	
}
