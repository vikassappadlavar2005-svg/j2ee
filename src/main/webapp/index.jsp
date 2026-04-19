<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Student Form</title>
<script>
function validate() {
    let m1 = document.forms["f"]["sub1"].value;
    let m2 = document.forms["f"]["sub2"].value;
    let m3 = document.forms["f"]["sub3"].value;
    let m4 = document.forms["f"]["sub4"].value;
    let m5 = document.forms["f"]["sub5"].value;

    if (m1 < 0 || m2 < 0 || m3 < 0 || m4 < 0 || m5 < 0) {
        alert("Marks must be positive");
        return false;
    }
    return true;
}
</script>
</head>
<body>
<center>
<h2>Student Marks Form</h2>
<form name="f" action="ResultServlet" method="post" onsubmit="return validate()">
Roll No: <input type="text" name="rollno" required><br><br>
Name: <input type="text" name="name" required><br><br>
Sub1: <input type="number" name="sub1" required><br><br>
Sub2: <input type="number" name="sub2" required><br><br>
Sub3: <input type="number" name="sub3" required><br><br>
Sub4: <input type="number" name="sub4" required><br><br>
Sub5: <input type="number" name="sub5" required><br><br>
<input type="submit" value="Submit">
</form>
</center>
</body>
</html>