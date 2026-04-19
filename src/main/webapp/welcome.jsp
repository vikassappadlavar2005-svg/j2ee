<%@ page language="java" contentType="text/html; charset=ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
<title>Welcome</title>
</head>
<body>

<%
String name = request.getParameter("uname");
int time = Integer.parseInt(request.getParameter("time"));

// Store values in session
session.setAttribute("user", name);

// Set session expiry time (user-defined)
session.setMaxInactiveInterval(time);
%>

<h2>Hello <%= name %>!</h2>

<p>Session started successfully.</p>
<p>Session expiry time: <b><%= time %> seconds</b></p>

<p>
Click the link below within the given time OR wait for expiry:
</p>

<a href="check.jsp">Check Session</a>

</body>
</html>