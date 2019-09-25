package com.Alansari.entity;

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
@Table(name = "outsource",catalog = "ATC")
@ApiModel(description = "All details about the Outsources. ")
public class Outsource {


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@ApiModelProperty(notes = "The Outsource id")
	@Column(name = "outid")
	private int outid;
	
	@ApiModelProperty(notes = "The Comapany registration")
	@Column(name = "cr",nullable = false)
	private String cr;
	
	@ApiModelProperty(notes = "The Name of the company")
	@Column(name = "cname",nullable = false)
	private String cname;
	
    @ApiModelProperty(notes = "The Contact person of the company")
	@Column(name = "cperson",nullable = false)
	private String cpersoon;
	
    @ApiModelProperty(notes = "The Mobile number of the contact person")
	@Column(name = "cmobile",nullable = false)
	private int cmobile;
	
    @ApiModelProperty(notes = "Maial id of the cionatct person")
	@Column(name = "cmail",nullable = false)
	private String cmail;
	
    @ApiModelProperty(notes = "Site id")
	@Column(name = "sid")
	private String siteid;

    @ApiModelProperty(notes = "Srvice received from the comapny")
	@Column(name = "service")
	private String service;

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	@ApiModelProperty(notes = "Company profile picture")
	@Lob
	@Basic
    @Column(name = "outpic",columnDefinition="LongBlob")
    private byte[] outpic;
	 
    @ApiModelProperty(notes = "The Company Cr copy")
	@Lob
	@Basic
    @Column(name = "crcopy",columnDefinition="LongBlob")
    private byte[] crcopy;


	public byte[] getOutpic() {
		return outpic;
	}

	public byte[] getCrcopy() {
		return crcopy;
	}

	public void setOutpic(byte[] outpic) {
		this.outpic = outpic;
	}

	public void setCrcopy(byte[] crcopy) {
		this.crcopy = crcopy;
	}

	public int getOutid() {
		return outid;
	}

	public String getCr() {
		return cr;
	}

	public String getCname() {
		return cname;
	}

	public String getCpersoon() {
		return cpersoon;
	}

	public int getCmobile() {
		return cmobile;
	}

	
	public String getCmail() {
		return cmail;
	}

	
	public String getSiteid() {
		return siteid;
	}

	public void setSiteid(String siteid) {
		this.siteid = siteid;
	}

	public void setOutid(int outid) {
		this.outid = outid;
	}

	public void setCr(String cr) {
		this.cr = cr;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public void setCpersoon(String cpersoon) {
		this.cpersoon = cpersoon;
	}

	public void setCmobile(int cmobile) {
		this.cmobile = cmobile;
	}

	public void setCmail(String cmail) {
		this.cmail = cmail;
	}		
}
