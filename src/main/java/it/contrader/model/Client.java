package it.contrader.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "client")
public class Client {

	@Id
	@Column(name = "idclient")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idclient;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idmoderator")
	@NotNull
	private User user;

	@Column(name = "username")
	@NotNull
	private String username;

	@Column(name = "password")
	@NotNull
	private String password;

	@NotNull
	@Column(name = "scode")
	private String scode;

	@NotNull
	@Column(name = "email")
	private String email;

	
//	public int getId() {
//		return this.idclient;
//	}
//	
//	public void setId(int idclient) {
//		this.idclient = idclient;
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

