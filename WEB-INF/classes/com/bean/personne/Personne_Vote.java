package com.bean.personne;

public class Personne_Vote implements java.io.Serializable {

	/**
	 * Classe Personne_vote représenté par le candidat voté par une personne
	 */
	private static final long serialVersionUID = 2291050940650177494L;
	String candidat;
	String votant;
	String date;

	/**
	 * On récupere la date à laquelle la personne a voté sur le site
	 * 
	 * @return date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * 
	 * @param date
	 */
	public void setDate(String date) {
		this.date = date;
	}
	/**
	 * Récupere la personne qui vient de voter sur le site
	 * 
	 * @return votant
	 */
	public String getVotant() {
		return votant;
	}
	/**
	 * Accès en écriture
	 * 
	 * @param votant
	 */
	public void setVotant(String votant) {
		this.votant = votant;
	}
	/**
	 * 
	 * @return le candidat voté
	 */
	public String getCandidat() {
		return candidat;
	}
	/**
	 * Accès en écriture
	 * 
	 * @param candidat
	 */
	public void setCandidat(String candidat) {
		this.candidat = candidat;
	}

}
