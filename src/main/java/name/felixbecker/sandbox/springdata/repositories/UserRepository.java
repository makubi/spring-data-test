package name.felixbecker.sandbox.springdata.repositories;

import java.util.List;

import name.felixbecker.sandbox.springdata.entities.User;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<User, Long> {
	public List<User> findByLastName(String lastname);
	public List<User> findByFirstNameAndLastName(String firstName, String lastName);
	public List<User> findByFirstNameAndAddressStreetName(String firstName, String streetName);
	
	public User findByUsername(String username);
	
	@Query("Select o from User o where o.lastName = :lastname")
	public List<User> schinken(@Param("lastname")String lastname);
}
