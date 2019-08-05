package it.contrader.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CatalogDTO {

	private Integer idcatalog;

<<<<<<< HEAD:src/main/java/it/contrader/dto/CatalogDTO.java
	private Integer idshop;
=======
//	private int idclient;
	private ClientDTO client;
	
	private String mac;
>>>>>>> b4af5e41d4d632b3d9a83f27bfc4c3f923a8f72d:src/main/java/it/contrader/dto/DeviceDTO.java
	
	private String name;

	private String type;

	private String price;
		
}
