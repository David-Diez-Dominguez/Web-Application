package de.frauas.app.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import de.frauas.app.dto.UserRegistrationDto;
import de.frauas.app.model.User;

public interface UserService extends UserDetailsService {
	User saveUser(UserRegistrationDto registrationDto);

}
