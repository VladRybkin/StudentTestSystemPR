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
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <title>login page</title>

</head>

<body>
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language: pageContext.request.locale}" scope="session"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="loc" var="rb"/>
<form>
    <input name="language" type="image" value="en_US"
    ${language=='en_US' ? 'selected' : '' } src = ${pageContext.request.contextPath}/images/flags/flag_usa.png style="height: 35px; width: 35px;">
    <input name="language" type="image" value="uk_UA"
    ${language=='uk_UA' ? 'selected' : '' } src = ${pageContext.request.contextPath}/images/flags/flag_ua.png style="height: 35px; width: 35px;">
</form>

<form method="post">
    <label><input type="text" name="login"></label><fmt:message key="login" bundle="${rb}" /><br>
    <label><input type="password" name="password"></label><fmt:message key="password" bundle="${rb}" /><br>
    <input type="submit" value=<fmt:message key="login" bundle="${rb}" />><br>

</form>
<label><a href="${pageContext.request.contextPath}/index.jsp"><button onclick=""><fmt:message key="back.to.the.main" bundle="${rb}" /></button></a></label><br>
</body>
</html>
