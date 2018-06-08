package pl.edu.agh.ki.mwo.SchoolWebApp.repository;

import org.springframework.data.repository.CrudRepository;
import pl.edu.agh.ki.mwo.SchoolWebApp.entity.Teacher;

public interface TeacherRepository extends CrudRepository<Teacher, Long> {

}
