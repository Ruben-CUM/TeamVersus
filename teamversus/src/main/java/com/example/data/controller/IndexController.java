package com.example.data.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
	
	@GetMapping("/combate")
	public String combatePage (Model model) {
		return "combate";
	}

	public String index() {
		return "index";
	}


	public IndexController() {
		// TODO Auto-generated constructor stub
		System.out.println("\t Builder of " + this.getClass().getSimpleName());
	}
}
