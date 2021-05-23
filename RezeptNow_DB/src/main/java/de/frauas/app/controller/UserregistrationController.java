package de.frauas.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import de.frauas.app.dto.UserRegistrationDto;
import de.frauas.app.service.UserService;

@Controller
@RequestMapping("/registration")
public class UserregistrationController {

	private UserService userService;

	public UserregistrationController(UserService userService) {
		super();
		this.userService = userService;
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
