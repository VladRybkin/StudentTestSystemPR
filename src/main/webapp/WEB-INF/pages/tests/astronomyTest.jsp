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
<h2><fmt:message key="astronomy.test" bundle="${rb}" /></h2><br/>
<br>

<fmt:message key="login" bundle="${rb}" />: <c:out value="${sessionScope.userLogin}"/><br/>
<fmt:message key="role" bundle="${rb}" />: <c:out value="${sessionScope.role}"/><br/>
<label><a href="${pageContext.request.contextPath}/api/logout"><button onclick=""><fmt:message key="logout" bundle="${rb}" /></button></a></label>
<br><br>


<br>


<form method="post">
    <label>${requestScope.Gfirst}<br><input type="text" name="userAnswer1"></label><fmt:message key="input.answer" bundle="${rb}" /><br>
    <label>${requestScope.Gsecond}<br><input type="text" name="userAnswer2"></label><fmt:message key="input.answer" bundle="${rb}" /><br>
    <label>${requestScope.Gthird}<br><input type="text" name="userAnswer3"></label><fmt:message key="input.answer" bundle="${rb}" /><br>
    <label>${requestScope.Gfourth}<br><input type="text" name="userAnswer4"></label><fmt:message key="input.answer" bundle="${rb}" /><br>
    <label>${requestScope.Gfifth}<br><input type="text" name="userAnswer5"></label><fmt:message key="input.answer" bundle="${rb}" /><br>
    <input type="submit" value="ok"><br>
    <label><fmt:message key="correct.answers" bundle="${rb}" />: </label><c:out value="${requestScope.count}"/><br/>


    <table>
        <tr>
            <th>statistic</th>
        </tr>
        <c:forEach var="i" items="${sessionScope.statistic}">
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
<label><a href="${pageContext.request.contextPath}/api/astronomyCourse.jsp"><button onclick=""><fmt:message key="back.to.the.astronomy.course" bundle="${rb}" /></button><br>
</a></label>

<label><a href="${pageContext.request.contextPath}/index.jsp"><button onclick=""><fmt:message key="back.to.the.main" bundle="${rb}" /></button><br>
</a></label>


<hr/>
</body>
</html>
