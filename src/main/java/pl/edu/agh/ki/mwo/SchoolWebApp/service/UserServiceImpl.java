package pl.edu.agh.ki.mwo.SchoolWebApp.service;

import pl.edu.agh.ki.mwo.SchoolWebApp.entity.Role;
import pl.edu.agh.ki.mwo.SchoolWebApp.entity.User;
import pl.edu.agh.ki.mwo.SchoolWebApp.repository.RoleRepository;
import pl.edu.agh.ki.mwo.SchoolWebApp.repository.UserRepository;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service("userService")
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	@Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public User findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public void saveUser(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(1);
/*        Role userRole = roleRepository.findByRole("ADMIN");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
*/		userRepository.save(user);
	}

}