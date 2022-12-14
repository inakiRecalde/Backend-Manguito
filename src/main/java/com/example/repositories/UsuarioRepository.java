package com.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.*;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	Usuario findByUsernameAndPassword(String username, String password);
	
}
