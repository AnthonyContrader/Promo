package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.contrader.dto.ClientDTO;

import it.contrader.services.ClientService;

import java.util.List;


@Controller
@RequestMapping("/Client")
public class ModeratorController {
	
	private final ClientService clientService;
	
	@Autowired
	public ModeratorController(ClientService clientService) {
		this.clientService = clientService;
	}

	private void visualClient(HttpServletRequest request){
		List<ClientDTO> allClient = this.clientService.getListaClientDTO();
		request.setAttribute("allClientDTO", allClient);
	}
	

}
