  <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        
<title>Confirmation</title>
 
<c:import url="/header.jsp"></c:import>   

	<div id="corps">

		<a href="<c:out value="Deconnexion_Personne"/>" id="deconnexion">
		<img alt="déconnexion" src="images/deconnexion.png"/>
		</a> 

 	 <img alt="logo" src="images/Urne.jpg" id="logo_vote"/>
 	 <span class="session"><c:out value="${sessionScope.sessionUtilisateur}"></c:out> </span>
 
 	 
 	  <div id="menu">
    

 	 	
 	 	<p id="confirmer_voter">
  		Merci d'avoir voté sur notre site, vous serez redirigé automatiquement vers la page d'accueil.
       <p>
       
	</div>
	
	</div>
<script>
window.setTimeout("location=('Inscription_Candidat');",3700);
</script>

<c:import url="/footer.jsp"></c:import>
