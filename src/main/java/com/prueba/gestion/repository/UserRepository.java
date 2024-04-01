package com.prueba.gestion.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.prueba.gestion.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByEmail(String email);
}
