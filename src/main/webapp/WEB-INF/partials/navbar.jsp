<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <a class="navbar-brand" href="/ads">Adlister</a>
        </div>
        <ul class="nav navbar-nav navbar-right">
            <c:choose>
                <%--            no method so by default they get handled in the doGet of the servlet--%>
                <c:when test="${sessionScope['user']!=null }">
                    <li><a href="/logout">Logout</a></li>
                    <li><a href="/profile">Profile</a></li>
                </c:when>
                <c:otherwise>
                    <li><a href="/login">Login</a></li>
                </c:otherwise>
            </c:choose>
        <%--test--%>
        </ul>
    </div><!-- /.navbar-collapse -->

</nav>