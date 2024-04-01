package com.prueba.gestion.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.prueba.gestion.dto.AuthResponse;
import com.prueba.gestion.dto.LoginRequest;
import com.prueba.gestion.dto.UserDTO;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
public interface AuthUsuarioController {
	
	/**
	 * 
	 * @param request
	 * @return
	 */
	@ApiOperation(value = "", notes = "")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successful return") })
	public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request);
	
	/**
	 * 
	 * @param UserDTO user
	 * @return
	 */
	@ApiOperation(value = "", notes = "")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successful return") })
	public ResponseEntity<Void>  guardarUsuario(UserDTO user);
	
	
}
