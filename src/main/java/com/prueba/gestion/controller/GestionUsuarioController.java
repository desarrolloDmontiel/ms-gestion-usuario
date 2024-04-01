package com.prueba.gestion.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.prueba.gestion.dto.UserDTO;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
public interface GestionUsuarioController {
	
	
	/**
	 * 
	 * @return
	 */
	@ApiOperation(value = "", notes = "")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successful return") })
	public ResponseEntity<List<UserDTO>> listarUsuarios();
	
}
