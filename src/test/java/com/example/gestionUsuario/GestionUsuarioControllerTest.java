package com.example.gestionUsuario;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
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
import com.prueba.gestion.controller.impl.GestionUsuarioControllerImpl;
import com.prueba.gestion.dto.UserDTO;
import com.prueba.gestion.service.GestionUsuarioService;

@ExtendWith(MockitoExtension.class)
class GestionUsuarioControllerImplTest {

    @Mock
    private GestionUsuarioService gestionUsuarioService;

    @InjectMocks
    private GestionUsuarioControllerImpl gestionUsuarioController;

    private MockMvc mockMvc;
    private ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(gestionUsuarioController).build();
    }

    @Test
    void listarUsuariosTest() throws Exception {
        UserDTO user1 = new UserDTO();
        UserDTO user2 = new UserDTO(); 
        List<UserDTO> usuarios = Arrays.asList(user1, user2);

        when(gestionUsuarioService.listarUsuarios()).thenReturn(usuarios);

        mockMvc.perform(get("/users/")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(usuarios)));

        verify(gestionUsuarioService).listarUsuarios();
    }
}