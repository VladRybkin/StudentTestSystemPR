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
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <title>Statistic</title>
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
<h1><fmt:message key="statistic" bundle="${rb}" /></h1>

<fmt:message key="login" bundle="${rb}" />: <c:out value="${sessionScope.userLogin}"/><br/>
<fmt:message key="role" bundle="${rb}" />: <c:out value="${sessionScope.role}"/><br/>
<label><a href="${pageContext.request.contextPath}/api/logout"><button onclick=""><fmt:message key="logout" bundle="${rb}" /></button></a></label>
<br><br>

<form action="" method="get">
    <div class="content-box-large">
        <div class="panel-heading">
            <div class="panel-title"><fmt:message key="user.test.results.statistic" bundle="${rb}" /></div>
        </div>
        <div class="panel-body">
            <table cellpadding="0" cellspacing="0" border="0" class="table table-striped table-bordered" >
                <thead>
                <tr class="mySuprerClass">
                    <th>Id</th>

                    <th><fmt:message key="category" bundle="${rb}" /></th>
                    <th><fmt:message key="result" bundle="${rb}" /></th>
                </tr>
                </thead>
                <tbody>

                <c:forEach var="i" items="${requestScope.userStatistic}">
                    <tr >
                        <td class="center"><c:out value="${i.id}"/></td>
                        <td class="center"><c:out value="${i.category}"/></td>
                        <td class="center"><c:out value="${i.result}"/></td>
                    </tr>
                </c:forEach>

                </tbody>
            </table>
        </div>
    </div>

    <br>

    <br>


</form>

<br>
<label><a href="${pageContext.request.contextPath}/api/userAnswerStatistic"><button onclick="">userAnswerStats</button></a></label><br>
<label><a href="${pageContext.request.contextPath}/api/student_page"><button onclick=""><fmt:message key="back.to.the.student.page" bundle="${rb}" /></button></a></label><br>
<label><a href="${pageContext.request.contextPath}/index.jsp"><button onclick=""><fmt:message key="back.to.the.main" bundle="${rb}" /></button></a></label><br>
</body>
</html>
