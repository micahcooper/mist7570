<!DOCTYPE html>

<jsp:useBean id="guesses" scope="session" class="model.GameNumber" >
	<jsp:setProperty name="guesses" property="value" value="1" />
</jsp:useBean>
<jsp:useBean id="max" scope="session" class="java.lang.Integer" />

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
	<script src="verify.js"></script>
	<link rel="stylesheet" type="text/css" href="stylesheet.css" />
	<title>Guessing Game - MVC Version</title>
</head>
<body>
	<div id=container>
		 <h1>Guessing Game - MVC Version</h1>
		 
		 <p>${msg}</p>
		 
		 <form name="guessForm" action="doGuess" method="post" onsubmit="return validateForm()">
			<label id="guessLabel">Guess <jsp:getProperty name="guesses" property="value" />:</label>
			<input type="text" name="guess" /><br />
			<input type="submit" name="submit" value="Make Guess">
		 </form>
		 
		 <p style=text-align:right;><em>For testing purposes only: ${target.getValue()}</em></p>
	</div>
</body>
</html>