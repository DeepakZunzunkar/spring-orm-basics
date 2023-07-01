package com.dz.app;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dz.app.model.entity.Employee;
import com.dz.app.service.EmployeeService;
import com.dz.app.utility.AppUtility;

/**
 * Hello world!
 *
 */
public class App {

	public static void main(String[] args) {

		System.err.println("____________XML Base Config_______________________\n");
		ApplicationContext context = new ClassPathXmlApplicationContext("com/dz/app/config.xml");

		Employee empTrn = null;
		List<Employee> employeeList = null;
		long eid = 0;
		
//		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
//		br.readLine();
		
		Scanner sc = new Scanner(System.in);
		EmployeeService empService = context.getBean("employeeService", EmployeeService.class);

		System.err.println("_________add________________");
		empTrn = AppUtility.setEmployeeForm(sc, "ADD", null);
		AppUtility.loader();
		empTrn = empService.saveEmployee(empTrn);
		System.out.println("Employee added.." + empTrn);

		/*System.err.println("_________update________________");
		System.out.println("Enter Employee EID : ");
		eid = sc.nextLong();
		AppUtility.loader();
		empTrn = empService.findById(eid);
		if (empTrn != null) {
			employeeList = new ArrayList<Employee>();
			employeeList.add(empTrn);
			AppUtility.displayRecords(employeeList);
			empTrn = AppUtility.updateEmployeeForm(sc, empTrn);
			empService.updateEmployee(empTrn);
			System.out.println("Employee updated..");
		} else {
			System.err.println("Employee Not Found By EID ");
		}*/

		/*System.err.println("_________delete________________");
		System.out.println("Enter Employee EID : ");
		eid = sc.nextLong();
		AppUtility.loader();
		empTrn = empService.findById(eid);
		if (empTrn != null) {
			employeeList = new ArrayList<Employee>();
			employeeList.add(empTrn);
			AppUtility.displayRecords(employeeList);
			AppUtility.loader();
			empService.deleteEmployee(empTrn);
			System.out.println("Employee Deleted successfully !");
		} else {
			System.err.println("Employee Not Found By EID ");
		}*/

		System.err.println("_________get multiple record ________________");
		employeeList = empService.getAllEmployees();
		if (employeeList != null && !employeeList.isEmpty()) {
			System.out.println("\n\nAll Employee Records ::");
			AppUtility.displayRecords(employeeList);
		} else {
			System.err.println("no data found");
		}

	}
}
