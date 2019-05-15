package tn.esprit.entities;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Article
 *
 */
@Entity

public class Article implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idart;
	private String nom;
	private int prix;
	private String image;
	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private Categorie categorie;
	private static final long serialVersionUID = 1L;

	public Article() {
		super();
	}   
	public int getIdart() {
		return this.idart;
	}

	public void setIdart(int idart) {
		this.idart = idart;
	}   
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}   
	public int getPrix() {
		return this.prix;
	}

	public void setPrix(int prix) {
		this.prix = prix;
	}   
	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
   
}
