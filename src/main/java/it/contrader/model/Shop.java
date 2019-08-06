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
@Table(name="Shop")
public class Shop {

	@Id
	@Column(name = "idshop")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idshop;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idmoderator")
	private User user ;

	@NotNull
	private String name;
	
    @Column(name = "type")
	@NotNull
    private String type;

	@NotNull
	@Column(name = "position")
	private String position;
	
	@NotNull
	@Column(name = "code")
	private String barcode;
}