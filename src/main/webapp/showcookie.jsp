<%@ page import="javax.servlet.http.*" %>
<!DOCTYPE html>
<html>
<head>
    <title>Active Cookies</title>
</head>
<body>

<h2>Active Cookie List</h2>

<%
Cookie[] cookies = request.getCookies();

if (cookies != null) {
    for (Cookie c : cookies) {
%>
        <p>
            Name: <%= c.getName() %> <br>
            Value: <%= c.getValue() %> <br>
            Max Age: <%= c.getMaxAge() %> <br>
            -------------------------
        </p>
<%
    }
} else {
%>
    <p>No cookies found</p>
<%
}
%>

<br>
<a href="index.jsp">Add Another Cookie</a>

</body>
</html>