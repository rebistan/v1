package com.Alansari.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Alansari.entity.Request;

public interface RequestRespository extends JpaRepository<Request, Integer> {

	List<Request> findBySender(Integer id);

}
