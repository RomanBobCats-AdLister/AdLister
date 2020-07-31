<%--
  Created by IntelliJ IDEA.
  User: armando
  Date: 7/28/20
  Time: 1:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach var="category" items="${category}">

    <div class="col-md-6">

        <h2>Title: ${category.category}</h2>
        <h2>Description:
            <textarea class="form-control rounded-0">${ad.description}</textarea>
        </h2>
        <a href = "/displayAd/${ad.id}">View ad details</a>

    </div>
    <%--        </div>--%>

</c:forEach>
</body>
</html>
