package com.Alansari.entity;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "fleets",catalog = "ATC")
@ApiModel(description = "All details about the  fleets. ")
public class Fleets {


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@ApiModelProperty(notes = "The Fleets Registration number")
	@Column(name = "regno",nullable = false)
	private int regno;
	
	@ApiModelProperty(notes = "The Fleets Brand")
	@Column(name = "brand",nullable = false)
	private String brand;

	@ApiModelProperty(notes = "The Fleets Model")
	@Column(name = "model",nullable = false)
	private int model;
	
	@ApiModelProperty(notes = "The Fleets Type")
	@Column(name = "equiptype",nullable = false)
	private String equiptype;

	@ApiModelProperty(notes = "The Fleets Istimara Validity")
	@Column(name = "istimara")
	private Date istimara;
	
	@ApiModelProperty(notes = "The Fleets Insurance Validity")
	
	@Column(name = "insurance")
	private Date insurance;
	
	@Column(name = "site")
	private String site;
		
	@Column(name = "status")
	private String status;
	
	public Date getIstimara() {
		return istimara;
	}

	public Date getInsurance() {
		return insurance;
	}

	public void setIstimara(Date istimara) {
		this.istimara = istimara;
	}

	public void setInsurance(Date insurance) {
		this.insurance = insurance;
	}

	@ApiModelProperty(notes = "The Fleets Picture")
	@Lob
	@Basic
    @Column(name = "fleetpic",columnDefinition="LongBlob")
    private byte[] fleetpic;

	public byte[] getFleetpic() {
		return fleetpic;
	}

	public void setFleetpic(byte[] fleetpic) {
		this.fleetpic = fleetpic;
	}

	public String getEquiptype() {
		return equiptype;
	}

	public void setEquiptype(String equiptype) {
		this.equiptype = equiptype;
	}

	

	public String getSite() {
		return site;
	}

	

	public String getStatus() {
		return status;
	}

	public void setSite(String site) {
		this.site = site;
	}

	

	public void setStatus(String status) {
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public int getRegno() {
		return regno;
	}

	public String getBrand() {
		return brand;
	}

	public int getModel() {
		return model;
	}

	public void setId(int id) {
		this.id =id;
	}

	public void setRegno(int regno) {
		this.regno = regno;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public void setModel(int model) {
		this.model = model;
	}
}
