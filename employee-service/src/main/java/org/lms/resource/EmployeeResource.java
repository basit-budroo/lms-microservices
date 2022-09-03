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

    @GetMapping(path = "/employees", produces = MediaType.APPLICATION_JSON_VALUE)
    public Employees getAllEmployees() {
        return new Employees(employeeService.getAllEmployees());
    }

    @GetMapping(path = "/employees/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Employee> getEmployeeByIdResource(@PathVariable("id") int id) {
        Optional<Employee> employeeOptional = employeeService.getEmployeeById(id);
        return employeeOptional
                .map(employee -> new ResponseEntity<>(employee, HttpStatus.FOUND))
                .orElseGet(() -> new ResponseEntity<>(new Employee(), HttpStatus.NOT_FOUND));
    }

    @PostMapping(path = "/employees", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Employee saveBookResource(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }

    @DeleteMapping(path = "/employees/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Employee deleteBookByIdResource(@PathVariable("id") int id) {
        return employeeService.deleteEmployee(id);
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
