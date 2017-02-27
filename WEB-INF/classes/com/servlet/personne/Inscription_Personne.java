package com.servlet.personne;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.personne.Personne;
import com.metier.personne.Metier;

/**
 * Servlet implementation class Inscription_Personne
 */
@WebServlet(description = "Servlet qui s'occupe de l'inscription d'une personne sur le site de vote en ligne", urlPatterns = {"/Inscription_Personne"})
public class Inscription_Personne extends HttpServlet {
	/**
	 * D�claration des variables
	 */
	private static final long serialVersionUID = 1L;
	public static final String ATT_USER = "personne";
	public static final String ATT_METIER = "metier";
	public static final String ATT_SESSION_USER = "sessionUtilisateur";
	public static final String COOKIE_1 = "_con87_";
	public static final String VUE = "/WEB-INF/accueil.jsp";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Inscription_Personne() {
		super();

	}
	/**
	 * Initialisation de la methode init lors du d�marrage du serveur TomCat
	 */

	public void init(ServletConfig config) throws ServletException {
		super.init(config);

		try {

			System.out.println("Initialisation de la servlet ====> 100%");

		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
	}
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
		// On pr�pare notre objet Metier

		Metier metier = new Metier();

		/*
		 * Appel au traitement et � la validation de la requ�te, et r�cup�ration
		 * du bean en r�sultant
		 */
		Personne personne = metier.inscriptionpersonne(request);

		/* Stockage du formulaire et du bean dans l'objet request */
		request.setAttribute(ATT_USER, personne);
		request.setAttribute(ATT_METIER, metier);

		/* Cr�ation de la session */
		/* R�cup�ration de la session depuis la requ�te */

		String session = request.getParameter("nom");
		request.getSession().setAttribute(ATT_SESSION_USER, session);

		// FIN DE CREATION

		/**
		 * Cr�ation de cookie
		 */

		Cookie etat_conn = new Cookie(COOKIE_1, metier.toString());
		response.addCookie(etat_conn);

		/*
		 * redirection � la page connexion si aucune erreur de validation n'a eu
		 * lieu
		 */
		this.getServletContext().getRequestDispatcher(VUE)
				.forward(request, response);

	}

}
