<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
  String msg = (String) request.getAttribute("msg");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Guessing Game - MVC Version</title>
</head>
<body>
<H1>Guessing Game - MVC Version</h1>

<%= msg %>

<p>
<a href=index.jsp>
  Play Again
</a>
</p>
</body>
</html>