package com.Alansari.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Alansari.entity.Payroll;

public interface PayrollRepository extends JpaRepository<Payroll,Integer> {

	List<Payroll> findByQid(Integer qid);
	List<Payroll> findByPayrec(Integer id);
}
