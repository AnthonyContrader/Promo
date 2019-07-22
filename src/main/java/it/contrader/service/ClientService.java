package it.contrader.service;

import it.contrader.converter.ClientConverter;
import it.contrader.dao.ClientDAO;
import it.contrader.dto.ClientDTO;
import it.contrader.model.Client;

public class ClientService extends AbstractService<Client, ClientDTO>{
public ClientService() {
	this.dao = new ClientDAO();
	this.converter= new ClientConverter();
}

public boolean insert(ClientDTO dto) {
	System.out.print("/t");
	return dao.insert(converter.toEntity(dto));
}
}
