package tn.esprit.managedBean;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import tn.esprit.entities.Article;
import tn.esprit.entities.Categorie;
import tn.esprit.service.ArticleServiceRemote;

@ManagedBean(name="examenBean")
@SessionScoped
public class examenBean {

	private String nomCat;
	private String nomArt;
	private String image;
	private int prix;
	private int idCategorie;
	private List<Categorie> categories;

	@EJB
	ArticleServiceRemote examenService;
	
	public String ajouterArticle()
	{
		Article article = new Article();
		
		article.setImage(image);
		article.setNom(nomArt);
		article.setPrix(prix);
		examenService.ajouterArticle(article);
		int id = examenService.getArticleId(nomArt);
		examenService.affecteArtCat(idCategorie, id);
		return "ajouterArticle?faces-redirect=true";
	}
	
	public String goToCategorie()
	{
		categories = examenService.getAllCategories();
		return "ajouterArticle?faces-redirect=true";
	}
	public void ajouterCategory()
	{
		Categorie cat = new Categorie();
		cat.setIdcat(3);
		cat.setNomcat(nomCat);
		examenService.ajouterCategorie(cat);
	}

	public String getNomCat() {
		return nomCat;
	}

	public void setNomCat(String nomCat) {
		this.nomCat = nomCat;
	}

	public ArticleServiceRemote getExamenService() {
		return examenService;
	}

	public void setExamenService(ArticleServiceRemote examenService) {
		this.examenService = examenService;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getPrix() {
		return prix;
	}

	public void setPrix(int prix) {
		this.prix = prix;
	}

	public int getIdCategorie() {
		return idCategorie;
	}

	public void setIdCategorie(int idCategorie) {
		this.idCategorie = idCategorie;
	}
	public List<Categorie> getCategories() {
		return categories;
	}
	public void setCategories(List<Categorie> categories) {
		this.categories = categories;
	}

	public String getNomArt() {
		return nomArt;
	}

	public void setNomArt(String nomArt) {
		this.nomArt = nomArt;
	}
	
	
	
	
	
}
