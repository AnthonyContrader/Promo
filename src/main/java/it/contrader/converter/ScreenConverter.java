package it.contrader.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.contrader.dto.ScreenDTO;
import it.contrader.model.Screen;

/**
 * Questa classe implementa i metodi di conversione dell'entità Device.
 *  
 * @author Vittorio Valent & Girolamo Murdaca
 * 
 *@see AbstractConverter
 *@see Converter
 */
@Component
public class ScreenConverter extends AbstractConverter<Screen,ScreenDTO> {

	@Autowired
	 private UserConverter converter;

	 
		@Override
		public Screen toEntity(ScreenDTO screenDTO) {
			Screen screen = null;
			if (screenDTO != null) {
				screen = new Screen();		
				screen.setId(screenDTO.getId());
				if(screenDTO.getUserDTO()!= null) {
					screen.setUser(converter.toEntity(screenDTO.getUserDTO()));
				}
				screen.setId(screenDTO.getId());
				screen.setOutput(screenDTO.getOutput());
				screen.setPosition(screenDTO.getPosition());		
			}
			return screen;
		}

		@Override
		public ScreenDTO toDTO(Screen screen) {
			ScreenDTO screenDTO = null;
			if (screen != null) {
				screenDTO = new ScreenDTO();
				screenDTO.setId(screen.getId());
				if(screen.getUser()!= null) {
					screenDTO.setUserDTO(converter.toDTO(screen.getUser()));
				}
				screenDTO.setId(screen.getId());
				screenDTO.setOutput(screen.getOutput());
				screenDTO.setPosition(screen.getPosition());			
			}
			return screenDTO;
		}
	}
		