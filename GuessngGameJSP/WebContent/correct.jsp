<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Guessing Game - JSP Version</title>
	<link rel="stylesheet" type="text/css" href="stylesheet.css" />
	<jsp:useBean id="msg" scope="session" class="model.GameMessage" />
</head>
<body>
	<div id=container>
		<H1>Guessing Game - JSP Version</h1>
		<p>${msg.message}</p>
		<p><a href=guess.jsp>Play Again</a></p>
	</div>
</body>
</html>