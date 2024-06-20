package com.example.employee.controller;

import org.springframework.web.bind.annotation.*;
import com.example.employee.Entity.Employee;

import java.util.*;

@RestController
@RequestMapping("/employees") // Base URL for all employee endpoints
public class EmployeeController {

    private List<Employee> emplist = new ArrayList<>(Arrays.asList(
            new Employee("Vimal", 21),
            new Employee("Lohith", 14)));

    // GET method to retrieve all employees
    @GetMapping
    public List<Employee> findAllEmployees() {
        return emplist;
    }

    // POST method to add a new employee
    @PostMapping
    public Employee postEmployee(@RequestBody Employee newEmployee) {
        emplist.add(newEmployee);
        return newEmployee;
    }

    // PUT method to update an existing employee
    @PutMapping("/{name}")
    public Employee updateEmployee(@PathVariable String name, @RequestBody Employee updatedEmployee) {
        for (Employee employee : emplist) {
            if (employee.getEmpName().equals(name)) {
                employee.setEmpName(updatedEmployee.getEmpName()); // Corrected line
                employee.setage(updatedEmployee.getage()); // Corrected line
                return employee;
            }
        }
        throw new NoSuchElementException("Employee not found with name: " + name);
    }

    // DELETE method to remove an employee
    @DeleteMapping("/{name}")
    public String deleteEmployee(@PathVariable String name) {
        Iterator<Employee> iterator = emplist.iterator();
        while (iterator.hasNext()) {
            Employee employee = iterator.next();
            if (employee.getEmpName().equals(name)) {
                iterator.remove();
                return "Employee deleted with name: " + name;
            }
        }
        throw new NoSuchElementException("Employee not found with name: " + name);
    }
}
