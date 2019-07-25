package it.contrader.service;

import it.contrader.converter.ClientConverter;
import it.contrader.dao.ClientDAO;
import it.contrader.dto.ClientDTO;
import it.contrader.model.Client;

/**
 * 
 * @author Vittorio 
 *
 *Grazie all'ereditarietà mi basta specificare i tipi di questa classe per
 *ereditare i metodi della clase AbstractService. Pertanto la classe risulta meno complicata
 *da scrivere, facendoci risparmiare tempo e fatica!
 */
public class ClientService extends AbstractService<Client, ClientDTO> {
	
	//Istanzio DAO  e Converter specifici.
	public ClientService(){
		this.dao = new ClientDAO();
		this.converter = new ClientConverter();
	}
	

}
