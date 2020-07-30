<%--
  Created by IntelliJ IDEA.
  User: bobbiearchambault
  Date: 7/27/20
  Time: 11:42 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
        <jsp:include page="/WEB-INF/partials/head.jsp">
            <jsp:param name="title" value="${ad.title}" />
        </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp"/>
<br>
<div class="container">
    <h1>${ad.title} Details!</h1>
    <div>
    <p>${ad.description} </p>
    </div>

    <h5>${user.username}, email:  ${user.email}</h5>
    <br>
    <c:choose>
        <c:when test="${user.getId() eq ad.userId}">
            <form action="/ads/updateAd" method="get" >
                <input type="hidden" name ="adToUpdate" value="${ad.id}">
                <input type="submit" value="Edit this ad" class="btn btn-block btn-primary">
            </form>
            <br>
            <form action="/ads/deleteAd"  method="post">
                <input type="hidden" name ="adToDelete" value="${ad.id}">
                <input type="submit" name ="deleteAd" value="Delete this ad" class="btn btn-block btn-primary">
            </form>
        </c:when>
    </c:choose>
</div>

</body>
</html>
