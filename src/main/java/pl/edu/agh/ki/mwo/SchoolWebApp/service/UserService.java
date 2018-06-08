package pl.edu.agh.ki.mwo.SchoolWebApp.service;

import pl.edu.agh.ki.mwo.SchoolWebApp.entity.User;

public interface UserService {
	public User findUserByEmail(String email);
	public void saveUser(User user);
}
