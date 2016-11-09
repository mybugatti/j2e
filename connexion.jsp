<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

    <title>Connexion</title>
    
<c:import url="header.jsp"></c:import>
	
 	<div id="corps">
 		
 		<div id="authentification">	
 		
 			<figure id="logo"><img alt="personne" src="images/user.gif"></figure>
 		
 			<form id="formID" class="formular" method="post" action="<c:url value="/Connexion_Personne" />">
 		
 				<label for="login"><span>Nom <span class="requis">*</span>  : </span>  <input class="validate[required] text-input" type="text" placeholder=" ex: Paul" name="nom" id="login" title="votre nom" /></label>
 		
 				<label for="password"><span> Mot de passe <span class="requis">*</span>  : </span> <input type="password" class="validate[required] text-input" placeholder=" Mot de passe" name="password" id="password" title="tapez votre mot de passe"></label>
 		<br><br> 
 		<br><br>
 				<p><input type="submit" name="envoyer" value="Connexion" id="connex"></p>
 		 
 		<br><br><br>
 	 
 
 			</form>
 		 
 		</div>
 		
	</div>
	
		<ul id="redir">
 				
 		    	<li> <a href="index.jsp" title="retour à la page d'accueil"> Accueil </a> </li>
 		    	<li> <a href="inscription.jsp" title="s'inscrire">Inscription</a></li> 
 		</ul>
	
<c:import url="footer.jsp"></c:import>    