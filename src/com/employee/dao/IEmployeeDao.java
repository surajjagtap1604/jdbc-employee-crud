package com.employee.dao;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.employee.pojos.Employee;

public interface IEmployeeDao {
	// declare the methods for requirement specifications
	// 1.Dislay details of employee joined within specific date and from specific
	// dept.
	List<Employee> getSelectedEmpDetails(String deptName, Date startDate, Date endDate) throws SQLException;

	// 2.Add a method to add new employee
	String insertEmployeeDetails(Employee emp) throws SQLException;

	// 3.Update employee dept and add increment to salary
	String updateEmpDeptAndSalary(int empId, double salIncrement, String newDeptName) throws SQLException;

	// 4.Delete an employee details
	String deleteEmployeeDetails(int empID) throws SQLException;

	// 5.Give deptwise avg salary details in the order in which depts are present in
	// the table
	Map<String, Double> showDeptwiseAvgSalary() throws SQLException;

	// 6.Display all employee details
	List<Employee> displayAllEmpDetails() throws SQLException;

}
