package sg.edu.nus.iss.app.pafroom21.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.edu.nus.iss.app.pafroom21.model.Room;
import sg.edu.nus.iss.app.pafroom21.repository.RoomRepository;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepo;

    public int count() {
        return roomRepo.count();
    }

    public Boolean save(Room room) {
        return roomRepo.save(room);
    }

    public List<Room> getAll() {
        return roomRepo.getAll();
    }

    public Room getById(Integer id) {
        return roomRepo.getById(id);
    }

    public int update(Room room) {
        return roomRepo.update(room);
    }

    public int deleteById(Integer id) {
        return roomRepo.deleteById(id);
    }

}
