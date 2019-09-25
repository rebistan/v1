package com.Alansari.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.Alansari.entity.Accom;
import java.util.List;


public interface AccomRepository extends JpaRepository<Accom, Integer> {
    List<Accom> findById(int id);



}
