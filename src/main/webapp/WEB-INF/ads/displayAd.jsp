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
<div class="container">
    <h1>${ad.title} Details!</h1>
    <div>
    <p>${ad.description} </p>
    </div>
    <form action="/DisplayAdServlet" >
    <input type="submit" value="Edit this ad" class="btn btn-block btn-primary">
    </form>
    <br>
    <form action="/displayAd" >
    <input type="submit" name ="deleteAd" value="Delete this ad" class="btn btn-block btn-primary">
    </form>
</div>

</body>
</html>
