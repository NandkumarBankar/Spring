package org.passData.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GeneratorType;

import lombok.Data;

@Data
@Entity
public class PassengerData {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	@Column(length = 30 ,nullable = false)
	String Name;
	@Column(length = 30 ,nullable = false)
	String Gender;
	@Column(length = 30 ,nullable = false)
	long ContactNo;
	@Column(length = 30 ,nullable = false)
	String DestinationFrom;
	@Column(length = 30 ,nullable = false)
	String destinationUpTo;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public long getContactNo() {
		return ContactNo;
	}
	public void setContactNo(long contactNo) {
		ContactNo = contactNo;
	}
	public String getDestinationFrom() {
		return DestinationFrom;
	}
	public void setDestinationFrom(String destinationFrom) {
		DestinationFrom = destinationFrom;
	}
	public String getDesinationUpTo() {
		return destinationUpTo;
	}
	public void setDesinationUpTo(String desinationUpTo) {
		this.destinationUpTo = desinationUpTo;
	}
	
	
	
}
