<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
</head>
<body>

<%
String name = request.getParameter("uname");

out.print("Welcome! " + name);
out.print("<br>Session has started ... " + name);

// Store in session
session.setAttribute("user", name);

out.print("<br>Your name has been stored in session object");

// Set session timeout = 60 seconds
session.setMaxInactiveInterval(60);

out.print("<br>Session will expire in 1 minute");
out.print("<br>Click below within 1 minute or wait to see expiry<br>");
%>

<a href="second.jsp">Display the value</a>

</body>
</html>