<%@page import="DatabaseAccess.*"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.SQLException"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

    <%      
        Connection conn = null; 
        Statement stmt = null; 
        PreparedStatement pst = null;
        
        int mealTypeID = Integer.parseInt(request.getParameter("mealTypeID"));
        
        String query = "DELETE FROM MEAL_TYPE WHERE MEAL_TYPE_ID = ?";

        try {
        Utilities.conn.Open();
        pst = Utilities.conn.conn.prepareStatement(query);
        pst.setInt(1, mealTypeID);
        
        pst.executeUpdate();
        
        } catch(SQLException e) {
            e.printStackTrace();
        }
        Utilities.conn.CloseConn();
    %>