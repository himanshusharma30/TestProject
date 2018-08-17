package webapp.web.room.model;

import java.sql.Date;
import java.time.format.DateTimeFormatter;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Component
public class Room {

	int room_id;	
	String host;	
	int price_monthly;
	int price_yearly;
	String details;
	String gps;
	String rules;
	String near_university;
	int near_university_id;
	int posted_by;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date posted_on;
	String tag;
	String type;
	String location;
	int current_distance;
	String image_url;
	int girls;
	int boys;
	int bathrooms;
	int rooms;
	int user;
	
	
	public int getNear_university_id() {
		return near_university_id;
	}


	public void setNear_university_id(int near_university_id) {
		this.near_university_id = near_university_id;
	}


	public int getUser() {
		return user;
	}


	public void setUser(int user) {
		this.user = user;
	}


	public Room()
	{
		
	}


	public int getRoom_id() {
		return room_id;
	}


	public void setRoom_id(int room_id) {
		this.room_id = room_id;
	}


	public String getHost() {
		return host;
	}


	public void setHost(String host) {
		this.host = host;
	}


	public int getPrice_monthly() {
		return price_monthly;
	}


	public void setPrice_monthly(int price_monthly) {
		this.price_monthly = price_monthly;
	}


	public int getPrice_yearly() {
		return price_yearly;
	}


	public void setPrice_yearly(int price_yearly) {
		this.price_yearly = price_yearly;
	}


	public String getDetails() {
		return details;
	}


	public void setDetails(String details) {
		this.details = details;
	}


	public String getGps() {
		return gps;
	}


	public void setGps(String gps) {
		this.gps = gps;
	}


	public String getRules() {
		return rules;
	}


	public void setRules(String rules) {
		this.rules = rules;
	}


	public String getNear_university() {
		return near_university;
	}


	public void setNear_university(String near_university) {
		this.near_university = near_university;
	}


	public int getPosted_by() {
		return posted_by;
	}


	public void setPosted_by(int posted_by) {
		this.posted_by = posted_by;
	}


	public Date getPosted_on() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"); 
		long millis=System.currentTimeMillis();  
		java.sql.Date posted_on=new java.sql.Date(millis);
		return posted_on;
	}


	public void setPosted_on(Date posted_on) {
		this.posted_on = posted_on;
	}


	public String getTag() {
		return tag;
	}


	public void setTag(String tag) {
		this.tag = tag;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public int getCurrent_distance() {
		return current_distance;
	}


	public void setCurrent_distance(int current_distance) {
		this.current_distance = current_distance;
	}


	public String getImage_url() {
		return image_url;
	}


	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}


	public int getGirls() {
		return girls;
	}


	public void setGirls(int girls) {
		this.girls = girls;
	}


	public int getBoys() {
		return boys;
	}


	public void setBoys(int boys) {
		this.boys = boys;
	}


	public int getBathrooms() {
		return bathrooms;
	}


	public void setBathrooms(int bathrooms) {
		this.bathrooms = bathrooms;
	}


	public int getRooms() {
		return rooms;
	}


	public void setRooms(int rooms) {
		this.rooms = rooms;
	}


	@Override
	public String toString() {
		return "Room [room_id=" + room_id + ", host=" + host + ", price_monthly=" + price_monthly + ", price_yearly="
				+ price_yearly + ", details=" + details + ", gps=" + gps + ", rules=" + rules + ", near_university="
				+ near_university + ", posted_by=" + posted_by + ", posted_on=" + posted_on + ", tag=" + tag + ", type="
				+ type + ", location=" + location + ", current_distance=" + current_distance + ", image_url="
				+ image_url + ", girls=" + girls + ", boys=" + boys + ", bathrooms=" + bathrooms + ", rooms=" + rooms
				+ "]";
	}
	
	
	
	

}
