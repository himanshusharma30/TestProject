package webapp.web.room;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import webapp.db.connection.JDBCConnection;
import webapp.web.room.model.Room;

@Service
public class RoomDAO {

	static PreparedStatement ps = null;
	static Connection con = null;
	static ResultSet rs = null;

	public static ArrayList<Room> getDetails(String university) throws Exception {
		ArrayList<Room> arr = new ArrayList<Room>();
		con = JDBCConnection.getConnection();
		ps = con.prepareStatement(RoomSQL.FIND_ALL_ROOMS);
		ps.setString(1, university);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Room r = new Room();
			r.setRoom_id(rs.getInt(1));
			r.setHost(rs.getString(2));
			r.setPrice_monthly(rs.getInt(3));
			r.setPrice_yearly(rs.getInt(4));
			r.setGps(rs.getString(5));
			r.setDetails(rs.getString(6));
			r.setRules(rs.getString(7));
			r.setPosted_by(rs.getInt(8));
			r.setPosted_on(rs.getDate(9));
			r.setType(rs.getString(11));
			r.setTag(rs.getString(10));
			r.setLocation(rs.getString(12));
			r.setCurrent_distance(rs.getInt(13));
			r.setImage_url(rs.getString(14));
			r.setGirls(rs.getInt(15));
			r.setBoys(rs.getInt(16));
			r.setRooms(rs.getInt(17));
			r.setBathrooms(rs.getInt(18));
			r.setNear_university(rs.getString(19));
			r.setNear_university_id(getUniversityId(rs.getString(19)));
			arr.add(r);
		}

		con.close();
		ps.close();
		rs.close();
		JDBCConnection.closeConnection(rs, ps, con);
		return arr;
	}

	public static Room getDetailsWithID(String university, int id) throws Exception {
		con = JDBCConnection.getConnection();
		ps = con.prepareStatement(RoomSQL.FIND_ROOM_BY_UNIVERSITY_ID_AND_ROOM_ID);
		ps.setString(1, university);
		ps.setInt(2, id);
		rs = ps.executeQuery();
		rs.next();

		Room r = new Room();
		r.setRoom_id(rs.getInt(1));
		r.setHost(rs.getString(2));
		r.setPrice_monthly(rs.getInt(3));
		r.setPrice_yearly(rs.getInt(4));
		r.setGps(rs.getString(5));
		r.setDetails(rs.getString(6));
		r.setRules(rs.getString(7));
		r.setPosted_by(rs.getInt(8));
		r.setPosted_on(rs.getDate(9));
		r.setTag(rs.getString(10));
		r.setType(rs.getString(11));
		r.setLocation(rs.getString(12));
		r.setCurrent_distance(rs.getInt(13));
		r.setImage_url(rs.getString(14));
		r.setGirls(rs.getInt(15));
		r.setBoys(rs.getInt(16));
		r.setRooms(rs.getInt(17));
		r.setBathrooms(rs.getInt(18));
		r.setNear_university(rs.getString(19));
		con.close();
		rs.close();
		ps.close();
		JDBCConnection.closeConnection(rs, ps, con);
		return r;
	}

	public static void postRoom(Room room) throws Exception {

		con = JDBCConnection.getConnection();
		ps = con.prepareStatement(RoomSQL.ADD_ROOM);
		ps.setString(1, room.getHost());
		ps.setInt(2, room.getPrice_monthly());
		ps.setInt(3, room.getPrice_yearly());
		ps.setString(4, room.getGps());
		ps.setString(5, room.getDetails());
		ps.setString(6, room.getRules());
		ps.setInt(7, room.getPosted_by());
		ps.setDate(8, room.getPosted_on());
		ps.setString(9, room.getTag());
		ps.setString(10, room.getType());
		ps.setString(11, room.getLocation());
		ps.setInt(12, room.getCurrent_distance());
		ps.setString(13, room.getImage_url());
		ps.setInt(14, room.getGirls());
		ps.setInt(15, room.getBoys());
		ps.setInt(16, room.getRooms());
		ps.setInt(17, room.getBathrooms());
		ps.setInt(18, room.getNear_university_id());
		int x = ps.executeUpdate();
		System.out.println(x);
		JDBCConnection.closeConnection(rs, ps, con);
		rs=null;
	}

	public static int getNextRoomId() throws Exception {
		int r_id;
		con = JDBCConnection.getConnection();
		ps = con.prepareStatement(RoomSQL.GET_ROOM_ID);
		rs = ps.executeQuery();
		if (rs.last())
			r_id = rs.getInt(1) + 1;
		else
			r_id = 0;
		JDBCConnection.closeConnection(rs, ps, con);
		return r_id;
	}

	public static int getUniversityId(String near_university) throws Exception {
		int univ_id = 0;
		con = JDBCConnection.getConnection();
		ps = con.prepareStatement(RoomSQL.FIND_UNIVERSITY_ID);
		ps.setString(1, near_university);
		rs = ps.executeQuery();
		rs.next();
		univ_id = rs.getInt(1);
		JDBCConnection.closeConnection(rs, ps, con);
		return univ_id;
	}

	public static String getUniversityName(int near_university_id) throws Exception {
		con = JDBCConnection.getConnection();
		ps = con.prepareStatement(RoomSQL.FIND_UNIVERSITY_NAME);
		ps.setInt(1, near_university_id);
		rs = ps.executeQuery();
		rs.next();
		String univ_name = rs.getString(1);
		JDBCConnection.closeConnection(rs, ps, con);
		return univ_name;
	}

}
