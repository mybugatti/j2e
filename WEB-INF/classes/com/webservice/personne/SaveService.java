package com.webservice.personne;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import com.bean.personne.Personne;
import com.bean.personne.Personne_Vote;
import com.liste.personne.Liste_Personne;
import com.liste.personne.Liste_Personne_Vote;
/**
 * La classe implemente trois interfaces (Liste_Personne,Serialisable et
 * Liste_Personne_Vote)
 * 
 * @author Liang Zhao et Heredia Ngoma
 * 
 */
@WebService
public class SaveService
		implements
			Liste_Personne,
			Serializable,
			Liste_Personne_Vote {

	private static final long serialVersionUID = 2673380353477551803L;
	/**
	 * 
	 * Déclaration de la collection "list" qui va contenir les personnes
	 */

	static private List<Personne> liste = new ArrayList<>();
	static private List<Personne_Vote> liste_votant = new ArrayList<>();

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.liste.personne.Liste_Personne#ajouter(com.bean.personne.Personne)
	 */
	@Override
	public void ajouter(Personne personne) {
		// TODO Auto-generated method stub
		// ajout d'une personne à la liste
		liste.add(personne);
	}
	/**
	 * 
	 * Retourne la liste de toutes les personnes
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.liste.personne.Liste_Personne#getallPersonnes()
	 */
	@Override
	public List<Personne> getallPersonnes() {
		// TODO Auto-generated method stub
		return liste;
	}

	/**
	 * Ajout d'un candidat à la liste
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.liste.personne.Liste_Personne_Vote#ajouter(com.bean.personne.
	 * Personne_Vote)
	 */
	@Override
	public void ajouter_candidat(Personne_Vote candidat) {
		// TODO Auto-generated method stub
		liste_votant.add(candidat);

	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.liste.personne.Liste_Personne_Vote#gePersonne_Votes()
	 */
	@Override
	public List<Personne_Vote> getallPersonne_Votes() {
		// TODO Auto-generated method stub
		return liste_votant;
	}

}
