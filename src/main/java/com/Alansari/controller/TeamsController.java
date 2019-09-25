package com.Alansari.controller;

import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.ResourceAccessException;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import com.Alansari.Util.ZXingHelper;
import com.Alansari.entity.Accom;
import com.Alansari.entity.Teams;
import com.Alansari.repository.TeamRepository;
import com.Alansari.exception.ResourceNotFoundException;


@RestController
@RequestMapping("/api/v1")
@Api(value="Team Management System", description="Operations pertaining to employee in Team Management System")
public class TeamsController {

	@Autowired
	TeamRepository teamsRepository;
		
	@ApiOperation(value = "Add an employee")
	@PostMapping("/team")
	public Teams createEmployee(
			@ApiParam(value = "Employee object store in database table", required = true)
			@Valid @RequestBody Teams team) {
		return teamsRepository.save(team);
	}

	@ApiOperation(value = "View a list of available employees", response = List.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@GetMapping("/team")
    public Iterable<Teams> getAll() {
        return teamsRepository.findAll();
    }
	
	@ApiOperation(value = "Get an employee by Id")
	@GetMapping("/team/{id}")
	public ResponseEntity<Teams> getEmployeeById(
			@ApiParam(value = "Employee id from which employee object will retrieve", required = true)
			@PathVariable(value = "id") String id)
			throws ResourceNotFoundException {
		Teams team = teamsRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + id));
		return ResponseEntity.ok().body(team);
	}
	
/*	@RequestMapping(value = "team/qrcode/{id}", method = RequestMethod.GET)
	public void qrcode(@PathVariable("id") String id, HttpServletResponse response) throws Exception {
		response.setContentType("image/png");
		OutputStream outputStream = response.getOutputStream();
		outputStream.write(ZXingHelper.getQRCodeImage(id, 200, 200));
		outputStream.flush();
		outputStream.close();
	}
	*/
	
	@GetMapping("team/position/{position}")
	public List<Teams> teamsByPosition(@PathVariable ("position") String position) {
		
		return teamsRepository.findByPosition(position);
				
}

	@ApiOperation(value = "Update an employee")
	@PutMapping("/team/{id}")
	public ResponseEntity<Teams> updateEmployee(
			@ApiParam(value = "Employee Id to update employee object", required = true)
			@PathVariable(value = "id") String id,
			@ApiParam(value = "Update employee object", required = true)
			@Valid @RequestBody Teams employeeDetails) throws ResourceNotFoundException {
		Teams employee = teamsRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + id));

		employee.setMobile(employeeDetails.getMobile());
		employee.setName(employeeDetails.getName());
		employee.setDob(employeeDetails.getDob());
		employee.setGender(employeeDetails.getGender());
		employee.setPosition(employeeDetails.getPosition());
		employee.setNationality(employeeDetails.getNationality());
		employee.setContractpic(employeeDetails.getContractpic());
		employee.setEmppic(employeeDetails.getEmppic());
		employee.setPassportpic(employeeDetails.getPassportpic());
		employee.setJoining(employeeDetails.getJoining());
		employee.setQidpic(employeeDetails.getQidpic());
		employee.setVillano(employeeDetails.getVillano());
		employee.setRoom(employeeDetails.getRoom());
		final Teams updatedEmployee = teamsRepository.save(employee);
		return ResponseEntity.ok(updatedEmployee);
	}
	@ApiOperation(value = "Delete an employee")
	@DeleteMapping("/team/{id}")
	public Map<String, Boolean> deleteEmployee(
			@ApiParam(value = "Employee Id from which employee object will delete from database table", required = true)
			@PathVariable(value = "id") String id)
			throws ResourceNotFoundException {
		Teams employee = teamsRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + id));
		teamsRepository.delete(employee);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	
}
