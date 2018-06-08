package pl.edu.agh.ki.mwo.SchoolWebApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.edu.agh.ki.mwo.SchoolWebApp.entity.User;


@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long> {
	 User findByEmail(String email);
}