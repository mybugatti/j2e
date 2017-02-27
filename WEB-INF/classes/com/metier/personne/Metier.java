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
 * Création de l'object métier qui va s'occuper du traitement de nos données
 * 
 * @author Liang Zhao et Heredia Ngoma
 * 
 */
public class Metier {

	/**
	 * 
	 * On déclare nos variables
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
	// remplacer le pointillé par votre repertoire workspace d'Eclipse
	public static StreamResult FICHIER = new StreamResult(new File(
			".../Vote_Online/WebContent/bdd.xml"));

	/**
	 * 
	 * @param request
	 * @return l'objet personne créée
	 */
	public Personne inscriptionpersonne(HttpServletRequest request) {
		/*
		 * On créé l'objet métier , on passe la requete à notre objet qui
		 * ensuite va retourner l'objet créé.
		 */

		/*
		 * Récupération des données respectives comme déclarées dans notre
		 * formulaire (nom, prenom, date, password et ville)
		 */

		String nom = getValeurChamp(request, CHAMP_NON);
		String prenom = getValeurChamp(request, CHAMP_PRENOM);
		String date_naissance = getValeurChamp(request, CHAMP_DATE);
		String password = getValeurChamp(request, CHAMP_PASSWORD);
		String ville = getValeurChamp(request, CHAMP_VILLE);
		String date = getValeurChamp(request, CHAMP_DATE_INSCRIPTION);

		/*
		 * Récupération et conversion de la date en String selon le format
		 * choisi.
		 */
		DateTime dt = new DateTime();
		DateTimeFormatter formatter = DateTimeFormat.forPattern(FORMAT_DATE);
		date = dt.toString(formatter);

		Personne personnes = new Personne();
		/**
		 * Après avoir instancié la classe Personne, On fait appel aux setters
		 * afin de faire la mise à jour des données: "simple affectation"
		 */

		personnes.setNom(nom);
		personnes.setPrenom(prenom);
		personnes.setDate_naissance(date_naissance);
		personnes.setPassword(password);
		personnes.setVille(ville);
		personnes.setDate(date);
		/**
		 * Préparation de l'objet Save, Appel à la méthode pour faire ajouter
		 * des personnes à la liste
		 */
		SaveService save = new SaveService();
		save.ajouter(personnes);
		// Création du fichier xml
		this.CreerXml(FICHIER, request);

		return personnes;

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

	/**
	 * Methode permettant de générer un fichier au format xml, Retourne le
	 * fichier xml créé
	 * 
	 * @param url
	 *            du fichier et la requete du client
	 */

	public void CreerXml(StreamResult fichier, HttpServletRequest request) {

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
			// affiche la liste de toutes les personnes
			for (Personne user : new SaveService().getallPersonnes()) {
				final Element personne = document.createElement("personne");
				personne.setAttribute("type", "majeur");
				racine.appendChild(personne);

				/*
				 * Etape 6 : création des champs de la personne
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

				// Récuperation du nom et mot de passe

				String name = request.getParameter("nom");
				String mdp = request.getParameter("password");
				// ------------------------------------------------------
				final Element racines = document.getDocumentElement();
				final NodeList racineNoeuds = racines
						.getElementsByTagName("personne");
				final int nbRacineNoeuds = racineNoeuds.getLength();

				for (int i = 0; i < nbRacineNoeuds; i++) {
					if (racineNoeuds.item(i).getNodeType() == Node.ELEMENT_NODE) {
						// Déclaration des variables
						/*
						 * Récuperation du nombre d'élément du noeud de l'arbre
						 * du fichier
						 */
						final Element cmpt = (Element) racineNoeuds.item(i);
						// Récupération du nom et mot de passe de l'élément du
						// fichier
						final Element lenom = (Element) cmpt
								.getElementsByTagName("nom").item(0);
						final Element lepassword = (Element) cmpt
								.getElementsByTagName("mot_de_passe").item(0);
						/*
						 * Vérification si les données recueillies sont
						 * identiques à celles enregistrées dans le fichier xml
						 */
						if (name.equals(lenom.getTextContent())
								&& mdp.equals(lepassword.getTextContent())) {
							System.out.println("accès autorisé " + name + " = "
									+ lepassword.getTextContent());
							System.out.println("======FIN=========");
							// état de la connexion si on arrive à se connecter
							resultat = "succès";

							// initialisation du compteur à zéro
							i = nbRacineNoeuds;

						} else {

							System.out.println("accès réfusé " + name + "!="
									+ lepassword.getTextContent());
							System.out.println("=======FIN========");
							// état de la connexion si l'on parvient pas à se
							// connecter
							resultat = "échec";

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
	 * @return le résultat de l'état de la connexion (succès ou échec)
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