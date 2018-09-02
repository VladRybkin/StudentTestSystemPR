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
<h2><fmt:message key="admin.page" bundle="${rb}" /></h2>
<fmt:message key="login" bundle="${rb}" />: <c:out value="${sessionScope.userLogin}"/><br/>
<fmt:message key="role" bundle="${rb}" />: <c:out value="${sessionScope.role}"/><br/>
<label><a href="${pageContext.request.contextPath}/api/logout"><button onclick=""><fmt:message key="logout" bundle="${rb}" /></button></a></label>
<br><br>
<form action="" method="get">

    <table>
        <tr>
            <th>user statistic</th>
        </tr>
        <c:forEach var="i" items="${requestScope.studentStats}">
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
    </table><br>

    <table>
        <tr>
            <th>result statistic</th>
        </tr>
        <c:forEach var="i" items="${requestScope.testResults}">
            <tr>
                <th>
                    <li><fmt:message key="category" bundle="${rb}" />: <c:out value="${i.category}"/></li>
                </th>
                <th>
                    <li><fmt:message key="result" bundle="${rb}" />%: <c:out value="${i.result}"/></li>
                </th>
                <th>
                    <li><fmt:message key="user" bundle="${rb}" />: <c:out value="${i.user.getLogin()}"/></li>
                </th>

                <%--<th>--%>
                    <%--<li>test results: <c:out value="${i.testResults}"/></li>--%>
                <%--</th>--%>

            </tr>

        </c:forEach>
    </table>
    <br>

    <br>
</form>

<br><br>

    <label><a href="${pageContext.request.contextPath}/index.jsp">
        <button onclick=""><fmt:message key="back.to.the.main" bundle="${rb}" /></button>
    </a></label><br>



</body>
</html>
