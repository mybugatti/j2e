

(function($) {
	$.fn.validationEngineLanguage = function() {};
	$.validationEngineLanguage = {
		newLang: function() {
			$.validationEngineLanguage.allRules = {"required":{    
						"regex":"none",
						
						"alertText":"* Ce champs est requis svp",
						
						"alertTextCheckboxe":"* Cette case est obligatoire"},
						
					"length":{
						"regex":"none",
						"alertText":"* Entre ",
						"alertText2":" ou ",
						"alertText3":" caractères requis"},
						
					"minCheckbox":{
						"regex":"none",
						"alertText":"* Nombre max the boite exceder"},	
						
					"confirm":{
						"regex":"none",
						"alertText":"* Oups, votre mot de passe n'est pas identique !"},		
						
					"date":{
						"regex":"/^[0-9]{4}\-\[0-9]{1,2}\-\[0-9]{1,2}$/",
                         "alertText":"* Date invalide, format YYYY-MM-DD requis"},
                         
					"onlyNumber":{
						"regex":"/^[0-9\ ]+$/",
						"alertText":"* Chiffres seulement accepté"},
						
					"noSpecialCaracters":{
						"regex":"/^[0-9a-zA-Z]+$/",
						"alertText":"* Aucune caractère spécial accepté"},
						
					"onlyLetter":{
						"regex":"/^[a-zA-Z\ \']+$/",
						"alertText":"* Lettres seulement accepté"}
				}	
		}
	}
})(jQuery);

$(document).ready(function() {	
	$.validationEngineLanguage.newLang()
});