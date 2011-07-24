package name.felixbecker.sandbox.springdata.services;

import name.felixbecker.sandbox.springdata.entities.User;
import name.felixbecker.sandbox.springdata.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

	@Autowired private UserRepository userRepository;
	
	@Transactional
	public User createUser(String firstName, String lastName, int age){
		User user = new User();
		user.setAge(age);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		return userRepository.save(user);
	}
	
}
