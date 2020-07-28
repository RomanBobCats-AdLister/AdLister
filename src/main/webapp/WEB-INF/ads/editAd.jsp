<%--
  Created by IntelliJ IDEA.
  User: bobbiearchambault
  Date: 7/28/20
  Time: 3:04 PM
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
    <h1>Update ad</h1>
    <form action="/ads/updateAd" method="post">
        <input type="hidden" name ="adToUpdate" value="${ad.id}">
<%--        update title input--%>
        <div class="form-group">
            <label for="title">Title</label>
            <input id="title" value="${ad.title}" name="title" class="form-control" type="text">
            <br>
            <input type="submit" name ="updateAdTitle" value="Update title" class="btn btn-block btn-primary">
        </div>
<%--        update description input--%>
        <div class="form-group">
            <label for="description">Description</label>
            <textarea id="description"  name="description" class="form-control">${ad.description}</textarea>
            <br>
            <input type="submit" name ="updateAdDescription" value="Update description" class="btn btn-block btn-primary">

        </div>

<%--    update category input--%>
<%--        <div class="form-group">--%>
<%--            <label for="category">Select category</label>--%>
<%--            <input id="category" name="category" value="${ad.category}"class="form-control" type="text">--%>
<%--            <br>--%>
<%--            <input type="submit" name ="updateAdCategory" value="Update category" class="btn btn-block btn-primary">--%>
<%--        </div>--%>

    </form>
</div>
</body>
</html>
