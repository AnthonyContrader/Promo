package it.contrader.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDTO {

	private int idclient;
//	
//	private int idmoderator;
	private UserDTO user;

	private String username;
	
	private String password;

	private String scode;
	
	private String email;
	
//	public int getId() {
//		return this.idclient;
//	}
//	
//	public void setId(int idclient) {
//		this.idclient = idclient;
//	}
//
//	public int getIdmoderator() {
//		return this.idmoderator;
//	}
//	
//	public void setIdmoderator(int idmoderator) {
//		this.idmoderator = idmoderator;
//	}
//	
//	public String getEmail() {
//		return this.email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}
	
}

