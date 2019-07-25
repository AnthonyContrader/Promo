package it.contrader.model;

public class Client {

	    private int id;
	    
	    private int idmoderator;

		private String username;
		
		private String password;
		
		private String scode;
		
		private String email;

		public Client(int id, String username, String password, String scode, String email) {
			
		}
		
		public Client(int id, int idmoderator , String username, String password, String scode, String email) {
					
		}
		
		public Client(String username, String password, String scode, String email) {
			
		}
		
		public Client() {
			
		}

		public int getIdmoderator() {
			return idmoderator;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public void setIdmoderator(int idmoderator) {
			this.idmoderator = idmoderator;
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

		public String getScode() {
			return scode;
		}

		public void setScode(String scode) {
			this.scode = scode;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}
		
}
