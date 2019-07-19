package it.contrader.service;

import it.contrader.dto.UserDTO;
import it.contrader.model.User;

public class ClientService extends AbstractService<Client, ClientDTO>{
public ClientService() {
	this.dao = new ClientDAO();
	this.converter= new ClientConverter();
}

public boolean insert(ClientDTO dto) {
	Client.out.print("sei qua");
	return dao.insert(converter.toEntity(dto));
}
}
