package com.servlet.personne;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.metier.personne.Metier;

/**
 * Servlet implementation class Connexion_Personne
 */
@WebServlet(description = "Servlet permettant d'�tablir la connexion d'une personne sur le site de vote en ligne", urlPatterns = {"/Connexion_Personne"})
public class Connexion_Personne extends HttpServlet {
	/**
	 * D�claration des variables
	 */
	private static final long serialVersionUID = 1L;

	public static final String ATT_METIER = "metier";
	public static final String ATT_SESSION_USER = "sessionUtilisateur";
	public static final String VUE_MEME = "/connexion.jsp";
	public static final String VUE = "/WEB-INF/accueil.jsp";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Connexion_Personne() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		Metier metier = new Metier();
		/*
		 * appel de la methode CreerXml avec en parametre le fichier xml et la
		 * requete
		 */

		metier.CreerXml(metier.getFICHIER(), request);

		if (metier.getResultat().equals("succ�s")) {

			/*
			 * redirection � la page connexion si aucune erreur de validation
			 * n'a eu lieu
			 */

			/* Stockage du formulaire et du bean dans l'objet request */

			/* Cr�ation de la session */
			/* R�cup�ration de la session depuis la requ�te */
			String session = request.getParameter("nom");
			request.getSession().setAttribute(ATT_SESSION_USER, session);
			this.getServletContext().getRequestDispatcher(VUE)
					.forward(request, response);

		} else {

			/*
			 * Sinon, r�-affichage du formulaire de connexion et Suppression de
			 * la session
			 */

			request.getSession().setAttribute(ATT_SESSION_USER, null);

			response.sendRedirect(request.getContextPath() + VUE_MEME);

		}
	}

}
