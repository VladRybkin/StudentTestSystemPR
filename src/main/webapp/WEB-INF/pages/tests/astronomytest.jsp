<%--
  Created by IntelliJ IDEA.
  User: Vlad
  Date: 29.08.2018
  Time: 5:13
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
    <title>geography test</title>
</head>
<body>
<h2>Astronomy test</h2><br/>
<br>

login: <c:out value="${userLogin}"/><br/>
role: <c:out value="${userRole}"/><br/>
<label><a href="${pageContext.request.contextPath}/api/logout"><button onclick="">logout</button></a></label>
<br><br>


<br>


<form method="post">
    <label>${requestScope.Gfirst}<br><input type="text" name="userAnswer1"></label>input answer<br>
    <label>${requestScope.Gsecond}<br><input type="text" name="userAnswer2"></label>input answer<br>
    <label>${requestScope.Gthird}<br><input type="text" name="userAnswer3"></label>input answer<br>
    <label>${requestScope.Gfourth}<br><input type="text" name="userAnswer4"></label>input answer<br>
    <label>${requestScope.Gfifth}<br><input type="text" name="userAnswer5"></label>input answer<br>
    <input type="submit" value="ok"><br>
    <label>correct answers: </label><c:out value="${count}"/><br/>


    <table>
        <tr>
            <th>STATISTIC</th>
        </tr>
        <c:forEach var="i" items="${statistic}">
            <tr>
                <th>
                    question: <c:out value="${i.testQuestion}"/>
                </th>
                <th>
                    user answer: <c:out value="${i.userAnswer}"/>
                </th>
                <th>
                    correct Answer: <c:out value="${i.correctAnswer}"/>
                </th>
            </tr>

        </c:forEach>
    </table>



</form>





<br>

<label><a href="${pageContext.request.contextPath}/api/user_statistic"><button onclick="">statistic</button></a></label><br>

<label><a href="${pageContext.request.contextPath}/index.jsp"><button onclick="">back to the main</button><br>
</a></label>


<hr/>
</body>
</html>
