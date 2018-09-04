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

    <div class="content-box-large">
        <div class="panel-heading">
            <div class="panel-title"><fmt:message key="user.statistic" bundle="${rb}" /></div>
        </div>
        <div class="panel-body">
            <table cellpadding="0" cellspacing="0" border="0" class="table table-striped table-bordered" >
                <thead>
                <tr class="mySuprerClass">
                    <th>Id</th>
                    <th><fmt:message key="login" bundle="${rb}" /></th>
                    <th><fmt:message key="role" bundle="${rb}" /></th>
                    <th><fmt:message key="email" bundle="${rb}" /></th>
                </tr>
                </thead>
                <tbody>

                <c:forEach var="i" items="${requestScope.studentStats}">
                    <tr >
                        <td class="center"><c:out value="${i.id}"/></td>
                        <td class="center"><c:out value="${i.login}"/></td>
                        <td class="center"><c:out value="${i.role}"/></td>
                        <td class="center"><c:out value="${i.email}"/></td>
                    </tr>
                </c:forEach>

                </tbody>
            </table>
        </div>
    </div><br>

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
                    <th><fmt:message key="user" bundle="${rb}" /></th>
                </tr>
                </thead>
                <tbody>

                <c:forEach var="i" items="${requestScope.testResults}">
                    <tr >
                        <td class="center"><c:out value="${i.id}"/></td>
                        <td class="center"><c:out value="${i.category}"/></td>
                        <td class="center"><c:out value="${i.result}"/></td>
                        <td class="center"><c:out value="${i.user.getLogin()}"/></td>
                    </tr>
                </c:forEach>

                </tbody>
            </table>
        </div>
    </div>
    <br>

    <br>

    <c:if test="${currentPage != 1}">
        <td><a href="/api/admin_page?page=${currentPage - 1}">Previous</a></td>
    </c:if>

    <%--For displaying Page numbers.
    The when condition does not display a link for the current page--%>
    <table border="0" cellpadding="0" cellspacing="0">
        <tr>
            <c:forEach begin="1" end="${noOfPages}" var="i">
                <c:choose>
                    <c:when test="${currentPage eq i}">
                        <td>${i}</td>
                    </c:when>
                    <c:otherwise>
                        <td><a href="/api/admin_page?page=${i}">${i}</a></td>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </tr>
    </table>

    <%--For displaying Next link --%>
    <c:if test="${currentPage lt noOfPages}">
        <td><a href="/api/admin_page?page=${currentPage + 1}">Next</a></td>
    </c:if>





</form>

<br><br>

    <label><a href="${pageContext.request.contextPath}/index.jsp">
        <button onclick=""><fmt:message key="back.to.the.main" bundle="${rb}" /></button>
    </a></label><br>



</body>
</html>
