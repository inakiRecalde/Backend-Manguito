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
	private DonacionRepository donacionRepository;
	
	@Autowired
	private EmprendimientoRepository emprendimientoRepository;
	
	@Autowired
	private PlanRepository planRepository;
	

	@Autowired
	private PosteoRepository posteoRepository;
	

	@Autowired
	private RolRepository rolRepository;
	

	@Autowired
	private UrlRepository urlRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	
	//  CONTROLERS CATEGORIA
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/createCategoria")
	 public ResponseEntity<Categoria> createCategoria(@RequestBody Categoria categoria) {
		 System.out.println("Entra al controller categoria");
		 categoriaRepository.save(categoria);
		 return new ResponseEntity<Categoria>(categoria, HttpStatus.CREATED);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping(value = "/updateCategoria")
	 public  ResponseEntity<Categoria> updateCategoria(@RequestParam String id, @RequestBody Categoria categoria) {
		System.out.println("Entra al controller update Categoria");
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
		System.out.println("Entra al controller LISTAR Categoria");
		 List<Categoria> lista = categoriaRepository.findAll();
		 if(lista.isEmpty()){
			 return new ResponseEntity<List<Categoria>>(HttpStatus.NO_CONTENT);
		 }
		 return new ResponseEntity<List<Categoria>>(lista, HttpStatus.OK);
	  }
	
	
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/deleteCategoria/{id}")
	 public ResponseEntity<Categoria> deleteCategoria(@PathVariable("id") String id) {
		Long idLong = Long.parseLong(id);
		 Optional<Categoria> categoria = categoriaRepository.findById(idLong);
		 if (categoria.isEmpty()) {
			 return new ResponseEntity<Categoria>(HttpStatus.NOT_FOUND);
		 }else {
			 categoriaRepository.delete(categoria.get());
			 return new ResponseEntity<Categoria>(categoria.get(), HttpStatus.OK);
		 }
		 
	 }
	
	//delete con requestparam
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/deleteCategoria")
	 public ResponseEntity<Categoria> deleteCategoriaRequestParam(@RequestParam String id) {
		Long idLong = Long.parseLong(id);
		 Optional<Categoria> categoria = categoriaRepository.findById(idLong);
		 if (categoria.isEmpty()) {
			 return new ResponseEntity<Categoria>(HttpStatus.NOT_FOUND);
		 }else {
			 categoriaRepository.delete(categoria.get());
			 return new ResponseEntity<Categoria>(categoria.get(), HttpStatus.OK);
		 }
		 
	 }
	//  CONTROLERS DONACION
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/createDonacion")
	 public ResponseEntity<Donacion> createDonacion(@RequestBody Donacion donacion) {
		 System.out.println("Entra al controller c DONACION");
		 donacionRepository.save(donacion);
		 return new ResponseEntity<Donacion>(donacion, HttpStatus.CREATED);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/getDonacion")
	 public ResponseEntity<Donacion> getDonacion(@RequestParam String id) {
		Long idLong = Long.parseLong(id);
		 Optional<Donacion> donacion = donacionRepository.findById(idLong);
		 if (donacion.isEmpty()) {
			 return new ResponseEntity<Donacion>(HttpStatus.NOT_FOUND);
		 }
		 return new ResponseEntity<Donacion>(donacion.get(), HttpStatus.OK);
	 }
	
	

	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/getDonacionesEmprendimiento")
	 public ResponseEntity<List<Donacion>> listar(@RequestParam Long idEmprendimiento) {
		System.out.println("Entra al controller LISTAR DONACION");
		 List<Donacion> lista = donacionRepository.findByEmprendimiento(idEmprendimiento);
		 if(lista.isEmpty()){
			 return new ResponseEntity<List<Donacion>>(HttpStatus.NO_CONTENT);
		 }
		 return new ResponseEntity<List<Donacion>>(lista, HttpStatus.OK);
	  }
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/getListaDonaciones")
	 public ResponseEntity<List<Donacion>> getListaDonaciones() {
		System.out.println("Entra al controller LISTAR Categoria");
		 List<Donacion> lista = donacionRepository.findAll();
		 if(lista.isEmpty()){
			 return new ResponseEntity<List<Donacion>>(HttpStatus.NO_CONTENT);
		 }
		 return new ResponseEntity<List<Donacion>>(lista, HttpStatus.OK);
	  }
	
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/deleteDonacion/{id}")
	 public ResponseEntity<Donacion> deleteDonacion(@PathVariable("id") String id) {
		Long idLong = Long.parseLong(id);
		 Optional<Donacion> donacion = donacionRepository.findById(idLong);
		 if (donacion.isEmpty()) {
			 return new ResponseEntity<Donacion>(HttpStatus.NOT_FOUND);
		 }else {
			 donacionRepository.delete(donacion.get());
			 return new ResponseEntity<Donacion>(donacion.get(), HttpStatus.OK);
		 }
		 
	 }
	
	//  CONTROLERS EMPRENDIMIENTO
	
	//anda
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/createEmprendimiento")
	 public ResponseEntity<Emprendimiento> createEmprendimiento(@RequestBody Emprendimiento emprendimiento) {
		 System.out.println("Entra al controller create EMPRENDIMIENTO");
		 emprendimientoRepository.save(emprendimiento);
		 return new ResponseEntity<Emprendimiento>(emprendimiento, HttpStatus.CREATED);
	}
	
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/getEmprendimiento")
	 public ResponseEntity<Emprendimiento> getEmprendimiento(@RequestParam String id) {
		 System.out.println("Entra al controller emprendimiento id");
		 Long idLong = Long.parseLong(id);
		 Optional<Emprendimiento> optionalEmprendimiento = emprendimientoRepository.findById(idLong);
		 if (optionalEmprendimiento.isEmpty()) {
			 System.out.println("Entra al empty emprendimiento id");
			 return new ResponseEntity<Emprendimiento>(HttpStatus.NOT_FOUND);
		 }
		 Emprendimiento emprendimiento = optionalEmprendimiento.get();
		 return new ResponseEntity<Emprendimiento>(emprendimiento, HttpStatus.OK);
	 }
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/getListaEmprendimientos")
	 public ResponseEntity<List<Emprendimiento>> getListaEmprendimientos() {
		 System.out.println("Entra al controller emprendimiento id");
		 List<Emprendimiento> emprendimientos = emprendimientoRepository.findAll();
		 if (emprendimientos.isEmpty()) {
			 System.out.println("Entra al empty emprendimiento id");
			 return new ResponseEntity<List<Emprendimiento>>(HttpStatus.NO_CONTENT);
		 }
		 System.out.println("no entra empty emprendimiento id");
		 return new ResponseEntity<List<Emprendimiento>>(emprendimientos, HttpStatus.OK);
	 }
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/emprendimientoDominio")
	 public ResponseEntity<String> getEmprendimientoDominio(@RequestParam String id) {
		 System.out.println("Entra al controller emprendimiento id");
		 Long idLong = Long.parseLong(id);
		 Optional<Emprendimiento> emprendimiento = emprendimientoRepository.findById(idLong);
		 if (emprendimiento.isEmpty()) {
			 System.out.println("Entra al empty emprendimiento id");
			 return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		 }
		 System.out.println("no entra empty al controller emprendimiento id");
		 System.out.println(emprendimiento.get());
		 return new ResponseEntity<String>(emprendimiento.get().getDominio(), HttpStatus.OK);
	 }
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping(value = "/emprendimiento/{id}")
	 public  ResponseEntity<Optional<Emprendimiento>> updateEmprendimiento(@PathVariable("id") String id, @RequestBody Emprendimiento emprendimiento) {
		 Long idLong = Long.parseLong(id);
		 Optional<Emprendimiento> currentEmprendimiento = emprendimientoRepository.findById(idLong);
		 if(currentEmprendimiento.isEmpty()){
			 return new ResponseEntity<Optional<Emprendimiento>>(HttpStatus.NOT_FOUND);
		 }
		 currentEmprendimiento.get().setNombre(emprendimiento.getNombre());
		 currentEmprendimiento.get().setDominio(emprendimiento.getDominio());
		 currentEmprendimiento.get().setPassword(emprendimiento.getPassword());
		 currentEmprendimiento.get().setDescripcion(emprendimiento.getDescripcion());
		 emprendimientoRepository.save(currentEmprendimiento.get());
		 
		 return new ResponseEntity<Optional<Emprendimiento>>(currentEmprendimiento,HttpStatus.OK);
	  }
	
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/deleteEmprendimiento/{id}")
	 public ResponseEntity<Emprendimiento> deleteEmprendimiento(@PathVariable("id") String id) {
		Long idLong = Long.parseLong(id);
		 Optional<Emprendimiento> emprendimiento = emprendimientoRepository.findById(idLong);
		 if (emprendimiento.isEmpty()) {
			 return new ResponseEntity<Emprendimiento>(HttpStatus.NOT_FOUND);
		 }else {
			 emprendimientoRepository.delete(emprendimiento.get());
			 return new ResponseEntity<Emprendimiento>(emprendimiento.get(), HttpStatus.OK);
		 }
		 
	 }
	
	//  CONTROLERS PLAN
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/createPlan")
	 public ResponseEntity<Plan> createPlan(@RequestBody Plan plan) {
		 System.out.println("Entra al controller Plan");
		 planRepository.save(plan);
		 return new ResponseEntity<Plan>(plan, HttpStatus.CREATED);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/getPlan")
	 public ResponseEntity<Plan> getPlan(@RequestParam String id) {
		Long idLong = Long.parseLong(id);
		 Optional<Plan> plan = planRepository.findById(idLong);
		 if (plan.isEmpty()) {
			 return new ResponseEntity<Plan>(HttpStatus.NOT_FOUND);
		 }
		 return new ResponseEntity<Plan>(plan.get(), HttpStatus.OK);
	 }
	
	//  CONTROLERS POSTEO
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/createPosteo")
	 public ResponseEntity<Posteo> createPosteo(@RequestBody Posteo posteo) {
		 System.out.println("Entra al controller posteo");
		 posteoRepository.save(posteo);
		 return new ResponseEntity<Posteo>(posteo, HttpStatus.CREATED);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/getPosteo")
	 public ResponseEntity<Posteo> getPosteo(@RequestParam String id) {
		Long idLong = Long.parseLong(id);
		 Optional<Posteo> posteo = posteoRepository.findById(idLong);
		 if (posteo.isEmpty()) {
			 return new ResponseEntity<Posteo>(HttpStatus.NOT_FOUND);
		 }
		 return new ResponseEntity<Posteo>(posteo.get(), HttpStatus.OK);
	 }
	
	
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/deletePlan/{id}")
	 public ResponseEntity<Plan> deletePlan(@PathVariable("id") String id) {
		Long idLong = Long.parseLong(id);
		 Optional<Plan> plan = planRepository.findById(idLong);
		 if (plan.isEmpty()) {
			 return new ResponseEntity<Plan>(HttpStatus.NOT_FOUND);
		 }else {
			 planRepository.delete(plan.get());
			 return new ResponseEntity<Plan>(plan.get(), HttpStatus.OK);
		 }
	}
		
		 
		 
	// CONTROLERS ROL
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/createRol")
	 public ResponseEntity<Rol> createRol(@RequestBody Rol rol) {
		 System.out.println("Entra al controller Rol");
		 rolRepository.save(rol);
		 return new ResponseEntity<Rol>(rol, HttpStatus.CREATED);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/getRol")
	 public ResponseEntity<Rol> getRol(@RequestParam String id) {
		Long idLong = Long.parseLong(id);
		 Optional<Rol> rol = rolRepository.findById(idLong);
		 if (rol.isEmpty()) {
			 return new ResponseEntity<Rol>(HttpStatus.NOT_FOUND);
		 }
		 return new ResponseEntity<Rol>(rol.get(), HttpStatus.OK);
	 }
	
	// CONTROLERS url
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/createUrl")
	 public ResponseEntity<Url> createUrl(@RequestBody Url url) {
		 System.out.println("Entra al controller Url");
		 urlRepository.save(url);
		 return new ResponseEntity<Url>(url, HttpStatus.CREATED);
	}
	
	@GetMapping("/getUrl")
	 public ResponseEntity<Url> getUrl(@RequestParam String id) {
		Long idLong = Long.parseLong(id);
		 Optional<Url> url = urlRepository.findById(idLong);
		 if (url.isEmpty()) {
			 return new ResponseEntity<Url>(HttpStatus.NOT_FOUND);
		 }
		 return new ResponseEntity<Url>(url.get(), HttpStatus.OK);
	 }
	
	
	// CONTROLERS Usuario
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/registrarUsuario")
	 public ResponseEntity<Usuario> createUsuario(@RequestBody Usuario user) {
		 System.out.println("Entra al controller");
		 usuarioRepository.save(user);
		 return new ResponseEntity<Usuario>(user, HttpStatus.CREATED);
	 }
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/getUsuario")
	 public ResponseEntity<Usuario> getUsuario(@RequestParam String id) {
		Long idLong = Long.parseLong(id);
		 Optional<Usuario> user = usuarioRepository.findById(idLong);
		 if (user.isEmpty()) {
			 return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
		 }
		 return new ResponseEntity<Usuario>(user.get(), HttpStatus.OK);
	 }

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/login")
	 public ResponseEntity<Usuario> login(@RequestParam String username, @RequestParam String password){
		 System.out.println("Entra al controller");
		 Usuario usuario = usuarioRepository.findByUsernameAndPassword(username, password);
		 if (usuario==null) {
			 return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
		 }
		 return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	 }
	

	
	//anda
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/probando")
	 public ResponseEntity<Emprendimiento> listar() {
		 System.out.println("Entra al controller");
		 Emprendimiento emprendimiento = new Emprendimiento("Probando","1234");
		 return ResponseEntity.ok(emprendimiento);
	 }
}
