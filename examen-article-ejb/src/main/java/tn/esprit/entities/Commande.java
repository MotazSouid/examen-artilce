package tn.esprit.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: Commande
 *
 */
@Entity

public class Commande implements Serializable {

	   
	@Id
	private int idcmd;
	private Date dateLivraison;
	private Status status;
	@OneToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private List<Article> articles;
	private static final long serialVersionUID = 1L;

	public Commande() {
		super();
	}   
	public int getIdcmd() {
		return this.idcmd;
	}

	public void setIdcmd(int idcmd) {
		this.idcmd = idcmd;
	}   
	public Date getDateLivraison() {
		return this.dateLivraison;
	}

	public void setDateLivraison(Date dateLivraison) {
		this.dateLivraison = dateLivraison;
	}   
	public Status getStatus() {
		return this.status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	public List<Article> getArticles() {
		return articles;
	}
	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
   
}
