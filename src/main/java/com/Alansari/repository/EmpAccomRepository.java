package com.Alansari.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Alansari.entity.Accom;
import com.Alansari.entity.EmpAccom;

public interface EmpAccomRepository extends JpaRepository<EmpAccom, Integer> {
	   List<Accom> findById(int id);

	
}
