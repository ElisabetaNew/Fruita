package cat.itacademy.barcelonactiva.MarcualMora.Elisenda.s04.t02.n01.model.domain;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "fruites")
public class Fruita implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "nom")
	private String nom;
	@Column(name = "quantitatQuilos")
	private int quantitatQuilos;
	
	public Fruita() {
		
	}
	
	
	public Fruita(String nom, int quantitatQuilos) {
		super();
		this.nom = nom;
		this.quantitatQuilos = quantitatQuilos;
	}


	public int getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getQuantitatQuilos() {
		return quantitatQuilos;
	}
	public void setQuantitatQuilos(int quantitatQuilos) {
		this.quantitatQuilos = quantitatQuilos;
	}


	@Override
	public String toString() {
		return "Fruita [id=" + id + ", nom=" + nom + ", quantitatQuilos=" + quantitatQuilos + "]";
	}

	
}
