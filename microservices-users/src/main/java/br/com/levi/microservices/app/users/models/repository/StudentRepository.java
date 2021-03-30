package br.com.levi.microservices.app.users.models.repository;

import org.springframework.data.repository.CrudRepository;
import br.com.levi.microservices.app.users.models.entity.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {

}
