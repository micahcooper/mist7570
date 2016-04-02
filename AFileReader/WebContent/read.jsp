<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Details of your file</title>
</head>
<body>

<h1>Details of your file</h1>

<h3>Using forTokens read the returned contents of the file</h3>
<c:set var="i" scope="page" value="${1}"/>
<c:forTokens items="${ contents }" delims="," var="name">
   <p><c:out value="Value ${i}: ${name}"/><p>
   <c:set var="i" scope="page" value="${i+1}"/>
</c:forTokens>

<h3>Using if statement to check for the word 'World'</h3>
<c:forTokens items="${ contents }" delims="," var="name">
	<c:if test="${name == 'World'}">
		<c:set var="foundWord" value="true" />
   </c:if>
   
</c:forTokens>
<c:if test="${foundWord}">
	<p><c:out value="The word World is contained within the file."/></p>
</c:if>
<c:if test="${!foundWord}">
   		<p><c:out value="The word World was not found." /></p>
</c:if>
<h3>Miscellaneous Tags</h3>
<h4>fmt tags, toLowerCase</h4>
<p><c:out value="${fn:toLowerCase( contents ) }"/></p>

<h4>Download the file examples here:</h4>
<ol>
	<li><a href="file.txt">file.txt</a></li>
	<li><a href="file2.txt">file2.txt</a></li>
</ol>
<p>Go back to <a href="index.jsp">index</a> and start over.</p>
</body>
</html>