package pl.edu.agh.ki.mwo.SchoolWebApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.edu.agh.ki.mwo.SchoolWebApp.entity.Role;


@Repository("roleRepository")
public interface RoleRepository extends JpaRepository<Role, Integer>{
	Role findByRole(String role);

}
