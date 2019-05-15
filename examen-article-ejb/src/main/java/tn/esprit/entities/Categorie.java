package tn.esprit.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: Categorie
 *
 */
@Entity

public class Categorie implements Serializable {

	   
	@Id
	private int idcat;
	private String nomcat;
	@OneToMany(mappedBy="categorie", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private List<Article> articles;
	private static final long serialVersionUID = 1L;

	public Categorie() {
		super();
	}   
	public int getIdcat() {
		return this.idcat;
	}

	public void setIdcat(int idcat) {
		this.idcat = idcat;
	}   
	public String getNomcat() {
		return this.nomcat;
	}

	public void setNomcat(String nomcat) {
		this.nomcat = nomcat;
	}
	public List<Article> getArticles() {
		return articles;
	}
	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
   
}
