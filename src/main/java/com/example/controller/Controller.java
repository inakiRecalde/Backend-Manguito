package com.example.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.*;

@RestController
@RequestMapping("/manguito")

public class Controller {
	
	
	
	
	//  CONTROLERS CATEGORIA
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/createCategoria")
	 public ResponseEntity<Categoria> createCategoria(@RequestBody Categoria categoria) {
		System.out.println("Se ha agregado la nueva categoria");
		return new ResponseEntity<Categoria>(categoria, HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/deleteCategoria/{id}")
	public ResponseEntity<Long> deleteCategoria(@PathVariable Long id){
		System.out.println("Se ha eliminado correctamente la categoria");
		return new ResponseEntity<>(id, HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping(value = "/categoria/{id}")
	 public  ResponseEntity<Categoria> updateCategoria(@PathVariable("id") long id, @RequestBody Categoria categoria) {
		System.out.println("Se modifico correctamente la categoria");
		return new ResponseEntity<Categoria>(categoria, HttpStatus.OK);
	  }
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/getListaCategorias")
	 public ResponseEntity<List<Categoria>> getListaCategorias() {
		 List<Categoria> categorias = new ArrayList<Categoria>();
		 Categoria cat = new Categoria(Long.valueOf(1), "Deportes");
		 categorias.add(cat);
		 cat = new Categoria(Long.valueOf(2), "Comida");
		 categorias.add(cat);
		 cat = new Categoria(Long.valueOf(3), "Moda");
		 categorias.add(cat);
		 return new ResponseEntity<List<Categoria>>(categorias, HttpStatus.OK);
	 }
	
	/*
	//  CONTROLERS DONACION
	
	@PostMapping("/createDonacion")
	 public ResponseEntity<Donacion> createDonacion(@RequestBody Donacion donacion) {
		 
	}
	
	@GetMapping("/getDonacion")
	 public ResponseEntity<Donacion> getDonacion(@RequestParam long id) {
		 
	 }
	
	@GetMapping("/getDonacionesEmprendimiento")
	 public ResponseEntity<List<Donacion>> listar(@RequestParam Long idEmprendimiento) {
		
	  }
	
	
	
	//  CONTROLERS EMPRENDIMIENTO
	
	//anda
	
	
	
	@GetMapping("/getEmprendimiento")
	 public ResponseEntity<Emprendimiento> getEmprendimiento(@RequestParam long id) {
		 
	 }
	*/
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/getEmprendimiento/{id}")
	 public ResponseEntity<Emprendimiento> getEmprendimiento(@PathVariable("id") String id) {
		Emprendimiento emprendimiento = new Emprendimiento(Long.valueOf(1), "https://panaderia22.com", "1234", "Panaderia Hermanos",
				 "Panaderia familiar desde el año 1960", 50.3, 10 );
		return new ResponseEntity<Emprendimiento>(emprendimiento, HttpStatus.OK);
	 }
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/getListaEmprendimientos")
	 public ResponseEntity<List<Emprendimiento>> getListaEmprendimientos() {
		 System.out.println("Entra al controller emprendimiento id");
		 List<Emprendimiento> emprendimientos = new ArrayList<Emprendimiento>();
		 Emprendimiento emp = new Emprendimiento(Long.valueOf(1), "https://panaderia22.com", "1234", "Panaderia Hermanos",
				 "Panaderia familiar desde el año 1960", 50.3, 10 );
		 emprendimientos.add(emp);
		 emp = new Emprendimiento(Long.valueOf(2), "https://zapateria100.com", "1234", "Zapateria Los Hornos",
				 "Arreglamos tus zapatos en menos tiempo de lo que te imaginas", 20.3, 34 );
		 emprendimientos.add(emp);
		 emp = new Emprendimiento(Long.valueOf(3), "https://cuidamosMascotas.com", "1234", "Amantes de los animales",
				 "Guarderia de mascotas las 24hs", 56.6, 304 );
		 emprendimientos.add(emp);
		 return new ResponseEntity<List<Emprendimiento>>(emprendimientos, HttpStatus.OK);
	 }
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/login")
	 public ResponseEntity<Usuario> login(@RequestParam String username, @RequestParam String password){
		 Usuario user = new Usuario(username, password);
		 System.out.println("Logeado");
		 //return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
		 return new ResponseEntity<Usuario>(user, HttpStatus.OK);
	 }
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/createEmprendimiento")
	 public ResponseEntity<Emprendimiento> createEmprendimiento(@RequestBody Emprendimiento emprendimiento) {
		System.out.println("Emprendimiento creado");
		return new ResponseEntity<Emprendimiento>(emprendimiento, HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/registrarUsuario")
	 public ResponseEntity<Usuario> createUsuario(@RequestBody Usuario user) {
		System.out.println("Usuario creado");
		return new ResponseEntity<Usuario>(user, HttpStatus.OK);
	 }
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping(value = "/emprendimiento/{id}")
	 public  ResponseEntity<Emprendimiento> updateEmprendimiento(@PathVariable("id") long id, @RequestBody Emprendimiento emprendimiento) {
		System.out.println("Emprendimiento modificado");
		return new ResponseEntity<Emprendimiento>(emprendimiento, HttpStatus.OK);
	  }
	
	
	/*
	@GetMapping("/emprendimientoDominio")
	 public ResponseEntity<String> getEmprendimientoDominio(@RequestParam long id) {
		 
	 }
	
	
	
	
	//  CONTROLERS PLAN
	
	@PostMapping("/createPlan")
	 public ResponseEntity<Plan> createPlan(@RequestBody Plan plan) {
		 
	}
	
	@GetMapping("/getPlan")
	 public ResponseEntity<Plan> getPlan(@RequestParam long id) {
	
	 }
	
	//  CONTROLERS POSTEO
	
	@PostMapping("/createPosteo")
	 public ResponseEntity<Posteo> createPosteo(@RequestBody Posteo posteo) {
		
	}
	
	@GetMapping("/getPosteo")
	 public ResponseEntity<Posteo> getPosteo(@RequestParam long id) {
		
	 }
	
	// CONTROLERS ROL
	
	@PostMapping("/createRol")
	 public ResponseEntity<Rol> createRol(@RequestBody Rol rol) {
		
	}
	
	@GetMapping("/getRol")
	 public ResponseEntity<Rol> getRol(@RequestParam long id) {
		 
	 }
	
	// CONTROLERS url
	
	@PostMapping("/createUrl")
	 public ResponseEntity<Url> createUrl(@RequestBody Url url) {
		
	}
	
	@GetMapping("/getUrl")
	 public ResponseEntity<Url> getUrl(@RequestParam long id) {
		 
	 }
	
	
	// CONTROLERS Usuario
	
	
	
	@GetMapping("/getUsuario")
	 public ResponseEntity<Usuario> getUsuario(@RequestParam long id) {
		 
	 }

	
	

	
	//anda
	@GetMapping("/probando")
	 public ResponseEntity<Emprendimiento> listar() {
		
	 }
	 */
}
