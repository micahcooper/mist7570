<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!--
c:if>
c:out>
c:forEach>
c:forTokens>
c:import>
2 more core tags of your choice
4 fmt tags of your choice
3 fn tags of your choice
-->

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>A File Reader App</title>
</head>
<body>
<h2>JSTL Examples</h2>
<h3>if example</h3>
<c:if test="${ param['read-file'] == null }">
	<p>The filename parameter is empty: <c:out value="true" /></p>
</c:if>
<c:if test="${ param['read-file'] != null }">
	<p>The filename parameter is empty: <c:out value="true" /></p>
</c:if>

<h3>a forEach static example</h3>
<c:forEach var="i" begin="1" end="5">
	<c:out value="${i}" />
</c:forEach>

<h3>a forTokens static example</h3>
<c:forTokens items="apples,oranges,banana" delims="," var="name">
   <c:out value="${name}"/><p>
</c:forTokens>

<h2>The File Reader Portion</h2>
<p>Added an interaction with files.  You can input a file name but it needs to exist in the package first.  You can enter file2.txt as an alternate option, otherwise the app defaults to file.txt.</p>
<p>This should probably be an upload function instead.</p>
<form name="guessForm" action="read.do" method="post" onsubmit="return validateForm()">
	<label>File Name</label>
	<input type='text' name='filename' value='file.txt'>
	<input type="submit" name="read-file" value="Read File">
</form>

</body>
</html>