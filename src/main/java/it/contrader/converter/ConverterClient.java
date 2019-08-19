
package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.ClientDTO;
import it.contrader.model.Client;

public class ConverterClient {

	public static ClientDTO toDTO(Client client) {
		ClientDTO clientDTO = null;
		if (client != null) {
			clientDTO = new ClientDTO();
			clientDTO.setIdclient(client.getIdclient());
			clientDTO.setUser(ConverterUser.toDTO(client.getUser()));
			clientDTO.setUsername(client.getUsername());
			clientDTO.setPassword(client.getPassword());
			clientDTO.setScode(client.getScode());
			clientDTO.setEmail(client.getEmail());
		}
		return clientDTO;
	}

	public static Client toEntity(ClientDTO clientDTO) {
		Client client = null;
		if (clientDTO != null) {
			client = new Client();
			client.setIdclient(clientDTO.getIdclient());
			client.setUser(ConverterUser.toEntity(clientDTO.getUser()));
			client.setUsername(clientDTO.getUsername());
			client.setPassword(clientDTO.getPassword());
			client.setScode(clientDTO.getScode());
			client.setEmail(clientDTO.getEmail());
		}
		return client;
	}

	public static List<ClientDTO> toListDTO(List<Client> list) {
		List<ClientDTO> listClientDTO = new ArrayList<>();
		if (!list.isEmpty()) {
			for (Client client : list) {
				listClientDTO.add(ConverterClient.toDTO(client));
			}
		}
		return listClientDTO;
	}

	public static List<Client> toListEntity(List<ClientDTO> listClientDTO) {
		List<Client> list = new ArrayList<>();
		if (!listClientDTO.isEmpty()) {
			for (ClientDTO clientDTO : listClientDTO) {
				list.add(ConverterClient.toEntity(clientDTO));
			}
		}
		return list;
	}
}
