package it.contrader.dto;

public class ClientDTO {
	
	   private int id;
	    
	    private int idmoderator;

		private String username;
		
		private String password;
				
		private String scode;
		
		private String email;
		
		public ClientDTO(int id,int idmoderator, String username, String password, String scode, String email) {
			this.id=id;
			this.idmoderator=idmoderator;
			this.username=username;
			this.password=password;
			this.scode=scode;
			this.email=email;
		}
		public ClientDTO(String username, String password, String scode, String email) {
			this.username=username;
			this.password=password;
			this.scode=scode;
			this.email=email;

		}
		public ClientDTO(int id, String username, String password, String scode, String email) {
			this.id=id;
			this.username=username;
			this.password=password;
			this.scode=scode;
			this.email=email;

		}
				
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
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

		public int getIdmoderator() {
			return idmoderator;
		}

		public void setIdmoderator(int idmoderator) {
			this.idmoderator = idmoderator;
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

		@Override
		public String toString() {
			return "ClientDTO id=" + id + ", idmoderator=" + idmoderator + ", username=" + username + ", password="
					+ password + ", scode=" + scode + ", email=" + email;
		}

}
