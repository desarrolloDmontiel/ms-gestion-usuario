package com.prueba.gestion.controller.impl;

import static com.prueba.gestion.util.ConstantUtil.LOG_START;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.prueba.gestion.controller.AuthUsuarioController;
import com.prueba.gestion.dto.AuthResponseDTO;
import com.prueba.gestion.dto.LoginRequestDTO;
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
	public ResponseEntity<AuthResponseDTO> login(@Valid @RequestBody LoginRequestDTO request) {
		String username = request.getEmail();
		request.setUsername(username);
		return ResponseEntity.ok(authService.login(request));
	}

	@Override
	@PostMapping("/")
	@ApiOperation(value = "Guarda un usuario", notes = "Guarda una usuario")
	public ResponseEntity<User> guardarUsuario(@Valid @RequestBody UserDTO user) throws ResponseStatusException{
		log.info(String.format(LOG_START, "guardarUsuario()"));

		return ResponseEntity.ok(gestionUsuarioService.guardarUsuario(user));
	}
}
