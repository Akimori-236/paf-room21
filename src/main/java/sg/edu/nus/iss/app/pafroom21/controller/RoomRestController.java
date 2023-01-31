package sg.edu.nus.iss.app.pafroom21.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sg.edu.nus.iss.app.pafroom21.model.Room;
import sg.edu.nus.iss.app.pafroom21.service.RoomService;

@RestController
@RequestMapping(path = "/api/rooms")
public class RoomRestController {

    @Autowired
    private RoomService roomSvc;

    @GetMapping(path = "/count")
    public Integer getRoomCount() {
        return roomSvc.count();
    }

    @GetMapping
    public ResponseEntity<List<Room>> getAllRooms() {
        List<Room> rooms = roomSvc.getAll();
        if (rooms.isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(rooms, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Room> getRoomById(@PathVariable Integer id) {
        Room room = roomSvc.getById(id);
        if (room.getRoomType() == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(room, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Boolean> insertRoom(@RequestBody Room room) {
        Boolean isInserted = roomSvc.save(room);
        if (isInserted) {
            return new ResponseEntity<>(null, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // ID to update is in the room object
    @PutMapping
    public ResponseEntity<Integer> updateRoom(@RequestBody Room room) {
        Integer updated = 0;
        updated = roomSvc.update(room);
        if (updated == 0) {
            return new ResponseEntity<>(updated, HttpStatus.NOT_MODIFIED);
        } else {
            return new ResponseEntity<>(updated, HttpStatus.OK);
        }
    }

    @DeleteMapping(path="/{id}")
    public ResponseEntity<Integer> deleteRoom(@PathVariable Integer id) {
        Integer deleted = 0;
        deleted = roomSvc.deleteById(id);
        if (deleted == 0) {
            return new ResponseEntity<>(deleted, HttpStatus.NOT_MODIFIED);
        } else {
            return new ResponseEntity<>(deleted, HttpStatus.OK);
        }
    }
}
