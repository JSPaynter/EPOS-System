<%@page import="DatabaseAccess.*"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.SQLException"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

    <%//MEAL_TYPE_ID, MEAL_TYPE
        Connection conn = null; 
        Statement stmt = null;
        PreparedStatement pst = null;
        
        String mealType = (request.getParameter("mealType"));
        String query = "INSERT INTO MEAL_TYPE (MEAL_TYPE) VALUES (?)";

        try {
        Utilities.conn.Open();
        pst = Utilities.conn.conn.prepareStatement(query);
        pst.setString(1, mealType);        

        pst.executeUpdate();
        
        } catch(SQLException e) {
            e.printStackTrace();
        }
        Utilities.conn.CloseConn();
    %>