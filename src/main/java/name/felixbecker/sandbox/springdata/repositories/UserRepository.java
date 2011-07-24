package name.felixbecker.sandbox.springdata.repositories;

import name.felixbecker.sandbox.springdata.entities.User;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

}
