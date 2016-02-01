<% 
/**TODO
1 - collect parameters form request
2 - create loan object
3 - create amortization object and pass it the loan object
4 - call the doAmortization method from amortization ojbect
**/ %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
 <%@ page import="calculator.Loan" %>
 <%@ page import="calculator.Amortization" %>

<%
	String error = null;
	Amortization amort = null;
	
	try{
		int loanAmount = Integer.parseInt( request.getParameter("loanAmount") );
		double loanRate = Double.parseDouble( request.getParameter("loanRate") );
		int loanTerm = Integer.parseInt( request.getParameter("loanTerm") );
		
		//create the loan object based on the based parameters from the html form on index.jsp
		Loan loan = new Loan(loanAmount,loanRate,loanTerm);
		//instantiate an Amortizaiton object and pass it the new Loan object
		amort = new Amortization(loan);
	}
	catch(Exception e){
		error = "<strong>Something went wrong, please go back and try again. No need to thank me for this informative error message.</strong>";
	}
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="stylesheet.css" />
<title>Loan Amortization Results</title>
</head>

<body>
<h1>Loan Amortization Results</h1>

<!-- call the Amortization object to build the html table -->
<% 
if(error != null)
	out.print(error);
else
	out.print(amort.doAmortization()); 
%>

</body>
</html>