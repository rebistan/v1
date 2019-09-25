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
@Table(name="employees", catalog = "ATC")

public class DocumentTeam {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	@Column(name="qid")
	private int qid;
	
	public int getQid() {
		return qid;
	}

	public byte[] getPassportpic() {
		return passportpic;
	}

	public byte[] getQidpic() {
		return qidpic;
	}

	public byte[] getContractpic() {
		return contractpic;
	}

	public void setQid(int qid) {
		this.qid = qid;
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

	@Lob
	@Basic
    @Column(name = "passportpic",columnDefinition="LongBlob")
    private byte[] passportpic;
	
	@Lob
	@Basic
    @Column(name = "qidpic",columnDefinition="LongBlob")
    private byte[] qidpic;
	
	@Lob
	@Basic
    @Column(name = "contractpic",columnDefinition="LongBlob")
    private byte[] contractpic;
	
}
