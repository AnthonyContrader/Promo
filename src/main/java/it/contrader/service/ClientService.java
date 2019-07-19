package it.contrader.service;

import com.mysql.cj.xdevapi.Client;
import it.contrader.dto.ClientDTO;
import it.contrader.converter.ClientConverter;
import it.contrader.dao.ClientDAO;

public class ClientService extends AbstractService<Client, ClientDTO>{
public ClientService() {
	this.dao = new ClientDAO();
	this.converter= new ClientConverter();
}

public boolean insert(ClientDTO dto) {
	System.out.print("sei qua");
	return dao.insert(converter.toEntity(dto));
}
}
