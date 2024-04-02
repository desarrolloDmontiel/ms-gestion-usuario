package com.prueba.gestion.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.prueba.gestion.dto.AuthResponseDTO;
import com.prueba.gestion.dto.LoginRequestDTO;
import com.prueba.gestion.dto.UserDTO;
import com.prueba.gestion.entity.User;

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
	public ResponseEntity<AuthResponseDTO> login(@RequestBody LoginRequestDTO request);
	
	/**
	 * 
	 * @param UserDTO user
	 * @return
	 */
	@ApiOperation(value = "", notes = "")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successful return") })
	public ResponseEntity<User>  guardarUsuario(UserDTO user);
	
	
}
