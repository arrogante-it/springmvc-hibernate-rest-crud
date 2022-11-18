package com.alexandrsinko.spring.rest.controller;

import com.alexandrsinko.spring.rest.entity.Employee;
import com.alexandrsinko.spring.rest.exception_handling.EmployeeIncorrectData;
import com.alexandrsinko.spring.rest.exception_handling.NoSuchEmployeeException;
import com.alexandrsinko.spring.rest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class RESTController {

    private EmployeeService employeeService;

    @Autowired
    public RESTController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(value = "/employees")
    public List<Employee> getAllEmployees() {
        List<Employee> allEmployees = employeeService.getAllEmployees();
        return allEmployees;
    }

    @GetMapping(value = "/employees/{id}")
    public Employee getEmployee(@PathVariable int id){
        Employee employee = employeeService.getEmployee(id);

        if(employee == null) {
            throw new NoSuchEmployeeException("There is no employee with ID = " +
                    id + " in DataBase");
        }

        return employee;
    }

    @PostMapping(value = "/employees")
    public Employee addEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return employee;
    }

    @PutMapping(value = "/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return employee;
    }

    @DeleteMapping(value = "/employees/{id}")
    public String deleteEmployee(@PathVariable int id) {
        Employee employee = employeeService.getEmployee(id);

        if(employee == null) {
            throw new NoSuchEmployeeException("There is no employee with ID = "
                    + id + " in DataBase");
        }

        employeeService.deleteEmployee(id);
        return "Employee with ID = " + id + " was deleted";
    }
}











































































