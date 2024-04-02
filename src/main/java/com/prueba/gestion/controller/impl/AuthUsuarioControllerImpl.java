package com.prueba.gestion.controller.impl;

import static com.prueba.gestion.util.ConstantUtil.LOG_START;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.gestion.controller.AuthUsuarioController;
import com.prueba.gestion.dto.AuthResponse;
import com.prueba.gestion.dto.LoginRequest;
import com.prueba.gestion.dto.UserDTO;
import com.prueba.gestion.entity.User;
import com.prueba.gestion.service.AuthService;
import com.prueba.gestion.service.GestionUsuarioService;
import com.prueba.gestion.service.impl.GestionUsuarioServiceImpl;

import io.swagger.annotations.ApiOperation;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthUsuarioControllerImpl implements AuthUsuarioController {

	private GestionUsuarioService gestionUsuarioService;
	private AuthService authService;
	private static final Logger log = LoggerFactory.getLogger(GestionUsuarioServiceImpl.class);

	public AuthUsuarioControllerImpl(GestionUsuarioService gestionUsuarioService,AuthService authService) {
		super();
		this.gestionUsuarioService = gestionUsuarioService;
		this.authService = authService;
	}

	@PostMapping(value = "login")
	public ResponseEntity<AuthResponse> login(@Valid @RequestBody LoginRequest request) {
		String username = request.getEmail();
		request.setUsername(username);
		return ResponseEntity.ok(authService.login(request));
	}

	@Override
	@PostMapping("/")
	@ApiOperation(value = "Guarda un usuario", notes = "Guarda una usuario")
	public ResponseEntity<User> guardarUsuario(@RequestBody UserDTO user) {
		log.info(String.format(LOG_START, "guardarUsuario()"));

		return ResponseEntity.ok(gestionUsuarioService.guardarUsuario(user));
	}
}
