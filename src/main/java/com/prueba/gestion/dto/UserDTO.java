package com.prueba.gestion.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
	@JsonProperty
	@NotEmpty(message = "not empty")
	private String name;
	
	@Email(message = "not valid")
	@JsonProperty
	@NotEmpty(message = "not empty")
    private String email;
	
	@JsonProperty
    private String password;
	
    private List<PhoneDTO> phones;
}