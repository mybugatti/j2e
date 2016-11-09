 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

    <title>Connexion</title>
    
<c:import url="header.jsp"></c:import>
	
 	<div id="corps">
 		
 		<div id="authentification">	
 		
 			<figure id="logo"><img alt="personne" src="images/user.gif"></figure>
 		
 			<form id="formID" class="formular" method="post" action="<c:url value="Authentificatino_Voter" />">
 		
 				<label for="login"><span>nom <span class="requis">*</span>  : </span>  <input class="validate[required] text-input" type="text" placeholder=" ex: Claudia" name="votant" id="login" title="votre nom" /></label>
 		
 		<br><br> 
 		<br><br>
 				<p><input type="submit" name="envoyer" value="Connexion" id="connex"></p>
 		
 		<br><br><br>
 		<p>${metier.resultat}</p>
 
 			</form>
 		 
 		</div>
 		
	</div>
	
		<ul id="redir">
 				
 		    	<li> <a href="index.jsp" title="retour à la page d'accueil"> Accueil </a> </li>
 		    	<li> <a href="inscription.jsp" title="s'inscrire">Inscription</a></li> 
 		</ul>
	
<c:import url="footer.jsp"></c:import>    