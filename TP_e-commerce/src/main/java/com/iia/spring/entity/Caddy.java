package com.iia.spring.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Class @see Caddy from database
 * @author Balidas Benjamin
 *
 */
@Entity
@Table(name = "caddy")
public class Caddy {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String date;
	private CaddyState state;
	private float totalPrice;
	
	/**
	 * Empty constructor class @see Caddy
	 */
	protected Caddy() {}
	
	/**
	 * Constructor class @see Caddy
	 * @param date			@see String			date of this @see Caddy
	 * @param state			@see CaddyState		State of this Caddy
	 * @param totalPrice	@see Float			totalPrice of this @see Caddy
	 */
	public Caddy(String date, CaddyState state, float totalPrice) {
		this.setDate(date)
			.setState(state)
			.setTotalPrice(totalPrice);
	}
	
	/**
	 * Override of the method @see toString() for the class @see Caddy
	 */
	@Override
	public String toString() {
		return "\nDate : " + this.getDate() 
			+ "\nState : " + this.getState() 
			+ "\nTotalPrice : " + this.getTotalPrice() 
			+ "\n";
		
	}
	
	/**
	 * References OneToMany to @see Customer 
	 */
	@OneToMany(mappedBy="caddy")
	private List<Customer> customers;
	
	/**
	 * @return the customers
	 */
	public List<Customer> getCustomers() {
		return customers;
	}

	/**
	 * @param customers the customers to set
	 * @return this @see Caddy
	 */
	public Caddy setCustomers(List<Customer> customers) {
		this.customers = customers;
		return this;
	}

	/**
	 * References ManyToMany to @see Product
	 */
	@ManyToMany(targetEntity = Product.class, cascade=CascadeType.MERGE)
	/**
	 * References Table "product_caddy" in database
	 */
	@JoinTable(
			name = "product_caddy",
			joinColumns = {@JoinColumn(name = "product_id")},
			inverseJoinColumns = {@JoinColumn(name = "caddy_id")})
	private Set<Product> products = new HashSet<>();

	/**
	 * @return the products
	 */
	public Set<Product> getProducts() {
		return products;
	}

	/**
	 * @param products the products to set
	 * @return this @see Caddy
	 */
	public Caddy setProducts(Set<Product> products) {
		this.products = products;
		return this;
	}
	
	/**
	 * Add a @see Product to @see Caddy products
	 * @param product	@see Product product to add
	 */
	public void ProductAdd(Product product) {
		this.products.add(product);
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	
	/**
	 * @param id the id to set
	 * @return this @see Caddy
	 */
	public Caddy setId(Long id) {
		this.id = id;
		return this;
	}
	
	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}
	
	/**
	 * @param date the date to set
	 * @return this @see Caddy
	 */
	public Caddy setDate(String date) {
		this.date = date;
		return this;
	}
	
	/**
	 * @return the state
	 */
	public CaddyState getState() {
		return state;
	}
	
	/**
	 * @param state the state to set
	 * @return this @see Caddy
	 */
	public Caddy setState(CaddyState state) {
		this.state = state;
		return this;
	}
	
	/**
	 * @return the totalPrice
	 */
	public float getTotalPrice() {
		return totalPrice;
	}
	
	/**
	 * @param totalPrice the totalPrice to set
	 * @return this @see Caddy
	 */
	public Caddy setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
		return this;
	}
	
}
