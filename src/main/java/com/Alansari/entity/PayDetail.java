package com.Alansari.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="Paydetail", catalog = "ATC")
@ApiModel(description = "All details about the Vacation. ")
public class PayDetail {
	@Id
	@ApiModelProperty(notes = "The employee Number")
	@Column(name = "qid")
	private Integer qid;
	@ApiModelProperty(notes = "The Last vacation")
	private Date lastvac;

	

	public Integer getQid() {
		return qid;
	}

	public Date getLastvac() {
		return lastvac;
	}

	public String getTicket() {
		return ticket;
	}

	public String getSettlement() {
		return settlement;
	}
	
	public void setQid(Integer qid) {
		this.qid = qid;
	}

	public void setLastvac(Date lastvac) {
		this.lastvac = lastvac;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

	public void setSettlement(String settlement) {
		this.settlement = settlement;
	}

	@ApiModelProperty(notes = "The Status of received ticket")
	private String ticket;

	@ApiModelProperty(notes = "The status of settlement")
	private String settlement;
}
