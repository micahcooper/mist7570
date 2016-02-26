<!DOCTYPE html>

<jsp:useBean id="guesses" scope="session" class="model.GameNumber" >
	<jsp:setProperty name="guesses" property="value" value="1" />
</jsp:useBean>
<jsp:useBean id="msg" scope="session" class="model.Message" />
<jsp:useBean id="target" scope="session" class="model.GameNumber" />

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
		 
		 <p><jsp:getProperty name="msg" property="guessMessage" /></p>
		 
		 <form name="guessForm" action="doGuess" method="post" onsubmit="return validateForm()">
			<label id="guessLabel">Guess <jsp:getProperty name="guesses" property="value" />:</label>
			<input type="text" name="guess" /><br />
			<input type="submit" name="submit" value="Make Guess">
		 </form>
		 
		 <p style=text-align:right;><em>For testing purposes only: <jsp:getProperty name="target" property="value" /></em></p>
	</div>
</body>
</html>