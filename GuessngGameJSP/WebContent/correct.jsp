<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Guessing Game - JSP Version</title>
	<link rel="stylesheet" type="text/css" href="stylesheet.css" />
</head>
<body>
	<div id=container>
		<H1>Guessing Game - JSP Version</h1>
		<p>${msg.correctMessage}</p>
		<p>${lastGameGuesses <= averages[maximum-minimum].average ? "Your score was better than average":"Your score was above average" }
		<p><a href=guess.jsp>Play Again</a></p>
		<hr />
		<h2>Game Details</h2>
		<p>No. of guesses: ${lastGameGuesses}</p>
		<p>Range : ${maximum-minimum }</p>
		<p>Average: ${ averages[maximum-minimum].average }</p>
		<p>Total guesses: ${ averages[maximum-minimum].numberOfTotalGuesses }</p>
		<p>Map size: ${ averages.size() }</p>
	</div>
</body>
</html>