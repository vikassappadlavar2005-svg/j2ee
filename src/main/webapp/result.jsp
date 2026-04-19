<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Result</title>
</head>
<body>
<center>
<h2>Result</h2>

<% if(request.getAttribute("error") != null) { %>
<p style="color:red;"><%= request.getAttribute("error") %></p>
<% } else { %>

<p>Roll No: <%= request.getAttribute("rollno") %></p>
<p>Name: <%= request.getAttribute("name") %></p>
<p>Sub1: <%= request.getAttribute("m1") %></p>
<p>Sub2: <%= request.getAttribute("m2") %></p>
<p>Sub3: <%= request.getAttribute("m3") %></p>
<p>Sub4: <%= request.getAttribute("m4") %></p>
<p>Sub5: <%= request.getAttribute("m5") %></p>
<p>Average: <%= request.getAttribute("avg") %></p>
<p>Result: <%= request.getAttribute("result") %></p>

<% } %>

<a href="index.jsp">Back</a>
</center>
</body>
</html>