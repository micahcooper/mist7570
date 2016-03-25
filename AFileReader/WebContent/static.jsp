<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Static JSTL Examples</title>
</head>
<body>
<h2>Static JSTL Examples</h2>
<p>Go back to <a href="index.jsp">index</a> and start over.</p>
<h3>if example</h3>
<c:if test="${ param['read-file'] == null }">
	<p>The filename parameter is empty: <c:out value="true" /></p>
</c:if>
<c:if test="${ param['read-file'] != null }">
	<p>The filename parameter is empty: <c:out value="true" /></p>
</c:if>

<h3>a forEach  example</h3>
<c:forEach var="i" begin="1" end="5">
	<c:out value="${i}" />
</c:forEach>

<h3>a forTokens  example</h3>
<c:forTokens items="apples,oranges,banana" delims="," var="name">
   <c:out value="${name}"/><p>
</c:forTokens>

<h3>Miscellaneous Tags</h3>
<h4>formatNumber tag</h4>
<fmt:formatNumber value="1000000000.00000" maxFractionDigits="3"/>
<h4>toUpperCase function</h4>
<p><c:out value="${fn:toUpperCase('all good men') }"/></p>
</body>
</html>