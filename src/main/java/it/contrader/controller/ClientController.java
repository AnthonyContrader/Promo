package it.contrader.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.AreariservataDTO;
import it.contrader.dto.ClientDTO;
import it.contrader.dto.LoginDTO;
import it.contrader.dto.UserDTO;
import it.contrader.service.ClientService;


/**
 * 
 * Questa classe estende AbstractController con tipo CureDTO.
 * In aggiunta ai metodi di CRUD si implementa il metodo di login.
 * 
 * @author Vittorio Valent & Girolamo Murdaca
 * 
 * @param<CureDTO>
 * 
 * @see AbstractController
 *
 */
@RestController
@RequestMapping("/client")
@CrossOrigin(origins = "http://localhost:4200")
public class ClientController extends AbstractController<ClientDTO>{
	@Autowired
	ClientService test;
	
	@GetMapping("tutto")
	public Iterable<ClientDTO> prova () {
		return test.getTutto();
	}
	
	//POST Angular a ClientDTO
	@PostMapping(value = "/login")
	public ClientDTO login( @RequestBody LoginDTO loginDTO ) {
		return test.findByUsernameAndPassword(loginDTO.getUsername(), loginDTO.getPassword());
	}
}