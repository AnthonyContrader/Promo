package it.contrader.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScreenDTO {

	private Integer idscreen;
	
	// int idmoderator
	private UserDTO user; 

	private String output;
	
	private String position;

}
