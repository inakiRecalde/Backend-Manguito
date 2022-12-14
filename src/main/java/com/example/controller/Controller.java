package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	
	@PostMapping("/createCategoria")
	 public ResponseEntity<Categoria> createCategoria(@RequestBody Categoria categoria) {
		 System.out.println("Entra al controller categoria");
		 categoriaRepository.save(categoria);
		 return new ResponseEntity<Categoria>(categoria, HttpStatus.CREATED);
	}
	
	//  CONTROLERS DONACION
	
	@PostMapping("/createDonacion")
	 public ResponseEntity<Donacion> createDonacion(@RequestBody Donacion donacion) {
		 System.out.println("Entra al controller c DONACION");
		 donacionRepository.save(donacion);
		 return new ResponseEntity<Donacion>(donacion, HttpStatus.CREATED);
	}
	
	@GetMapping("/getDonacion")
	 public ResponseEntity<Donacion> getDonacion(@RequestParam long id) {
		 Optional<Donacion> donacion = donacionRepository.findById(id);
		 if (donacion.isEmpty()) {
			 return new ResponseEntity<Donacion>(HttpStatus.NOT_FOUND);
		 }
		 return new ResponseEntity<Donacion>(donacion.get(), HttpStatus.OK);
	 }
	
	@GetMapping("/getDonacionesEmprendimiento")
	 public ResponseEntity<List<Donacion>> listar(@RequestParam Long idEmprendimiento) {
		System.out.println("Entra al controller LISTAR DONACION");
		 List<Donacion> lista = donacionRepository.findByEmprendimiento(idEmprendimiento);
		 if(lista.isEmpty()){
			 return new ResponseEntity<List<Donacion>>(HttpStatus.NO_CONTENT);
		 }
		 return new ResponseEntity<List<Donacion>>(lista, HttpStatus.OK);
	  }
	
	
	
	//  CONTROLERS EMPRENDIMIENTO
	
	//anda
	@PostMapping("/createEmprendimiento")
	 public ResponseEntity<Emprendimiento> createEmprendimiento(@RequestBody Emprendimiento emprendimiento) {
		 System.out.println("Entra al controller create EMPRENDIMIENTO");
		 emprendimientoRepository.save(emprendimiento);
		 return new ResponseEntity<Emprendimiento>(emprendimiento, HttpStatus.CREATED);
	}
	
	
	
	@GetMapping("/getEmprendimiento")
	 public ResponseEntity<Emprendimiento> getEmprendimiento(@RequestParam long id) {
		 System.out.println("Entra al controller emprendimiento id");
		 Optional<Emprendimiento> optionalEmprendimiento = emprendimientoRepository.findById(id);
		 if (optionalEmprendimiento.isEmpty()) {
			 System.out.println("Entra al empty emprendimiento id");
			 return new ResponseEntity<Emprendimiento>(HttpStatus.NOT_FOUND);
		 }
		 Emprendimiento emprendimiento = optionalEmprendimiento.get();
		 return new ResponseEntity<Emprendimiento>(emprendimiento, HttpStatus.OK);
	 }
	
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
	
	@GetMapping("/emprendimientoDominio")
	 public ResponseEntity<String> getEmprendimientoDominio(@RequestParam long id) {
		 System.out.println("Entra al controller emprendimiento id");
		 Optional<Emprendimiento> emprendimiento = emprendimientoRepository.findById(id);
		 if (emprendimiento.isEmpty()) {
			 System.out.println("Entra al empty emprendimiento id");
			 return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		 }
		 System.out.println("no entra empty al controller emprendimiento id");
		 System.out.println(emprendimiento.get());
		 return new ResponseEntity<String>(emprendimiento.get().getDominio(), HttpStatus.OK);
	 }
	
	
	@PutMapping(value = "/emprendimiento/{id}")
	 public  ResponseEntity<Optional<Emprendimiento>> updateEmprendimiento(@PathVariable("id") long id, @RequestBody Emprendimiento emprendimiento) {
		 Optional<Emprendimiento> currentEmprendimiento = emprendimientoRepository.findById(id);
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
	
	//  CONTROLERS PLAN
	
	@PostMapping("/createPlan")
	 public ResponseEntity<Plan> createPlan(@RequestBody Plan plan) {
		 System.out.println("Entra al controller Plan");
		 planRepository.save(plan);
		 return new ResponseEntity<Plan>(plan, HttpStatus.CREATED);
	}
	
	@GetMapping("/getPlan")
	 public ResponseEntity<Plan> getPlan(@RequestParam long id) {
		 Optional<Plan> plan = planRepository.findById(id);
		 if (plan.isEmpty()) {
			 return new ResponseEntity<Plan>(HttpStatus.NOT_FOUND);
		 }
		 return new ResponseEntity<Plan>(plan.get(), HttpStatus.OK);
	 }
	
	//  CONTROLERS POSTEO
	
	@PostMapping("/createPosteo")
	 public ResponseEntity<Posteo> createPosteo(@RequestBody Posteo posteo) {
		 System.out.println("Entra al controller posteo");
		 posteoRepository.save(posteo);
		 return new ResponseEntity<Posteo>(posteo, HttpStatus.CREATED);
	}
	
	@GetMapping("/getPosteo")
	 public ResponseEntity<Posteo> getPosteo(@RequestParam long id) {
		 Optional<Posteo> posteo = posteoRepository.findById(id);
		 if (posteo.isEmpty()) {
			 return new ResponseEntity<Posteo>(HttpStatus.NOT_FOUND);
		 }
		 return new ResponseEntity<Posteo>(posteo.get(), HttpStatus.OK);
	 }
	
	// CONTROLERS ROL
	
	@PostMapping("/createRol")
	 public ResponseEntity<Rol> createRol(@RequestBody Rol rol) {
		 System.out.println("Entra al controller Rol");
		 rolRepository.save(rol);
		 return new ResponseEntity<Rol>(rol, HttpStatus.CREATED);
	}
	
	@GetMapping("/getRol")
	 public ResponseEntity<Rol> getRol(@RequestParam long id) {
		 Optional<Rol> rol = rolRepository.findById(id);
		 if (rol.isEmpty()) {
			 return new ResponseEntity<Rol>(HttpStatus.NOT_FOUND);
		 }
		 return new ResponseEntity<Rol>(rol.get(), HttpStatus.OK);
	 }
	
	// CONTROLERS url
	
	@PostMapping("/createUrl")
	 public ResponseEntity<Url> createUrl(@RequestBody Url url) {
		 System.out.println("Entra al controller Url");
		 urlRepository.save(url);
		 return new ResponseEntity<Url>(url, HttpStatus.CREATED);
	}
	
	@GetMapping("/getUrl")
	 public ResponseEntity<Url> getUrl(@RequestParam long id) {
		 Optional<Url> url = urlRepository.findById(id);
		 if (url.isEmpty()) {
			 return new ResponseEntity<Url>(HttpStatus.NOT_FOUND);
		 }
		 return new ResponseEntity<Url>(url.get(), HttpStatus.OK);
	 }
	
	
	// CONTROLERS Usuario
	
	@PostMapping("/registrarUsuario")
	 public ResponseEntity<Usuario> createUsuario(@RequestBody Usuario user) {
		 System.out.println("Entra al controller");
		 usuarioRepository.save(user);
		 return new ResponseEntity<Usuario>(user, HttpStatus.CREATED);
	 }
	
	
	@GetMapping("/getUsuario")
	 public ResponseEntity<Usuario> getUsuario(@RequestParam long id) {
		 Optional<Usuario> user = usuarioRepository.findById(id);
		 if (user.isEmpty()) {
			 return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
		 }
		 return new ResponseEntity<Usuario>(user.get(), HttpStatus.OK);
	 }

	
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
	@GetMapping("/probando")
	 public ResponseEntity<Emprendimiento> listar() {
		 System.out.println("Entra al controller");
		 Emprendimiento emprendimiento = new Emprendimiento("Probando","1234");
		 return ResponseEntity.ok(emprendimiento);
	 }
}
