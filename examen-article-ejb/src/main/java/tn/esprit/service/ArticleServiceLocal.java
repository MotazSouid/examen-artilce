package tn.esprit.service;

import javax.ejb.Local;

import tn.esprit.entities.Categorie;

@Local
public interface ArticleServiceLocal {

	public void ajouterCategorie(Categorie cat);
}
