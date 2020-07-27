<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <div class="columns">
        <div class="content">
            <h1>Welcome, ${sessionScope.user.username}!</h1>
            <div class="column is-two-thirds">
                <img alt="profilePic" class="profilePic" src="pictures/batman.jpeg">
            </div>
            <div class="column is-one-third">
                <h5>Profile Info</h5>
                <p>Username: ${user.username}</p>
                <p>Email: ${user.email}</p>
                <a href ="http://localhost:8080/updateProfile">Edit Info</a>
            </div>
        </div>
    </div>
</div>

</body>
</html>

