package com.employee.tester;

import java.sql.Date;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.employee.dao.EmployeeDaoImpl;
import com.employee.pojos.Employee;

public class TestEmployeeCRUD {

	public static void main(String[] args) {
		// create instance of EmployeeDaoImple:Initialization phase
		try (Scanner sc = new Scanner(System.in)) {
			EmployeeDaoImpl dao = new EmployeeDaoImpl();
			boolean exit = false;
			while (!exit) {
				System.out.println(
						"Select the option: \n 1.Show Employee details joined between specific dates \n 2.Insert new Employee \n 3.Update emp deptName & give salary increment"
								+ "\n 4.Delete employee details \n 5.Display deptwise avg salary \n 6.Display all employee details \n 7.Exit");
				try {
					switch (sc.nextInt()) {
					case 1: // Show Employee details
						System.out.println("Enter the deptName, startDate, endDate(yyyy-mm-dd)");
						List<Employee> empDetails = dao.getSelectedEmpDetails(sc.next(), Date.valueOf(sc.next()),
								Date.valueOf(sc.next()));
						empDetails.forEach(System.out::println);
						break;

					case 2:
						System.out.println(
								"Enter employee details-> name | address | salary | dept_name | join_date(yyyy-mm-dd)");
						System.out.println(dao.insertEmployeeDetails(new Employee(sc.next(), sc.next(), sc.nextDouble(),
								sc.next(), Date.valueOf(sc.next()))));
						break;

					case 3:
						System.out.println("Enter empID, salary Increment, new dept name");
						System.out.println(dao.updateEmpDeptAndSalary(sc.nextInt(), sc.nextDouble(), sc.next()));
						break;

					case 4:
						System.out.println("Enter the empId of employee whose details to be deleted");
						System.out.println(dao.deleteEmployeeDetails(sc.nextInt()));
						break;

					case 5:
						dao.showDeptwiseAvgSalary().forEach((deptName, avgSal) -> System.out
								.println("Dept Name: " + deptName + " Avg Salary: " + avgSal));
						break;

					case 6:
						dao.displayAllEmpDetails().forEach(System.out::println);
						break;

					case 7: // clean up DB resources
						exit = true;
						dao.cleanUp();
						break;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
