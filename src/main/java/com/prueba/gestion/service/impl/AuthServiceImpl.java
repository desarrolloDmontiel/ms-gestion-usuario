package com.prueba.gestion.service.impl;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.prueba.gestion.config.JwtUtil;
import com.prueba.gestion.dto.AuthResponseDTO;
import com.prueba.gestion.dto.LoginRequestDTO;
import com.prueba.gestion.entity.User;
import com.prueba.gestion.repository.UserRepository;
import com.prueba.gestion.service.AuthService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final JwtUtil jwtService = new JwtUtil();
    private final AuthenticationManager authenticationManager;

    public AuthResponseDTO login(LoginRequestDTO request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        User user=userRepository.findByEmail(request.getEmail()).orElseThrow();
        String token=jwtService.getToken(user);
        return AuthResponseDTO.builder()
            .token(token)
            .build();

    }

}
