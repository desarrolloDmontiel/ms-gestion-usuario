package com.example.gestionUsuario;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.prueba.gestion.controller.impl.AuthUsuarioControllerImpl;
import com.prueba.gestion.dto.AuthResponseDTO;
import com.prueba.gestion.dto.LoginRequestDTO;
import com.prueba.gestion.dto.UserDTO;
import com.prueba.gestion.dto.PhoneDTO;
import com.prueba.gestion.entity.User;
import com.prueba.gestion.service.AuthService;
import com.prueba.gestion.service.GestionUsuarioService;

@ExtendWith(MockitoExtension.class)
class AuthUsuarioControllerTest {

    @Mock
    private GestionUsuarioService gestionUsuarioService;

    @Mock
    private AuthService authService;

    @InjectMocks
    private AuthUsuarioControllerImpl authUsuarioController;

    private MockMvc mockMvc;
    private ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(authUsuarioController).build();
    }

    @Test
    void loginTest() throws Exception {
        LoginRequestDTO request = new LoginRequestDTO();
        request.setEmail("user@correo.com");
        request.setPassword("pass123");

        AuthResponseDTO response = new AuthResponseDTO("Bearer token");

        when(authService.login(any(LoginRequestDTO.class))).thenReturn(response);

        mockMvc.perform(post("/auth/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(response)));
    }

    @Test
    void guardarUsuarioTest() throws Exception {
        UserDTO userDTO = new UserDTO();
        User user = new User();
        PhoneDTO phone = new PhoneDTO();
      
        
        lenient().when(gestionUsuarioService.guardarUsuario(any(UserDTO.class))).thenReturn(user);
        mockMvc.perform(post("/auth/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(userDTO)))
                .andExpect(status().isBadRequest());
           
    }
}