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

<<<<<<< Updated upstream
	//@GetMapping("/")
	public String home() {
		return "redirect:/index";
	}

	public IndexController() {

=======
	@GetMapping("/")
	public String index() {
		System.out.println("\t Recojo la peticion. "
				+ "Devuelvo la vista index; "
				+ "index.html esta ubicado en Templates");
		return "index";
	}


	public IndexController() {
		// TODO Auto-generated constructor stub
		System.out.println("\t Builder of " + this.getClass().getSimpleName());
>>>>>>> Stashed changes
	}
}
