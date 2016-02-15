<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="stylesheet.css" />
<title>Loan Amortization Results</title>
</head>

<body>
<div class=header style=''>&nbsp;</div>
<div id=container>
<h1>Loan Amortization Results</h1>
<form action='index.jsp' method='post'><input type='submit' value='Try Another!'/></form>
    	
  <!-- call the Amortization object to build the html table -->
  ${amort.doAmortization()} 	

    	
<form action='index.jsp' method='post'><input type='submit' value='Try Another!'/></form>
</div>
<div class=footer style=''>&nbsp;</div>
</body>
</html>