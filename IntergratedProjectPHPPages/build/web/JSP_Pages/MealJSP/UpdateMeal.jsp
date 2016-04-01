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
        String name = request.getParameter("name");
        Double price = Double.parseDouble(request.getParameter("price"));
        String description = request.getParameter("description");
        int mealTypeID = Integer.parseInt(request.getParameter("mealTypeID"));
        int menu = Integer.parseInt(request.getParameter("menu"));
        
        String query = "UPDATE MEAL SET NAME = ?, PRICE = ?, DESCRIPTION = ?,"
                + "MEAL_TYPE_ID = ?, MENU = ? WHERE MEAL_ID = ?";

        try {
        Utilities.conn.Open();
        pst = Utilities.conn.conn.prepareStatement(query);
        pst.setString(1, name);
        pst.setDouble(2, price);
        pst.setString(3, description);
        pst.setInt(4, mealTypeID);
        pst.setInt(5, menu);
        pst.setInt(6, mealID);

        pst.executeUpdate();
        
        } catch(SQLException e) {
            e.printStackTrace();
        }
        Utilities.conn.CloseConn();
    %>