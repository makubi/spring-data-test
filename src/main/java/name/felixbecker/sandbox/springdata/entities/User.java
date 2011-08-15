package name.felixbecker.sandbox.springdata.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class User implements Serializable {
	
	private String username;
	private String password;
	
	private String firstName;
	private String lastName;
	private Integer age;
	
	@ManyToOne
	private Address address;
	
	@Id	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	public User(String firstName, String lastName, int age){
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}
	
	public User(){};
	
	// boilerplate below

	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password
				+ ", firstName=" + firstName + ", lastName=" + lastName
				+ ", age=" + age + ", address=" + address + ", id=" + id + "]";
	}
	
	
}
