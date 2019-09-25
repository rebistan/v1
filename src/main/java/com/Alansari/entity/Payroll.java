package com.Alansari.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="payroll", catalog = "ATC")
@ApiModel(description = "All details about the Payroll. ")
public class Payroll {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
@ApiModelProperty(notes = "The Payroll Number")
@Column(name = "id")
private Integer id;
@ApiModelProperty(notes = "The employee Number")
@Column(name = "qid")
private Integer qid;

@ApiModelProperty(notes = "The recent payment")
private Date payrec;

@ApiModelProperty(notes = "The basic payment")
private int basic;

@ApiModelProperty(notes = "Over time done hours")
private int ot;

@ApiModelProperty(notes = "The overtime payment")
private int otime;

@ApiModelProperty(notes = "Allowances provided by comapany")
private int allowance;

@ApiModelProperty(notes = "Deduction from salary")
private int deduction;

public Payroll() {
}


public Date getPayrec() {
	return payrec;
}



public int getBasic() {
	return basic;
}

public int getOt() {
	return ot;
}

public int getOtime() {
	return otime;
}

public int getAllowance() {
	return allowance;
}

public int getDeduction() {
	return deduction;
}



public void setPayrec(Date payrec) {
	this.payrec = payrec;
}


public void setBasic(int basic) {
	this.basic = basic;
}

public void setOt(int ot) {
	this.ot = ot;
}

public void setOtime(int otime) {
	this.otime = otime;
}

public void setAllowance(int allowance) {
	this.allowance = allowance;
}

public void setDeduction(int deduction) {
	this.deduction = deduction;
}


public Integer getQid() {
	return qid;
}


public void setQid(Integer qid) {
	this.qid = qid;
}

}
