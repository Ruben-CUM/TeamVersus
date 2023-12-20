package com.teamversus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.teamversus.service.CombateService;

@Controller
public class CombateController {

	@Autowired
	private final CombateService combateService;

	public CombateController(CombateService combateService) {
		this.combateService = combateService;
	}

//	@Transactional
	@GetMapping("/combatePreview")
	public String combatePreviewPage(Model model) {
		combateService.createCombate();
		model.addAttribute("combate", combateService.findUltimoCombate());
		return "combatePreview";
	}

	@GetMapping("/combate")
	public String combatePage(Model model) {
		model.addAttribute("combate", combateService.findUltimoCombate());
		return "combate";
	}

	@PostMapping("/procesarTurno/{indiceJugador}")
	public String procesarTurno(@PathVariable int indiceJugador, @RequestParam(name = "indiceRival") int indiceRival,
			RedirectAttributes redirectAttributes) {
		int[] indices = combateService.procesarTurno(indiceJugador, indiceRival);
		System.out.println(indices[0]+ " "+indices[1]);
		redirectAttributes.addFlashAttribute("indices", indices);
		return "redirect:/combateSucesivo";
	}

	@GetMapping("/combateSucesivo")
	public String combateSucesivoPage(Model model, @ModelAttribute("indices") int[] indices) {
		model.addAttribute("indices", indices);
		System.out.println(indices[0]+ " "+indices[1]);
		model.addAttribute("combate", combateService.findUltimoCombate());
		return "combateSucesivo";
	}
}
