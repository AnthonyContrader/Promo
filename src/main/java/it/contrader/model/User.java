package it.contrader.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.springframework.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//HYBERNATE
@Data//permette di accedere ai dati privati di una classe attrraverso un'altra. Fa automaticamente i GET e il SET
@AllArgsConstructor//crea costruttore con attributi
@NoArgsConstructor//crea un costruttore vuoto
@Entity//crea una tabella
public class User {

	@Id//primary key
	@Column(name = "idUser")//sta creando e riempendo una colonna di nome idUser
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	/*genera chiavi primarie, 
	Generatetype=definiscew il tipo della chiave primaria,
	IDENTITY serve per inserire all'interno del database la primary key per il'identita*/
	private Integer idUser;

	@Column(name = "username")//il name è d'obbligo sempre per assegnare un nome alla colonna
	@NotNull//impone di inserire degli attributi obbligatoriamente
	private String username;

	@Column(name = "password")
	@NotNull
	private String password;

	@NotNull
	@Column(name = "ruolo")
	private String ruolo;

	@Nullable//la colonna può essere vuota, ma solo in certe circostanze
	@Column(name = "barcode")
	private String barcode;
	
	@Nullable//la colonna può essere vuota, ma solo in certe circostanze
	@Column(name = "scode")
	private String scode;
	
}
