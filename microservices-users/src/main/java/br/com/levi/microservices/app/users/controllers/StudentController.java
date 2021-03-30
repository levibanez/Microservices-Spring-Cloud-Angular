package br.com.levi.microservices.app.users.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.levi.microservices.app.users.models.entity.Student;
import br.com.levi.microservices.app.users.services.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService service;
	
	@GetMapping
	public ResponseEntity<?> list() {
		return ResponseEntity.ok().body(service.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> get(@PathVariable Long id) {
		
		Optional<Student> o = service.findById(id);
		
		if (o.isEmpty()) {
			ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(o.get());
	}
}
