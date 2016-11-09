  <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        
<title>Refus du vote</title>
 
<c:import url="/header.jsp"></c:import>   

	<div id="corps">

		<a href="<c:out value="Deconnexion_Personne"/>" id="deconnexion">
		<img alt="déconnexion" src="images/deconnexion.png"/>
		</a> 

 	 <img alt="logo" src="images/Urne.jpg" id="logo_vote"/>
 	 <span class="session"><c:out value="${sessionScope.sessionUtilisateur}"></c:out> </span>
 
 	 
 	  <div id="menu">
   
 	 	
 	 	<p id="deja_voter">
  		Désolé <c:out value="${sessionScope.sessionUtilisateur}"></c:out>,  vous avez deja voté !
       <p>
        <img alt="" src="images/desole.png" id="desoler"/> 
 
	</div>
	
	</div>
<script>
window.setTimeout("location=('Inscription_Candidat');",4000);
</script>

<c:import url="/footer.jsp"></c:import>
