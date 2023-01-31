package sg.edu.nus.iss.app.pafroom21.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sg.edu.nus.iss.app.pafroom21.model.Room;
import sg.edu.nus.iss.app.pafroom21.service.RoomService;

@RestController
@RequestMapping(path = "/api/rooms")
public class RoomRestController {

    @Autowired
    private RoomService roomSvc;

    @GetMapping(path = "count")
    public Integer getRoomCount() {
        return roomSvc.count();
    }

    @GetMapping
    public ResponseEntity<List<Room>> getAllRooms() {
        List<Room> rooms = roomSvc.findAll();

        if (rooms.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(rooms, HttpStatus.OK);
    }
}
