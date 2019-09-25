package com.Alansari.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


import com.Alansari.entity.Fleets;


public interface FleetsRepository extends CrudRepository<Fleets, Integer> {


	List<Fleets> findByStatus(String name);
	List<Fleets> findByModel(int model);
	List<Fleets> findByBrand(String brand);
	List<Fleets> findBySite(String site);
	List<Fleets> findByEquiptype(String equiptype);
}
