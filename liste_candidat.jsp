  <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        
<title>candidat</title>
 
<c:import url="/header.jsp"></c:import>   

	<div id="corps">

		<a href="<c:out value="Deconnexion_Personne"/>" id="deconnexion">
		<img alt="déconnexion" src="images/deconnexion.png"/>
		</a> 

 	 <img alt="logo" src="images/Urne.jpg" id="logo_vote"/>
 	 <span class="session"><c:out value="${sessionScope.sessionUtilisateur}"></c:out> </span>
 
 	 
 	  <div id="menu">
    	 <a href="<c:out value="Inscription_Candidat"/>" class="menu_accueil">
 	 	<img alt="accueil" src="images/home.png" class="menu_accueil"/>
 	 	</a>
 	 	<br>
 	   <ul>
 	 <li class="cadre"><img alt="candidat1" src="images/candidat1.jpg"  class="liste_candidat" />
 	 À tout juste 40 ans, BERNADETTE POIZON présente comme la digne héritière de son père. Après treize années passées au poste d’adjointe à ses côtés, elle mène une liste socialiste d’union de la gauche, et entend bien conquérir la mairie du 9e. 
 	 </li>
 		
 	  <li class="cadre"><img alt="candidat2" src="images/candidat2.jpg"  class="liste_candidat" />
 	  A l'approche des élections municipales, KERY ANGE, tête de liste UMP, UDI et Modem, entend bien faire basculer le 9e arrondissement à droite. Déterminée, la candidate fait valoir son expérience du quartier.
 	  </li> 
 		
 	  <li class="cadre"><img alt="candidat3" src="images/candidat3.jpg"  class="liste_candidat" />
 	  À quelques mois des élections municipales, PATRICK NICOLAS représente le candidat d’Europe Écologie-Les Verts.
 	  </li>
 		
      <li class="cadre"><img alt="candidat4" src="images/candidat4.jpg"  class="liste_candidat" />
      JOANNE MARIE est tête de liste du Front national (FN) pour les municipales dans le 9e arrondissement de Paris. 30 ans de vie militante pour le «Front», et déjà 14 élections au compteur...
      </li>
       </ul>
       
 	 </div>	
 	  		   	 <a href="<c:out value="Inscription_Candidat"/>" class="menu_accueil">
 	 	<img alt="accueil" src="images/home.png" class="menu_accueil"/>
 	 	</a>
 		
 	 <!-- balise à éviter -->
 
 	 
 	 <div id="loi">
 	 <p>Ce site est sécurisé et les informations de vote sont cryptées pour garantir le secret de vote
 	  </p>
 	 <p><span style="color:red;">Important:</span> le vote est un acte personnel </p>
 	 </div>
	</div>
	 
<c:import url="/footer.jsp"></c:import>  