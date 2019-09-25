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

import com.Alansari.entity.Clients;
import com.Alansari.repository.ClientsRepository;
import com.Alansari.exception.ResourceNotFoundException;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/v1")
@Api(value="Client Management System", description="Add , Update , dalete and view the client details")
public class ClientsController {

	@Autowired
	ClientsRepository clientssRepository;


	@ApiOperation(value = "View a list of available Clients", response = List.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@GetMapping("/clients")
	public Iterable<Clients> getAllClients() {
		return clientssRepository.findAll();
	}
	
	
	@ApiOperation(value = "Add an Clients")
	@PostMapping("/clients")
	public Clients createClients(
			@ApiParam(value = "Clients object store in database table", required = true)
			@Valid @RequestBody Clients clients) {
		return clientssRepository.save(clients);
	}

	@ApiOperation(value = "Get an Clients by Id")
	@GetMapping("/clients/{id}")
	public ResponseEntity<Clients> getEmployeeById(
			@ApiParam(value = "Clients id from which client object will retrieve", required = true)
			@PathVariable(value = "id") Integer id)
			throws ResourceNotFoundException {
		Clients clients = clientssRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Clients not found for this id :: " + id));
		return ResponseEntity.ok().body(clients);
	}

	

	@ApiOperation(value = "Update an Client Details")
	@PutMapping("/clients/{id}")
	public ResponseEntity<Clients> updateClients(
			@ApiParam(value = "Clients Id to update client object", required = true)
			@PathVariable(value = "id") Integer id,
			@ApiParam(value = "Update employee object", required = true)
			@Valid @RequestBody Clients clients) throws ResourceNotFoundException {
		Clients cli = clientssRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + id));

		cli.setCr(clients.getCr());
		cli.setCrcopy(clients.getCrcopy());
		cli.setClipic(clients.getClipic());
		cli.setCstreet(clients.getCstreet());
		cli.setCstate(clients.getCstate());
		cli.setCcountry(clients.getCcountry());
		cli.setCperson(clients.getCperson());
		cli.setPosition(clients.getPosition());
		cli.setCname(clients.getCname());
		cli.setCmobile(clients.getCmobile());
		final Clients updatedClients = clientssRepository.save(cli);
		return ResponseEntity.ok(updatedClients);
	}

	@ApiOperation(value = "Delete an Client")
	@DeleteMapping("/clients/{id}")
	public Map<String, Boolean> deleteClient(
			@ApiParam(value = "Clients Id from which client object will delete from database table", required = true)
			@PathVariable(value = "id") Integer id)
			throws ResourceNotFoundException {
		Clients clients = clientssRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Client not found for this id :: " + id));

		clientssRepository.delete(clients);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
