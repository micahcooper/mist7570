<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Guessing Game - MVC Version</title>
	<link rel="stylesheet" type="text/css" href="stylesheet.css" />
	<jsp:useBean id="msg" scope="session" class="model.Message" />
</head>
<body>
	<div id=container>
		<H1>Guessing Game - Bean Version</h1>
		<p><jsp:getProperty name="msg" property="message" /></p>
		<p><a href=doGuess>Play Again</a></p>
	</div>
</body>
</html>