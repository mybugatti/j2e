<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        
<title>Accueil</title>
 
<c:import url="/header.jsp"></c:import>   

	<div id="corps">

		<a href="<c:out value="Deconnexion_Personne"/>" id="deconnexion">
		<img alt="déconnexion" src="images/deconnexion.png"/>
		</a> 
 
 	 <img alt="logo" src="images/Urne.jpg" id="logo_vote"/>
 	 
 	  <h1> Bienvenue <span class="session"><c:out value="${sessionScope.sessionUtilisateur}"></c:out></span>
 	 dans votre espace de vote </h1>
 	 
 	  <div id="menu">
 	 <p class="menu_vote"><a href="voter.jsp">Voter </a></p>
 	 <br>
 	 <p class="menu_vote"><a href="liste_candidat.jsp">Liste des candidats</a></p>
 	  <br>
 	 <p class="menu_vote"><a href="information_inscription.jsp">Liste des personnes inscrites sur le site</a></p>
 	   <br>
 	 <p class="menu_vote"><a href="information_vote.jsp">Liste des personnes ayant voté</a></p>
 	 	   <br>
 	 <p class="menu_vote"><a href="resultat.jsp">Résultat</a></p>
 	 
 	 </div>	
 	 <!-- balise à éviter -->
 	 <br> <br><br>  
 	 
 	 <div id="loi">
 	 <p>Ce site est sécurisé et les informations de vote sont cryptées pour garantir le secret de vote
 	  </p>
 	 <p><span style="color:red;">Important:</span> le vote est un acte personnel </p>
 	 </div>
	</div>
	 
<c:import url="/footer.jsp"></c:import>  