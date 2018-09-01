<%--
  Created by IntelliJ IDEA.
  User: Vlad
  Date: 30.08.2018
  Time: 9:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <title>Geography material</title>
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
<h1>Топ города планеты</h1>
<br>

<h2>Окленд, Новая Зеландия </h2>
<form> <img src=http://image2.turizm.ru/CE/pub/page/179345/00.jpg><br>
    Окленд - крупнейший город в Новой Зеландии. Количество населения здесь - около 1,3 миллиона человек, что составляет почти четверть жителей всей страны. История поселения насчитывает более 800 лет, как город он начал формироваться с 19 века - с приходом сюда европейских поселенцев. Динамичному развитию Окленда во многом способствовало расширение сети железных дорог, а позже - и автомобильных. Окленд - поистине космополитический город, который не раз входил в список лучших городов для жизни. Туристам здесь будет интересно посетить остров-вулкан Рангитото, Оклендский музей, городские парки, Центр антарктических исследований, подводный тоннель, большой сувенирный рынок</form>




<label><a href="${pageContext.request.contextPath}/api/geographyCourse"><button onclick="">back to geography course</button></a></label><br>
<label><a href="${pageContext.request.contextPath}/index.jsp"><button onclick="">back to main</button></a></label><br>
</body>
</html>
