<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Session Check</title>
</head>
<body>

<h2>Display the session value</h2>

<%
String name = (String) session.getAttribute("user");

if (name == null) {
    out.print("Sorry, the session has ended");
} else {
    out.print("Hello " + name);
}
%>

</body>
</html>