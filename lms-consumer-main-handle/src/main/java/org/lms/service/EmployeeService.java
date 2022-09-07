package org.lms.service;

import java.util.List;

import org.lms.bean.Employee;

public interface EmployeeService {

	boolean removeEmployee(int employeeId);

	boolean addEmployee(Employee employee);

	Employee searchEmployee(int id);

	List<Employee> getAllEmployees();

}
