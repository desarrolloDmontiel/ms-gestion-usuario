package com.prueba.gestion.service;

import com.prueba.gestion.dto.AuthResponseDTO;
import com.prueba.gestion.dto.LoginRequestDTO;



public interface AuthService {

    public AuthResponseDTO login(LoginRequestDTO request);

}
