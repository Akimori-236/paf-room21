package sg.edu.nus.iss.app.pafroom21.repository;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.app.pafroom21.model.Room;

@Repository
public class RoomRepository implements RoomRepositoryInterface {

    @Autowired
    private JdbcTemplate template;

    String countSQL = "SELECT COUNT(*) FROM room";
    String selectSQL = "SELECT * FROM room";
    String selectByIdSQL = "SELECT * FROM room WHERE id=?";
    String insertSQL = "INSERT INTO room(room_type, price) VALUES(?, ?)";
    String updateSQL = "UPDATE room SET room_type=?, price=? WHERE id=?";
    String deleteSQL = "DELETE FROM room WHERE id=?";

    // SELECT COUNT(*) FROM room
    @Override
    public int count() {
        Integer result = 0;
        result = template.queryForObject(countSQL, Integer.class);
        if (result == null) {
            return 0;
        } else {
            return result;
        }
    }

    // INSERT INTO room(room_type, price) VALUES(?, ?)
    @Override
    public Boolean save(Room room) {

        Boolean saved = false;
        // execute SQL
        saved = template.execute(insertSQL, (PreparedStatementCallback<Boolean>) ps -> {
            // inject variables into the SQL statement
            ps.setString(1, room.getRoomType());
            ps.setInt(2, room.getPrice());
            Boolean result = ps.execute();
            return result;
        });
        return saved;
    }

    // SELECT * FROM room
    @Override
    public List<Room> getAll() {
        List<Room> roomList = new LinkedList<>();
        // mapping each row of SQL record to a Room class instance
        roomList = template.query(selectSQL, BeanPropertyRowMapper.newInstance(Room.class));
        return roomList;
    }

    @Override
    public Room getById(Integer id) {
        Room room = template.queryForObject(selectByIdSQL, BeanPropertyRowMapper.newInstance(Room.class), id);
        return room;
    }

    // UPDATE room SET room_type=?, price=? WHERE id=?
    @Override
    public int update(Room room) {
        int updated = 0;
        // returns number of rows affected
        updated = template.update(updateSQL, (PreparedStatementSetter) ps -> {
            ps.setString(1, room.getRoomType());
            ps.setInt(2, room.getPrice());
            ps.setInt(3, room.getId());
        });
        return updated;
    }

    // DELETE room WHERE id=?
    @Override
    public int deleteById(Integer id) {
        int deleted = 0;
        deleted = template.update(deleteSQL, (PreparedStatementSetter) ps -> ps.setInt(1, id));
        return deleted;
    }
}
