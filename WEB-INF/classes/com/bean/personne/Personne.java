package com.bean.personne;
/**
 * Creation du Bean Personne Une personne qui s'inscrit sur le site de vote est
 * caractérisée par les informations suivantes:
 * <ul>
 * <li>Nom</li>
 * <li>Prenom</li>
 * <li>Date de Naissance</li>
 * <li>Mot de Passe</li>
 * <li>Ville</li>
 * </ul>
 * 
 * @author Liang Zhao et Heredia Ngoma
 */

public class Personne implements java.io.Serializable {

	/**
	 * Génération d'un identifiant unique
	 */

	private static final long serialVersionUID = 6278053124521736551L;

	/**
	 * Déclaration des variables
	 * 
	 * Le nom de la personne
	 */
	String nom;
	/**
	 * Son prénom
	 */
	String prenom;
	/**
	 * Sa date de naissance
	 */
	String date_naissance;
	/**
	 * Son mot de passe
	 */
	String password;
	/**
	 * Sa ville
	 */
	String ville;
	/**
	 * Date de l'inscription de la personne sur le site
	 */
	String date;

	/**
	 * 
	 * @return la date de la personne inscripte
	 */
	public String getDate() {
		return date;
	}

	/**
	 * Accès en écriture de la date
	 */
	public void setDate(String date) {
		this.date = date;
	}
	/**
	 * retourne le nom de la personne
	 * 
	 * @return nom
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * Met à jour le nom de la personne
	 * 
	 * @param nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	/**
	 * retourne le prenom de la personne
	 * 
	 * @return prenom
	 */
	public String getPrenom() {
		return prenom;
	}
	/**
	 * Met à jour le prenom
	 * 
	 * @param prenom
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	/**
	 * retourne la date de naissance
	 * 
	 * @return date de naissance de la personne
	 */
	public String getDate_naissance() {
		return date_naissance;
	}
	/**
	 * Met à jour la date de naissance
	 * 
	 * @param date_naissance
	 */
	public void setDate_naissance(String date_naissance) {
		this.date_naissance = date_naissance;
	}
	/**
	 * Retourne le mot de passe
	 * 
	 * @return le mot de passe
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * Met à jour le mot de passe de la personne
	 * 
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * Retourne la ville de la personne
	 * 
	 * @return la ville
	 */
	public String getVille() {
		return ville;
	}
	/**
	 * Met à jour la ville
	 * 
	 * @param ville
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}

}
