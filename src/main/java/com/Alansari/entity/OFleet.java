package com.Alansari.entity;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "ofleets",catalog = "ATC")
@ApiModel(description = "All details about the Fleets. ")
public class OFleet {

	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;
		
	    @ApiModelProperty(notes = "The Fleets Istimara")
		
		@Column(name = "istimara")
		private Date istimara;
		
		@ApiModelProperty(notes = "The Fleets insurance")
		
		@Column(name = "insurance")
		private Date insurance;
		
		@ApiModelProperty(notes = "The Fleets Picture")
		@Lob
		@Basic
	    @Column(name = "fleetpic",columnDefinition="LongBlob")
	    private byte[] fleetpic;
		
		@ApiModelProperty(notes = "The Fleets Brand")
		@NotNull
	    private String brand;
		
	 

		public byte[] getFleetpic() {
			return fleetpic;
		}

		

		public Date getIstimara() {
			return istimara;
		}



		public Date getInsurance() {
			return insurance;
		}



		public void setIstimara(Date istimara) {
			this.istimara = istimara;
		}



		public void setInsurance(Date insurance) {
			this.insurance = insurance;
		}



		public void setFleetpic(byte[] fleetpic) {
			this.fleetpic = fleetpic;
		}

		public int getId() {
			return id;
		}

		public String getBrand() {
			return brand;
		}

		public int getModel() {
			return model;
		}

		public int getRegno() {
			return regno;
		}

		public void setId(int id) {
			this.id = id;
		}

		public void setBrand(String brand) {
			this.brand = brand;
		}

		public void setModel(int model) {
			this.model = model;
		}

		public void setRegno(int regno) {
			this.regno = regno;
		}

		@ApiModelProperty(notes = "The Fleets MOdel")
		@NotNull
	    private int model;
	    
		@ApiModelProperty(notes = "The Fleets Number")
	    @NotNull
	    private int regno;
	    
	    public int getOutid() {
			return outid;
		}

		public void setOutid(int outid) {
			this.outid = outid;
		}
		@ApiModelProperty(notes = "The Outsource Number")
		@NotNull
	    private int outid;
	    
	
}
