package com.iia.spring;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.text.Style;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.iia.spring.entity.Caddy;
import com.iia.spring.entity.CaddyState;
import com.iia.spring.entity.Customer;
import com.iia.spring.entity.Product;
import com.iia.spring.repository.CaddyRepository;
import com.iia.spring.repository.CustomerRepository;
import com.iia.spring.repository.ProductRepository;

/**
 * Main application
 * @author Balidas Benjamin
 *
 */
@SpringBootApplication
public class Application {
	
	final static Log logger = LogFactory.getLog(Style.class);
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	public CommandLineRunner clr(CustomerRepository customerRepository, ProductRepository productRepository, CaddyRepository caddyRepository) {
		return (args) -> {
			
			//PRODUCT
			productRepository.deleteAll();
			
			Product product1 = new Product("Jouet", "Tres utile pour les enfants", 666, true, 1299.99f);
			Product product2 = new Product("Gateau", "Manger", 666, true, 1299.99f);
			Product product3 = new Product("Joris", "Inutle", 0, false, 0.01f);
			
			//DATE FORMAT
			Date date = new Date();
			DateFormat shortDateFormat = DateFormat.getDateTimeInstance(
				DateFormat.SHORT,
				DateFormat.SHORT);
			
			//CADDY
			productRepository.deleteAll();

			Caddy caddy1 = new Caddy(shortDateFormat.format(date), CaddyState.Brouillon, 125849.15f);
			Caddy caddy2 = new Caddy(shortDateFormat.format(date), CaddyState.EnCours, 125849.15f);
			Caddy caddy3 = new Caddy(shortDateFormat.format(date), CaddyState.Finie, 125849.15f);
			
			//CUSTOMER
			customerRepository.deleteAll();

			Customer customer1 = new Customer("Balidas", "Benjamin", "0649381612", "5 impasse de la boistardiere", 53240, "Saint jean sur mayenne", caddy1);
			Customer customer2 = new Customer("Guerrier", "Joris", "0606060606", "Rue du plouc", 49000, "Angers", caddy2);
			Customer customer3 = new Customer("Antonio", "Maxime", "0606060606", "Rue du dev", 53000, "Laval", caddy3);
			
			List<Customer> customers = new ArrayList<Customer>();
			customers.add(customer1);
			customers.add(customer2);
			customers.add(customer3);
			
			//CUSTOMER OF THE CADDYS
			caddy1.setCustomers(customers);
			caddy2.setCustomers(customers);
			caddy3.setCustomers(customers);
			
			//PRODUCT <- CADDY
			product1.CaddyAdd(caddy1);
			product1.CaddyAdd(caddy3);
			product2.CaddyAdd(caddy2);
			product3.CaddyAdd(caddy3);

			//CADDY <- PRODUCT
			caddy1.ProductAdd(product1);
			caddy2.ProductAdd(product2);			
			caddy3.ProductAdd(product1);
			caddy3.ProductAdd(product3);
			
			//SAVE PRODUCT
			logger.info("\n*************************************************************************************************");
			productRepository.save(product1);
			logger.info("\nThis product is added : " + product1.toString());
			productRepository.save(product2);
			logger.info("\nThis product is added : " + product2.toString());
			productRepository.save(product3);
			logger.info("\nThis product is added : " + product3.toString());
			logger.info("\n*************************************************************************************************");
			
			//SAVE CADDY
			logger.info("\n*************************************************************************************************");
			caddyRepository.save(caddy1);
			logger.info("\nThis caddy is added : " + caddy1.toString());
			caddyRepository.save(caddy2);
			logger.info("\nThis caddy is added : " + caddy2.toString());
			caddyRepository.save(caddy3);
			logger.info("\nThis caddy is added : " + caddy3.toString());
			logger.info("\n*************************************************************************************************");
			
			
			//SAVE CUSTOMER
			logger.info("\n*************************************************************************************************");
			customerRepository.save(customer1);
			logger.info("\nThis customer is added : " + customer1.toString());
			customerRepository.save(customer2);
			logger.info("\nThis customer is added : " + customer2.toString());
			customerRepository.save(customer3);
			logger.info("\nThis customer is added : " + customer3.toString());
			logger.info("\n*************************************************************************************************");
			
		};
	}
	
}
