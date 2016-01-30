<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Loan Amortization Calculator</title>
<link rel="stylesheet" type="text/css" href="stylesheet.css" />
</head>

<body>
	<h1>Loan Amortization Calculator</h1>
	
	<form name="loanTable" action="doAmortization.jsp" method="post">
		<label>Loan Amount:</label>
		<input type="text" name="loanAmount" value="0" />
		<br />
		<label>Loan Term:</label>
		<input type="text" name="loanTerm" value="0" />
		<br />
		<label>Loan Rate:</label>
		<input type="text" name="loanRate" value="0" />
		
		<input type="submit" />
	</form>
	
</body>
</html>