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
public class UserDTO {
	
	private int id;

	private String username;
	
	private String password;
	
	private String usertype;

    private int barcode;
	
	private String scode;

	
	public UserDTO() {
		
	}

	public UserDTO (String username, String password, String usertype, int barcode, String scode) {
		this.username = username;
		this.password = password;
		this.usertype = usertype;
		this.barcode=barcode;
		this.scode=scode;
	}

	public UserDTO (int id, String username, String password, String usertype, int barcode, String scode) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.usertype = usertype;
		this.barcode=barcode;
		this.scode=scode;
	}

	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getUsertype() {
		return this.usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}


	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public int getBarcode() {
		return this.barcode;
	}

	public void setBarcode(int barcode) {
		this.barcode = barcode;
	}

	public void setScode(String scode) {
		this.scode = scode;
	}

	public String getScode() {
		return scode;
	}
	@Override
	public String toString() {
		return  id + "\t "  + username +"\t\t " +   password + "\t\t " + usertype;
	}
}
