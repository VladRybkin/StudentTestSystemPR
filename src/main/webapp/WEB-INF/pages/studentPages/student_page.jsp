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
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <title>admin page</title>
</head>
<body>
<h2>Student page</h2>

    login: <c:out value="${userLogin}"/><br/>
    role: <c:out value="${userRole}"/><br/>
<label><a href="${pageContext.request.contextPath}/api/logout"><button onclick="">logout</button></a></label>

<br><br>


<label><a href="${pageContext.request.contextPath}/api/user_statistic"><button onclick="">Statistic</button></a></label><br>
<label><a href="${pageContext.request.contextPath}/api/geographyCourse"><button onclick="">Geography course</button></a></label><br>
<label><a href="${pageContext.request.contextPath}/api/astronomyCourse"><button onclick="">Astronomy course</button></a></label><br>
<label><a href="${pageContext.request.contextPath}/index.jsp"><button onclick="">back to main</button></a></label><br>


</body>
</html>
