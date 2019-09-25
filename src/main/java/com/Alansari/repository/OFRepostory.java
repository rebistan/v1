package com.Alansari.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Alansari.entity.OFleet;

public interface OFRepostory extends JpaRepository<OFleet, Integer> {

	List<OFleet> findByOutid(int id);

}
