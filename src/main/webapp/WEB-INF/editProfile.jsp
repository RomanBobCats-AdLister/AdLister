<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>


<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp"/>
<br>
<div class="container">
        <div class="content">
        <h1>Please Edit your information.</h1>
        <form action="/updateProfile" method="post">

            <div class="field">


                <input type="hidden" name="id" class="form-control" value="${user.id}">
                <label for="email">Email</label>
                <div class="control">
                <input id="email" name="email" class="input is-rounded" type="text" value="${user.email}">
<%--    tried to edit user name--%>
<%--                <input id="username" name="username" class="input is-rounded" type="text" value="${user.username}">--%>
            </div>
            </div>


            <div class="field">

                        <input type="hidden" name="id" class="form-control" value="${user.id}">
                        <label for="email">Password</label>
                    <div class="control">
                    <input id="password" name="password" class="input is-rounded" type="password" value="${user.password}">

                    </div>
                </div>


            <div class="field">
                <div class="control">
            <input type="submit" class="button is-info is-rounded">
                </div>
            </div>
        </form>
</div>
</div>
</body>
</html>
