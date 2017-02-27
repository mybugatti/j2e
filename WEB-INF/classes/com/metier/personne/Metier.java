package com.metier.personne;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
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
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.bean.personne.Personne;
import com.webservice.personne.SaveService;

/**
 * 
 * Cr�ation de l'object m�tier qui va s'occuper du traitement de nos donn�es
 * 
 * @author Liang Zhao et Heredia Ngoma
 * 
 */
public class Metier {

	/**
	 * 
	 * On d�clare nos variables
	 */

	private static final String CHAMP_NON = "nom";
	private static final String CHAMP_PRENOM = "prenom";
	private static final String CHAMP_DATE = "date_naissance";
	private static final String CHAMP_PASSWORD = "password";
	private static final String CHAMP_VILLE = "ville";
	private static final String CHAMP_DATE_INSCRIPTION = "date";
	private static final String FORMAT_DATE = "dd/MM/yyyy HH:mm:ss";
	private String resultat;
	// la variable FICHIER avec chemin absolu du fichier xml
	// remplacer le pointill� par votre repertoire workspace d'Eclipse
	public static StreamResult FICHIER = new StreamResult(new File(
			".../Vote_Online/WebContent/bdd.xml"));

	/**
	 * 
	 * @param request
	 * @return l'objet personne cr��e
	 */
	public Personne inscriptionpersonne(HttpServletRequest request) {
		/*
		 * On cr�� l'objet m�tier , on passe la requete � notre objet qui
		 * ensuite va retourner l'objet cr��.
		 */

		/*
		 * R�cup�ration des donn�es respectives comme d�clar�es dans notre
		 * formulaire (nom, prenom, date, password et ville)
		 */

		String nom = getValeurChamp(request, CHAMP_NON);
		String prenom = getValeurChamp(request, CHAMP_PRENOM);
		String date_naissance = getValeurChamp(request, CHAMP_DATE);
		String password = getValeurChamp(request, CHAMP_PASSWORD);
		String ville = getValeurChamp(request, CHAMP_VILLE);
		String date = getValeurChamp(request, CHAMP_DATE_INSCRIPTION);

		/*
		 * R�cup�ration et conversion de la date en String selon le format
		 * choisi.
		 */
		DateTime dt = new DateTime();
		DateTimeFormatter formatter = DateTimeFormat.forPattern(FORMAT_DATE);
		date = dt.toString(formatter);

		Personne personnes = new Personne();
		/**
		 * Apr�s avoir instanci� la classe Personne, On fait appel aux setters
		 * afin de faire la mise � jour des donn�es: "simple affectation"
		 */

		personnes.setNom(nom);
		personnes.setPrenom(prenom);
		personnes.setDate_naissance(date_naissance);
		personnes.setPassword(password);
		personnes.setVille(ville);
		personnes.setDate(date);
		/**
		 * Pr�paration de l'objet Save, Appel � la m�thode pour faire ajouter
		 * des personnes � la liste
		 */
		SaveService save = new SaveService();
		save.ajouter(personnes);
		// Cr�ation du fichier xml
		this.CreerXml(FICHIER, request);

		return personnes;

	}
	/**
	 * M�thode utilitaire qui a pour but de retourner les donn�es des champs
	 * sinon rien. Elle est d�clar� private car elle ne sera accessible qu'�
	 * l'int�rieur de cette classe "Metier"
	 * 
	 * @param request
	 * @param champNon
	 * @return
	 */
	private String getValeurChamp(HttpServletRequest request, String champNon) {
		// TODO Auto-generated method stub
		/*
		 * On r�cupere la requ�te de l'utilisateur en fonction de ses donn�es
		 * saisies puis on les traite.
		 */
		String valeur = request.getParameter(champNon);
		if (valeur == null || valeur.trim().length() == 0) {
			return null;
		} else {
			return valeur;
		}

	}

	/**
	 * Methode permettant de g�n�rer un fichier au format xml, Retourne le
	 * fichier xml cr��
	 * 
	 * @param url
	 *            du fichier et la requete du client
	 */

	public void CreerXml(StreamResult fichier, HttpServletRequest request) {

		try {
			/*
			 * Etape 1 : r�cup�ration d'une instance de la classe
			 * "DocumentBuilderFactory"
			 */

			final DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();

			/*
			 * Etape 2 : cr�ation d'un parseur
			 */
			final DocumentBuilder builder = factory.newDocumentBuilder();

			/*
			 * Etape 3 : cr�ation d'un Document
			 */
			final Document document = builder.newDocument();

			/*
			 * Etape 4 : cr�ation de l'Element racine
			 */
			final Element racine = document.createElement("systeme");
			document.appendChild(racine);

			/*
			 * Etape 5 : cr�ation d'une personne
			 */
			final Comment commentaire = document
					.createComment(" LIANG ZHAO ET HEREDIA NGOMA Tout Droit R�serv� @2014");
			racine.appendChild(commentaire);

			// une boucle permettant de parcourir tout le fichier
			// affiche la liste de toutes les personnes
			for (Personne user : new SaveService().getallPersonnes()) {
				final Element personne = document.createElement("personne");
				personne.setAttribute("type", "majeur");
				racine.appendChild(personne);

				/*
				 * Etape 6 : cr�ation des champs de la personne
				 */
				final Element nom = document.createElement("nom");
				nom.appendChild(document.createTextNode(user.getNom()));

				final Element prenom = document.createElement("prenom");
				prenom.appendChild(document.createTextNode(user.getPrenom()));

				final Element date = document.createElement("date_naissance");
				date.appendChild(document.createTextNode(user
						.getDate_naissance()));

				final Element password = document.createElement("mot_de_passe");
				password.appendChild(document.createTextNode(user.getPassword()));

				final Element ville = document.createElement("ville");
				ville.appendChild(document.createTextNode(user.getVille()));

				final Element date_inscription = document
						.createElement("date_inscription");
				date_inscription.appendChild(document.createTextNode(user
						.getDate()));

				personne.appendChild(nom);
				personne.appendChild(prenom);
				personne.appendChild(date);
				personne.appendChild(password);
				personne.appendChild(ville);
				personne.appendChild(date_inscription);

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

				// ------------------- parcours du fichier xml
				// -------------------------
				// ----------------------------------------------------------------------

				// R�cuperation du nom et mot de passe

				String name = request.getParameter("nom");
				String mdp = request.getParameter("password");
				// ------------------------------------------------------
				final Element racines = document.getDocumentElement();
				final NodeList racineNoeuds = racines
						.getElementsByTagName("personne");
				final int nbRacineNoeuds = racineNoeuds.getLength();

				for (int i = 0; i < nbRacineNoeuds; i++) {
					if (racineNoeuds.item(i).getNodeType() == Node.ELEMENT_NODE) {
						// D�claration des variables
						/*
						 * R�cuperation du nombre d'�l�ment du noeud de l'arbre
						 * du fichier
						 */
						final Element cmpt = (Element) racineNoeuds.item(i);
						// R�cup�ration du nom et mot de passe de l'�l�ment du
						// fichier
						final Element lenom = (Element) cmpt
								.getElementsByTagName("nom").item(0);
						final Element lepassword = (Element) cmpt
								.getElementsByTagName("mot_de_passe").item(0);
						/*
						 * V�rification si les donn�es recueillies sont
						 * identiques � celles enregistr�es dans le fichier xml
						 */
						if (name.equals(lenom.getTextContent())
								&& mdp.equals(lepassword.getTextContent())) {
							System.out.println("acc�s autoris� " + name + " = "
									+ lepassword.getTextContent());
							System.out.println("======FIN=========");
							// �tat de la connexion si on arrive � se connecter
							resultat = "succ�s";

							// initialisation du compteur � z�ro
							i = nbRacineNoeuds;

						} else {

							System.out.println("acc�s r�fus� " + name + "!="
									+ lepassword.getTextContent());
							System.out.println("=======FIN========");
							// �tat de la connexion si l'on parvient pas � se
							// connecter
							resultat = "�chec";

						}
					}

				} // FIN parcours
					// FIN Test de connexion

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
	/**
	 * 
	 * @return le r�sultat de l'�tat de la connexion (succ�s ou �chec)
	 */
	public String getResultat() {
		return resultat;
	}
	/**
	 * 
	 * @return le fichier xml
	 */
	public StreamResult getFICHIER() {
		return FICHIER;
	}

}