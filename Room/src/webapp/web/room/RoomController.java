package webapp.web.room;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import webapp.web.room.model.Room;

@Component
public class RoomController {

	@Autowired
	RoomDAO roomDao;

	@Autowired
	Room room;

	public List<Room> getAllDetails(String university) {

		List<Room> rooms = null;
		try {
			String univ = university.replace("-", " ");
			rooms = RoomDAO.getDetails(univ);
			System.out.println((new Date()).toString());

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return rooms;
	}

	public Room getDetailsById(String university, int roomId) {

		room = null;
		try {
			String univ = university.replace("-", " ");
			room = RoomDAO.getDetailsWithID(univ, roomId);
			System.out.println((new Date()).toString());

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return room;
	}

	public void postRoom(Room room) throws Exception {

		room.setUser(1);
		room.setPosted_on(room.getPosted_on());
		System.out.println(room.getNear_university());
		room.setNear_university_id(RoomDAO.getUniversityId(room.getNear_university()));
		RoomDAO.postRoom(room);
		System.out.println((new Date()).toString());

	}
}
