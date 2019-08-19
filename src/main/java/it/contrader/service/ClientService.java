
package it.contrader.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.ConverterClient;
import it.contrader.dao.ClientRepository;
import it.contrader.dto.ClientDTO;
import it.contrader.model.Client;

@Service
public class ClientService {

	private final ClientRepository clientRepository;

	@Autowired
	public ClientService(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}

	public List<ClientDTO> getListaClientDTO() {
		return ConverterClient.toListDTO((List<Client>) clientRepository.findAll());
	}

	public ClientDTO getClientDTOById(Integer idclient) {
		return ConverterClient.toDTO(clientRepository.findById(idclient).get());
	}

	public ClientDTO getByUsernameAndPassword(String username, String password) {

		final Client client = clientRepository.findClientByUsernameAndPassword(username, password);

		return ConverterClient.toDTO(client);
	}

	public boolean insertClient(ClientDTO clientDTO) {
		return clientRepository.save(ConverterClient.toEntity(clientDTO)) != null;
	}
	
	public boolean insertNewClient(ClientDTO clientDTO) {
		return clientRepository.save(ConverterClient.toEntity(clientDTO)) != null;
	}

	public boolean updateClient(ClientDTO clientDTO) {
		return clientRepository.save(ConverterClient.toEntity(clientDTO)) != null;
	}
	
	public void deleteClientById(Integer idclient) {
		clientRepository.deleteById(idclient);
	}
	
	public List<ClientDTO> findClientDTOByUsername(String username) {
		
		final List<Client> list = clientRepository.findAllByUsername(username);
		final List<ClientDTO> clientDTOs = new ArrayList<>();
		list.forEach(i -> clientDTOs.add(ConverterClient.toDTO(i)));
		return clientDTOs;
	}
}
