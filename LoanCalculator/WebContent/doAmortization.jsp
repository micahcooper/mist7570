<% 
/**TODO
1 - collect parameters form request
2 - create loan object
3 - create amortization object and pass it the loan object
4 - call the doAmortization method from amortization ojbect
**/ %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ page import="calculator.Loan" %>
 <%@ page import="calculator.Amortization" %>

<% 

%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Loan Amortization Results</title>
</head>

<body>
<h1>Loan Amortization Results</h1>

<%= (new Amortization().doAmortization()) %>

</body>
</html>