package pl.edu.agh.ki.mwo.repository;

import org.springframework.data.repository.CrudRepository;

import pl.edu.agh.ki.mwo.entity.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {

}
