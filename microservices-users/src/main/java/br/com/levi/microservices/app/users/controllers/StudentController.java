package br.com.levi.microservices.app.users.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.levi.microservices.app.users.models.entity.Student;
import br.com.levi.microservices.app.users.services.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService service;
	
	/**
	 * List All Students
	 * @return all students
	 */
	@GetMapping
	public ResponseEntity<?> list() {
		
		return ResponseEntity.ok().body(service.findAll());
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<?> get(@PathVariable Long id) {
		
		Optional<Student> o = service.findById(id);
		
		if (o.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(o.get());
	}
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Student student) {
		
		Student studentDb = service.save(student);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(studentDb);
	}
	
	@PutMapping("/{id}") 
	public ResponseEntity<?> edit(@RequestBody Student student, @PathVariable Long id) {
		
		Optional<Student> o = service.findById(id);
		
		if (o.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		Student studentDb = o.get();
		studentDb.setName(student.getName());
		studentDb.setNickname(student.getNickname());
		studentDb.setEmail(student.getEmail());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(studentDb));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> remove(@PathVariable Long id) {
		
		service.deleteById(id);
		
		return ResponseEntity.noContent().build();
	}
}




















