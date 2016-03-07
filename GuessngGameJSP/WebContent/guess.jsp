<!DOCTYPE html>

<jsp:useBean id="guesses" scope="session" class="model.GameNumber" >
	<jsp:setProperty name="guesses" property="value" value="1" />
</jsp:useBean>
<jsp:useBean id="msg" scope="session" class="model.GameMessage" />
<jsp:useBean id="target" scope="session" class="model.GameNumber" />

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
	<script src="verify.js"></script>
	<link rel="stylesheet" type="text/css" href="stylesheet.css" />
	<title>Guessing Game - JSP Version</title>
</head>
<body>
	<div id=container>
		 <h1>Guessing Game<br />JSP EL Version</h1>
		 <p style=float:right;><a href="createGame.jsp">Change game parameters</a></p>
		 <p>Make a guess between ${minimum} and ${maximum}.</p>
		 <p><jsp:getProperty name="msg" property="message" /></p>
		 
		 <form name="guessForm" action="doGuess" method="post" onsubmit="return validateForm()">
			<label id="guessLabel">Guess ${guesses.value}:</label>
			<input type="text" name="guess" value=1 /><br />
			<input type="submit" name="submit" value="Make Guess">
		 </form>
		 
		 <p style=text-align:right;><em>For testing purposes only: <jsp:getProperty name="target" property="value" /></em></p>
	</div>
</body>
</html>