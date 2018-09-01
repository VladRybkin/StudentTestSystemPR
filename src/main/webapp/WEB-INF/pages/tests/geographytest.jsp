<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <title>geography test</title>
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
<h2>Geography test</h2><br/>
<br>

<fmt:message key="login" bundle="${rb}" />: <c:out value="${userLogin}"/><br/>
<fmt:message key="role" bundle="${rb}" />: <c:out value="${userRole}"/><br/>
<label><a href="${pageContext.request.contextPath}/api/logout"><button onclick=""><fmt:message key="logout" bundle="${rb}" /></button></a></label>
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

<label><a href="${pageContext.request.contextPath}/api/user_statistic"><button onclick=""><fmt:message key="statistic" bundle="${rb}" /></button></a></label><br>

<label><a href="${pageContext.request.contextPath}/index.jsp"><button onclick=""><fmt:message key="back.to.the.main" bundle="${rb}" /></button><br>
</a></label>


<hr/>
</body>
</html>
