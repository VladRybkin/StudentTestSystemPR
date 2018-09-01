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
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <title>Geography material</title>
</head>
<body>
<h1>Топ города планеты</h1>
<br>

<h2>Окленд, Новая Зеландия </h2>
<form> <img src=http://image2.turizm.ru/CE/pub/page/179345/00.jpg><br>
    Окленд - крупнейший город в Новой Зеландии. Количество населения здесь - около 1,3 миллиона человек, что составляет почти четверть жителей всей страны. История поселения насчитывает более 800 лет, как город он начал формироваться с 19 века - с приходом сюда европейских поселенцев. Динамичному развитию Окленда во многом способствовало расширение сети железных дорог, а позже - и автомобильных. Окленд - поистине космополитический город, который не раз входил в список лучших городов для жизни. Туристам здесь будет интересно посетить остров-вулкан Рангитото, Оклендский музей, городские парки, Центр антарктических исследований, подводный тоннель, большой сувенирный рынок</form>




<label><a href="${pageContext.request.contextPath}/api/geographyCourse"><button onclick="">back to geography course</button></a></label><br>
<label><a href="${pageContext.request.contextPath}/index.jsp"><button onclick="">back to main</button></a></label><br>
</body>
</html>
