package it.contrader.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.ClientConverter;
import it.contrader.dao.ClientRepository;
import it.contrader.dto.ClientDTO;
import it.contrader.model.Client;

/**
 * Estende AbstractService con parametri Cure e CureDTO. 
 * Implementa il metodo di login ed eredita quelli Abstract. 
 * 
 * @author Vittorio Valent & Girolamo Murdaca
 * 
 * @see AbstractService
 * @see ServiceDTO
 */
@Service
public class ClientService extends AbstractService<Client,ClientDTO> {
	
	//ALL crud methods in AbstractService
	@Autowired
	ClientRepository asd ;
	@Autowired
	ClientConverter xkcd;
	//LOGIN method
	public ClientDTO findById(int id) {
		return converter.toDTO(((ClientRepository)repository).findById(id));
	}
	public Iterable<ClientDTO> getTutto () {
		return xkcd.toDTOList(asd.findAll());
		
	}

}
