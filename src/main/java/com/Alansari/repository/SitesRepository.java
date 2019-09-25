package com.Alansari.repository;

import java.util.List;


import org.springframework.data.repository.CrudRepository;

import com.Alansari.entity.Sites;

public interface SitesRepository extends CrudRepository<Sites, Integer> {

	List<Sites> findByStatus(String name);


	
}
