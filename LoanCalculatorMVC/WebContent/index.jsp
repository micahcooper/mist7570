<!DOCTYPE html>
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
			<form id="fp-page" name="loanTable" action="doAmortization" method="post">
				<p><label>Loan Amount:</label>
				<input type="text" name="loanAmount" value="20000" /></p>
				
				<p><label>Loan Term (in years):</label>
				<input type="text" name="loanTerm" value="30" /></p>
				
				<p><label>Loan Rate:</label>
				<input type="text" name="loanRate" value="6" /></p>
				
				<input type="submit" />
			</form>
		</div>
	</div>
</body>
</html>