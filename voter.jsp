 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        
<title>Vote</title>
 
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
 
 	 
 		<p>Veuillez voter pour votre candidat</p>
 		<ol>
 		<li>Cliquez sur la photo de votre candidat</li>
 		<li>Valider votre vote en cliquant sur le bouton "Je vote"</li>
 		</ol>
 	 
 		 
 		<form method="POST" action="<c:url value="Inscription_Candidat" />">
 		
 		  <ul>
 	 <li class="cadres"> <label for="candidat1"><img alt="candidat1" src="images/candidat1.jpg"  class="liste_candidat" />
  	 BERNADETTE POIZON </label><input type="radio" value="BERNADETTE POIZON" name="candidat" id="candidat1"/> 
 		 
 	 </li>
 		
 	  <li class="cadres"><label for="candidat2"><img alt="candidat2" src="images/candidat2.jpg"  class="liste_candidat" />
  	  KERY ANGE </label><input type="radio" value="KERY ANGE" name="candidat" id="candidat2"/> 
 		 
 	  </li> 
 		
 	  <li class="cadres"> <label for="candidat3"> <img alt="candidat3" src="images/candidat3.jpg"  class="liste_candidat" />
 	  		PATRICK NICOLAS </label><input type="radio" value="PATRICK NICOLAS" name="candidat" id="candidat3"/>
 		 
 	  </li>
 		
      <li class="cadres"><label for="candidat4"><img alt="candidat4" src="images/candidat4.jpg"  class="liste_candidat" />
  		  JOANNE MARIE </label><input type="radio" value="JOANNE MARIE" name="candidat" id="candidat4"/>
      </li>
      
      <li class="cadres"> <label for="candidat0"><img alt="candidat0" src="images/candidat0.jpg"  class="liste_candidat" /> 
      
      VOTE BLANC </label><input type="radio" value="VOTE BLANC" name="candidat" id="candidat0" checked="checked"/>
 		 
 	</li>
       </ul>
       
 	 <input type="hidden" name="date" size="30" maxlength="30"/>
 		 <input type="hidden" value="<c:out value="${sessionScope.sessionUtilisateur}"></c:out>" name="votant"/>  
  
 	   <input type="submit" value="Je vote" id="connex" onclick="return confirm('Acceptez-vous de voter ?');"/>
 		</form>
 			
 	 </div>	
 	 	<a href="<c:out value="Inscription_Candidat"/>" class="menu_accueil">
 	 	<img alt="accueil" src="images/home.png" class="menu_accueil"/>
 	 	</a>
 	 
 	 <!-- balise à éviter -->
 	 <br> <br><br> <br><br> <br>
 	 
 	 <div id="loi">
 	 <p>Ce site est sécurisé et les informations de vote sont cryptées pour garantir le secret de vote
 	  </p>
 	 <p><span style="color:red;">Important:</span> le vote est un acte personnel </p>
 	 </div>
	</div>
	 
<c:import url="/footer.jsp"></c:import>  