package com.example.controller;

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

import com.example.repositories.*;
import com.example.model.*;

@RestController
@RequestMapping("/manguito")

public class Controller {
	@Autowired
	private CategoriaRepository categoriaRepository;

	
	@Autowired
	private EmprendimientoRepository emprendimientoRepository;
	
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	//  CONTROLERS CATEGORIA
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/createCategoria")
	 public ResponseEntity<Categoria> createCategoria(@RequestBody Categoria categoria) {
		 categoriaRepository.save(categoria);
		 return new ResponseEntity<Categoria>(categoria, HttpStatus.CREATED);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/deleteCategoria/{id}")
	 public ResponseEntity<Categoria> deleteCategoria(@PathVariable("id") String id) {
		Long idLong = Long.parseLong(id);
		 Optional<Categoria> categoria = categoriaRepository.findById(idLong);
	     if (categoria.get().getEmprendimientos().isEmpty()) {
			 	
				 System.out.println("categoria eliminada");
				 categoriaRepository.delete(categoria.get());
				 return new ResponseEntity<Categoria>(categoria.get(), HttpStatus.OK);
		 }else {
			 System.out.println("no se puede eliminar para mantener la integridad de la db");
			 return new ResponseEntity<Categoria>(HttpStatus.NOT_FOUND);
		 }
		 
	 }
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping(value = "/categoria/{id}")
	 public  ResponseEntity<Categoria> updateCategoria(@PathVariable("id") String id, @RequestBody Categoria categoria) {
		 Long idLong = Long.parseLong(id);
		 Optional<Categoria> current = categoriaRepository.findById(idLong);
		 if(current.isEmpty()){
			 return new ResponseEntity<Categoria>(HttpStatus.NOT_FOUND);
		 }
		 current.get().setNombre(categoria.getNombre());
		 categoriaRepository.save(current.get());
		 return new ResponseEntity<Categoria>(current.get(),HttpStatus.OK);
	  }
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/getListaCategorias")
	 public ResponseEntity<List<Categoria>> getListaCategorias() {
		 List<Categoria> lista = categoriaRepository.findAll();
		 if(lista.isEmpty()){
			 return new ResponseEntity<List<Categoria>>(HttpStatus.NO_CONTENT);
		 }
		 return new ResponseEntity<List<Categoria>>(lista, HttpStatus.OK);
	  }
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/getEmprendimiento/{id}")
	 public ResponseEntity<Emprendimiento> getEmprendimiento(@PathVariable("id") String id){
		 Long idLong = Long.parseLong(id);
		 Optional<Emprendimiento> optionalEmprendimiento = emprendimientoRepository.findById(idLong);
		 if (optionalEmprendimiento.isEmpty()) {
			 return new ResponseEntity<Emprendimiento>(HttpStatus.NOT_FOUND);
		 }
		 Emprendimiento emprendimiento = optionalEmprendimiento.get();
		 return new ResponseEntity<Emprendimiento>(emprendimiento, HttpStatus.OK);
	 }

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/getListaEmprendimientos")
	 public ResponseEntity<List<Emprendimiento>> getListaEmprendimientos() {
		 List<Emprendimiento> emprendimientos = emprendimientoRepository.findAll();
		 if (emprendimientos.isEmpty()) {
			 return new ResponseEntity<List<Emprendimiento>>(HttpStatus.NO_CONTENT);
		 }
		 return new ResponseEntity<List<Emprendimiento>>(emprendimientos, HttpStatus.OK);
	 }
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/createEmprendimiento/{id}")
	 public ResponseEntity<Emprendimiento> createEmprendimiento(@PathVariable("id") String id, @RequestBody Emprendimiento emprendimiento) {
		Optional<Usuario> user = usuarioRepository.findById(Long.parseLong(id));
		System.out.println("pasa user find by id");
		user.get().setEmprendimiento(emprendimiento);
		System.out.println("pasa user set emprendimiento");
		emprendimiento.setNombre("Sin nombre");
		emprendimiento.setDescripcion("sin Descripcion");
		emprendimientoRepository.save(emprendimiento);
		System.out.println("pasa save emprendimiento");
		usuarioRepository.save(user.get());
		System.out.println("pasa save user");
		return new ResponseEntity<Emprendimiento>(emprendimiento, HttpStatus.CREATED);
	}
	

	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/login")
	 public ResponseEntity<Usuario> login(@RequestParam String username, @RequestParam String password){
		 Usuario usuario = usuarioRepository.findByUsernameAndPassword(username, password);
		 if (usuario==null) {
			 return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
		 }
		 return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	 }

	
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping(value = "/emprendimiento/{idEmprendimiento}/{idUsuario}")
	 public  ResponseEntity<Optional<Emprendimiento>> updateEmprendimiento(@PathVariable("idEmprendimiento") String idEmprendimiento, @PathVariable("idUsuario") String idUsuario, @RequestBody Emprendimiento emprendimiento) {
		 Long idLong = Long.parseLong(idEmprendimiento);
		 Optional<Emprendimiento> currentEmprendimiento = emprendimientoRepository.findById(idLong);
		 if(currentEmprendimiento.isEmpty()){
			 return new ResponseEntity<Optional<Emprendimiento>>(HttpStatus.NOT_FOUND);
		 }
		 currentEmprendimiento.get().setNombre(emprendimiento.getNombre());
		 currentEmprendimiento.get().setDescripcion(emprendimiento.getDescripcion());
		 currentEmprendimiento.get().setPassword(emprendimiento.getPassword());
		 currentEmprendimiento.get().setDescripcion(emprendimiento.getDescripcion());
		 currentEmprendimiento.get().setPrecioPorManguito(emprendimiento.getPrecioPorManguito());
		 currentEmprendimiento.get().setRedesSociales(emprendimiento.getRedesSociales());
		 currentEmprendimiento.get().setCategorias(emprendimiento.getCategorias());
		 
		 Optional<Usuario> user = usuarioRepository.findById(Long.parseLong(idUsuario));
		 
		 user.get().setEmprendimiento(currentEmprendimiento.get());
		 usuarioRepository.save(user.get());
		 emprendimientoRepository.save(currentEmprendimiento.get());
		 return new ResponseEntity<Optional<Emprendimiento>>(currentEmprendimiento,HttpStatus.OK);
	  }
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/registrarUsuario")
	 public ResponseEntity<Usuario> createUsuario(@RequestBody Usuario user) {
		Rol rol = new Rol(Long.parseLong("2"),"Emprendedor");
		user.setRol(rol);
		usuarioRepository.save(user);
		return new ResponseEntity<Usuario>(user, HttpStatus.CREATED);
	 }
	
}
