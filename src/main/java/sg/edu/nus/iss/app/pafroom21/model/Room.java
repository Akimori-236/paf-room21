package sg.edu.nus.iss.app.pafroom21.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Room {
    private Integer id;
    private String roomType;
    private Integer price;
}
