<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page pageEncoding="UTF-8" %>
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language: pageContext.request.locale}" scope="session"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="loc" var="rb"/>
<html>
<head>
    <meta charset="UTF-8">
    <title>Stutdent test system</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

</head>
<body>

<h1>Student test system</h1><br/>

<form>
    <input name="language" type="image" value="en_US"
    ${language=='en_US' ? 'selected' : '' } src = "http://icons.iconarchive.com/icons/custom-icon-design/all-country-flag/128/United-States-Flag-icon.png" style="height: 35px; width: 35px;">
    <input name="language" type="image" value="uk_UA"
    ${language=='uk_UA' ? 'selected' : '' } src = "http://icons.iconarchive.com/icons/custom-icon-design/all-country-flag/128/Ukraine-Flag-icon.png" style="height: 35px; width: 35px;">
</form>
<br>

<label><a href="${pageContext.request.contextPath}/api/registration"><button onclick=""><fmt:message key="registration" bundle="${rb}" /></button></a></label>
<label><a href="${pageContext.request.contextPath}/api/login"><button onclick=""><fmt:message key="login" bundle="${rb}" /></button></a></label>


<br>
<br>
<label><a href="${pageContext.request.contextPath}/api/admin_page"><button onclick=""><fmt:message key="admin.page" bundle="${rb}" /></button></a></label>
<label><a href="${pageContext.request.contextPath}/api/user_statistic"><button onclick=""><fmt:message key="statistic" bundle="${rb}" /></button></a></label>
<label><a href="${pageContext.request.contextPath}/api/student_page"><button onclick=""><fmt:message key="student.page" bundle="${rb}" /></button></a></label>
<label><a href="${pageContext.request.contextPath}/api/error"><button onclick=""><fmt:message key="error" bundle="${rb}" /></button></a></label>

<h2><fmt:message key="student.test.system" bundle="${rb}" /></h2>
</body>
</html>
