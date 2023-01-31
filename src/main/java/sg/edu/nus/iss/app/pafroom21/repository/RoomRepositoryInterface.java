package sg.edu.nus.iss.app.pafroom21.repository;

import java.util.List;

import sg.edu.nus.iss.app.pafroom21.model.Room;

public interface RoomRepositoryInterface {
    int count();

    Boolean save(Room room);
    
    List<Room> getAll();

    Room getById(Integer id);

    int update(Room room);

    int deleteById(Integer id);
}
