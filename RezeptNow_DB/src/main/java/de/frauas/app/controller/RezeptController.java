package de.frauas.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import de.frauas.app.model.Rezept;
import de.frauas.app.service.RezeptService;

@Controller
public class RezeptController {

	@Autowired
	private RezeptService rezeptService;

	// zeigt Liste aller Rezeptr an
	@GetMapping("/RezeptNow/dashboard")
	public String displayRezept(Model model) {
		model.addAttribute("listRezepte", rezeptService.getAllRezept());
		return "index";
	}

	@GetMapping("/RezeptNow/new")
	public String displayNewRezept(Model model) {
		Rezept rezept = new Rezept();
		model.addAttribute("rezept", rezept);
		return "rezept_new";
	}

	@PostMapping("/RezeptNow/saveRezept")
	public String saveRezept(@ModelAttribute("rezept") Rezept rezept) {
		rezeptService.SaveRezept(rezept);
		return "redirect:/RezeptNow/dashboard";
	}

	@GetMapping("/updateRezept/{id}")
	public String updateRezept(@PathVariable(value = "id") int id, Model model) {
		Rezept rezept = rezeptService.getRezeptById(id);
		model.addAttribute("rezept", rezept);
		return"rezept_update";
	}
	@GetMapping("/deleteRezept/{id}")
	public String deleteRezept(@PathVariable(value = "id") int id) {
		this.rezeptService.deleteRezeptById(id);
		return "redirect:/RezeptNow/dashboard";
	}
	
}
