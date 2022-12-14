package com.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.*;

@Repository
public interface EmprendimientoRepository extends JpaRepository<Emprendimiento, Long>{

	Emprendimiento findByDominio(String dominio);
}
