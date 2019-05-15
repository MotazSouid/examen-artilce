package tn.esprit.service;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.entities.Article;
import tn.esprit.entities.Categorie;
import tn.esprit.entities.Commande;

@Remote
public interface ArticleServiceRemote {
	
	public void ajouterCategorie(Categorie cat);
	
	public void ajouterArticle(Article article);
	
	public void ajouterCommande(Commande commande);
	
	public void affecteArtCat(int idcat, int idart);
	
	public void affecterArtCmd(int idcmd, int idart);
	
	public List<String> getAllarticleNamesByCategorie(int idcat);
	
	public List<String> getAllCategoiesNames();
	
	public List<String> getAllArticleNamesGreaterThanTwoHundred();
	
	public List<Categorie> getAllCategories();
	
	public int getArticleId(String nom);

}
