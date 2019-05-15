package tn.esprit.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.entities.Article;
import tn.esprit.entities.Categorie;
import tn.esprit.entities.Commande;

/**
 * Session Bean implementation class ArticleService
 */
@Stateless
@LocalBean
public class ArticleService implements ArticleServiceRemote, ArticleServiceLocal {
	@PersistenceContext(unitName = "imputation-ejb")
	EntityManager em;
    /**
     * Default constructor. 
     */
    public ArticleService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void ajouterCategorie(Categorie cat) {
		em.persist(cat);
		
	}

	@Override
	public void ajouterArticle(Article article) {
		em.persist(article);
		
	}

	@Override
	public void ajouterCommande(Commande commande) {
		em.persist(commande);
		
	}

	@Override
	public void affecteArtCat(int idcat, int idart) {
		Categorie categorie = em.find(Categorie.class, idcat);
		Article art = em.find(Article.class, idart);
		categorie.getArticles().add(art);
		art.setCategorie(categorie);
		
	}

	@Override
	public void affecterArtCmd(int idcmd, int idart) {
		Commande commande= em.find(Commande.class, idcmd);
		Article article = em.find(Article.class, idart);
		commande.getArticles().add(article);
		
		
	}

	@Override
	public List<String> getAllarticleNamesByCategorie(int idcat) {
		Categorie categorie = em.find(Categorie.class, idcat);
		List<String> names = new ArrayList<>();
		for(Article art: categorie.getArticles())
		{
			names.add(art.getNom());
		}
		return names;
	}

	@Override
	public List<String> getAllCategoiesNames() {
		List<Categorie> categories = em.createQuery("select c from Categorie c ",Categorie.class).getResultList();
		List<String> names = new ArrayList<>();
		for(Categorie c: categories)
		{
			names.add(c.getNomcat());
		}
		return names;
	}

	@Override
	public List<String> getAllArticleNamesGreaterThanTwoHundred() {
		
		List<Article> articles = em.createQuery("select c from Article c where c.prix > 200",Article.class)
				.getResultList();
		List<String> names = new ArrayList<>();
		for(Article c: articles)
		{
			names.add(c.getNom());
		}
		return names;
	}

	@Override
	public List<Categorie> getAllCategories() {
		// TODO Auto-generated method stub
		return em.createQuery("select c from Categorie c ", Categorie.class).getResultList();
	}

	@Override
	public int getArticleId(String nom) {
		int id = em.createQuery("select c.idart from Article c where c.nom = :nom")
				.setParameter("nom", nom).getFirstResult();
		return id;
	}

}
