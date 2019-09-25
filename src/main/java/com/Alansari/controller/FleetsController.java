package com.Alansari.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Alansari.entity.Fleets;
import com.Alansari.repository.FleetsRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/v1")
@Api(value="Fleets Management System", description="Add , Update , dalete and view the Fleets details")
public class FleetsController {

	@Autowired
	FleetsRepository fleetsRepository;

	@ApiOperation(value = "Add an Fleets")
	@PostMapping("fleet/add")
	public Fleets addFleets(@RequestBody Fleets fleets) {

		return fleetsRepository.save(fleets);
	}

	@ApiOperation(value = "View a list of available Fleeets", response = List.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@GetMapping("fleet/all")
	public Iterable<Fleets> allFleets() {

		return fleetsRepository.findAll();
	}

	@ApiOperation(value = "Get an Fleet by Id")
	@GetMapping("fleet/id/{id}")
	public Optional<Fleets> fleetsById(@PathVariable("id") int id) {

		return fleetsRepository.findById(id);
	}

	@ApiOperation(value = "Get an Fleet by Status")
	@GetMapping("fleet/status/{status}")
	public List<Fleets> SitesByStatus(@PathVariable("status") String status) {

		return fleetsRepository.findByStatus(status);
}
	@ApiOperation(value = "Get an Fleet by Site")
	@GetMapping("fleet/site/{site}")
	public List<Fleets> SitesBySite(@PathVariable String site) {

		return fleetsRepository.findBySite(site);
}
	@ApiOperation(value = "Get an Fleet by type of equipment")
	@GetMapping("fleet/type/{equiptype}")
	public List<Fleets> SitesByEquiptype(@PathVariable String equiptype) {

		return fleetsRepository.findByEquiptype(equiptype);
}
	@ApiOperation(value = "Get an Fleet by Brand")
	@GetMapping("fleet/brand/{brand}")
	public List<Fleets> SitesByBrand(@PathVariable String brand) {

		return fleetsRepository.findByBrand(brand);
}
	
	@ApiOperation(value = "Get an Fleet by Model")
	@GetMapping("fleet/model/{model}")
	public List<Fleets> SitesByModel(@PathVariable int model) {

		return fleetsRepository.findByModel(model);
}
	
	
	@ApiOperation(value = "Update an Fleets")
	@PutMapping("fleet/update/{id}")
	public Fleets updateFleets(@PathVariable("id") Integer id,@RequestBody Fleets fleets) {

		return fleetsRepository.save(fleets);
	}

	@ApiOperation(value = "Update an Delete")
	@DeleteMapping("fleet/id/{id}")
	public void deleteFleets(@PathVariable("id") int id) {

		fleetsRepository.deleteById(id);
	}
}
