package com.bean.personne;

public class Personne_Vote implements java.io.Serializable {

	/**
	 * Classe Personne_vote repr�sent� par le candidat vot� par une personne
	 */
	private static final long serialVersionUID = 2291050940650177494L;
	String candidat;
	String votant;
	String date;

	/**
	 * On r�cupere la date � laquelle la personne a vot� sur le site
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
	 * R�cupere la personne qui vient de voter sur le site
	 * 
	 * @return votant
	 */
	public String getVotant() {
		return votant;
	}
	/**
	 * Acc�s en �criture
	 * 
	 * @param votant
	 */
	public void setVotant(String votant) {
		this.votant = votant;
	}
	/**
	 * 
	 * @return le candidat vot�
	 */
	public String getCandidat() {
		return candidat;
	}
	/**
	 * Acc�s en �criture
	 * 
	 * @param candidat
	 */
	public void setCandidat(String candidat) {
		this.candidat = candidat;
	}

}
