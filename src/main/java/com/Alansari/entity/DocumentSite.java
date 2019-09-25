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
@Table(name="sites",catalog = "ATC")
public class DocumentSite {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	@Column(name="sid")
	private int sid;
	
	@Lob
	@Basic
	@Column(name = "quotation",columnDefinition="LongBlob")
	private byte[] quotation;
	
	@Lob
	@Basic
	@Column(name = "lpo",columnDefinition="LongBlob")
	private byte[] lpo;
	
	@Lob
	@Basic
	@Column(name = "cheque",columnDefinition="LongBlob")
	private byte[] cheque;
	
	@Lob
	@Basic
	@Column(name = "agreement",columnDefinition="LongBlob")
	private byte[] agreement;

	public int getSid() {
		return sid;
	}

	public byte[] getQuotation() {
		return quotation;
	}

	public byte[] getLpo() {
		return lpo;
	}

	public byte[] getCheque() {
		return cheque;
	}

	public byte[] getAgreement() {
		return agreement;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public void setQuotation(byte[] quotation) {
		this.quotation = quotation;
	}

	public void setLpo(byte[] lpo) {
		this.lpo = lpo;
	}

	public void setCheque(byte[] cheque) {
		this.cheque = cheque;
	}

	public void setAgreement(byte[] agreement) {
		this.agreement = agreement;
	}
	

}
