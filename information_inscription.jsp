 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x" %>
 
        
<title>Informations</title>
 
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
 	  
 <c:import url="/bdd.xml" var="personnes"  />
 <table class="gradienttable">
    <caption> <x:parse xml="${personnes}" var="listepersonnes"  />
 <p>Nombre de Personnes inscrites sur le site : 
 <x:out select="count($listepersonnes/systeme/personne)" />
</p>
   </caption>      
          <thead> <!-- En-tête du tableau -->
          <tr>
            <th scope="col"><p>Nom</p></th>
            <th scope="col"><p>Prénom</p></th>
            <th scope="col"><p>Ville</p></th>
            <th scope="col"><p>Date d'inscription </p></th>
          </tr>
          </thead>
          
            <tfoot> <!-- Pied de tableau -->
       
          <tr>
           <th scope="col"><p>Nom</p></th>
            <th scope="col"><p>Prénom</p></th>
            <th scope="col"><p>Ville</p></th>
            <th scope="col"><p>Date d'inscription </p></th>
          </tr>
       
   			</tfoot>
          
       <x:forEach var="unepersonne" select="$listepersonnes/systeme/personne">
            <tbody> <!-- Corps du tableau -->
           <tr>
              <td><p><x:out select="$unepersonne/nom"/></p></td>
              <td><p><x:out select="$unepersonne/prenom"/></p></td>
              <td><p><x:out select="$unepersonne/ville"/></p></td>
              <td><p><x:out select="$unepersonne/date_inscription"/></p></td>
           </tr>
           </tbody>
            
        </x:forEach>      
 </table>         

 	 </div>	
 	 
	
 	 <!-- balise à éviter -->
 	 <br> <br><br> <br><br> <br>
 	 
 	 <div id="loi">
 	 <p>Ce site est sécurisé et les informations de vote sont cryptées pour garantir le secret de vote
 	  </p>
 	 <p><span style="color:red;">Important:</span> le vote est un acte personnel </p>
 	 </div>
	</div>
	 
<c:import url="/footer.jsp"></c:import>  