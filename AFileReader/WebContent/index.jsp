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
<title>A File Reader</title>
</head>
<body>
${ param.test }
<c:if test="request.getParameter('test') == null">
	<c:out value="true" />
</c:if>

<c:forEach var="i" begin="1" end="5">
	<c:out value="${i}" />
</c:forEach>

<c:forTokens items="Zara,nuha,roshy" delims="," var="name">
   <c:out value="${name}"/><p>
</c:forTokens>

<form name="guessForm" action="doRead" method="post" onsubmit="return validateForm()">
	<input type='text' name='test'>
	<input type="submit" name="reset" value="RESET">
</form>

</body>
</html>