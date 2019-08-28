package it.contrader.service;

import org.springframework.stereotype.Service;

import it.contrader.dao.ScreenRepository;
import it.contrader.dto.ScreenDTO;
import it.contrader.model.Screen;

/**
 * Estende AbstractService con parametri Device e DeviceDTO. 
 * Implementa il metodo di login ed eredita quelli Abstract. 
 * 
 * @author Vittorio Valent & Girolamo Murdaca
 * 
 * @see AbstractService
 * @see ServiceDTO
 */
@Service
public class ScreenService extends AbstractService<Screen,ScreenDTO> {
	
	//ALL crud methods in AbstractService
	
	//LOGIN method
	public ScreenDTO findById(int id) {
		return converter.toDTO(((ScreenRepository)repository).findById(id));
	}

}
