package it.contrader.model;

public class Client {

	private int id;
	
	private int idAdmin;
	
	private String username;
	
	private String password;
	
	private String email;
	
	private String scode;

	public Client(int id, int idAdmin, String username, String password, String email, String scode) {
		super();
		this.id = id;
		this.idAdmin = idAdmin;
		this.username = username;
		this.password = password;
		this.email = email;
		this.scode = scode;
	}

	public Client(int idAdmin, String username, String password, String email, String scode) {
		super();
		this.idAdmin = idAdmin;
		this.username = username;
		this.password = password;
		this.email = email;
		this.scode = scode;
	}
	
	public Client() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdAdmin() {
		return idAdmin;
	}

	public void setIdAdmin(int idAdmin) {
		this.idAdmin = idAdmin;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getScode() {
		return scode;
	}

	public void setScode(String scode) {
		this.scode = scode;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", idAdmin=" + idAdmin + ", username=" + username + ", password=" + password
				+ ", email=" + email + ", scode=" + scode + "]";
	}


}

