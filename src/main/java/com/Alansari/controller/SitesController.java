package com.Alansari.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Alansari.entity.Sites;
import com.Alansari.repository.SitesRepository;
import com.Alansari.exception.ResourceNotFoundException;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/v1")
@Api(value="Site Management System", description="Add , Update , delete and Sort the sites")
public class SitesController {

	@Autowired
	SitesRepository sitesRepository;

	
	@ApiOperation(value = "Add an site")
	@PostMapping("/site")
	public Sites createSite(
			@ApiParam(value = "Site object store in database table", required = true)
			@Valid @RequestBody Sites site) {
		return sitesRepository.save(site);
	}
	
	@ApiOperation(value = "View a list of available Sites", response = List.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@GetMapping("/site")
	public Iterable<Sites> getAllSites() {
		return sitesRepository.findAll();
	}
	
	@ApiOperation(value = "Get an Site by Id")
	@GetMapping("/site/{id}")
	public ResponseEntity<Sites> getSiteById(
			@ApiParam(value = "Sites id from which site object will retrieve", required = true)
			@PathVariable(value = "id") Integer id)
			throws ResourceNotFoundException {
		Sites site = sitesRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("site not found for this id :: " + id));
		return ResponseEntity.ok().body(site);
	}
	
	@GetMapping("site/status/{status}")
	public List<Sites> SitesByTitles(@PathVariable String status) {
		return sitesRepository.findByStatus(status);
}

	@ApiOperation(value = "Update an Site")
	@PutMapping("/site/{id}")
	public ResponseEntity<Sites> updateSite(
			@ApiParam(value = "Sites Id to update site object", required = true)
			@PathVariable(value = "id") Integer id,
			@ApiParam(value = "Update site object", required = true)
			@Valid @RequestBody Sites site) throws ResourceNotFoundException {
		Sites sites = sitesRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + id));

		sites.setSname(site.getSname());
		site.setScountry(sites.getScountry());
		site.setSstate(sites.getSstate());
		site.setSstreet(sites.getSstreet());
		site.setTeamleader(sites.getTeamleader());
		site.setLaborers(sites.getLaborers());
		site.setTmobile(sites.getTmobile());
		site.setVehicles(sites.getVehicles());
		site.setStatus(sites.getStatus());
		final Sites updatedSite = sitesRepository.save(sites);
		return ResponseEntity.ok(updatedSite);
	}

	@ApiOperation(value = "Delete a site")
	@DeleteMapping("/site/{id}")
	public Map<String, Boolean> deleteSite(
			@ApiParam(value = "Sites Id from which site object will delete from database table", required = true)
			@PathVariable(value = "id") Integer id)
			throws ResourceNotFoundException {
		Sites site = sitesRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Site not found for this id :: " + id));

		sitesRepository.delete(site);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
