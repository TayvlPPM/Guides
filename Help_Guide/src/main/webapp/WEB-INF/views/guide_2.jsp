<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" 	uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link href="<spring:url value='/resources/css/style.css'/>" rel="stylesheet">
    <script src="<spring:url value='/resources/js/jquery/jquery-3.4.1.min.js'/>"></script>
    <title>Application guides</title>
</head>
<body>
<main>
    <div class="guide-page">
        <section class="menu-panel">
            <p>Guides</p>
            <c:forEach var="guideTitle" items="${guides}">
                <a class="menu-value" href="${guideTitle.url}">${guideTitle.caption}</a><br>
            </c:forEach>
        </section>
        <div id="guide-body"class="guide-panel">
            <div class="guide-body">
                ${content.document}
            </div>
        </div>
        <div class="contents-panel">
        </div>
    </div>

</main>
</body>
</html>
