package it.contrader.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import it.contrader.model.Catalog;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Shop")
public class Shop {

	@Id
	@Column(name = "idshop")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idshop;

	//collegamento con user
	@ManyToOne
	@JoinColumn(name = "iduser", referencedColumnName="iduser")
	private User iduser;
	
	//collegamento con shop
	@OneToMany(mappedBy="shop", cascade = CascadeType.ALL)
	private Set <Catalog> catalog;
	
	@Column(name = "nome")
	@NotNull
	private String name;
	
    @Column(name = "tipo")
	@NotNull
    private String type;

	@NotNull
	@Column(name = "posizione")
	private String position;
	
	@NotNull
	@Column(name = "code")
	private String barcode;
}