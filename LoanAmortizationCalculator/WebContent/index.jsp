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
	<div id=container class=frontpage>
		<h1>Loan Amortization Calculator</h1>
		<div class=fp-form>
			<form name="loanTable" action="doAmortization" method="post">
				<p><label>Loan Amount:</label>
				<input type="text" name="loanAmount" value="195000" /></p>
				
				<p><label>Loan Term (in years):</label>
				<input type="text" name="loanTerm" value="30" /></p>
				
				<p><label>Loan Rate:</label>
				<input type="text" name="loanRate" value="4" /></p>
				
				<input type="submit" />
			</form>
		</div>
	</div>
</body>
</html>