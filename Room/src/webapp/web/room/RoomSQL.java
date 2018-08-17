package webapp.web.room;

public interface RoomSQL {

	/* public final String */

	public final String FIND_ROOM_BY_UNIVERSITY_ID_AND_ROOM_ID = ""
			+ "select room_id, host, price_monthly,"
			+ "price_yearly, gps, details, rules, posted_by,"
			+ "posted_on, tag,type, location, current_distance, image_urls, "
			+ "girls, boys,rooms,bathrooms, university_name from room inner join university "
			+ "on room.near_university_id=university.university_id having university.university_name=? and room.room_id=?";
	public final String FIND_ALL_ROOMS = "select room_id, host, price_monthly,"
			+ "price_yearly, gps, details, rules, posted_by,"
			+ "posted_on, tag,type, location, current_distance, image_urls, "
			+ "girls, boys,rooms,bathrooms, university_name from room inner join university "
			+ "on room.near_university_id=university.university_id having university.university_name=?";
	
	public final String FIND_UNIVERSITY_ID="select university_id from abroadma_test.university where university_name=?";
	
	public final String ADD_ROOM="insert into abroadma_test.room(host,price_monthly,price_yearly,gps,details,rules,posted_by,posted_on,tag,type,location,"
			+ "current_distance,image_urls,girls,boys,rooms,bathrooms,near_university_id)"
			+ " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public final String GET_ROOM_ID="select room_id from abroadma_test.room";
	
	public final String FIND_UNIVERSITY_NAME="select university_name from abroadma_test.university where university_id=?";
}
