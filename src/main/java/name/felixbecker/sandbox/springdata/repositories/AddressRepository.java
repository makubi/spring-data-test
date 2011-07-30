package name.felixbecker.sandbox.springdata.repositories;

import name.felixbecker.sandbox.springdata.entities.Address;

import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Long> {

}
