package com.Alansari.entity;

import javax.persistence.*;

@Entity
@Table(name = "employees", catalog = "ATC")
public class EmpPay {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    
    @Column(name = "qid")
    private Integer qid;
  
    private Integer room;
    public Integer getRoom() {
		return room;
	}

	public void setRoom(Integer room) {
		this.room = room;
	}

	private String fname;
    private String lname;
    public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	private String position;
    public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getFname() {
		return fname;
	}

	public void setName(String fname) {
		this.fname = fname;
	}



	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "qid", referencedColumnName = "qid")
    private Payroll pay;

    public EmpPay() {
    }

    public Payroll getUsers() {
        return pay;
    }

    public EmpPay setUsers(Payroll pay) {
        this.pay = pay;
        return this;
    }

 

	public Integer getQid() {
		return qid;
	}

	

	public void setQid(Integer qid) {
		this.qid = qid;
	}

	


}
