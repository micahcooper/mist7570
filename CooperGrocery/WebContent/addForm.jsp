<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<link rel="stylesheet" type="text/css" href="stylesheet.css" />
<title>Cooper Grocery - Add a Product</title>
</head>
<body>

<div id=wrapper>
	<h1>Cooper Grocery - Add a Product</h1>
	
	<div id=menu>
		<p>
		  <a class=button href="read">Products Database</a>
		  <a class=button href="add">Add a Product</a>
		  <a class=button href="search">Search Products</a>
		  <a class=button href="read">Stub Button</a>
		</p>
	</div>
	
	<div id=content>
		<form name=addForm action=addProduct method=post >
			<label>Product SKU:</label>
			<input type=text name=sku value="" />
			<br />
			<label>Product Type:</label>
			<input type=text name=productType value="" />
			<br />
			<label>Product Flavor:</label>
			<input type=text name=flavor value="" />
			<br />
			<label>Product Cost:</label>
			<input type=text name=cost value="" />
			<br />
			<label>Product Price:</label>
			<input type=text name=price value="" />
			<br />
			<label>Quantity:</label>
			<input type=text name=quantity value="" />
			<br />
			<input type=submit name=submit value="Add Product" />
		</form>
	</div>
	
	<div id=footer>
		<p>This is the footer.</p>
	</div>
</div>
</body>
</html>