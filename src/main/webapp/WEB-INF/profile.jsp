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
                <button id="myButton" class="btn btn-primary btn-block" >Create a new ad</button>
                <script type="text/javascript">
                    document.getElementById("myButton").onclick = function () {
                        location.href = "/ads/create";
                    };
                </script>
            </div>
        </div>
    </div>

    <div>
        <h4>Here are your Ads!</h4>
        <c:forEach var="ad" items="${ads}">

        <h5>${ad.title}</h5>
        <p>${ad.description}</p>
            <button id="editButton" class="btn btn-primary btn-block" >Edit Ad</button>
            <script type="text/javascript">
                document.getElementById("editButton").onclick = function () {
                    location.href = "/ads/edit";
                };
            </script>

            <button id="deleteButton" class="btn btn-primary btn-block" >Delete Ad</button>
            <script type="text/javascript">
                document.getElementById("deleteButton").onclick = function () {
                    location.href = "/ads/delete";
                };
            </script>

        </c:forEach>


    </div>
    <button id="myButton" class="btn btn-primary btn-block" >Create a new ad</button>
    <script type="text/javascript">
        document.getElementById("myButton").onclick = function () {
            location.href = "/ads/create";
        };
    </script>


</div>

</body>
</html>

