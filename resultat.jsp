 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x" %>
 
        
<title>Résultat</title>
 
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
 	  
 
<c:import url="/liste_votant.xml" var="personnes" />

<table class="gradienttable">
    <caption> <x:parse xml="${personnes}" var="listepersonnes"  />
 <p>Résultat:</p>
   </caption>      
          <thead> <!-- En-tête du tableau -->
          <tr>
            <th scope="col"><p>Candidat</p></th>
            <th scope="col"><p>Nombre des voix</p></th>
          </tr>
          </thead>
          
            <tfoot> <!-- Pied de tableau -->
       
          <tr>
           <th scope="col"><p> </p></th>
            <th scope="col"><p> </p></th>
          </tr>
       
   			</tfoot>
          
     
            <tbody> <!-- Corps du premier candidat -->
           <tr>
           
             <td><p> 
            <!--   
            <x:if  select="$listepersonnes/systeme/personne[candidat='BERNADETTE POIZON']">
			<x:out select="$listepersonnes/systeme/personne[candidat='BERNADETTE POIZON']/candidat" /> 	
			</x:if>   --> 
			
								<x:choose>
 		<x:when select="$listepersonnes/systeme/personne[candidat='BERNADETTE POIZON']">
 		<x:out select="$listepersonnes/systeme/personne[candidat='BERNADETTE POIZON']/candidat" /> 	
   		</x:when>
  		<x:otherwise>
  		  BERNADETTE POIZON
 		 </x:otherwise>
		</x:choose>

             </p></td>
              
              <td><p>
               <x:out select="count($listepersonnes/systeme/personne[candidat='BERNADETTE POIZON'])" />
		
               </p></td>
           
           </tr>
           </tbody>  <!-- Fin du Corps du premier candidat -->
           
            <tbody> <!-- Corps du 2eme candidat -->
           <tr>
           
             <td><p> 
         <!--  
       	<x:if  select="$listepersonnes/systeme/personne[candidat='JOANNE MARIE']">
 		<x:out select="$listepersonnes/systeme/personne[candidat='JOANNE MARIE']/candidat" /> 
		</x:if>  
		-->
			
					<x:choose>
 		<x:when select="$listepersonnes/systeme/personne[candidat='JOANNE MARIE']">
 		<x:out select="$listepersonnes/systeme/personne[candidat='JOANNE MARIE']/candidat" /> 
   		</x:when>
  		<x:otherwise>
  		   JOANNE MARIE
 		 </x:otherwise>
		</x:choose>

             </p></td>
              
              <td><p>
 		 <x:out select="count($listepersonnes/systeme/personne[candidat='JOANNE MARIE'])" />
			
               </p></td>
           
           </tr>
           </tbody>  <!-- Fin du Corps du 2eme candidat -->
           
           
            <tbody> <!-- Corps du 3eme candidat -->
           <tr>
           
             <td><p> 
            <!--    
  		 	<x:if  select="$listepersonnes/systeme/personne[candidat='PATRICK NICOLAS']">
 			<x:out select="$listepersonnes/systeme/personne[candidat='PATRICK NICOLAS']/candidat" /> 
  
			</x:if> -->
			
		<x:choose>
 		<x:when select="$listepersonnes/systeme/personne[candidat='PATRICK NICOLAS']">
 		<x:out select="$listepersonnes/systeme/personne[candidat='PATRICK NICOLAS']/candidat" /> 
   		</x:when>
  		<x:otherwise>
  		    PATRICK NICOLAS
 		 </x:otherwise>
		</x:choose>

             </p></td>
              
              <td><p>
 	   		 <x:out select="count($listepersonnes/systeme/personne[candidat='PATRICK NICOLAS'])" />
	 
               </p></td>
           
           </tr>
           </tbody>  <!-- Fin du Corps du 3eme candidat -->
           
           
            <tbody> <!-- Corps du 4eme candidat -->
           <tr>
           
             <td><p> 
    <!--            
  	<x:if  select="$listepersonnes/systeme/personne[candidat='KERY ANGE']">
	 <x:out select="$listepersonnes/systeme/personne[candidat='KERY ANGE']/candidat" /> 
	</x:if> -->

		<x:choose>
 		 <x:when select="$listepersonnes/systeme/personne[candidat='KERY ANGE']">
 		<x:out select="$listepersonnes/systeme/personne[candidat='KERY ANGE']/candidat" /> 
   		</x:when>
  		<x:otherwise>
  		    KERY ANGE
 		 </x:otherwise>
		</x:choose>

             </p></td>
              
              <td><p>
       <x:out select="count($listepersonnes/systeme/personne[candidat='KERY ANGE'])" />

               </p></td>
           
           </tr>
           </tbody>  <!-- Fin du Corps du 4eme candidat -->
           
           
                       <tbody> <!-- Corps du 5eme candidat -->
           <tr>
           
             <td><p> 
  <!--             
 <x:if  select="$listepersonnes/systeme/personne[candidat='VOTE BLANC']">
 <x:out select="$listepersonnes/systeme/personne[candidat='VOTE BLANC']/candidat" /> 
</x:if>  -->

		<x:choose>
 		<x:when select="$listepersonnes/systeme/personne[candidat='VOTE BLANC']">
 		<x:out select="$listepersonnes/systeme/personne[candidat='VOTE BLANC']/candidat" /> 
   		</x:when>
  		<x:otherwise>
  		    VOTE BLANC
 		 </x:otherwise>
		</x:choose>
             </p></td>
              
              <td><p>
       <x:out select="count($listepersonnes/systeme/personne[candidat='VOTE BLANC'])" />

               </p></td>
           
           </tr>
           </tbody>  <!-- Fin du Corps du 5eme candidat -->
           
   
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