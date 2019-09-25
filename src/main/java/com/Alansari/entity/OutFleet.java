package com.Alansari.entity;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "ofleets",catalog = "ATC")
@ApiModel(description = "All details about the Outsourced fleets. ")
public class OutFleet {

	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;
	    @ApiModelProperty(notes = "The Fleets Brand")
		@NotNull
	    private String brand;
	    
	    @ApiModelProperty(notes = "The Fleets Type")
	    @Column(name = "equiptype",nullable = false)
		private String equiptype;

		@ApiModelProperty(notes = "The Fleets Istimara document")
		@Lob
		@Basic
		@Column(name = "istimara",columnDefinition="LongBlob")
		private byte [] istimara;
		
	    @ApiModelProperty(notes = "The Fleets Insurance documnent")
		@Lob
		@Basic
		@Column(name = "insurance",columnDefinition="LongBlob")
		private byte[] insurance;
		
	    @ApiModelProperty(notes = "The Fleets Picture")
		@Lob
		@Basic
	    @Column(name = "fleetpic",columnDefinition="LongBlob")
	    private byte[] fleetpic;
	    @ApiModelProperty(notes = "The Fleets Model")
		@NotNull
	    private int model;
	    
		@ApiModelProperty(notes = "The Fleets Registration number")
	    @NotNull
	    private int regno;
	    
	
	    
	    public byte[] getIstimara() {
			return istimara;
		}

		public byte[] getInsurance() {
			return insurance;
		}

		public byte[] getFleetpic() {
			return fleetpic;
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

		public Outsource getOut() {
			return out;
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

		public void setOut(Outsource out) {
			this.out = out;
		}
		public String getEquiptype() {
			return equiptype;
		}

		public void setEquiptype(String equiptype) {
			this.equiptype = equiptype;
		}
		
		@OneToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "outid", referencedColumnName = "outid" )
		
    private Outsource out;
	
}
