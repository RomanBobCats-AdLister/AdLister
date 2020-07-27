<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>
</head>
<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />

    <div class="container">
        <h1>Welcome, ${sessionScope.user.username}!</h1>
        <button id="creatAdButton" class="btn btn-primary btn-block" >Create a new ad</button>

        <script type="text/javascript">

            document.getElementById("creatAdButton").onclick = function () {
                location.href = "/ads/create";
            };
        </script>
    </div>

</body>
</html>
