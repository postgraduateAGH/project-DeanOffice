package pl.edu.agh.ki.mwo.SchoolWebApp.repository;

import org.springframework.data.repository.CrudRepository;
import pl.edu.agh.ki.mwo.SchoolWebApp.entity.School;

// this will be AUTO IMPLEMENTED by Spring into a Bean called schoolRepositoiry

public interface SchoolRepository extends CrudRepository<School, Long> {

}
