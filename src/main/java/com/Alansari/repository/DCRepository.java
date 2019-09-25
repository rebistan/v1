package com.Alansari.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Alansari.entity.DocumentClient;


public interface DCRepository extends JpaRepository<DocumentClient, Integer> {

}
