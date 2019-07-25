package it.contrader.dto;

/**
 * 
 * @author Vittorio
 *
 *Il DTO è simile al Model ma può contenere meno attributi (ad esempio d dati sensibili
 *che non devono arrivare alla View). GLi oggetti vengono trasformati da oggetti del Model
 *a oggetti del DTO tramite i Converter (chiamati dai Service). 
 *Per la descrizione della classe far riferimento al Model "User".
 */
public class ClientDTO {
	
	private int idclient;
	
	private int idmoderator;

	private String username;
	
	private String password;
	
	private String scode;
	
	private String email;
	
	public ClientDTO() {
		
	}

	public ClientDTO (int idmoderator, String username, String password, String scode, String email) {
		this.idmoderator = idmoderator;
		this.username = username;
		this.password = password;
	    this.scode = scode;
		this.email = email;
		
	}

	public ClientDTO (int idclient, int idmoderator, String username, String password, String scode, String email) {
		this.idclient = idclient;
		this.idmoderator = idmoderator;
		this.username = username;
		this.password = password;
		this.scode = scode;
		this.email = email;
	}

	public int getId() {
		return this.idclient;
	}
	public void setId(int idclient) {
		this.idclient = idclient;
	}
	public int getIdmoderator() {
		return this.idmoderator;
	}
	public void setIdmoderator(int idmoderator) {
		this.idmoderator = idmoderator;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public String getScode() {
		return this.scode;
	}

	public void setScode(String scode) {
		this.scode = scode;
	}

	public String  getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

	@Override
	public String toString() {
		return  idclient + "\t\t"  + idmoderator + "\t"  + username +"\t\t" +   password + "\t\t" + scode + "\t\t"  + email;
	}
}
