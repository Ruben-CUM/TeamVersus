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

import com.teamversus.logic.DatosCombate;
import com.teamversus.service.CombateService;

@Controller
public class CombateController {

	@Autowired
	private final CombateService combateService;

	public CombateController(CombateService combateService) {
		this.combateService = combateService;
	}

	@GetMapping("/combatePreview")
	public String combatePreviewPage(Model model) {
		combateService.createCombate();
		model.addAttribute("combate", combateService.findUltimoCombate());
		return "combatePreview";
	}

	@GetMapping("/combate")
	public String combatePage(Model model) {
		DatosCombate datosCombate = combateService.procesarTurno(0, 0);
		model.addAttribute("combate", combateService.findUltimoCombate());
		model.addAttribute("datosCombate", datosCombate);
		return "combate";
	}

	@PostMapping("/procesarTurno/{indiceJugador}")
	public String procesarTurno(@PathVariable int indiceJugador, @RequestParam(name = "indiceRival") int indiceRival,
			RedirectAttributes redirectAttributes) {
		DatosCombate datosCombate = combateService.procesarTurno(indiceJugador, indiceRival);
		if (datosCombate.isFin() == false) {
			datosCombate = combateService.recalcularEfectividad(datosCombate);
			// datosCombate.setGanador(datosCombate.getGanador());
			System.out.println(datosCombate.getGanador().toString());
		}
		redirectAttributes.addFlashAttribute("datosCombate", datosCombate);
		if (datosCombate.isFin() == true || datosCombate.getIndices()[0] > 5 || datosCombate.getIndices()[1] > 5) {
			return "redirect:/ganador";
		} else if (datosCombate.getIndices()[0] <= 5 && datosCombate.getIndices()[1] <= 5) {
			return "redirect:/combateSucesivo";
		} else {
			System.out.println("ERROR");
			return "index";
		}
	}

	@GetMapping("/ganador")
	public String ganadorPage(Model model, @ModelAttribute("datosCombate") DatosCombate datosCombate) {
		datosCombate = combateService.establecerGanador(datosCombate);
		model.addAttribute("datosCombate", datosCombate);
		model.addAttribute("combate", combateService.findUltimoCombate());
		return "ganador";
	}

	@GetMapping("/combateSucesivo")
	public String combateSucesivoPage(Model model, @ModelAttribute("datosCombate") DatosCombate datosCombate) {
		model.addAttribute("datosCombate", datosCombate);
		model.addAttribute("combate", combateService.findUltimoCombate());
		return "combateSucesivo";
	}
}
