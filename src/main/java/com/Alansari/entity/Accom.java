package com.Alansari.entity;

import javax.persistence.*;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "accom", catalog = "ATC")
@ApiModel(description = "All details about the Accommadtion. ")
public class Accom {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(notes = "The Accomadation Number")
    @Column(name = "user_id",nullable = false)
    private Integer accomid;
    @ApiModelProperty(notes = "The Acccommadation Name")
    @Column(name = "name" ,nullable = false)
    private String name;
    @ApiModelProperty(notes = "The Acccommadation Street")
    @Column(name = "street",nullable = false)
    private String street;
    @ApiModelProperty(notes = "The Acccommadation Contract")
    @Basic
   
    @Column(name = "contract",nullable = false)
    private byte[] cont;

   

	public byte[] getCont() {
		return cont;
	}

	public void setCont(byte[] cont) {
		this.cont = cont;
	}

	public Accom() {
    }

    public Integer getAccomid() {
        return accomid;
    }

    public Accom setAccomid(Integer accomid) {
        this.accomid = accomid;
        return this;
    }

    public String getName() {
        return name;
    }

    public Accom setName(String name) {
        this.name = name;
        return this;
    }

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}
 
}
