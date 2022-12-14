package com.example.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.*;


public interface DonacionRepository extends JpaRepository<Donacion, Long>{

	List<Donacion> findByEmprendimiento(Long id);
}
