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

import com.Alansari.entity.Manpower;
import com.Alansari.entity.OFleet;
import com.Alansari.entity.OManpower;
import com.Alansari.entity.OutFleet;
import com.Alansari.entity.Outsource;
import com.Alansari.repository.ManpowerRepository;
import com.Alansari.repository.OFRepostory;
import com.Alansari.repository.OMRepository;
import com.Alansari.repository.OfleetRepository;
import com.Alansari.repository.OutsourceRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/v1")
@Api(value="Outsource management", description="Crud Outsource are done here")
public class OutsourceController {

	@Autowired
	OutsourceRepository outsourceRepository;
	@Autowired
    private OMRepository omrepository;
	@Autowired
    private ManpowerRepository manpowerRepository;	
	@Autowired
	OfleetRepository ofleetsrepository;
	@Autowired
	OFRepostory  ofrepository;
	
	
	public OutsourceController(ManpowerRepository manpowerRepository) {
        this.manpowerRepository = manpowerRepository;
    }
	
	@GetMapping("outsource/all")
	public Iterable<Outsource> allOutsource() {

		return outsourceRepository.findAll();
	}
	
	@PostMapping("outsurce/add")
	public Outsource addOutsource(@RequestBody Outsource outsource) {

		return outsourceRepository.save(outsource);
	}


	@GetMapping("outsource/id/{id}")
	public Optional<Outsource> fleetsById(@PathVariable("id") int id) {

		return outsourceRepository.findById(id);
	}
		
	@PutMapping("outsource/id/update")
	public Outsource updateOutsource(@RequestBody Outsource outsource) {

		return outsourceRepository.save(outsource);
	}
	@DeleteMapping("outsource/id/{id}")
	public void deleteOutsource(@PathVariable("id") int id) {

		outsourceRepository.deleteById(id);
	}
	
    
	@ApiOperation(value = "All outsourced Manpower ")
    @GetMapping(value = "outsource/man/all")
    public List<Manpower> getUsersContact() {
        return manpowerRepository.findAll();
    }
    
	@ApiOperation(value = "Specific  outsourced Manpower ")
    @GetMapping("outsource/man/id/{outid}")
    public List<OManpower> getOutid(@PathVariable("outid") final Integer id) {
        return omrepository.findByOutid(id);
    }
    
	@ApiOperation(value = "Add outsourced Manpower ")
 	@PostMapping("outsource/man/add")
 	public OManpower addOutMan(@RequestBody OManpower oman) {
 		return omrepository.save(oman);
 	}
 	
	@ApiOperation(value = "Delete outsourced Manpower ")
 	@DeleteMapping("outsource/man/id/{id}")
	public void deleteOutMan(@PathVariable("id") int id) {
 
 		omrepository.deleteById(id);
	}
 	
	@ApiOperation(value = "Update outsourced Manpower ")
 	@PutMapping("outsource/man/id/update")
 	public OManpower updateOutMan(@RequestBody OManpower oman) {

 		return omrepository.save(oman);
 	}
	
	
	
	@ApiOperation(value = "Add outsourced fleet ")
	@PostMapping("outsource/fleet/add")
	public OFleet addOutFleet(@RequestBody OFleet ofleet) {

		return ofrepository.save(ofleet);
	}
 
	@ApiOperation(value = "List all outsourced fleets ")
	@GetMapping("outsource/fleet/all")
	public Iterable<OutFleet> allOutfleet() {
		return ofleetsrepository.findAll();
	}

	@ApiOperation(value = " Display Particular Outsource comapny fleets")
	@GetMapping("outsource/fleet/id/{id}")
	public List<OFleet> fleetsByOutid(@PathVariable("id") int id) {

		return ofrepository.findByOutid(id);
	}
	
	@ApiOperation(value = "Update outsourced fleet ")
	@PutMapping("outsource/fleet/id/update")
	public OFleet updateOutsource(@RequestBody OFleet ofleet) {

		return ofrepository.save(ofleet);
	}

	@ApiOperation(value = "Delete outsourced fleet ")
	@DeleteMapping("outsource/fleet/id/{id}")
	public void deleteOutFleet(@PathVariable("id") int id) {

		ofrepository.deleteById(id);
	}
}
