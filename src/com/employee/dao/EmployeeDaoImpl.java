package com.employee.dao;

import static com.employee.utils.DBUtils.openConnection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.employee.pojos.Employee;

public class EmployeeDaoImpl implements IEmployeeDao {

	// add date members
	private Connection cn;
	private PreparedStatement pst1, pst2, pst3, pst4, pst5, pst6;

	// add constructor
	public EmployeeDaoImpl() throws SQLException {
		// get DB connection from DBUtils
		cn = openConnection();
		pst1 = cn.prepareStatement("select * from employee where dept_name=? and join_date between ? and ?");
		pst2 = cn.prepareStatement("insert into employee values(default,?,?,?,?,?)");
		pst3 = cn.prepareStatement("update employee set salary=salary+?, dept_name=? where emp_id=?");
		pst4 = cn.prepareStatement("delete from employee where emp_id=?");
		pst5 = cn.prepareStatement("select dept_name, avg(salary) from employee group by dept_name");
		pst6 = cn.prepareStatement("select * from employee");
		System.out.println("Employee Dao Created!!");
	}

	@Override
	public List<Employee> getSelectedEmpDetails(String deptName, Date startDate, Date endDate) throws SQLException {
		// create empty ArrayList
		List<Employee> emps = new ArrayList<Employee>();

		// set IN parameters
		pst1.setString(1, deptName);
		pst1.setDate(2, startDate);
		pst1.setDate(3, endDate);

		try (ResultSet rst = pst1.executeQuery()) {
			while (rst.next()) {
				emps.add(new Employee(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getDouble(4),
						rst.getString(5), rst.getDate(6)));
			}
		}
		return emps;
	}

	@Override
	public String insertEmployeeDetails(Employee emp) throws SQLException {
		// set IN params-> name | address | salary | dept_name | join_date
		pst2.setString(1, emp.getName());
		pst2.setString(2, emp.getAddress());
		pst2.setDouble(3, emp.getSalary());
		pst2.setString(4, emp.getDeptName());
		pst2.setDate(5, emp.getJoinDate());

		int updateCount = pst2.executeUpdate();
		if (updateCount == 1)
			return "Employee details added successfully!!";
		return "Employee details insertion failed!";
	}

	@Override
	public String updateEmpDeptAndSalary(int empId, double salIncrement, String newDeptName) throws SQLException {
		// set IN params
		pst3.setDouble(1, salIncrement);
		pst3.setString(2, newDeptName);
		pst3.setInt(3, empId);

		int updateCount = pst3.executeUpdate();
		if (updateCount == 1)
			return "Employee details updated Successfully!!";
		return "Employee details updation failed!";
	}

	@Override
	public String deleteEmployeeDetails(int empID) throws SQLException {
		// set IN param
		pst4.setInt(1, empID);

		int updateCount = pst4.executeUpdate();
		if (updateCount == 1)
			return "Employee details deleted successfully!!";
		return "Employee details deletion failed!";
	}

	@Override
	public Map<String, Double> showDeptwiseAvgSalary() throws SQLException {
		// create empty Map
		Map<String, Double> avgSalMap = new LinkedHashMap<>();
		try (ResultSet rst = pst5.executeQuery()) {
			while (rst.next()) {
				avgSalMap.put(rst.getString(1), rst.getDouble(2));
			}
		}
		return avgSalMap;
	}

	@Override
	public List<Employee> displayAllEmpDetails() throws SQLException {
		// create empty ArrayList
		List<Employee> emp = new ArrayList<Employee>();
		try (ResultSet rst = pst6.executeQuery()) {
			while (rst.next()) {
				emp.add(new Employee(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getDouble(4),
						rst.getString(5), rst.getDate(6)));
			}
		}
		return emp;
	}

	// add a method to clean DB resources
	public void cleanUp() throws SQLException {
		if (pst1 != null)
			pst1.close();
		if (pst2 != null)
			pst2.close();
		if (pst3 != null)
			pst3.close();
		if (pst4 != null)
			pst4.close();
		if (pst5 != null)
			pst5.close();
		if (pst6 != null)
			pst6.close();
		if (cn != null)
			cn.close();
		System.out.println("Employee Dao cleaned up! \nHave a nice day!!\nBYE!!!");
	}

}
