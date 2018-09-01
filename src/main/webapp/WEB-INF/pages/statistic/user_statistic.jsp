<%--
  Created by IntelliJ IDEA.
  User: Vlad
  Date: 27.08.2018
  Time: 1:15
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <title>Statistic</title>
</head>
<body>
<h1>statistic page</h1>

login: <c:out value="${userLogin}"/><br/>
role: <c:out value="${userRole}"/><br/>
<label><a href="${pageContext.request.contextPath}/api/logout"><button onclick="">logout</button></a></label>
<br><br>

<form action="" method="get">


    <table>
        <tr><th>statistic</th></tr>

        <c:forEach var="i" items="${userStatistic}">
            <tr>
                <th>
                    category: <c:out value="${i.category}"/>
                </th>
                <th>
                    result %: <c:out value="${i.result}"/>
                </th>
            </tr>

        </c:forEach>
    </table>
    <br>

    <table>
        <tr><th>statistic</th></tr>

        <c:forEach var="i" items="${userAnswerStatistic}">
            <tr>
                <th>
                    question: <c:out value="${i.testQuestion}"/>
                </th>
                <th>
                    user answer: <c:out value="${i.userAnswer}"/>
                </th>
                <th>
                    correct answer: <c:out value="${i.correctAnswer}"/>
                </th>

            </tr>

        </c:forEach>
    </table>
    <br>

</form>
<br>
<%--results: <c:out value="${userResults}"/><br/>--%>
<label><a href="${pageContext.request.contextPath}/api/student_page"><button onclick="">back to student page</button></a></label><br>
<label><a href="${pageContext.request.contextPath}/index.jsp"><button onclick="">back to main</button></a></label><br>
</body>
</html>
