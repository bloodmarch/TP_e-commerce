package com.iia.spring.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Class @see Customer from database
 * @author Balidas Benjamin
 *
 */
@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String lastName;
	private String firstName;
	private String phone;
	private String address;
	private int cp;
	private String city;
	
	/**
	 * Empty constructor class @see Customer
	 */
	protected Customer() {}
	
	/**
	 * Constructor class @see Customer
	 * @param lastName		@see String		lastName of this @see Customer
	 * @param firstName 	@see String		firstName of this @see Customer
	 * @param phone			@see String		phone of this @see Customer
	 * @param address		@see String		address of this @see Customer
	 * @param cp			@see Integer	cp of this @see Customer
	 * @param city 			@see String		city of this @see Customer
	 * @param caddy			@see Caddy 		caddy of this @see Customer
	 */	
	public Customer(String lastName, String firstName, String phone, String address, int cp, String city, Caddy caddy) {
		this.setLastName(lastName)
			.setFirstName(firstName)
			.setPhone(phone)
			.setAddress(address)
			.setCp(cp)
			.setCity(city)
			.setCaddy(caddy);
	}
	
	/**
	 * Override of the method @see toString() for the class @see Customer
	 */
	@Override
	public String toString() {
		return "\nLastName : " + this.getLastName() 
			+ "\nFirstName : " + this.getFirstName() 
			+ "\nPhone : " + this.getPhone() 
			+ "\nAddress : " + this.getAddress() 
			+ "\nCp : " + this.getCp() 
			+ "\nCity : " + this.getCity() 
			+ "\nCaddy : " + this.getCaddy() 
			+ "\n";
		
	}

	/**
	 * References ManyToOne to @see Caddy
	 */
	@ManyToOne
	private Caddy caddy;
	
	/**
	 * @return the @see Caddy caddy
	 */
	public Caddy getCaddy() {
		return caddy;
	}

	/**
	 * @param caddy the @see Caddy caddy to set
	 * @return this @see Customer
	 */
	public Customer setCaddy(Caddy caddy) {
		this.caddy = caddy;
		return this;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	
	/**
	 * @param id the id to set
	 * @return this @see Customer
	 */
	public Customer setId(Long id) {
		this.id = id;
		return this;
	}
	
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * @param lastName the lastName to set
	 * @return this @see Customer
	 */
	public Customer setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}
	
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * @param firstName the firstName to set
	 * @return this @see Customer
	 */
	public Customer setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}
	
	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	
	/**
	 * @param phone the phone to set
	 * @return this @see Customer
	 */
	public Customer setPhone(String phone) {
		this.phone = phone;
		return this;
	}
	
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	
	/**
	 * @param address the address to set
	 * @return this @see Customer
	 */
	public Customer setAddress(String address) {
		this.address = address;
		return this;
	}
	
	/**
	 * @return the cp
	 */
	public int getCp() {
		return cp;
	}
	
	/**
	 * @param cp the cp to set
	 * @return this @see Customer
	 */
	public Customer setCp(int cp) {
		this.cp = cp;
		return this;
	}
	
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	
	/**
	 * @param city the city to set
	 * @return this @see Customer
	 */
	public Customer setCity(String city) {
		this.city = city;
		return this;
	}

}
