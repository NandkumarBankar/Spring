package com.hbproject.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Employee {


	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id;
	
	@Column(length=30 ,nullable=false)
	private String name;
	
	@Column(length=30 ,nullable=false)
	private String eEdu;
	
	@Column(length=30 ,nullable=false)
	private String DOJ;
	
	@Column(length=30 ,nullable=false ,unique=true)
    private String email;
	
	@Column(length=30 ,nullable=false, unique =true)
	private long phone ;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String geteEdu() {
		return eEdu;
	}

	public void seteEdu(String eEdu) {
		this.eEdu = eEdu;
	}

	public String getDOJ() {
		return DOJ;
	}

	public void setDOJ(String dOJ) {
		DOJ = dOJ;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}
	
	
}
