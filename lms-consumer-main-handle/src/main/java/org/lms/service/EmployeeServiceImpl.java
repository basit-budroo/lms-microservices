package org.lms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.lms.bean.Employee;
import org.lms.bean.Employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public boolean removeEmployee(int employeeId) {
        restTemplate.delete("http://employee-service/employees/" + employeeId);
        return true;
    }

    @Override
    public boolean addEmployee(Employee employee) {
        ResponseEntity<Employee> employeeResponseEntity = restTemplate.postForEntity("http://employee-service/employees", employee, Employee.class);
        return employeeResponseEntity.getStatusCode().equals(HttpStatus.CREATED);
    }

    @Override
    public Employee searchEmployee(int id) {
        ResponseEntity<Employee> responseEntity = restTemplate.getForEntity("http://employee-service/employees/" + id, Employee.class);
        if (responseEntity.getStatusCode().equals(HttpStatus.FOUND)) {
            return responseEntity.getBody();
        }
        return null;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return restTemplate.getForObject("http://employee-service/employees/", Employees.class).getList();
    }
}
