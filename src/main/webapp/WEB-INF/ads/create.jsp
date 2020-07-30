<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Create a new Ad" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp"/>
<br>
    <div class="container">
        <h1>Create a new Ad</h1>
        <form action="/ads/create" method="post">
            <div class="form-group">
                <label for="title">Title</label>
                <input id="title" name="title" class="form-control" type="text">
            </div>
            <div class="form-group">
                <label for="description">Description</label>
                <textarea id="description" name="description" class="form-control" type="text"></textarea>
            </div>

<%--            CATEGORY DROPDOWN LIST--%>
            <div class="form-group">
                <label for="category">Select category</label>
<%--                <textarea id="category" name="category" class="form-control" type="text"></textarea>--%>
                <select id="category" name="id">
                    <option value="1">clothing</option>
                    <option value="2">vehicles</option>
                    <option value="3">collectibles</option>
                    <option value="4">pets</option>
                    <option value="5">household</option>
                    <option value="6">beauty</option>
                    <option value="7">misc</option>
                </select>
            </div>
            <input type="submit" class="btn btn-block btn-primary">
        </form>
    </div>
</body>
</html>

<%--                <label for="category">--%>
<%--                    <select id="category" name="id">--%>
<%--                        <c:forEach  items="${categories}" var="category">--%>
<%--                             <option value="${category.id}" > ${category}</option>--%>
<%--                            <h2>${category}</h2>--%>
<%--                         </c:forEach>--%>
<%--                 </select>--%>
<%--&lt;%&ndash;                </label>&ndash;%&gt;--%>
<%--<textarea id="category" name="category" class="form-control" type="text"></textarea>--%>
<%--<select id="category" name="id">--%>
<%--    <option value="1">clothing</option>--%>
<%--    <option value="2">vehicles</option>--%>
<%--    <option value="3">collectibles</option>--%>
<%--    <option value="4">pets</option>--%>
<%--    <option value="5">household</option>--%>
<%--    <option value="6">beauty</option>--%>
<%--    <option value="7">misc</option>--%>