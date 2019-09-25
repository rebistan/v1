package com.Alansari.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.Alansari.entity.Teams;

public interface TeamRepository extends CrudRepository<Teams, String> {

	List<Teams> findByPosition(String position);

	List<Teams> findByVillano(Integer id);


}
