package com.prueba.gestion.entity;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.prueba.gestion.enums.Role;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "users")
@JsonIgnoreProperties(value = { 
	    "accountNonExpired", "accountNonLocked", "credentialsNonExpired", "enabled", "authorities", "username"
	})
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String password;
    
    private LocalDateTime created;
    
    private LocalDateTime modified;
    
    private LocalDateTime lastLogin;
    
    private boolean isActive;
    
    private String token;
    
    
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Phone> phones;
    
    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
       return true;
    }
    
    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
       return true;
    }
    
    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    
    @JsonIgnore
    @Override
    public boolean isEnabled() {
        return true;
    }
    
    @JsonIgnore
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

    
}
