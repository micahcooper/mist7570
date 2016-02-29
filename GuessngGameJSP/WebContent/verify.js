function validateForm() {
	var guessField = document.forms["guessForm"]["guess"];
    var x = document.forms["guessForm"]["guess"].value;
    if (x == null || x == "" || isNaN(x)) {  
      	document.getElementById("guessLabel").childNodes[0].nodeValue = "Guess 1 (please enter a number):";
    	guessField.style.border = "1px red solid";
    	
        return false;
    }
}