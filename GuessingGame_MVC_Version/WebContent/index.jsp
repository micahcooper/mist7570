<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
	<title>Guessing Game - MVC Version</title>
</head>
<body>
  <h1>Guessing Game - MVC Version</h1>
  
  <p>
     Welcome to our guessing game!
  </p>
  
  <p>
     Please guess a number between
  </p>
  
  <form name="guessForm" action="doGuess" method="get">
     <label>
        Guess 1: 
     </label>
     <input type="text" name="guess" /><br />
     <input type="submit" name="submit" value="Make Guess">
  </form>
</body>
</html>