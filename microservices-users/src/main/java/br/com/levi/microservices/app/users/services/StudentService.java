package br.com.levi.microservices.app.users.services;

import java.util.Optional;

import br.com.levi.microservices.app.users.models.entity.Student;

public interface StudentService {

	public Iterable<Student> findAll();
	
	public Optional<Student> findById(Long id);
	
	public Student save(Student student);
	
	public void deleteById(Long id);
}
