package com.liste.personne;

import java.util.List;

import com.bean.personne.Personne;
/**
 * Interface
 * 
 * @author Liang Zhao et Heredia Ngoma
 * 
 */
public interface Liste_Personne {
	/**
	 * Methode avec personne en parametre, On ajoute une personne à la liste
	 * 
	 * @param personne
	 */

	void ajouter(Personne personne);

	/**
	 * methode permettant de renvoyer la liste de toutes les personnes
	 * 
	 * @return la liste de toutes les personnes
	 */
	List<Personne> getallPersonnes();
}
