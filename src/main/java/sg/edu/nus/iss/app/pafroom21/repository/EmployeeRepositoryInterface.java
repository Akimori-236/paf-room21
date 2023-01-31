package sg.edu.nus.iss.app.pafroom21.repository;

import java.util.List;

import sg.edu.nus.iss.app.pafroom21.model.Employee;

public interface EmployeeRepositoryInterface {
    List<Employee> getAllEmployees();
    Employee getEmployeeById(int id);
}
