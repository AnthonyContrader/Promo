package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;
import it.contrader.dto.ClientDTO;
import it.contrader.model.Client;

/**
 * 
 * @author Vittorio
 * 
 * Implementando questa l'interfaccia converter la classe UserConverter è OBBLIGATA ad implementarne i metodi
 *
 */
public class ClientConverter implements Converter<Client, ClientDTO> {
	
	/**
	 * Crea un oggetto di tipo UserDTO e lo riempie con i campi del parametro user di tipo User.
	 * Notare l'uso del metodo get() per ottenere il valore dell'attributo-
	 */
	@Override
	public ClientDTO toDTO(Client client) {
		ClientDTO clientDTO = new ClientDTO(client.getId(), client.getIdmoderator(), client.getUsername(), client.getPassword(),client.getScode(), client.getEmail());
		return clientDTO;
	}

	/**
	 * Crea un oggetto di tipo Client e lo riempie con i campi del parametro user di tipo ClientDTO.
	 * Notare l'uso del metodo get() per ottenere il valore dell'attributo-
	 */
	@Override
	public Client toEntity(ClientDTO clientDTO) {
		Client client = new Client(clientDTO.getId(), clientDTO.getIdmoderator(), clientDTO.getUsername(), clientDTO.getPassword(), clientDTO.getScode(), clientDTO.getEmail());
		
		if (clientDTO.getId() != 0)
			client.setId(clientDTO.getId());
		return client;
	}
	
	/**
	 * Metodo per convertire le liste di User.
	 */
	@Override
	public List<ClientDTO> toDTOList(List<Client> clientList) {
		//Crea una lista vuota.
		List<ClientDTO> clientDTOList = new ArrayList<ClientDTO>();
		
		//Cicla tutti gli elementi della lista e li converte uno a uno
		for(Client client : clientList) {
			//Utilizza il metodo toDTO per convertire ogni singolo elemento della lista
			//e lo aggiunge ad una lista di DTO
			clientDTOList.add(toDTO(client));
		}
		return clientDTOList;
	}

	
	
}
