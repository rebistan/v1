package com.Alansari.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "manpower",catalog = "ATC")
@ApiModel(description = "All details about the Employee. ")
public class Manpower {

	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;
	    @ApiModelProperty(notes = "The Manpower name")
		@NotNull
	    private String name;
	    
	    @ApiModelProperty(notes = "The Manpower Profession")
	    @NotNull
	    private String prof;
	    
	    @ApiModelProperty(notes = "The Manpower QID")
	    @NotNull
	    private int qid;
	    
	    @OneToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "outid", referencedColumnName = "outid")
	
    private Outsource out;

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

	public Outsource getOut() {
		return out;
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

	public void setOut(Outsource out) {
		this.out = out;
	}
	
	
}
