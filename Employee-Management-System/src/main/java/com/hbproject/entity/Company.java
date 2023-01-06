package com.hbproject.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Company{

	@Id
	private int deptId;
	@Column(length = 20,nullable = false)
	private String deptName;
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="deptId")
	List<Employee> list;
	public List<Employee> getList() {
		return list;
	}
	public void setList(List<Employee> list) {
		this.list = list;
	}
}
