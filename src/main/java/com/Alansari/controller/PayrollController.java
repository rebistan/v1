package com.Alansari.controller;


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


import com.Alansari.entity.PayDetail;
import com.Alansari.entity.Payroll;
import com.Alansari.exception.ResourceNotFoundException;
import com.Alansari.repository.PayDetailRepository;
import com.Alansari.repository.PayrollRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1")
@Api(value="Payroll management", description="Crud Payroll are done here")
public class PayrollController {

    @Autowired
    PayrollRepository payrollRepository;
    @Autowired
    PayDetailRepository payDetailRepository;

    @ApiOperation(value = "View a list of available Payroll", response = List.class)
   	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
   			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
   			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
   			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
       @GetMapping("/payroll/all")
       public List<Payroll> getAll() {
           return payrollRepository.findAll();
       }
    
    @ApiOperation(value = "View a list of available Vacation", response = List.class)
    @GetMapping("/vacation/all")
    public List<PayDetail> getAll1() {
        return payDetailRepository.findAll();
    }
    
    @ApiOperation(value = "Add an payroll")
    @PostMapping("/payroll/add")
	public Payroll addPayroll(@ApiParam(value = "Payroll object store in database table", required = true)
	@RequestBody Payroll payroll,	HttpServletResponse response) {
	
		return payrollRepository.save(payroll);	
	} 

    @ApiOperation(value = "Add an Vacation")
    @PostMapping("/vacation/add")
	public PayDetail addPaydetail(@ApiParam(value = "Vacation object store in database table", required = true)
	@RequestBody PayDetail paydetail,	HttpServletResponse response) {
	
		return payDetailRepository.save(paydetail);	
	} 
    
    
    @PutMapping("vacation/update/{qid}")
	public PayDetail updatePaydetail(@PathVariable(value = "qid") Integer qid,@RequestBody PayDetail payDetail) {

		return payDetailRepository.save(payDetail);
	}
    
    @ApiOperation(value = "Get an Payroll by Id")
   	@GetMapping("/payroll/id/{id}")
   	public ResponseEntity<Payroll> getPayrollById(
   			@ApiParam(value = "Payroll id from which accommadation object will retrieve", required = true)
   			@PathVariable(value = "id") Integer id)
   			throws ResourceNotFoundException {
   		Payroll payroll = payrollRepository.findById(id)
   				.orElseThrow(() -> new ResourceNotFoundException("Accom not found for this id :: " + id));
   		return ResponseEntity.ok().body(payroll);
   	}  
    @ApiOperation(value = "Get an Recent pay")
   	@GetMapping("/payroll/rec/{id}")
   	public ResponseEntity<Payroll> getEmployeeById(
   			@ApiParam(value = "Recent payment", required = true)
   			@PathVariable(value = "id") Integer id)
   			throws ResourceNotFoundException {
   		Payroll pay = payrollRepository.findById(id)
   				.orElseThrow(() -> new ResourceNotFoundException("Pay not found for this id :: " + id));
   		return ResponseEntity.ok().body(pay);
   	}
    
    @ApiOperation(value = "View a History of payroll", response = List.class)
    @GetMapping("payroll/history/{qid}")
    public List<Payroll> getQid(@PathVariable("qid") final Integer id) {
        return payrollRepository.findByQid(id);
    }
           
    @ApiOperation(value = "Update an Payroll")
   	@PutMapping("/payroll/update/{id}")
   	public ResponseEntity<Payroll> updatePayroll(
   			@ApiParam(value = "Payroll Id to update Payroll object", required = true)
   			@PathVariable(value = "id") Integer id,
   			@ApiParam(value = "Update Payroll object", required = true)
   			@Valid @RequestBody Payroll payroll) throws ResourceNotFoundException {
   		Payroll pay = payrollRepository.findById(id)
   				.orElseThrow(() -> new ResourceNotFoundException("Payroll not found for this id :: " + id));	
   		pay.setPayrec(payroll.getPayrec());
   		pay.setBasic(payroll.getBasic());
   		pay.setOt(payroll.getOt());
   		pay.setAllowance(payroll.getAllowance());
   		pay.setOtime(payroll.getOtime());
   		pay.setDeduction(payroll.getDeduction());
   		
   		final Payroll updatedPayroll = payrollRepository.save(pay);
   		return ResponseEntity.ok(updatedPayroll);
   	}
    
    @ApiOperation(value = "Delete a site")
	@DeleteMapping("/payroll/{id}")
	public Map<String, Boolean> deleteSite(
			@ApiParam(value = "payroll Id from which site object will delete from database table", required = true)
			@PathVariable(value = "id") Integer id)
			throws ResourceNotFoundException {
		Payroll pay = payrollRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Payroll not found for this id :: " + id));

		payrollRepository.delete(pay);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
