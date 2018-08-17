package webapp.web.room;

import java.io.File;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import webapp.upload.image.CompressImage;
import webapp.upload.image.UploadFile;
import webapp.web.room.model.Room;

@RestController
public class RoomServlet {

	@Autowired
	RoomController roomController;

	@Autowired
	Room room;

	@RequestMapping("/")
	public ModelAndView first() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("index1");
		return modelAndView;
	}

	@RequestMapping("/{input}")
	public ModelAndView fun(@PathVariable("input") String university) {
		System.out.println((new Date()).toString());
		List<Room> rooms = roomController.getAllDetails(university);
		if (rooms == null)
			return new ModelAndView("error", "message", "Server Internal error");
		return new ModelAndView("index", "rooms", rooms);

	}

	@RequestMapping("/{university}/{room_id}")
	public ModelAndView getDetail(@PathVariable("university") String university, @PathVariable("room_id") int r_id) {
		System.out.println((new Date()).toString());
		room = roomController.getDetailsById(university, r_id);
		if (room == null)
			return new ModelAndView("error", "message", "No rooms are available");
		return new ModelAndView("index", "rooms", room);
	}

	@RequestMapping(value = "/post", method = RequestMethod.POST)
	public ModelAndView postRoom(@ModelAttribute Room room1, @RequestParam("img") MultipartFile[] imgs,
			HttpServletRequest req) {
		int r_id = 0, user = 1;
		System.out.println(room1);
		try {
			r_id = RoomDAO.getNextRoomId();
			
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		room1.setRoom_id(r_id);
		try {
			room1.setNear_university_id(RoomDAO.getUniversityId(room1.getNear_university()));
		} catch (Exception e) {
			return new ModelAndView("error", "message", "Invalid university");
		}
		try {
			String originalPath = req.getServletContext().getRealPath("/") + "user-" + user + File.separator + "room-"
					+ r_id + File.separator + "original" + File.separator;
			String thumbnailPath = req.getServletContext().getRealPath("/") + "user-" + user + File.separator + "room-"
					+ r_id + File.separator + "thumbnails";
			UploadFile.upload(originalPath, imgs);
			CompressImage.compress(thumbnailPath, imgs);

		} catch (Exception e) {
			return new ModelAndView("error", "message", "You failed to upload images => " + e.getMessage());
		}
		try {

			String img_url = "/user-" + user + "/room-" + r_id;
			room1.setImage_url(img_url);
			roomController.postRoom(room1);
		} catch (Exception e) {
			e.printStackTrace();
			return new ModelAndView("error", "message", "No rooms are available");
		}

		return new ModelAndView("messages", "msg", "You successfully uploaded images and added a new room");

	}
	@RequestMapping("/testy")
	public String esyh(@RequestParam("tex")String t)
	{
		return t;
	}

}
