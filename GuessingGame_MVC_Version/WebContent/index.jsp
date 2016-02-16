<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
    
<%@ page import="model.GameNumber" %>

<%
   // initialize the numbers
   int minimum = 0;
   int maximum = 1000;
   
   GameNumber target = new GameNumber();
   target.setRandom(minimum, maximum);
   
   GameNumber guesses = new GameNumber(1);

%>
    
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
     Please guess a number between <%= minimum %> and <%= maximum %>.
  </p>
  
  <form name="guessForm" action="doGuess" method="get">
     <label>
        Guess 1: 
     </label>
     <input type="text" name="guess" /><br />
     <input type="submit" name="submit" value="Make Guess">
     
     <input type="hidden" name="target" value="<%= target.getValue() %>" />
     <input type="hidden" name="guesses" value="<%= guesses.getValue() %>" />
     <input type="hidden" name="minimum" value="<%= minimum %>" />
     <input type="hidden" name="maximum" value="<%= maximum %>" />
  
  </form>
  

</body>
</html>