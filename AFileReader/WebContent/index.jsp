<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>A File Reader App</title>
</head>
<body>
<h2>JSTL Examples</h2>

<ol>
	<li><a href="static.jsp">Static JSTL Examples</a></li>
	<li><a href="#filereader">A File Reader with JSTL</a> (see below)</li>
</ol>

<a name="filereader"></a>
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