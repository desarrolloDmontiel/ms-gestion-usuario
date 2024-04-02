package com.prueba.gestion.controller.impl;

import static com.prueba.gestion.util.ConstantUtil.LOG_END;
import static com.prueba.gestion.util.ConstantUtil.LOG_START;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.gestion.controller.GestionUsuarioController;
import com.prueba.gestion.dto.UserDTO;
import com.prueba.gestion.service.GestionUsuarioService;
import com.prueba.gestion.service.impl.GestionUsuarioServiceImpl;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/users")
public class GestionUsuarioControllerImpl implements GestionUsuarioController {

	private GestionUsuarioService gestionUsuarioService;
	private static final Logger log = LoggerFactory.getLogger(GestionUsuarioServiceImpl.class);

	public GestionUsuarioControllerImpl(GestionUsuarioService encuestaService) {
		super();
		this.gestionUsuarioService = encuestaService;
	}

	@Override
	@GetMapping("/")
	@ApiOperation(value = "Lista todos los usuarios", notes = "Lista todos los usuarios")
	public ResponseEntity<List<UserDTO>> listarUsuarios() {
		log.info(String.format(LOG_START, "listarUsuarios()"));

		List<UserDTO> response = gestionUsuarioService.listarUsuarios();

		log.info(String.format(LOG_END, "listarUsuarios()"));
		return ResponseEntity.ok(response);
	}

}
