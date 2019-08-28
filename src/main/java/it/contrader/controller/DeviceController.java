package it.contrader.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.DeviceDTO;
import it.contrader.service.DeviceService;


/**
 * 
 * Questa classe estende AbstractController con tipo DeviceDTO.
 * In aggiunta ai metodi di CRUD si implementa il metodo di login.
 * 
 * @author Vittorio Valent & Girolamo Murdaca
 * 
 * @param<DeviceDTO>
 * 
 * @see AbstractController
 *
 */
@RestController
@RequestMapping("/device")
@CrossOrigin(origins = "http://localhost:4200")
public class DeviceController extends AbstractController<DeviceDTO>{
	@Autowired
	DeviceService test;
	
	@GetMapping("tutto")
	public Iterable<DeviceDTO> prova () {
		return test.getTutto();
	}

}