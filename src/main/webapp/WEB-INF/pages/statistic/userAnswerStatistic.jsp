
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
    ${language=='en_US' ? 'selected' : '' } src = ${pageContext.request.contextPath}/images/flags/flag_usa.png style="height: 35px; width: 35px;">
    <input name="language" type="image" value="uk_UA"
    ${language=='uk_UA' ? 'selected' : '' } src = ${pageContext.request.contextPath}/images/flags/flag_ua.png style="height: 35px; width: 35px;">
</form>
<br>
<fmt:message key="login" bundle="${rb}" />: <c:out value="${sessionScope.userLogin}"/><br/>
<fmt:message key="role" bundle="${rb}" />: <c:out value="${sessionScope.role}"/><br/>
<label><a href="${pageContext.request.contextPath}/api/logout"><button onclick=""><fmt:message key="logout" bundle="${rb}" /></button></a></label>
<br><br>
<h2><fmt:message key="previous.page" bundle="${rb}" /></h2><br>
<form method="get">


    <div class="content-box-large">
        <div class="panel-heading">
            <div class="panel-title"><fmt:message key="user.answers.statistic" bundle="${rb}" /></div>
        </div>
        <div class="panel-body">
            <table cellpadding="" cellspacing="0" border="0" class="table table-striped table-bordered" >
                <thead>
                <tr class="mySuprerClass">
                    <th>Id</th>

                    <th><fmt:message key="test.question" bundle="${rb}" /></th>
                    <th><fmt:message key="user.answer" bundle="${rb}" /></th>
                    <th><fmt:message key="correct.answer" bundle="${rb}" /></th>
                </tr>
                </thead>
                <tbody>

                <c:forEach var="i" items="${requestScope.userAnswerStatistic}">
                    <tr >
                        <td class="center"><c:out value="${i.id}"/></td>
                        <td class="center"><c:out value="${i.testQuestion}"/></td>
                        <td class="center"><c:out value="${i.userAnswer}"/></td>
                        <td class="center"><c:out value="${i.correctAnswer}"/></td>


                    </tr>
                </c:forEach>

                </tbody>
            </table>
        </div>
    </div>




    <%--For displaying Previous link except for the 1st page --%>
    <c:if test="${currentPage != 1}">
        <td><a href="/api/userAnswerStatistic?page=${currentPage - 1}"><fmt:message key="previous.page" bundle="${rb}" /></a></td>
    </c:if>

    <%--For displaying Page numbers.
    The when condition does not display a link for the current page--%>
    <table border="1" cellpadding="5" cellspacing="5">
        <tr>
            <c:forEach begin="1" end="${noOfPages}" var="i">
                <c:choose>
                    <c:when test="${currentPage eq i}">
                        <td>${i}</td>
                    </c:when>
                    <c:otherwise>
                        <td><a href="/api/userAnswerStatistic?page=${i}">${i}</a></td>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </tr>
    </table>

    <%--For displaying Next link --%>
    <c:if test="${currentPage lt noOfPages}">
        <td><a href="/api/userAnswerStatistic?page=${currentPage + 1}"><fmt:message key="next.page" bundle="${rb}" /></a></td>
    </c:if>


</form>








<label><a href="${pageContext.request.contextPath}/api/user_statistic"><button onclick=""><fmt:message key="back.to.the.test.results" bundle="${rb}" /></button></a></label><br>
<label><a href="${pageContext.request.contextPath}/api/student_page"><button onclick=""><fmt:message key="back.to.the.student.page" bundle="${rb}" /></button></a></label><br>
<label><a href="${pageContext.request.contextPath}/index.jsp"><button onclick=""><fmt:message key="back.to.the.main" bundle="${rb}" /></button></a></label><br>







</body>
</html>