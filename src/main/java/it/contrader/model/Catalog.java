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
@Table(name="Catalogo")
public class Catalog {

	@Id
	@Column(name = "idcatalogo")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idcatalog;
	
	@ManyToOne
	@JoinColumn(name = "idshop", referencedColumnName="idshop")
	private Shop idshop;
	
	@Column(name = "nome")
	@NotNull
	private String name;

	@Column(name = "tipo")
	@NotNull
	private String type;

	@NotNull
	@Column(name = "prezzo")
	private String price;
}