package de.frauas.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import de.frauas.app.dto.UserRegistrationDto;
import de.frauas.app.service.RezeptService;
import de.frauas.app.service.UserService;

@Controller
@RequestMapping("/registration")
public class UserregistrationController {

	private UserService userService;
	
	private RezeptService rezeptService;

	public UserregistrationController(UserService userService) {
		super();
		this.userService = userService;
	}

	// zeigt Liste aller Rezeptr an
		@GetMapping("/dashboard")
		public String displayRezept(Model model) {
			model.addAttribute("listRezepte", rezeptService.getAllRezept());
			return "index";
		}

	@ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto() {
        return new UserRegistrationDto();
    }
	
	@GetMapping
	public String showRegistrationForm() {
		return "registration";
	}
	
	@PostMapping
	public String registerUserAccount(@ModelAttribute("user") UserRegistrationDto registrationDto) {
		userService.saveUser(registrationDto);
		return "redirect:/registration?success";
	}
}
