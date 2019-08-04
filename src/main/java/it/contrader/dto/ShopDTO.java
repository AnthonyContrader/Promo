package it.contrader.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShopDTO {

	private int idshop;
	
	// int idmoderator
	private UserDTO user;
	
	private String name;
	
	private String type;

	private String position;
	
	private String barcode;
	
}
