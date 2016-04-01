<%@page import="java.sql.Date"%>
<%@page import="java.time.LocalDate"%>
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
        
        int mealID = Integer.parseInt(request.getParameter("mealID"));
        int menu = Integer.parseInt("menu");
        
        String query = "UPDATE MEAL SET MENU = ? WHERE MEAL_ID = ?";

        try {
        Utilities.conn.Open();
        pst = Utilities.conn.conn.prepareStatement(query);
        pst.setInt(1, menu);
        pst.setInt(2, mealID);

        pst.executeUpdate();
        
        } catch(SQLException e) {
            e.printStackTrace();
        }
        Utilities.conn.CloseConn();
    %>