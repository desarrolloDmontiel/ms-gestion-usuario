package com.prueba.gestion.service;

import com.prueba.gestion.dto.AuthResponse;
import com.prueba.gestion.dto.LoginRequest;



public interface AuthService {

    public AuthResponse login(LoginRequest request);

}
