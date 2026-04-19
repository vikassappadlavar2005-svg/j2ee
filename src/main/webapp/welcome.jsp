<%@ page language="java" contentType="text/html; charset=ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
<title>Welcome</title>
</head>
<body>

<%
String name = request.getParameter("uname");

// Store name in session
session.setAttribute("user", name);

// Set session expiry = 60 seconds
session.setMaxInactiveInterval(60);
%>

<h2>Hello <%= name %>!</h2>

<p>Session has started.</p>
<p>Your name is stored in session.</p>
<p>Session will expire in <b>1 minute</b>.</p>

<a href="check.jsp">Check Session</a>

</body>
</html>