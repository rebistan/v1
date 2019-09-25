package com.Alansari.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Alansari.entity.OManpower;

public interface OMRepository extends JpaRepository<OManpower, Integer>{

	List<OManpower> findByOutid(Integer id);

}
