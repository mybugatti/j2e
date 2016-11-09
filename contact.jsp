  <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        
<title>Contact</title>
 
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
 	 	
 	 	<p id="contact">
  		 Ce site web a été développé par Liang Zhao et Ngoma Heredia dans le cadre du projet en java EE - 
  		 
  		 <a href="mailto:ngoma.heredia@gmail.com">Nous contacter</a>
  		 
         <p>
 
	</div>
	
	</div>
	 
<c:import url="/footer.jsp"></c:import>  