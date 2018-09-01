<%--
  Created by IntelliJ IDEA.
  User: Vlad
  Date: 23.08.2018
  Time: 0:04
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>registration page</title>
</head>
<body>
<form method="post" action="">
    <label><input type="text" name="user_login"></label>login<br>
    <label><input type="password" name="user_password"></label>password<br>
    <label><input type="text" name="user_mail"></label>mail<br>
    <input type="submit" value="register"><br>
    <c:out value="${successReg}"/><br/>
</form>

<label><a href="${pageContext.request.contextPath}/index.jsp"><button onclick="">back to the main</button></a></label><br>

</body>
</html>
