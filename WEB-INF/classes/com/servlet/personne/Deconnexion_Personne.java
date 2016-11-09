package com.servlet.personne;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Deconnexion_Personne
 */
@WebServlet(description = "Mise en place de la servlet permettant de faire la déconnexion sur le site de vote en ligne", urlPatterns = {"/Deconnexion_Personne"})
public class Deconnexion_Personne extends HttpServlet {
	/**
	 * Déclaration des variables
	 */
	private static final long serialVersionUID = 1L;
	public static final String URL_REDIRECTION = "/Vote_Online/index.jsp";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		/* Récupération et destruction de la session en cours */
		HttpSession session = request.getSession();
		session.invalidate();

		/* Redirection vers la page d'accueil du site ! */
		response.sendRedirect(URL_REDIRECTION);
	}

}
