package com.prueba.gestion.dto;


public class PhoneDTO {
    private String number;
    private String citycode;
    private String contrycode;
    
    public PhoneDTO(String number, String citycode, String contrycode) {
        this.number = number;
        this.citycode = citycode;
        this.contrycode = contrycode;
    }
    
	public String getNumber() {
		return number;
	}
	
	public void setNumber(String number) {
		this.number = number;
	}
	public String getCityCode() {
		return citycode;
	}
	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}
	public String getContryCode() {
		return contrycode;
	}
	public void setContryCode(String contrycode) {
		this.contrycode = contrycode;
	} 
}