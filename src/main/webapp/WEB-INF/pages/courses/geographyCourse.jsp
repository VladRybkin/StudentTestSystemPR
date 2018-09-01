<%--
  Created by IntelliJ IDEA.
  User: Vlad
  Date: 30.08.2018
  Time: 1:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <title>Geography Course</title>
</head>
<body>
<h1>Georgraphy course</h1>

login: <c:out value="${userLogin}"/><br/>
role: <c:out value="${userRole}"/><br/>
<label><a href="${pageContext.request.contextPath}/api/logout"><button onclick="">logout</button></a></label>
<br><br>



<label><a href="${pageContext.request.contextPath}/api/geographyMaterial"><button onclick="">Geography material</button></a></label><br>
<label><a href="${pageContext.request.contextPath}/api/geographytest"><button onclick="">Geography test</button></a></label><br>
<label><a href="${pageContext.request.contextPath}/api/student_page"><button onclick="">back to student page</button></a></label><br>
<label><a href="${pageContext.request.contextPath}/index.jsp"><button onclick="">back to main</button></a></label><br>

</body>