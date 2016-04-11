<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<link rel="stylesheet" type="text/css" href="stylesheet.css" />
<title>Cooper Grocery - Search</title>
</head>
<body>
<div id=wrapper>
	<h1><a href="index.jsp">Cooper Grocery - Search</a></h1>
	
	<div id=menu>
		<p>
		  <a class=button href="read">Products Database</a>
		  <a class=button href="add">Add a Product</a>
		  <a class=button href="search">Search Products</a>
		  <a class=button href="read">Stub Button</a>
		</p>
	</div>
	
	<div id=content>
		<form name=addForm action=search method=post >
			<label>Product SKU:</label>
			<input type=text name=sku value="" />
			<input type=submit name=submit value="Search" />
		</form>
		${table}
	</div>
	
	<div id=footer>
		<p>This is the footer.</p>
	</div>
</div>

</body>
</html>