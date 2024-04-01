package com.prueba.gestion.service.impl;

import static com.prueba.gestion.util.ConstantUtil.ERROR_REGISTRO;
import static com.prueba.gestion.util.ConstantUtil.LOG_END;
import static com.prueba.gestion.util.ConstantUtil.LOG_START;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.prueba.gestion.dto.AuthResponse;
import com.prueba.gestion.dto.LoginRequest;
import com.prueba.gestion.dto.PhoneDTO;
import com.prueba.gestion.dto.UserDTO;
import com.prueba.gestion.entity.Phone;
import com.prueba.gestion.entity.User;
import com.prueba.gestion.repository.UserRepository;
import com.prueba.gestion.service.AuthService;
import com.prueba.gestion.service.GestionUsuarioService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GestionUsuarioServiceImpl implements GestionUsuarioService {

	private final UserRepository userRepository;
	private final AuthService authService;
	private static final Logger log = LoggerFactory.getLogger(GestionUsuarioServiceImpl.class);
	private final PasswordEncoder passwordEncoder;

	@Override
	public User guardarUsuario(UserDTO userDto) {
		log.info(String.format(LOG_START, "guardarUsuario"));

		log.info("user es ", userRepository.findByEmail(userDto.getEmail()));
		if (!userRepository.findByEmail(userDto.getEmail()).isEmpty()) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ERROR_REGISTRO);
		}
		User user = new User();
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(passwordEncoder.encode(userDto.getPassword()));
		user.setActive(true);
		user.setCreated(LocalDateTime.now());
		user.setLastLogin(LocalDateTime.now());
		user.setModified(LocalDateTime.now());

		user.setPhones(userDto.getPhones().stream().map(phoneDTO -> {
			Phone phone = new Phone();
			phone.setNumber(phoneDTO.getNumber());
			phone.setCitycode(phoneDTO.getCityCode());
			phone.setCountrycode(phoneDTO.getContryCode());
			phone.setUser(user);
			return phone;
		}).collect(Collectors.toList()));

		userRepository.save(user);
		
		LoginRequest request = new LoginRequest();
		request.setEmail(user.getEmail());
		request.setPassword(userDto.getPassword());
		AuthResponse token = authService.login(request);
		
		user.setToken(token.getToken());
		userRepository.save(user);
		log.info(String.format(LOG_END, "guardarUsuario"));
		return user;
	}

	@Override
	public List<UserDTO> listarUsuarios() {
		log.info(String.format(LOG_START, "listarUsuarios()"));

		List<User> users = userRepository.findAll();

		List<UserDTO> userDTOs = users.stream().map(this::convertToUserDTO).collect(Collectors.toList());

		return userDTOs;
	}

	private UserDTO convertToUserDTO(User user) {
		UserDTO userDTO = new UserDTO();
		userDTO.setName(user.getName());
		userDTO.setEmail(user.getEmail());
		userDTO.setPhones(user.getPhones().stream()
				.map(phone -> new PhoneDTO(phone.getNumber(), phone.getCitycode(), phone.getCountrycode()))
				.collect(Collectors.toList()));
		return userDTO;
	}

}
