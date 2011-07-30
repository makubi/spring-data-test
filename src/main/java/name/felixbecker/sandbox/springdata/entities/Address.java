package name.felixbecker.sandbox.springdata.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Address {

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String streetName;
	private String zipCode;
	
	// boiler plate below
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	@Override
	public String toString() {
		return "Address [id=" + id + ", streetName=" + streetName
				+ ", zipCode=" + zipCode + "]";
	}
	
}
