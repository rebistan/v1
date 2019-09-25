package com.Alansari.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Alansari.entity.Teams;
import com.Alansari.exception.ResourceNotFoundException;
import com.Alansari.repository.TeamRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api/v1")
@Api(value="Profile Management System", description=" Update  and view the profile details")
public class ProfileController {
	@Autowired
	TeamRepository teamsRepository;
	
	@ApiOperation(value = "Get an User by Id")
	@GetMapping("/profile/{id}")
	public ResponseEntity<Teams> getEmployeeById(
			@ApiParam(value = "profile id from which client object will retrieve", required = true)
			@PathVariable(value = "id") String id)
			throws ResourceNotFoundException {
		Teams team = teamsRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("profile not found for this id :: " + id));
		return ResponseEntity.ok().body(team);
	}
}
