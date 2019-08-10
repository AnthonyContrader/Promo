/*
package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.ScreenDTO;
import it.contrader.model.Screen;

public class ConverterScreen {

	public static ScreenDTO toDTO(Screen screen) {
		ScreenDTO screenDTO = null;
		if (screen != null) {
			screenDTO = new ScreenDTO();
			screenDTO.setIdscreen(screen.getIdscreen());
			screenDTO.setUser(ConverterUser.toDTO(screen.getUser()));
			screenDTO.setOutput(screen.getOutput());
			screenDTO.setPosition(screen.getPosition());
		}
		return screenDTO;
	}

	public static Screen toEntity(ScreenDTO screenDTO) {
		Screen screen = null;
		if (screenDTO != null) {
			screen = new Screen();
			screen.setIdscreen(screenDTO.getIdscreen());
			screen.setUser(ConverterUser.toEntity(screenDTO.getUser()));
			screen.setOutput(screenDTO.getOutput());
			screen.setPosition(screenDTO.getPosition());
		}
		return screen;
	}

	public static List<ScreenDTO> toListDTO(List<Screen> list) {
		List<ScreenDTO> listScreenDTO = new ArrayList<>();
		if (!list.isEmpty()) {
			for (Screen screen : list) {
				listScreenDTO.add(ConverterScreen.toDTO(screen));
			}
		}
		return listScreenDTO;
	}

	public static List<Screen> toListEntity(List<ScreenDTO> listScreenDTO) {
		List<Screen> list = new ArrayList<>();
		if (!listScreenDTO.isEmpty()) {
			for (ScreenDTO screenDTO : listScreenDTO) {
				list.add(ConverterScreen.toEntity(screenDTO));
			}
		}
		return list;
	}
}
*/