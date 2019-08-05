package it.contrader.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShopDTO {

	private Integer idshop;

	private Integer iduser;
	
	private String name;

	private String position;

	private String type;
	
	private String barcode;
}
