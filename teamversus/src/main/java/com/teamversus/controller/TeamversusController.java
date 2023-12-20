package com.teamversus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.teamversus.logic.Tabla;
import com.teamversus.service.TeamversusService;

@Controller
public class TeamversusController {

	@Autowired
	private final TeamversusService teamversusService;

	public TeamversusController(TeamversusService teamversusService) {
		this.teamversusService = teamversusService;
	}

	@GetMapping("/")
	public String index(Model model) {
		teamversusService.eliminarEquipo();
		model.addAttribute("combates", teamversusService.findCombates());
		return "index";
	}

	@GetMapping("/tablaTipos")
	public String tablaTiposPage(Model model) {
		Tabla tabla = new Tabla();
		model.addAttribute("tabla", tabla);
		return "tablaTipos";
	}

	@GetMapping("/listaPokemon")
	public String listarPokemonPage(Model model) {
		model.addAttribute("listaPokemon", teamversusService.findListaPokemon());
		model.addAttribute("equipo", teamversusService.findEquipo());
		return "listaPokemon";
	}

	@PostMapping("/addPokemon/{pokemonId}")
	public String addPokemon(@PathVariable int pokemonId) {
		teamversusService.addPokemon(pokemonId);
		return "redirect:/listaPokemon";
	}

	@PostMapping("/deletePokemon/{pokemonId}")
	public String deletePokemon(@PathVariable int pokemonId) {
		teamversusService.deletePokemonById(pokemonId);
		return "redirect:/listaPokemon";
	}

}
