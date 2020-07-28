<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%
    String driver = "com.mysql.jdbc.Driver";
    String connectionUrl = "jdbc:mysql://localhost:3306/";
    String database = "student";
    String userid = "root";
    String password = "";
    String searchedAd = request.getParameter("search_ads");
    try {
        Class.forName(driver);
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }
    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;
%>
<!DOCTYPE html>
<html>
<body>
<h1>Search Data</h1>
<table border="1">
    <tr>
        <td>Name</td>
        <td>Email Id</td>
        <td>Roll No</td>
    </tr>
    <%
        try{
            connection = DriverManager.getConnection(connectionUrl+database, userid, password);
            statement=connection.createStatement();
            String sql ="select * from ads where searchedAd="+searchedAd+"' ";
            resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
    %>
    <tr>
        <td><%=resultSet.getString("title") %></td>
        <td><%=resultSet.getString("description") %></td>

    </tr>
    <%
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    %>
</table>
</body>
</html>