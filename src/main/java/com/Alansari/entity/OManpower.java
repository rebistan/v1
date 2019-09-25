package com.Alansari.entity;


import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "manpower",catalog = "ATC")
@ApiModel(description = "All details about the Employee. ")
public class OManpower {

	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;
	    @ApiModelProperty(notes = "The Manpower name")
		@NotNull
	    private String name;
	    
	    @ApiModelProperty(notes = "The Manpower professon")
	    @NotNull
	    private String prof;
	    
	    @ApiModelProperty(notes = "The Manpower QID")
	    @NotNull
	    private int qid;
	    
	    @ApiModelProperty(notes = "The Manpower Out source ID")
	    @NotNull
	    private int outid;
	    
	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getProf() {
		return prof;
	}

	public int getQid() {
		return qid;
	}

	

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setProf(String prof) {
		this.prof = prof;
	}

	public void setQid(int qid) {
		this.qid = qid;
	}

	
	
}
