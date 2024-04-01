package com.prueba.gestion.service;

import java.util.List;
import com.prueba.gestion.dto.UserDTO;


public interface GestionUsuarioService {
	/**
	 * 
	 * @param UserDTO user
	 */
	void guardarUsuario(UserDTO user);
	
	/**
	 * 
	 * @return
	 */
	public List<UserDTO> listarUsuarios(); 
	

	
}
