package com.Alansari.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Alansari.entity.EmpPay;
import com.Alansari.repository.EpayrollRepository;

import java.util.List;
import java.util.Optional;

@RequestMapping("alansari")
@RestController
public class EmpPayrollController {

    private EpayrollRepository epayrollRepository;

    public EmpPayrollController(EpayrollRepository epayrollRepository) {
        this.epayrollRepository = epayrollRepository;
    }

    @GetMapping(value = "epay/all")
    public List<EmpPay> getUsersContact() {
        return epayrollRepository.findAll();
    }

    @GetMapping("epay/id/{accomid}")
    public Optional<EmpPay> getId(@PathVariable("accomid") final Integer id) {
        return epayrollRepository.findById(id);
    }
}
