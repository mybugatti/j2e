package com.servlet.personne;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.personne.Personne_Vote;
import com.metier.personne.Metier_Candidat;

/**
 * Servlet implementation class Inscription_Candidat
 */
@WebServlet(description = "Classe qui enregistre le candidat selectionn� par une personne", urlPatterns = {"/Inscription_Candidat"})
public class Inscription_Candidat extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String VUE_CONFIRMATION = "/confirmation.jsp";
	public static final String VUE = "/WEB-INF/accueil.jsp";
	public static final String DEJA = "/interdit.jsp";
	public static final String COOKIE_DERNIER_VOTANT = "_vote_by";
	public static final String COOKIE_ETAT_VOTE = "_etat_vote";
	public static final String COOKIE_DERNIERE_DATE = "_date_by";
	public static final String CHAMP_MEMOIRE = "votant";
	public static final String EXPRIME = "Exprime";
	public static final int COOKIE_MAX_AGE = 60 * 60 * 24 * 365; // l'exipiration
																	// du cookie
																	// sera dans
																	// 1 an

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher(VUE)
				.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		/* on instancie l'objet */
		Metier_Candidat can = new Metier_Candidat();

		/* Tentative de r�cup�ration du cookie depuis la requ�te du votant */
		String derniereConnexion = can.getCookieValue(request,
				COOKIE_DERNIER_VOTANT);

		/*
		 * Tentative de la r�cup�ration de la valeur du votant depuis sa requete
		 */

		String MEMOIRE = request.getParameter(CHAMP_MEMOIRE);

		/**
		 * Si la derni�re valeur du cookie stock� dans le navigateur du votant
		 * correspond � son nom, alors la personne a d�j� vot� sur notre site.
		 * Sinon c'est � dire si aucune valeur du cookie n'est identique � son
		 * nom, elle peut tout simplement voter sur notre site.
		 * 
		 * 
		 */

		if (MEMOIRE.equals(derniereConnexion)) {
			/*
			 * Dans le cas o� la personne a d�j� vot� sur le site, on lui
			 * affiche un message
			 */
			this.getServletContext().getRequestDispatcher(DEJA)
					.forward(request, response);

		} else {

			/*
			 * Pr�paration de l'objet
			 */

			Personne_Vote per = can.inscriptioncandidat(request);
			/* Cr�ation du cookie, et ajout � la r�ponse HTTP */
			can.setCookie(response, COOKIE_DERNIER_VOTANT, MEMOIRE,
					COOKIE_MAX_AGE);

			can.setCookie(response, COOKIE_DERNIERE_DATE, per.getDate(),
					COOKIE_MAX_AGE);

			can.setCookie(response, COOKIE_ETAT_VOTE, EXPRIME, COOKIE_MAX_AGE);

			request.setAttribute("Etat", EXPRIME);

			/*
			 * redirection apr�s avoir vot�
			 */
			this.getServletContext().getRequestDispatcher(VUE_CONFIRMATION)
					.forward(request, response);

		}

	}

}
