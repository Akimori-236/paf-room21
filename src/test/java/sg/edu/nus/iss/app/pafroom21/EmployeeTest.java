package sg.edu.nus.iss.app.pafroom21;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import sg.edu.nus.iss.app.pafroom21.repository.EmployeeRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class EmployeeTest {
    @Autowired
    EmployeeRepository employeeRepo;
    
    // @Test
    // public void getAllEmployees() {
    //     List<Employee> empList = employeeRepo.getAllEmployees;
    //     empList.forEach((emp) -> )
    // }

}
