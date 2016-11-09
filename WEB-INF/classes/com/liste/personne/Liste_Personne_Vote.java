package com.liste.personne;

import java.util.List;

import com.bean.personne.Personne_Vote;

public interface Liste_Personne_Vote {
	/**
	 * On ajoute un candidat à la liste
	 * 
	 * @param per
	 */
	void ajouter_candidat(Personne_Vote candidat);
	/**
	 * 
	 * @return la liste de tous les candidats
	 */

	List<Personne_Vote> getallPersonne_Votes();

}
