<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Cooper Grocery - Update a Product</title>
</head>
<body>

<h1>Cooper Grocery - Update a Product</h1>

<form name=updateForm action=updateProduct method=post >

    <label>
      SKU:
   </label>
   <!--  Changed this field to disabled. Users should not be able to update the ID! -->
   <input type=text name=sku value="${product.sku}" readonly="readonly" />
   <br />

   <label>
      Product Type:
   </label>
   <input type=text name=productType value="${product.productType}" />
   <br />
   <label>
      Flavor:
   </label>
   <input type=text name=flavor value="${product.flavor}" />
   <br />
   
   <label>
      Cost:
   </label>
   <input type=text name=cost value="${product.cost}" />
   <br />
   
   <label>
      Price:
   </label>
   <input type=text name=price value="${product.price}" />
   <br />
   
   <label>
      Quantity:
   </label>
   <input type=text name=quantity value="${product.quantity}" />
   <br />
   
   <input type=submit name=submit value="Update the Product" />

</form>

</body>
</html>