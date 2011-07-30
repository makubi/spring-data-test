package name.felixbecker.sandbox.springdata.services;

import java.util.ArrayList;
import java.util.List;

import name.felixbecker.sandbox.springdata.entities.Address;
import name.felixbecker.sandbox.springdata.entities.User;
import name.felixbecker.sandbox.springdata.repositories.AddressRepository;
import name.felixbecker.sandbox.springdata.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

	@Autowired private UserRepository userRepository;
	@Autowired private AddressRepository addressRepository;
	
	@Transactional
	public User createUser(String firstName, String lastName, int age, String streetname, String zipCode){
		User user = new User();
		user.setAge(age);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		Address address = new Address();
		address.setStreetName(streetname);
		address.setZipCode(zipCode);
		user.setAddress(address);
		addressRepository.save(address);
		return userRepository.save(user);
	}
	
	@Transactional(readOnly=true)
	public List<User> getAllUsers(){
		List<User> ret = new ArrayList<User>();
		for(User user : userRepository.findAll()){
			ret.add(user);
		}
		return ret;
	}
	
	public UserRepository getUserRepository(){ return userRepository; };
	
	
}
