package it.contrader.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDTO {

	private int idclient;
	
//	private int idmoderator;
	private UserDTO user;

	private String username;
	
	private String password;

	private String scode;
	
	private String email;
	
	
}

