package sg.edu.nus.iss.app.pafroom21.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sg.edu.nus.iss.app.pafroom21.model.Employee;
import sg.edu.nus.iss.app.pafroom21.repository.EmployeeRepository;

@RestController
@RequestMapping(path = "api/employees")
public class EmployeeRestController {
    @Autowired
    EmployeeRepository employeeRepo;

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeRepo.getAllEmployees();
        if (employees.isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(employees, HttpStatus.OK);
        }
    }
}
