package sg.edu.nus.iss.app.pafroom21.model;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dependant {
    private Integer id;
    private Employee employee;
    private String dependantName;
    private String relationship;
    private Date birthDate;
}
