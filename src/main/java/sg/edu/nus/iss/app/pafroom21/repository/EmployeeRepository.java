package sg.edu.nus.iss.app.pafroom21.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.app.pafroom21.model.Dependant;
import sg.edu.nus.iss.app.pafroom21.model.Employee;

@Repository
public class EmployeeRepository implements EmployeeRepositoryInterface {

    private static String selectSQL = "SELECT e.id emp_id, e.first_name, e.last_name, e.salary, d.id dep_id, d.dependant_name, d.relationship, d.birth_date FROM employee e INNER JOIN dependant d ON e.id = d.employee_id";

    @Autowired
    JdbcTemplate template;

    @Override
    public List<Employee> getAllEmployees() {
        return template.query(selectSQL, new ResultSetExtractor<List<Employee>>() {

            @Override
            @Nullable
            public List<Employee> extractData(ResultSet rs) throws SQLException, DataAccessException {
                List<Employee> employees = new ArrayList<>();

                // iterate through the rows
                while (rs.next()) {
                    Employee e = new Employee();
                    e.setId(rs.getInt("emp_id"));
                    e.setFirstName(rs.getString("first_name"));
                    e.setLastName(rs.getString("last_name"));
                    e.setSalary(rs.getInt("salary"));

                    Dependant d = new Dependant();
                    d.setBirthDate(rs.getDate("birth_date"));
                    d.setDependantName(rs.getString("dependant_name"));
                    d.setEmployee(e);
                    d.setId(rs.getInt("dep_id"));
                    d.setRelationship(rs.getString("relationship"));

                    if (!employees.contains(e)) {
                        e.getDependants().add(d);
                        employees.add(e);
                    } else {
                        for (Employee emp : employees) {
                            if (emp == d.getEmployee()) {
                                // emp.getDependants().add(d);
                            }
                        }
                    }

                }
                return employees;
            }

        });
    }

    @Override
    public Employee getEmployeeById(int id) {
        // TODO Auto-generated method stub
        return null;
    }

}
