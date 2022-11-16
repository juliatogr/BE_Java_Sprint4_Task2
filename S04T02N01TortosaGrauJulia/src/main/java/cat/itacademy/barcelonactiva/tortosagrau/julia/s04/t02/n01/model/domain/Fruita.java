package cat.itacademy.barcelonactiva.tortosagrau.julia.s04.t02.n01.model.domain;

import javax.persistence.*;

@Entity
@Table(name = "fruites")
public class Fruita {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private int id;
	
	@Column(name = "nom")
	private String nom;
	
	@Column(name = "quantitat_quilos")
	private int quantitatQuilos;
	
	public Fruita() {
		this.nom = "";
		this.quantitatQuilos = 0;
	}
	
	public Fruita(String nom, int quantitatQuilos) {
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
