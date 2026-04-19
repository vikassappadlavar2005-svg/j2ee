<%@ page language="java" contentType="text/html; charset=ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
<title>Session Check</title>
</head>
<body>

<h2>Session Status</h2>

<%
String name = (String) session.getAttribute("user");

if (name == null) {
%>
    <p style="color:red;">Session expired!</p>
    <p>Please start a new session.</p>
<%
} else {
%>
    <p>Hello <%= name %>!</p>
    <p>Session is still active.</p>
<%
}
%>

<br>
<a href="index.html">Go Back</a>

</body>
</html>