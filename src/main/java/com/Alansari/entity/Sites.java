package com.Alansari.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="sites",catalog = "ATC")
@ApiModel(description = "All details about the Sites. ")
public class Sites implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	@ApiModelProperty(notes = "The Site ID")
	@Column(name="sid")
	private int sid;
	
	@ApiModelProperty(notes = "The Site Street")
	@Column(name="sstreet",nullable = false)
	private String sstreet;
	
	@ApiModelProperty(notes = "The Site State")
	@Column(name="sstate",nullable = false)
	private String sstate;
	
	@ApiModelProperty(notes = "The Site Country")
	@Column(name="scountry",nullable = false)
	private String scountry;
	
	@ApiModelProperty(notes = "The Site Team Leader")
	@Column(name="teamleader")
	private String teamleader;
	
	@ApiModelProperty(notes = "The Site Incharge Mobile ")
	@Column(name="tmobile")
	private int tmobile;
	
	@ApiModelProperty(notes = "The Site Vechiles count**")
	@Column(name="vehicles")
	private int vehicles;
	
	@ApiModelProperty(notes = "The Site Labours Count**")
	@Column(name="laborers")
	private int laborers;
	
	@ApiModelProperty(notes = "The Site Name")
	@Column(name="sname")
	private String sname; 
	
	@ApiModelProperty(notes = "The Site Status")
	@Column(name="sstatus")
	private String status; 
	
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getSid() {
		return sid;
	}

	public String getSstreet() {
		return sstreet;
	}

	public String getSstate() {
		return sstate;
	}

	public String getScountry() {
		return scountry;
	}

	public String getTeamleader() {
		return teamleader;
	}

	public int getTmobile() {
		return tmobile;
	}

	public int getVehicles() {
		return vehicles;
	}

	public int getLaborers() {
		return laborers;
	}


	public void setSid(int sid) {
		this.sid = sid;
	}

	public void setSstreet(String sstreet) {
		this.sstreet = sstreet;
	}

	public void setSstate(String sstate) {
		this.sstate = sstate;
	}

	public void setScountry(String scountry) {
		this.scountry = scountry;
	}

	public void setTeamleader(String teamleader) {
		this.teamleader = teamleader;
	}

	public void setTmobile(int tmobile) {
		this.tmobile = tmobile;
	}

	public void setVehicles(int vehicles) {
		this.vehicles = vehicles;
	}

	public void setLaborers(int laborers) {
		this.laborers = laborers;
	}

}
