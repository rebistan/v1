package com.Alansari.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Alansari.entity.EmpAccom;
import com.Alansari.repository.EmpAccomRepository;

import java.util.List;
import java.util.Optional;

@RequestMapping("alansari")
@RestController
public class EmpAccomController {

    private EmpAccomRepository empAccomRepository;

    public EmpAccomController(EmpAccomRepository empAccomRepository) {
        this.empAccomRepository = empAccomRepository;
    }

    @GetMapping(value = "eaccom/all")
    public List<EmpAccom> getUsersContact() {
        return empAccomRepository.findAll();
    }

    @GetMapping("eaccom/id/{accomid}")
    public Optional<EmpAccom> getId(@PathVariable("accomid") final Integer id) {
        return empAccomRepository.findById(id);
    }
}
