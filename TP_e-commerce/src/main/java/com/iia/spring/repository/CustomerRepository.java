package com.iia.spring.repository;

import org.springframework.data.repository.CrudRepository;

import com.iia.spring.entity.Customer;

/**
 * Repository of the class @see Customer
 * @author Balidas Benjamin
 *
 */
public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
