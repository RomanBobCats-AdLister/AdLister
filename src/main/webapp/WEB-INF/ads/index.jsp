<%@ page import="java.sql.Statement" %>
<%@ page import="com.mysql.cj.api.mysqla.result.Resultset" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.sql.ResultSet" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing All The Ads" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<div class="container">
    <h1 class="text-center">Here Are all the ads!</h1>
<%--SEARCH BAR--%>
    <div class="col-md-6">
        <h3>Looking for something specific?</h3>
        <br>
        <form action="/ads" method="post">
            <input type="text" id="ad" name="ad" placeholder="Search">
            <button>Search</button>
        </form>
    </div>

<%--    ALL ADS--%>
    <c:forEach var="ad" items="${ads}">

        <div class="col-md-6">

            <h2> ${ad.title}</h2>
            <h2>
            <textarea class="form-control rounded-0">${ad.description}</textarea>
            </h2>
            <a href = "/displayAd/${ad.id}">View ad details</a>

        </div>
    </c:forEach>


</div>



</body>
</html>
