package pl.edu.agh.ki.mwo.SchoolWebApp.repository;


import org.springframework.data.repository.CrudRepository;

import pl.edu.agh.ki.mwo.SchoolWebApp.entity.Subjects;

public interface SubjectRepository extends CrudRepository<Subjects, Long> {

}
