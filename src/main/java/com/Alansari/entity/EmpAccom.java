package com.Alansari.entity;

import javax.persistence.*;

@Entity
@Table(name = "employees", catalog = "ATC")
public class EmpAccom {

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
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private Accom accom;

    public EmpAccom() {
    }

    public Accom getUsers() {
        return accom;
    }

    public EmpAccom setUsers(Accom accom) {
        this.accom = accom;
        return this;
    }

	public Integer getQid() {
		return qid;
	}

	
	public void setQid(Integer qid) {
		this.qid = qid;
	}


}
