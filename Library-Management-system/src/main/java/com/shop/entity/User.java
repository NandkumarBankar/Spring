package com.shop.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.Setter;

@Entity   //entity class 
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long uId;
	
	@Column(length=20,nullable=false)
	@NotBlank(message="please Entered User Name")
	private String uName;
	
	
	@Column(length=15,nullable=false)
	@NotBlank(message=" Entered User Address")
	private String uAddress;
	
	@Column(length=30,nullable=false)
	@NotBlank(message=" Entered User Email")
	private String uEmail;
	
	@NotNull(message="please Entered User phone contact")
	private long uPhone;
	
	@OneToMany(fetch = FetchType.EAGER , mappedBy = "user" ,cascade = CascadeType.ALL )
	@JsonManagedReference
	private List<Book> book;
	
	//setter & Getter

	public List<Book> getBook() {
		return book;
	}

	public void setBook(List<Book> book) {
		this.book = book;
	}

	public long getuId() {
		return uId;
	}

	public void setuId(long uId) {
		this.uId = uId;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public String getuAddress() {
		return uAddress;
	}

	public void setuAddress(String uAddress) {
		this.uAddress = uAddress;
	}

	public String getuEmail() {
		return uEmail;
	}

	public void setuEmail(String uEmail) {
		this.uEmail = uEmail;
	}

	public long getuPhone() {
		return uPhone;
	}

	public void setuPhone(long uPhone) {
		this.uPhone = uPhone;
	}
	
	//All ArgsConstructor


	public User(Long uId, @NotBlank(message = "please Entered User Name") String uName,
			@NotBlank(message = " Entered User Address") String uAddress,
			@NotBlank(message = " Entered User Email") String uEmail,
			@NotNull(message = "please Entered User phone contact") Long uPhone) {
		super();
		this.uId = uId;
		this.uName = uName;
		this.uAddress = uAddress;
		this.uEmail = uEmail;
		this.uPhone = uPhone;
		
	}

	//No ArgsConstructor

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
