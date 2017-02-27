package com.metier.personne;

import java.io.File;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.w3c.dom.Comment;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.bean.personne.Personne_Vote;
import com.webservice.personne.SaveService;

/**
 * Création de l'object métier qui va s'occuper du traitement de nos données
 * 
 * @author Liang Zhao et Heredia Ngoma
 * 
 */
public class Metier_Candidat {

	/**
	 * 
	 * On déclare nos variables
	 */

	private static final String CHAMP_CANDIDAT = "candidat";
	private static final String CHAMP_VOTANT = "votant";
	private static final String CHAMP_DATE = "date";
	private static final String FORMAT_DATE = "dd/MM/yyyy HH:mm:ss";

	// la variable FICHIER avec chemin absolu du fichier xml
	// remplacer le pointillé par votre repertoire workspace d'Eclipse
	public StreamResult FICHIER = new StreamResult(new File(
			".../Vote_Online/WebContent/liste_votant.xml"));

	public Personne_Vote inscriptioncandidat(HttpServletRequest request) {

		/**
		 * Récupération de la requete envoyée par l'utilisateur
		 */

		String candidat = getValeurChamp(request, CHAMP_CANDIDAT);
		String votant = getValeurChamp(request, CHAMP_VOTANT);
		String date = getValeurChamp(request, CHAMP_DATE);

		/*
		 * Récupération et conversion de la date en String selon le format
		 * choisi.
		 */
		DateTime dt = new DateTime();
		DateTimeFormatter formatter = DateTimeFormat.forPattern(FORMAT_DATE);
		date = dt.toString(formatter);

		Personne_Vote vote = new Personne_Vote();
		vote.setCandidat(candidat);
		vote.setVotant(votant);
		vote.setDate(date);

		/**
		 * Préparation de l'objet Save, Appel à la méthode pour faire ajouter
		 * des personnes à la liste
		 */
		SaveService save = new SaveService();
		save.ajouter_candidat(vote);

		// Création du fichier xml
		this.CreerFichier(FICHIER);

		return vote;

	}

	/**
	 * Méthode utilitaire qui a pour but de retourner les données des champs
	 * sinon rien. Elle est déclaré private car elle ne sera accessible qu'à
	 * l'intérieur de cette classe "Metier"
	 * 
	 * @param request
	 * @param champNon
	 * @return
	 */
	private String getValeurChamp(HttpServletRequest request, String champNon) {
		// TODO Auto-generated method stub
		/*
		 * On récupere la requête de l'utilisateur en fonction de ses données
		 * saisies puis on les traite.
		 */
		String valeur = request.getParameter(champNon);
		if (valeur == null || valeur.trim().length() == 0) {
			return null;
		} else {
			return valeur;
		}

	}

	public void CreerFichier(StreamResult fichier) {

		try {
			/*
			 * Etape 1 : récupération d'une instance de la classe
			 * "DocumentBuilderFactory"
			 */

			final DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();

			/*
			 * Etape 2 : création d'un parseur
			 */
			final DocumentBuilder builder = factory.newDocumentBuilder();

			/*
			 * Etape 3 : création d'un Document
			 */
			final Document document = builder.newDocument();

			/*
			 * Etape 4 : création de l'Element racine
			 */
			final Element racine = document.createElement("systeme");
			document.appendChild(racine);

			/*
			 * Etape 5 : création d'une personne
			 */
			final Comment commentaire = document
					.createComment(" LIANG ZHAO ET HEREDIA NGOMA Tout Droit Réservé @2014");
			racine.appendChild(commentaire);

			// une boucle permettant de parcourir tout le fichier
			// affiche la liste de toutes les personnes qui ont voté
			for (Personne_Vote candidat : new SaveService()
					.getallPersonne_Votes()) {
				final Element personne = document.createElement("personne");
				personne.setAttribute("type", "vote");
				racine.appendChild(personne);

				/*
				 * Etape 6 : création des champs de la personne
				 */
				final Element date = document.createElement("date");
				date.appendChild(document.createTextNode(candidat.getDate()));

				final Element vote = document.createElement("candidat");
				vote.appendChild(document.createTextNode(candidat.getCandidat()));

				final Element votant = document.createElement("votant");
				votant.appendChild(document.createTextNode(candidat.getVotant()));

				personne.appendChild(vote);
				personne.appendChild(date);
				personne.appendChild(votant);

				/*
				 * Etape 8 : affichage
				 */
				final TransformerFactory transformerFactory = TransformerFactory
						.newInstance();
				final Transformer transformer = transformerFactory
						.newTransformer();
				final DOMSource source = new DOMSource(document);

				// prologue
				transformer.setOutputProperty(OutputKeys.VERSION, "1.0");
				transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
				transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");

				// formatage
				transformer.setOutputProperty(OutputKeys.INDENT, "yes");
				transformer.setOutputProperty(
						"{http://xml.apache.org/xslt}indent-amount", "2");

				// sortie
				transformer.transform(source, fichier);
			} // fin boucle
		} catch (final ParserConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
	}

	/*
	 * Méthode utilitaire gérant la création d'un cookie et son ajout à la
	 * réponse HTTP.
	 */
	public void setCookie(HttpServletResponse response, String nom,
			String valeur, int maxAge) {
		Cookie cookie = new Cookie(nom, valeur);
		cookie.setMaxAge(maxAge);
		response.addCookie(cookie);
	}
	/**
	 * Méthode utilitaire gérant la récupération de la valeur d'un cookie donné
	 * depuis la requête HTTP.
	 */
	public String getCookieValue(HttpServletRequest request, String nom) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie != null && nom.equals(cookie.getName())) {
					return cookie.getValue();
				}

			}

		}
		return null;

	}

}
