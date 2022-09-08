package org.lms.resource;

import org.lms.bean.Employee;
import org.lms.bean.Employees;
import org.lms.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class EmployeeResource {

    @Autowired
    private EmployeeService employeeService;

//    @GetMapping(path = "/employees", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<Employees> getAllEmployees() {
//        Employees employees = new Employees(employeeService.getAllEmployees());
//        if (employees.getEmployees() != null) {
//            return new ResponseEntity<>(employees, HttpStatus.FOUND);
//        }
//        return new ResponseEntity<>(new Employees(null), HttpStatus.NOT_FOUND);
//    }

    @GetMapping(path = "/employees", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Employees> getAllEmployeesResource() {
        Employees employees = new Employees(employeeService.getAllEmployees());
        if (employees.getEmployees().isEmpty())
            return new ResponseEntity<Employees>(employees, HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<Employees>(employees, HttpStatus.OK);
    }

    @GetMapping(path = "/employees/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Employee> getEmployeeByIdResource(@PathVariable("id") int id) {
        Optional<Employee> employeeOptional = employeeService.getEmployeeById(id);
        return employeeOptional.map(employee -> new ResponseEntity<>(employee, HttpStatus.FOUND)).orElseGet(() -> new ResponseEntity<>(new Employee(), HttpStatus.NOT_FOUND));
    }

    @PostMapping(path = "/employees", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Employee> saveEmployeeResource(@RequestBody Employee employee) {
        Employee employeeVar = employeeService.addEmployee(employee);
        if (employeeVar != null) {
            return new ResponseEntity<>(employeeVar, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(new Employee(), HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(path = "/employees/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Employee> deleteEmployeeByIdResource(@PathVariable("id") int id) {
        Employee employee = employeeService.deleteEmployee(id);
        if (employee != null) {
            return new ResponseEntity<>(employee, HttpStatus.OK);
        }
        return new ResponseEntity<>(new Employee(), HttpStatus.NOT_MODIFIED);
    }

    @PutMapping(path = "/employees/{id}/{books_qt}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Employee increaseBookQuantity(@PathVariable("id") int id, @PathVariable("books_qt") int quantity) {
        Optional<Employee> employeeOptional = employeeService.getEmployeeById(id);
        if (employeeOptional.isPresent()) {
            employeeService.deleteEmployee(id);
            int curr_number = employeeOptional.get().getBooksIssued();
            employeeOptional.get().setBooksIssued(curr_number + quantity);
            employeeService.addEmployee(employeeOptional.get());
            return employeeOptional.get();
        }
        return new Employee();
    }
}
