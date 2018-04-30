package pl.edu.agh.ki.mwo.SchoolWebApp.repository;

import org.springframework.data.repository.CrudRepository;

import pl.edu.agh.ki.mwo.SchoolWebApp.entity.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {

}
