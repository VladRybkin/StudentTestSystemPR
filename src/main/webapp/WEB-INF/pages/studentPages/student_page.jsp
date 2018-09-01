<%--
  Created by IntelliJ IDEA.
  User: Vlad
  Date: 25.08.2018
  Time: 10:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <title>admin page</title>
</head>
<body>
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language: pageContext.request.locale}" scope="session"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="loc" var="rb"/>
<form>
    <input name="language" type="image" value="en_US"
    ${language=='en_US' ? 'selected' : '' } src = "http://icons.iconarchive.com/icons/custom-icon-design/all-country-flag/128/United-States-Flag-icon.png" style="height: 35px; width: 35px;">
    <input name="language" type="image" value="uk_UA"
    ${language=='uk_UA' ? 'selected' : '' } src = "http://icons.iconarchive.com/icons/custom-icon-design/all-country-flag/128/Ukraine-Flag-icon.png" style="height: 35px; width: 35px;">
</form>

<h2><fmt:message key="student.page" bundle="${rb}" /></h2>

<fmt:message key="login" bundle="${rb}" />: <c:out value="${requestScope.userLogin}"/><br/>
<fmt:message key="role" bundle="${rb}" />: <c:out value="${requestScope.userRole}"/><br/>
<label><a href="${pageContext.request.contextPath}/api/logout"><button onclick=""><fmt:message key="logout" bundle="${rb}" /></button></a></label>

<br><br>


<label><a href="${pageContext.request.contextPath}/api/user_statistic"><button onclick=""><fmt:message key="statistic" bundle="${rb}" /></button></a></label><br>
<label><a href="${pageContext.request.contextPath}/api/geographyCourse"><button onclick=""><fmt:message key="geography.course" bundle="${rb}" /></button></a></label><br>
<label><a href="${pageContext.request.contextPath}/api/astronomyCourse"><button onclick=""><fmt:message key="astronomy.course" bundle="${rb}" /></button></a></label><br>
<label><a href="${pageContext.request.contextPath}/index.jsp"><button onclick=""><fmt:message key="back.to.the.main" bundle="${rb}" /></button></a></label><br>


</body>
</html>
