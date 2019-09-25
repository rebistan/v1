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
@Table(name = "fleets",catalog = "ATC")
public class DocumentFleet {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	
	public int getId() {
		return id;
	}

	public byte[] getIstimara() {
		return istimara;
	}

	public byte[] getInsurance() {
		return insurance;
	}

	public void setIstimara(byte[] istimara) {
		this.istimara = istimara;
	}

	public void setInsurance(byte[] insurance) {
		this.insurance = insurance;
	}

	public void setId(int id) {
		this.id = id;
	}


	@Lob
	@Basic
	@Column(name = "istimara",columnDefinition="LongBlob")
	private byte[] istimara;
	
	@Lob
	@Basic
	@Column(name = "insurance",columnDefinition="LongBlob")
	private byte[] insurance;
	
}
