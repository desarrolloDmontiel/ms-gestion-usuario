package com.prueba.gestion.service;

import java.util.List;
import com.prueba.gestion.dto.UserDTO;
import com.prueba.gestion.entity.User;


public interface GestionUsuarioService {
	/**
	 * 
	 * @param UserDTO user
	 */
	User guardarUsuario(UserDTO user);
	
	/**
	 * 
	 * @return
	 */
	public List<UserDTO> listarUsuarios(); 
	

	
}
