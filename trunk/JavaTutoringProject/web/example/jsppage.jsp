<%@ page contentType="text/html; charset=iso-8859-1" language="java" %>
<html>
<head></head>
<body>

q Parameter = <%=request.getParameter("q")%>

<br/>
<br/>

<form method="post" action="#">
	sometext = <input name="sometext" id="sometext" type="text" />
	<br/>
	<input type="Submit" value="Submit">
</form>

</body>
</html>
