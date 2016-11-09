<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
 <title>Inscription</title>   
 
<c:import url="header.jsp"></c:import>   
	
	<div id="corps">
	 
      <form id="formID" class="formular" method="post" action="<c:url value="/Inscription_Personne" />" >
       <div id="formulaire">	
       
				<label>
					<span>Nom <span class="requis">*</span> :</span>
					<input class="validate[required,custom[onlyLetter],length[0,100]] text-input" type="text" name="nom" id="nom" title="quel est votre nom ?" />
				</label>
				
				<label>
					<span>Prénom <span class="requis">*</span>  : </span>
					<input class="validate[required,custom[onlyLetter],length[0,100]] text-input" type="text" name="prenom" id="prenom" title="quel est votre prénom?"/>
				</label>
				
				<label>
					<span>Date de naissance <span class="requis">*</span> :(YYYY-MM-DD)</span>
					<input class="validate[required,custom[date]] text-input" type="date" name="date_naissance"  id="date" title="date de naissance"/>
				</label>
				
				<label>
					<span>Mot de passe <span class="requis">*</span>  : </span>
					<input class="validate[required,length[6,40]] text-input" type="password" name="password"  id="password" title="tapez votre mot de passe"/>
				</label>
				
				<label>
					<span>Confirmation Mot de passe <span class="requis">*</span>  : </span>
					<input class="validate[required,confirm[password]] text-input" type="password" name="password2"  id="password2" />
				</label>
				
				<label>
					<span>Ville <span class="requis">*</span>  :  </span>
					<input class="validate[required] text-input" type="text" name="ville" id="ville" placeholder="  indiquez votre ville" title="quelle est votre ville ?"/>
				</label> 
				<!-- champs caché pour la date d'inscription sur le site -->
				 <input type="hidden" name="date" size="30" maxlength="30"/>
					<br>
 					<br>
 					
				<p><input type="submit" name="valider" value="Valider" id="connex"></p>
			
				<p><br></p>
 				<br>
 				
 				<!--  
				<label>
					<span class="checkbox"> J'accepte les conditions : </span>
					<input class="validate[required] checkbox" type="checkbox"  id="condition"  name="condition"/>
				</label>
				-->
			     <p id="loi"> </p>  
			     
	    	</div>
	    	
	    			 
			<ul id="redir">
 				
 		    	<li> <a href="index.jsp" title="Retour à la page d'accueil"> Accueil </a> </li>
 		    	<li> <a href="connexion.jsp" title="se connecter">Connexion</a></li> 
 		    </ul>
 		
	   </form>
	</div>

<!-- autocomplete coordonnées  -->
    <script>
      $(function(){
        $("#ville").geocomplete();
      })  
    </script>	
    
<c:import url="footer.jsp"></c:import>  