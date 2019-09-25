package com.Alansari.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.Alansari.entity.EmpPay;

public interface EpayrollRepository extends JpaRepository<EmpPay, Integer> {
	   List<EmpPay> findById(int id);

	
}
