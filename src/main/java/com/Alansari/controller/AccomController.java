package com.Alansari.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.Alansari.Util.ZXingHelper;
import com.Alansari.entity.Accom;
import com.Alansari.entity.Sites;
import com.Alansari.entity.Teams;
import com.Alansari.exception.ResourceNotFoundException;
import com.Alansari.repository.AccomRepository;
import com.Alansari.repository.TeamRepository;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.QRCodeWriter;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/v1")
@Api(value="Accomadation management", description="Crud Accomadations are done here")
public class AccomController {

    @Autowired
    AccomRepository accomRepository;
    @Autowired
    TeamRepository teamsRepository;
  
    @ApiOperation(value = "View a list of available Accommdationos", response = List.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
    @GetMapping("/accom/all")
    public List<Accom> getAll() {
        return accomRepository.findAll();
    }
    
    @ApiOperation(value = "Update an Accommadtion")
   	@PutMapping("/accom/update/{id}")
   	public ResponseEntity<Accom> updateAccom(
   			@ApiParam(value = "Employee Id to update Accommadation object", required = true)
   			@PathVariable(value = "id") Integer id,
   			@ApiParam(value = "Update Accom object", required = true)
   			@Valid @RequestBody Accom accom) throws ResourceNotFoundException {
   		Accom ac = accomRepository.findById(id)
   				.orElseThrow(() -> new ResourceNotFoundException("Accom not found for this id :: " + id));	
   		ac.setStreet(accom.getStreet());
   		ac.setName(accom.getName());
   		final Accom updatedAccom = accomRepository.save(ac);
   		return ResponseEntity.ok(updatedAccom);
   	}
    
    @PostMapping("/accom/add")
	public Accom addAccom(@ApiParam(value = "Clients object store in database table", required = true)
	@RequestBody Accom accom) throws IOException {
           	
   		return accomRepository.save(accom);
   	}
      
	@ApiOperation(value = "Get an Accommadtion by Id")
	@GetMapping("/accom/id/{id}")
	public ResponseEntity<Accom> getEmployeeById(
			@ApiParam(value = "Accom id from which accommadation object will retrieve", required = true)
			@PathVariable(value = "id") Integer id)
			throws ResourceNotFoundException {
		Accom accom = accomRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Accom not found for this id :: " + id));
		return ResponseEntity.ok().body(accom);
	}
  
    @ApiOperation(value = "View a list of Employees livingin particular Accommdationos", response = List.class)
    @GetMapping("accom/list/{villano}")
    public List<Teams> getVillano(@PathVariable("villano") final Integer id) {
        return teamsRepository.findByVillano(id);
    }

}
