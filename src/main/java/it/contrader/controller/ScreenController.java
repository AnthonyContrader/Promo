package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.contrader.dto.ScreenDTO;
import it.contrader.model.Screen;
import it.contrader.services.ScreenService;

import java.util.List;


@Controller
@RequestMapping("/Screen")
public class ScreenController {

	private final ScreenService screenService;
	private HttpSession session;
	
	@Autowired
	public ScreenController(ScreenService screenService) {
		this.screenService = screenService;
	}

	private void visualScreen(HttpServletRequest request){
		List<ScreenDTO> allScreen = this.screenService.getListaScreenDTO();
		request.setAttribute("allScreenDTO", allScreen);
	}
	
	
	@GetMapping("/viewNewScreen")
	public String viewNewScreen() {
		return "screen/viewNewScreen";		
	}
	
	@RequestMapping(value = "/insertNewScreen", method = RequestMethod.POST)
	public String insertNewScreen(HttpServletRequest request) {
		Integer idscreen = Integer.parseInt(request.getParameter("output").toString());
		String output= request.getParameter("output").toString();
		String position = request.getParameter("position").toString();

		ScreenDTO screenObj = new ScreenDTO(idscreen, output, position);
		
		screenService.insertScreen(screenObj);

		visualScreen(request);
		return "user/homeModerator";
	}
	
	@RequestMapping(value = "/viewScreenUpdate", method = RequestMethod.GET)
	public String viewScreenUpdate(HttpServletRequest request) {
		int idscreen = Integer.parseInt(request.getParameter("idscreen"));
		ScreenDTO screenDTO = screenService.getScreenDTOById(idscreen);
		request.setAttribute("screen", screenDTO);
		return "screen/updateScreen";		
	}
	
	@RequestMapping(value = "/updateScreen", method = RequestMethod.POST)
	public String updateScreen(HttpServletRequest request) {
		int idUpdate = Integer.parseInt(request.getParameter("idscreen"));
		String outputUpdate = request.getParameter("output");
		String positionUpdate = request.getParameter("position");
		
		final ScreenDTO screen = new ScreenDTO(idUpdate, outputUpdate, positionUpdate);
		screen.setIdscreen(idUpdate);
		
		screenService.updateScreen(screen);
		
		visualScreen(request);
		return "user/homeModerator";	
	}
	
	@RequestMapping(value = "/deleteScreen", method = RequestMethod.GET)
	public String delete(HttpServletRequest request) {
		int idscreen = Integer.parseInt(request.getParameter("idscreen"));
		request.setAttribute("idscreen", idscreen);
		this.screenService.deleteScreenById(idscreen);
		visualScreen(request);
		return "user/homeModerator";
		
	}
	
}
