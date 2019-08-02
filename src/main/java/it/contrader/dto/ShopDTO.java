package it.contrader.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShopDTO {

	private int idshop;

	private int iduser;
	
	private String name;

	private String position;

	private String type;
	
	private String barcode;
	
}
