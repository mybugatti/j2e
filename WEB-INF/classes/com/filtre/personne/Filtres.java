package com.filtre.personne;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class Filtres
 */

@WebFilter(description = "Classe permettant de vérifier si une persone à accès à la ressource demandée. Sinon, elle n'y accède pas", urlPatterns = {
		"/Filtres", "/liste_candidat.jsp", "/voter.jsp",
		"/Inscription_Candidat", "/resultat.jsp",
		"/information_inscription.jsp", "/information_vote.jsp",
		"/interdit.jsp"})
public class Filtres implements Filter {
	public static final String ATT_SESSION_USER = "sessionUtilisateur";
	public static final String UTF = "UTF-8";
	/**
	 * Default constructor.
	 */
	public Filtres() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		/**
		 * Vérification de la session de la personne sur le site Si aucune
		 * session ne lui est associée alors, elle n'a pas droit d'accéder à
		 * l'espace de vote, elle ne pourra jamais voter.
		 */
		HttpServletRequest httprequest = (HttpServletRequest) request;
		/**
		 * Gestion des caractères accentués, les caractères spéciaux et
		 * alphabets non latins...
		 * 
		 * On précise l'encodage des données de nos requêtes
		 */
		httprequest.setCharacterEncoding(UTF);

		if (httprequest.getSession().getAttribute(ATT_SESSION_USER) == null) {

			// redirection vers la page index
			HttpServletResponse httpresponse = (HttpServletResponse) response;
			httpresponse.sendRedirect("index.jsp");
		} else

		{
			/**
			 * Si tout la session est définie alors, on accède à la ressource
			 */

			chain.doFilter(request, response);
		}
	}
	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
