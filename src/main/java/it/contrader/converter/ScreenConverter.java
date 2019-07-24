package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.ScreenDTO;
import it.contrader.model.Screen;

/**
 * 
 * @author Vittorio
 * 
 * Implementando questa l'interfaccia converter la classe UserConverter è OBBLIGATA ad implementarne i metodi
 *
 */
public class ScreenConverter  implements Converter<Screen, ScreenDTO> {
	
	/**
	 * Crea un oggetto di tipo UserDTO e lo riempie con i campi del parametro user di tipo User.
	 * Notare l'uso del metodo get() per ottenere il valore dell'attributo-
	 */
	@Override
	public ScreenDTO toDTO(Screen screen) {
		ScreenDTO screenDTO = new ScreenDTO(screen.getIdscreen(), screen.getOutput());
		return screenDTO;
	}

	/**
	 * Crea un oggetto di tipo User e lo riempie con i campi del parametro user di tipo UserDTO.
	 * Notare l'uso del metodo get() per ottenere il valore dell'attributo-
	 */
	@Override
	public Screen toEntity(ScreenDTO screenDTO) {
		Screen screen = new Screen(screenDTO.getIdscreen(), screenDTO.getOutput());
		return screen;
	}
	
	/**
	 * Metodo per convertire le liste di User.
	 */
	@Override
	public List<ScreenDTO> toDTOList(List<Screen> screenList) {
		//Crea una lista vuota.
		List<ScreenDTO> screenDTOList = new ArrayList<ScreenDTO>();
		
		//Cicla tutti gli elementi della lista e li converte uno a uno
		for(Screen screen : screenList) {
			//Utilizza il metodo toDTO per convertire ogni singolo elemento della lista
			//e lo aggiunge adda lista di DTO
			screenDTOList.add(toDTO(screen));
		}
		return screenDTOList;
	}

}