<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>

    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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