<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
    
<%@ page import="model.GameNumber" %>

<%
  // get the inputs from the request parameters
  //GameNumber target = new GameNumber(Integer.parseInt(request.getParameter("target")));
  //int minimum = Integer.parseInt(request.getParameter("minimum"));
  //int maximum = Integer.parseInt(request.getParameter("maximum"));
  
  // get the inputs from the request attributes
  GameNumber guesses = (GameNumber) request.getAttribute("guesses");
  String msg = (String) request.getAttribute("msg");
  
  // output the form to the client
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
     <%= msg %>
  </p>
  
  <form name="guessForm" action="doGuess" method="get">
     <label>
        Guess <%= guesses.getValue() %>: 
     </label>
     <input type="text" name="guess" /><br />
     <input type="submit" name="submit" value="Make Guess">
  
  </form>
  

</body>
</html>