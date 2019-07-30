package it.contrader.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data//permette di accedere ai dati privati di una classe attrraverso un'altra. Fa automaticamente i GET e il SET
@AllArgsConstructor//crea costruttore con attributi
@NoArgsConstructor//crea costruttore vuoto
public class UserDTO {

	private Integer idUser;

	private String username;
	
	private String password;

	private String ruolo;
	
	private String barcode;
	
	private String scode;
}
