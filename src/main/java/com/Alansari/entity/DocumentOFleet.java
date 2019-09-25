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
@Table(name="ofleets",catalog = "ATC")
public class DocumentOFleet {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	
    
	@Lob
	@Basic
    @Column(name = "fleetpic",columnDefinition="LongBlob")
    private byte[] fleetpic;
	
	@Lob
	@Basic
	@Column(name = "istimara",columnDefinition="LongBlob")
	private byte [] istimara;
	
	@Lob
	@Basic
	@Column(name = "insurance",columnDefinition="LongBlob")
	private byte[] insurance;
	
	public int getId() {
		return id;
	}

	public byte[] getIstimara() {
		return istimara;
	}

	public byte[] getInsurance() {
		return insurance;
	}

	public byte[] getFleetpic() {
		return fleetpic;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setIstimara(byte[] istimara) {
		this.istimara = istimara;
	}

	public void setInsurance(byte[] insurance) {
		this.insurance = insurance;
	}

	public void setFleetpic(byte[] fleetpic) {
		this.fleetpic = fleetpic;
	}

	
}
