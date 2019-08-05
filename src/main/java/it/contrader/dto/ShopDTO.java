package it.contrader.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShopDTO {

<<<<<<< HEAD
	private Integer idshop;

	private Integer iduser;
=======
	private int idshop;
	
	// int idmoderator
	private UserDTO user;
>>>>>>> b4af5e41d4d632b3d9a83f27bfc4c3f923a8f72d
	
	private String name;
	
	private String type;

	private String position;
	
	private String barcode;
}
