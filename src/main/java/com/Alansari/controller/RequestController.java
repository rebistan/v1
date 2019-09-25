package com.Alansari.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.Alansari.entity.Request;
import com.Alansari.exception.ResourceNotFoundException;
import com.Alansari.repository.RequestRespository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/v1")
@Api(value="Request management", description="Crud Request are done here")
public class RequestController {

	@Autowired
	RequestRespository requestRepository;
	
	 @ApiOperation(value = "View a list of available Payroll", response = List.class)
	   	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
	   			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	   			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	   			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	       @GetMapping("/request/all")
	       public List<Request> getAll() {
	           return requestRepository.findAll();
	       }
	    @ApiOperation(value = "Add an payroll")
	    @PostMapping("/request/add")
		public Request addRequest(@ApiParam(value = "Request object store in database table", required = true)
		@RequestBody Request request,	HttpServletResponse response) {
					return requestRepository.save(request);	
		} 
	    
	    @ApiOperation(value = "REspose from Management")
	   	@PutMapping("/request/respose/{id}")
	   	public ResponseEntity<Request> updateAccom(
	   			@ApiParam(value = "Request Id to update request object", required = true)
	   			@PathVariable(value = "id") Integer id,
	   			@ApiParam(value = "Update Response object", required = true)
	   			@Valid @RequestBody Request req) throws ResourceNotFoundException {
	    	Request ac = requestRepository.findById(id)
	   				.orElseThrow(() -> new ResourceNotFoundException("Req not found for this id :: " + id));	
	   	
	   		ac.setRespose(req.getRespose());
	   		final Request updatedreq = requestRepository.save(ac);
	   		return ResponseEntity.ok(updatedreq);
	   	}
	   
	    @GetMapping("request/sender/{sender}")
		public List<Request> RequestBySender(@PathVariable("sender") Integer id) {
			return requestRepository.findBySender(id);
	}    
}
