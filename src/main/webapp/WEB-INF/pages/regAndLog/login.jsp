<%--
  Created by IntelliJ IDEA.
  User: Vlad
  Date: 24.08.2018
  Time: 17:11
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <title>login page</title>

</head>

<body>
<form method="post">
    <label><input type="text" name="login"></label>login<br>
    <label><input type="password" name="password"></label>password<br>
    <input type="submit" value="login"><br>

</form>
<label><a href="${pageContext.request.contextPath}/index.jsp"><button onclick="">back to the main</button></a></label><br>
</body>
</html>
