package com.Alansari.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "client",catalog = "ATC")
public class Clients {


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "cid",nullable = false)
	private int cid;

	@ApiModelProperty(notes = "The Client Comapany Registration")
	@Column(name = "cr",nullable = false)
	private String cr;

	@ApiModelProperty(notes = "The Client Name")
	@Column(name = "cname",nullable = false)
	private String cname;

	@ApiModelProperty(notes = "The Client Contact person")
	@Column(name = "cperson",nullable = false)
	private String cperson;
	
	@ApiModelProperty(notes = "The Client Mobile")
	@Column(name = "cmobile",nullable = false)
	private String cmobile;
	
	@ApiModelProperty(notes = "The Contact person Position")
	@Column(name = "position",nullable = false)
	private String position;
	
	@ApiModelProperty(notes = "The Client Company state")
	@Column(name = "cstate",nullable = false)
	private String cstate;
	
	@ApiModelProperty(notes = "The Client Company street")
	@Column(name = "cstreet",nullable = false)
	private String cstreet;
	
	@ApiModelProperty(notes = "The Client Company couontry")
	@Column(name = "ccountry",nullable = false)
	private String ccountry;
	
	@ApiModelProperty(notes = "The Client Cr copy Image")
	@Lob
	@Basic
    @Column(name = "crcopy",columnDefinition="LongBlob")
    private byte[] crcopy;
	
	public byte[] getCrcopy() {
		return crcopy;
	}

	public void setCrcopy(byte[] crcopy) {
		this.crcopy = crcopy;
	}

	
	@ApiModelProperty(notes = "The Client Comapny profile picture")
	@Lob
	@Basic
    @Column(name = "clipic",columnDefinition="LongBlob")
    private byte[] clipic;
	

	public byte[] getClipic() {
		return clipic;
	}

	public void setClipic(byte[] clipic) {
		this.clipic = clipic;
	}

	public int getCid() {
		return cid;
	}

	public String getCr() {
		return cr;
	}

	public String getCname() {
		return cname;
	}

	public String getCperson() {
		return cperson;
	}

	public String getCmobile() {
		return cmobile;
	}

	public String getPosition() {
		return position;
	}

	public String getCstate() {
		return cstate;
	}

	public String getCstreet() {
		return cstreet;
	}

	public String getCcountry() {
		return ccountry;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public void setCr(String cr) {
		this.cr = cr;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public void setCperson(String cperson) {
		this.cperson = cperson;
	}

	public void setCmobile(String cmobile) {
		this.cmobile = cmobile;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public void setCstate(String cstate) {
		this.cstate = cstate;
	}

	public void setCstreet(String cstreet) {
		this.cstreet = cstreet;
	}

	public void setCcountry(String ccountry) {
		this.ccountry = ccountry;
	}

	
}
