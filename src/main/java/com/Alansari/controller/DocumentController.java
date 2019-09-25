package com.Alansari.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Alansari.entity.DocumentAccom;
import com.Alansari.entity.DocumentClient;
import com.Alansari.entity.DocumentFleet;
import com.Alansari.entity.DocumentOFleet;
import com.Alansari.entity.DocumentSite;
import com.Alansari.entity.DocumentTeam;
import com.Alansari.entity.DocumentOutsource;
import com.Alansari.repository.DARepository;
import com.Alansari.repository.DCRepository;
import com.Alansari.repository.DFRepository;
import com.Alansari.repository.DOFRepository;
import com.Alansari.repository.DORepository;
import com.Alansari.repository.DSRepository;
import com.Alansari.repository.DTRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
@RequestMapping("/api/v1")
@Api(value="Document management", description="All documents are display here")
public class DocumentController {
 @Autowired
 DFRepository fdrepository;
 
 @Autowired
 DTRepository tdrepository;
 
 @Autowired
 DSRepository sdrepository;
 
 @Autowired
 DARepository  adrepository;
 
 @Autowired
 DOFRepository ofdrepository;
 
 @Autowired
 DORepository odrepository;
 
 @Autowired
 DCRepository cdrepository;
 
 @ApiOperation(value = "View a list of available Documents", response = List.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
 
 @GetMapping("document/fleet/all")
  public List<DocumentFleet> allFleetDocumet(){
	 return fdrepository.findAll();
 }
 @ApiOperation(value = "View a list of available Documents", response = List.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
 @GetMapping("document/team/all")
 public List<DocumentTeam> allTeamDocumet(){
	 return tdrepository.findAll();
}
 @ApiOperation(value = "View a list of available Documents", response = List.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
 @GetMapping("document/site/all")
 public List<DocumentSite> allSiteDocumet(){
	 return sdrepository.findAll();
}
 @ApiOperation(value = "View a list of available Documents", response = List.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
 @GetMapping("document/accom/all")
 public List<DocumentAccom> allAccomDocumet(){
	 return adrepository.findAll();
}
 @ApiOperation(value = "View a list of available Documents", response = List.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
 @GetMapping("document/ofleet/all")
 public List<DocumentOFleet> allOfleetDocumet(){
	 return ofdrepository.findAll();
}
 @ApiOperation(value = "View a list of available Documents", response = List.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
 @GetMapping("document/outsource/all")
 public List<DocumentOutsource> allOutsourceDocumet(){
	 return odrepository.findAll();	 	 
}
 @ApiOperation(value = "View a list of available Documents", response = List.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
 @GetMapping("document/client/all")
 public List<DocumentClient> allClientDocumet(){
	 return cdrepository.findAll();
 }
}