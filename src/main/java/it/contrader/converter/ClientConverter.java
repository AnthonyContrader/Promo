package it.contrader.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.contrader.dto.ClientDTO;
import it.contrader.model.Client;

/**
 * Questa classe implementa i metodi di conversione dell'entità User.
 *  
 * @author Vittorio Valent & Girolamo Murdaca
 * 
 *@see AbstractConverter
 *@see Converter
 */
@Component
public class ClientConverter extends AbstractConverter<Client,ClientDTO> {
 @Autowired
 private UserConverter converter;

 
	@Override
	public Client toEntity(ClientDTO clientDTO) {
		Client client = null;
		if (clientDTO != null) {
			client = new Client();		
			client.setId(clientDTO.getId());
			if(clientDTO.getUserDTO()!= null) {
				client.setUser(converter.toEntity(clientDTO.getUserDTO()));
			}
			client.setUsername(clientDTO.getUsername());
			client.setPassword(clientDTO.getPassword());
			client.setEmail(clientDTO.getEmail());		
		}
		return client;
	}

	@Override
	public ClientDTO toDTO(Client client) {
		ClientDTO clientDTO = null;
		if (client != null) {
			clientDTO = new ClientDTO();
			clientDTO.setId(client.getId());
			if(client.getUser()!= null) {
				clientDTO.setUserDTO(converter.toDTO(client.getUser()));
			}
			clientDTO.setUsername(client.getUsername());
			clientDTO.setPassword(client.getPassword());
			clientDTO.setEmail(client.getEmail());			
		}
		return clientDTO;
	}
}
	