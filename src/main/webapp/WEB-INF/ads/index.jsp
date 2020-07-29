<%@ page import="java.sql.Statement" %>
<%@ page import="com.mysql.cj.api.mysqla.result.Resultset" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.sql.ResultSet" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing All The Ads" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<div class="container">
    <h1 class="text-center">Here Are all the ads!</h1>
<%--    <div class ="row">--%>
    <c:forEach var="ad" items="${ads}">

        <div class="col-md-6">

            <h2>Title: ${ad.title}</h2>
            <h2>Description:
            <textarea class="form-control rounded-0">${ad.description}</textarea>
            </h2>
            <a href = "/displayAd?id=${ad.id}">View ad details</a>

        </div>
<%--        </div>--%>

    </c:forEach>

<%--<tr class="col-md-4">--%>
    <div class="col-md-6">
        <ul>
            <li>
                <div>
                    <h3>Looking for something specific?</h3>
                </div>
            </li>
            <li>
                <form action="/ads" method="post">
                    <input type="text" id="ad" name="ad" placeholder="Search">
                    <button>Search</button>
                </form>
            </li>
        </ul>
    </div>
</div>
<%--    <c:if test="${ads != null}">--%>
<%--        <h1>Displaying results for <c:out value="${searchQuery}"/> </h1>--%>
<%--        <table>--%>
<%--            <th>Title</th>--%>
<%--            <th>Description</th>--%>
<%--            <c:forEach items="${ads}" var="ad">--%>
<%--                <tr>--%>
<%--                    <td>${ad.title}</td>--%>
<%--                    <td>${ad.description}</td>--%>
<%--                </tr>--%>
<%--            </c:forEach>--%>
<%--        </table>--%>
<%--    </c:if>--%>
</div>



</body>
</html>
