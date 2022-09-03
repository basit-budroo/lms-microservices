package org.lms.service;

import org.lms.bean.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    Optional<Employee> getEmployeeById(int employeeId);
    Employee addEmployee(Employee employee);
    Employee deleteEmployee(int employeeId);

}
