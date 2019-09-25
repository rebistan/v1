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
@Table(name = "outsource",catalog = "ATC")
public class DocumentOutsource {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "outid")
	private int outid;
	
	@Lob
	@Basic
    @Column(name = "crcopy",columnDefinition="LongBlob")
    private byte[] crcopy;

	public int getOutid() {
		return outid;
	}

	public byte[] getCrcopy() {
		return crcopy;
	}

	public void setOutid(int outid) {
		this.outid = outid;
	}

	public void setCrcopy(byte[] crcopy) {
		this.crcopy = crcopy;
	}
	
}
