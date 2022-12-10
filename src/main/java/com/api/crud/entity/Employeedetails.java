package com.api.crud.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="emp_details")
public class Employeedetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name="emp_name")
	private String name;
	@Column(name="emp_address")
	private String address;
	@Column(name="emp_salary")
	private String salary;
	@Column(name="emp_age")
	private String age;
	
	
	public Employeedetails() {
		
	}


	public Employeedetails(long id, String name, String address, String salary, String age) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.salary = salary;
		this.age = age;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getSalary() {
		return salary;
	}


	public void setSalary(String salary) {
		this.salary = salary;
	}


	public String getAge() {
		return age;
	}


	public void setAge(String age) {
		this.age = age;
	}
	
	
	
}


