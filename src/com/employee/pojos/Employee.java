package com.employee.pojos;

import java.sql.Date;

public class Employee {
	// emp_id | name | address | salary | dept_name | join_date
	// add date members
	private int empId;
	private String name;
	private String address;
	private double salary;
	private String deptName;
	private Date joinDate;

	// add constructors
	public Employee(int empId, String name, String address, double salary, String deptName, Date joinDate) {
		super();
		this.empId = empId;
		this.name = name;
		this.address = address;
		this.salary = salary;
		this.deptName = deptName;
		this.joinDate = joinDate;
	}

	public Employee(String name, String address, double salary, String deptName, Date joinDate) {
		super();
		this.name = name;
		this.address = address;
		this.salary = salary;
		this.deptName = deptName;
		this.joinDate = joinDate;
	}

	// add getters and setters
	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
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

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	// add toString
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", address=" + address + ", salary=" + salary
				+ ", deptName=" + deptName + ", joinDate=" + joinDate + "]";
	}

}
