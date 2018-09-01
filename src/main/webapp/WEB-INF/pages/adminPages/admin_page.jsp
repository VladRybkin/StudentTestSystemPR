<%--
  Created by IntelliJ IDEA.
  User: Vlad
  Date: 25.08.2018
  Time: 10:09
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <title>admin page</title>
</head>
<body>
<h2>Hello admin</h2>
login: <c:out value="${userLogin}"/><br/>
role: <c:out value="${userRole}"/><br/>
<label><a href="${pageContext.request.contextPath}/api/logout"><button onclick="">logout</button></a></label>
<br><br>
<form action="" method="get">


    <table>
        <tr>
            <th>result statistic</th>
        </tr>
        <c:forEach var="i" items="${testResults}">
            <tr>
                <th>
                    <li>category: <c:out value="${i.category}"/></li>
                </th>
                <th>
                    <li>result%: <c:out value="${i.result}"/></li>
                </th>
                <th>
                    <li>user: <c:out value="${i.user}"/></li>
                </th>

                <%--<th>--%>
                    <%--<li>test results: <c:out value="${i.testResults}"/></li>--%>
                <%--</th>--%>

            </tr>

        </c:forEach>
    </table>
    <br>
    <table>
        <tr>
                    <th>user statistic</th>
        </tr>
        <c:forEach var="i" items="${studentStats}">
            <tr>
                <th>
                    <li>login: <c:out value="${i.login}"/></li>
                </th>
                <th>
                    <li>role: <c:out value="${i.role}"/></li>
                </th>
                <th>
                    <li>email: <c:out value="${i.email}"/></li>
                </th>
                
            </tr>

        </c:forEach>
    </table>
    <br>
</form>

<br><br>

    <label><a href="${pageContext.request.contextPath}/index.jsp">
        <button onclick="">back to main</button>
    </a></label><br>



</body>
</html>
