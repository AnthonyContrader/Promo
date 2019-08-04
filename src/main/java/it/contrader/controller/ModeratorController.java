package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.contrader.dto.ClientDTO;
import it.contrader.dto.ScreenDTO;
import it.contrader.dto.UserDTO;

import it.contrader.services.ClientService;
import it.contrader.services.UserService;
import it.contrader.services.ScreenService;

import java.util.List;

@Controller
@RequestMapping("/Moderator")
public class ModeratorController {
	
	private final ClientService clientService;
	
	private final ScreenService screenService;
	
	private final UserService userService;
	
	
	@Autowired
	public ModeratorController(ClientService clientService, ScreenService screenService, UserService userService) {
		this.clientService = clientService;
		this.screenService = screenService;
		this.userService = userService;
	}

	private void visualClient(HttpServletRequest request){
		List<ClientDTO> allClient = this.clientService.getListaClientDTO();
		request.setAttribute("allClientDTO", allClient);
	}
	
	@RequestMapping(value = "/viewAllClients", method = RequestMethod.GET)
	public String viewAllClients(HttpServletRequest request) {
		visualClient(request);
		return "moderator/homeModeratorManagement";		
	}
	
	@GetMapping("/viewNewClient")
	public String viewNewClient() {
		return "moderator/viewNewClient";		
	}
	
	@RequestMapping(value = "/insertNewClient", method = RequestMethod.POST)
	public String insertNewClient(HttpServletRequest request) {
		Integer idmoderator = Integer.parseInt(request.getParameter("idmoderator").toString());
		UserDTO moderator = userService.getUserDTOById(idmoderator);
		String username = request.getParameter("username").toString();
		String password = request.getParameter("password").toString();
		String scode = request.getParameter("scode").toString();
		String email = request.getParameter("email").toString();

		ClientDTO clientObj = new ClientDTO(0, moderator, username, password, scode, email);
		
		clientService.insertClient(clientObj);

		visualClient(request);
		return "moderator/homeModeratorManagement";
	}
	
	@RequestMapping(value = "/viewClientUpdate", method = RequestMethod.GET)
	public String viewClientUpdate(HttpServletRequest request) {
		int idclient = Integer.parseInt(request.getParameter("idclient"));
		ClientDTO client = clientService.getClientDTOById(idclient);
		request.setAttribute("client", client);
		return "moderator/updateClient";		
	}
	
	@RequestMapping(value = "/updateClient", method = RequestMethod.POST)
	public String updateClient(HttpServletRequest request) {
		int idclient = Integer.parseInt(request.getParameter("idclient"));
		int idmoderator = Integer.parseInt(request.getParameter("idmoderator"));
		UserDTO moderator = userService.getUserDTOById(idmoderator);
		String usernameUpdate = request.getParameter("username");
		String passwordUpdate = request.getParameter("password");
		String scodeUpdate = request.getParameter("scode");
		String emailUpdate = request.getParameter("email");
		
		final ClientDTO client = new ClientDTO(idclient, moderator, usernameUpdate, passwordUpdate, scodeUpdate, emailUpdate);
		client.setIdclient(idclient);
		
		clientService.updateClient(client);
		
		visualClient(request);
		return "moderator/homeModeratorManagement";	
	}
	
	@RequestMapping(value = "/deleteClient", method = RequestMethod.GET)
	public String delete(HttpServletRequest request) {
		int idclient = Integer.parseInt(request.getParameter("idclient"));
		request.setAttribute("idclient", idclient);
		this.clientService.deleteClientById(idclient);
		visualClient(request);
		return "moderator/homeModeratorManagement";
	}
	
	/*
	 *  Gestione Screen ***
	*/
	
	private void visualScreen(HttpServletRequest request){
		List<ScreenDTO> allScreen = this.screenService.getListaScreenDTO();
		request.setAttribute("allScreenDTO", allScreen);
	}
	
	@RequestMapping(value = "/viewAllScreens", method = RequestMethod.GET)
	public String viewAllScreens(HttpServletRequest request) {
		visualScreen(request);
		return "moderator/screenManagement";		
	}
	
	@GetMapping("/viewNewScreen")
	public String viewNewScreen() {
		return "moderator/viewNewScreen";		
	}
	
	@RequestMapping(value = "/insertNewScreen", method = RequestMethod.POST)
	public String insertNewScreen(HttpServletRequest request) {
		Integer idmoderator = Integer.parseInt(request.getParameter("idmoderator").toString());
		UserDTO moderator = userService.getUserDTOById(idmoderator);
		String output = request.getParameter("output").toString();
		String position = request.getParameter("position").toString();

		ScreenDTO screenObj = new ScreenDTO(0, moderator, output, position);
		
		screenService.insertScreen(screenObj);

		visualScreen(request);
		return "moderator/screenManagement";
	}
	
	@RequestMapping(value = "/viewScreenUpdate", method = RequestMethod.GET)
	public String viewScreenUpdate(HttpServletRequest request) {
		int idscreen = Integer.parseInt(request.getParameter("idscreen"));
		ScreenDTO screen = screenService.getScreenDTOByIdscreen(idscreen);
		request.setAttribute("screen", screen);
		return "moderator/updateScreen";		
	}
	
	@RequestMapping(value = "/updateScreen", method = RequestMethod.POST)
	public String updateScreen(HttpServletRequest request) {
		int idscreen = Integer.parseInt(request.getParameter("idscreen"));
		int idmoderator = Integer.parseInt(request.getParameter("idmoderator"));
		UserDTO moderator = userService.getUserDTOById(idmoderator);
		String outputUpdate = request.getParameter("output");
		String positionUpdate = request.getParameter("position");
		
		final ScreenDTO screen = new ScreenDTO(idscreen, moderator, outputUpdate, positionUpdate);
		screen.setIdscreen(idscreen);
		
		screenService.updateScreen(screen);
		
		visualScreen(request);
		return "moderator/screenManagement";	
	}
	
	@RequestMapping(value = "/deleteScreen", method = RequestMethod.GET)
	public String deleteScreen(HttpServletRequest request) {
		int idscreen = Integer.parseInt(request.getParameter("idscreen"));
		request.setAttribute("idscreen", idscreen);
		this.screenService.deleteScreenById(idscreen);
		visualScreen(request);
		return "moderator/screenManagement";
	}
	

}
