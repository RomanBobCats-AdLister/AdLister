<%--
  Created by IntelliJ IDEA.
  User: bobbiearchambault
  Date: 7/27/20
  Time: 11:42 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
        <jsp:include page="/WEB-INF/partials/head.jsp">
            <jsp:param name="title" value="${Ad.title}" />
        </jsp:include>
</head>
<body>
<div class="container">
    <h1>${Ad.title} Details!</h1>
    <div>
    <p>${Ad.description} </p>
    </div>
    <input type="submit" value="Edit this ad" class="btn btn-block btn-primary">
    <br>
    <input type="submit" value="Delete this ad" class="btn btn-block btn-primary">
</div>

</body>
</html>
