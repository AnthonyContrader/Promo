package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;
import it.contrader.dto.ClientDTO;
import it.contrader.model.Client;

public class ClientConverter  implements Converter<Client, ClientDTO> {
		
		/**
		 * Crea un oggetto di tipo ClientDTO e lo riempie con i campi del parametro Client di tipo Client.
		 * Notare l'uso del metodo get() per ottenere il valore dell'attributo-
		 */
		@Override
		public ClientDTO toDTO(Client client) {
			ClientDTO clientDTO = new ClientDTO(client.getId(), client.getUsername(), client.getPassword(), client.getEmail(), client.getScode());
			return clientDTO;
		}

		/**
		 * Crea un oggetto di tipo Client e lo riempie con i campi del parametro Client di tipo ClientDTO.
		 * Notare l'uso del metodo get() per ottenere il valore dell'attributo-
		 */
		@Override
		public Client toEntity(ClientDTO clientDTO) {
			Client client = new Client(clientDTO.getId(), clientDTO.getUsername(), clientDTO.getPassword(), clientDTO.getScode(), clientDTO.getEmail());
			return client;
		}
		
		/**
		 * Metodo per convertire le liste di Client.
		 */
		@Override
		public List<ClientDTO> toDTOList(List<Client> clientList) {
			//Crea una lista vuota.
			List<ClientDTO> clientDTOList = new ArrayList<ClientDTO>();
			
			//Cicla tutti gli elementi della lista e li converte uno a uno
			for(Client client : clientList) {
				//Utilizza il metodo toDTO per convertire ogni singolo elemento della lista
				//e lo aggiunge adda lista di DTO
				clientDTOList.add(toDTO(client));
			}
			return clientDTOList;
		}

		
		
	}