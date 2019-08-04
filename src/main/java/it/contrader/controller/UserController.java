package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.contrader.dto.UserDTO;
import it.contrader.services.UserService;

import java.util.List;


@Controller
@RequestMapping("/User")
public class UserController {

	private final UserService userService;
	private HttpSession session;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	private void visualUser(HttpServletRequest request){
		List<UserDTO> allUser = this.userService.getListaUserDTO();
		request.setAttribute("allUserDTO", allUser);
	}
	
	@GetMapping("/areariservata")
	public String areariservata() {
		return "user/login";		
	}
	
	@GetMapping("/register")
	public String register() {
		return "user/register";		
	}
	
	@RequestMapping(value = "/registerNewUser", method = RequestMethod.POST)
	public String insertUser(HttpServletRequest request) {
		String username = request.getParameter("username").toString();
		String password = request.getParameter("password").toString();
		String usertype = request.getParameter("usertype").toString();
		Integer barcode = Integer.parseInt(request.getParameter("barcode").toString());
		String scode = request.getParameter("scode").toString();

		UserDTO userObj = new UserDTO(0, username, password, usertype, barcode, scode);
		
		userService.insertUser(userObj);

		visualUser(request);
		return "user/login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginControl(HttpServletRequest request) {
		session = request.getSession();
		final String username = request.getParameter("username");
		final String password = request.getParameter("password");
		final UserDTO userDTO = userService.getByUsernameAndPassword(username, password);
		final String usertype = userDTO.getUsertype();
		if (!StringUtils.isEmpty(usertype)) {
			session.setAttribute("utenteCollegato", userDTO);
			if (usertype.equals("ADMIN")) {
				List<UserDTO> allUser = this.userService.getListaUserDTO();
				request.setAttribute("allUserDTO", allUser);
				return "user/homeAdmin";
			} else if (usertype.equals("MODERATOR")) {
				return "moderator/homeModerator";
			}
		}
		return "index";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logOut(HttpServletRequest request) {
		request.getSession().invalidate();
		return "index";
	}
	
	@GetMapping("/viewNewUser")
	public String viewNewUser() {
		return "user/viewNewUser";		
	}
	
	@RequestMapping(value = "/insertNewUser", method = RequestMethod.POST)
	public String insertNewUser(HttpServletRequest request) {
		String username = request.getParameter("username").toString();
		String password = request.getParameter("password").toString();
		String usertype = request.getParameter("usertype").toString();
		Integer barcode = Integer.parseInt(request.getParameter("barcode").toString());
		String scode = request.getParameter("scode").toString();

		UserDTO userObj = new UserDTO(0, username, password, usertype, barcode, scode);
		
		userService.insertUser(userObj);

		visualUser(request);
		return "user/homeAdmin";
	}
	
	@RequestMapping(value = "/viewUserUpdate", method = RequestMethod.GET)
	public String viewUserUpdate(HttpServletRequest request) {
		int idUser = Integer.parseInt(request.getParameter("id"));
		UserDTO user = userService.getUserDTOById(idUser);
		request.setAttribute("user", user);
		return "user/updateUser";		
	}
	
	@RequestMapping(value = "/updateUser", method = RequestMethod.POST)
	public String updateUser(HttpServletRequest request) {
		int idUpdate = Integer.parseInt(request.getParameter("id"));
		String usernameUpdate = request.getParameter("username");
		String passwordUpdate = request.getParameter("password");
		String usertypeUpdate = request.getParameter("usertype");
		int barcodeUpdate = Integer.parseInt(request.getParameter("barcode"));
		String scodeUpdate = request.getParameter("scode");
		
		final UserDTO user = new UserDTO(idUpdate, usernameUpdate, passwordUpdate, usertypeUpdate, barcodeUpdate, scodeUpdate);
		user.setId(idUpdate);
		
		userService.updateUser(user);
		
		visualUser(request);
		return "user/homeAdmin";	
	}
	
	@RequestMapping(value = "/deleteUser", method = RequestMethod.GET)
	public String delete(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("id", id);
		this.userService.deleteUserById(id);
		visualUser(request);
		return "user/homeAdmin";
	}
	
	@RequestMapping(value = "/crea", method = RequestMethod.GET)
	public String insert(HttpServletRequest request) {
		visualUser(request);
		request.setAttribute("option", "insert");
		return "creaUser";	
	}
	
	@RequestMapping(value = "/cercaUser", method = RequestMethod.GET)
	public String cercaUser(HttpServletRequest request) {

		final String content = request.getParameter("search");

		List<UserDTO> allUser = this.userService.findUserDTOByUsername(content);
		request.setAttribute("allUserDTO", allUser);

		return "homeAdmin";

	}
	
}
