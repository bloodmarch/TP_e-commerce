package com.iia.spring.repository;

import org.springframework.data.repository.CrudRepository;

import com.iia.spring.entity.Caddy;

/**
 * Repository of the class @see Caddy
 * @author Balidas Benjamin
 *
 */
public interface CaddyRepository extends CrudRepository<Caddy, Long> {

}
