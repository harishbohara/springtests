<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="false"%>
<html>
<body>
	<h1>Title : ${title}</h1>
	<h1>Message : ${message}</h1>
	<form action="<c:url value="/signin/facebook" />" method="POST">
		<button type="submit" name="submit"></button>
	</form>
</body>
</html>