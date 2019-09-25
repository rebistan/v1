package com.Alansari.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="accom",catalog = "ATC")
public class DocumentAccom {

	
	 @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    @Column(name = "user_id")
	    private Integer accomid;
	 
	 @Lob
		@Basic
		@Column(name = "contract",columnDefinition="LongBlob")
		private byte[] contract;

	public Integer getAccomid() {
		return accomid;
	}

	public byte[] getContract() {
		return contract;
	}

	public void setAccomid(Integer accomid) {
		this.accomid = accomid;
	}

	public void setContract(byte[] contract) {
		this.contract = contract;
	}
}
