package org.lms.service;

import org.lms.bean.Employee;
import org.lms.persistence.EmployeeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeDAO.findAll();
    }

    @Override
    public Optional<Employee> getEmployeeById(int employeeId) {
        return employeeDAO.findById(employeeId);
    }

    @Override
    public Employee addEmployee(Employee employee) {
        return employeeDAO.save(employee);
    }

    @Override
    public Employee deleteEmployee(int employeeId) {
        Optional<Employee> employeeOptional = employeeDAO.findById(employeeId);
        if (employeeOptional.isPresent()) {
            employeeDAO.deleteById(employeeId);
            return employeeOptional.get();
        }
        return new Employee();
    }
}
