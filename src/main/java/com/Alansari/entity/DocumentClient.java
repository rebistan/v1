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
@Table(name = "client",catalog = "ATC")
public class DocumentClient {

	
	public int getCid() {
		return cid;
	}

	public byte[] getCrcopy() {
		return crcopy;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public void setCrcopy(byte[] crcopy) {
		this.crcopy = crcopy;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "cid")
	private int cid;
	
	@Lob
	@Basic
    @Column(name = "crcopy",columnDefinition="LongBlob")
    private byte[] crcopy;
}
