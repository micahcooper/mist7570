<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Guessing Game - JSP Version</title>
</head>
<body>
	<div id=container>
		<H1>Setup the Game</h1>
		<form name="guessForm" action="doGuess" method="post" onsubmit="return validateForm()">
			<label id="minLabel">Minimum value:</label><input type="text" name="minimum" value=1 /><br />
			<label id="maxLabel">Maximum value:</label><input type="text" name="maximum" value=1000 /><br />
			<input type="submit" name="submit" value="Start the Game">
		 </form>
	</div>
</body>
</html>