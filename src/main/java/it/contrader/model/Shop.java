package it.contrader.model;

<<<<<<< HEAD
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
=======
import javax.persistence.*;
>>>>>>> b4af5e41d4d632b3d9a83f27bfc4c3f923a8f72d
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

<<<<<<< HEAD
	//collegamento con user
	@ManyToOne
	@JoinColumn(name = "iduser", referencedColumnName="iduser")
	private User iduser;
	
	//collegamento con shop
	@OneToMany(mappedBy="shop", cascade = CascadeType.ALL)
	private Set <Catalog> catalog;
	
	@Column(name = "nome")
=======
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idmoderator")
	private User user ;

	@Column(name = "name")
>>>>>>> b4af5e41d4d632b3d9a83f27bfc4c3f923a8f72d
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