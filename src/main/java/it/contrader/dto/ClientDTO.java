package it.contrader.dto;

public class ClientDTO {
	private int id;
	private int idAdmin;
	private String username;
	private String password;		
	private String email;
	private String scode;
	
	public  ClientDTO() {	}
	
	public  ClientDTO(int idAdmin, String username, String password, String email, String scode) {
		this.idAdmin=idAdmin;
		this.username=username;
		this.password=password;
		this.email=email;
		this.scode=scode;
	}
	
	public  ClientDTO(int id, int idAdmin, String username, String password, String email, String scode) {
		this.id=id;
		this.idAdmin=idAdmin;
		this.username=username;
		this.password=password;
		this.email=email;
		this.scode=scode;
	}
	

	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getIdAdmin() {
		return this.idAdmin;
	}
	public void setIdAdmin(int idAdmin) {
		this.idAdmin = idAdmin;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setScode(String scode) {
		this.scode = scode;
	}

	public String getScode() {
		return scode;
	}
	
	@Override
	public String toString() {
		return id + "\t " + idAdmin + "\t\t " +  username + "\t\t " +  password + "\t\t " + email + "\t\t "+ scode;
	}
}
