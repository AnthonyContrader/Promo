package it.contrader.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CatalogDTO {

	private Integer idcatalog;

	private Integer idshop;
	
	private String name;

	private String type;

	private String price;
		
}
