package com.prueba.gestion.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PhoneDTO {
    private String number;
    private String citycode;
    private String contrycode; 
}