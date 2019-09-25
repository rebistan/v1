package com.Alansari.entity;
import java.sql.Date;

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
@Table(name="employee",catalog = "ATC")
@ApiModel(description = "All details about the Employee. ")
public class Teams  {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	@ApiModelProperty(notes = "The employee QId")
	@Column(name="qid",nullable = false)
	private String qid;
	
	@ApiModelProperty(notes = "The employee first name")
	@Column(name="name",nullable = false)
	private String name;
	

	@ApiModelProperty(notes = "The employee Gender")
	@Column(name="gender",nullable = false)
	private String gender;
	
	@ApiModelProperty(notes = "The employee nationality")
	@Column(name="nationality",nullable = false)
	private String nationality;
	
	@ApiModelProperty(notes = "The employee accom number")
	@Column(name="user_id")
	private int villano;
	
	@ApiModelProperty(notes = "The employee mobile number")
	@Column(name="mobile",nullable = false)
	private String mobile;
	
	@ApiModelProperty(notes = "The employee Joining date")
	@Column(name="joining",nullable = false)
	private Date joining;
	
	@ApiModelProperty(notes = "The employee date of birth")
	@Column(name="dob",nullable = false)
	private Date dob;
	
	@ApiModelProperty(notes = "The employee position")
	@Column(name="position",nullable = false)
	private String position;
	
	@ApiModelProperty(notes = "The employee room number")
	@Column(name="room")
	private String room;

	@ApiModelProperty(notes = "The employee profile picture")
	@Lob
	@Basic
    @Column(name = "emppic",columnDefinition="LongBlob")
    private byte[] emppic;
	
	@ApiModelProperty(notes = "The employee passport picture")
	@Lob
	@Basic
    @Column(name = "passportpic",columnDefinition="LongBlob")
    private byte[] passportpic;
	
	@ApiModelProperty(notes = "The employee Qid picture")
	@Lob
	@Basic
    @Column(name = "qidpic",columnDefinition="LongBlob")
    private byte[] qidpic;
	
	@ApiModelProperty(notes = "The employee contract picture")
	@Lob
	@Basic
    @Column(name = "contractpic",columnDefinition="LongBlob")
    private byte[] contractpic;

	public byte[] getPassportpic() {
		return passportpic;
	}

	public byte[] getQidpic() {
		return qidpic;
	}

	public byte[] getContractpic() {
		return contractpic;
	}

	public void setPassportpic(byte[] passportpic) {
		this.passportpic = passportpic;
	}

	public void setQidpic(byte[] qidpic) {
		this.qidpic = qidpic;
	}

	public void setContractpic(byte[] contractpic) {
		this.contractpic = contractpic;
	}

	public byte[] getEmppic() {
		return emppic;
	}

	public void setEmppic(byte[] emppic) {
		this.emppic = emppic;
	}

	public Teams() {
		
	}
	
	public String getRoom() {
		return room;
	}

	public Teams setRoom(String room) {
		this.room = room;
		return this;
	}

	public String getPosition() {
		return position;
	}

	public Teams setPosition(String position) {
		this.position = position;
		return this;
	}

	
	public Date getDob() {
		return dob;
	}

	public Teams setDob(Date dob) {
		this.dob = dob;
		return this;
	}

	public Date getJoining() {
		return joining;
	}

	public void setJoining(Date joining) {
		this.joining = joining;
	}


	
	public String getQid() {
		return qid;
	}

	public void setQid(String qid) {
		this.qid = qid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public int getVillano() {
		return villano;
	}

	public void setVillano(int villano) {
		this.villano = villano;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	
	
	
}
	