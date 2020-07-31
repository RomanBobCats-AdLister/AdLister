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
                <br>
                <br>
                <br>

<%--                tried profile pic --%>
<%--                <img alt="profilePic" class="profilePic" src="pictures/batman.jpeg">--%>
            </div>
            <div class="column is-one-third">
                <h5>Profile Info</h5>
                <p>Username: ${user.username}</p>
                <p>Email: ${user.email}</p>
                <a href ="/updateProfile">Edit Info</a>
<%--                <a href ="/deleteProfile">Delete Profile</a>--%>


        </div>
    </div>

    <form action="/deleteProfile"  method="post">
        <input type="hidden" name ="userId" value="${user.id}">
        <input type="submit" name ="deleteAccount" value="Delete this Account" class="btn btn-primary">
    </form>
</div>


<button id="myButton" class="btn btn-primary " >Create a new ad</button>
<script type="text/javascript">
    document.getElementById("myButton").onclick = function () {
        location.href = "/ads/create";
    };
</script>

    <div>
        <h4>Here are your Ads!</h4>
        <c:forEach var="ad" items="${ads}">
        <h5>${ad.title}</h5>
        <p>${ad.description}</p>

            <a href = "/displayAd/${ad.id}">View ad details</a>

            <form action="/ads/updateAd" method="get" >
                <input type="hidden" name ="adToUpdate" value="${ad.id}">
                <input type="submit" value="Edit this ad" class="btn btn-primary ">
            </form>
            <form action="/ads/deleteAd"  method="post">
                <input type="hidden" name ="adToDelete" value="${ad.id}">
                <input type="submit" name ="deleteAd" value="Delete this ad" class="btn  btn-primary">
            </form>

        </c:forEach>

    </div>
</body>
</html>

