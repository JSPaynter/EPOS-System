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
        
        int itemID = Integer.parseInt(request.getParameter("itemID"));
        int billID = Integer.parseInt(request.getParameter("billID"));
        int mealID = Integer.parseInt(request.getParameter("mealID"));
        
        String query = "UPDATE BILL_ORDER SET BILL_ID = ?, MEAL_ID = ?"
                + "WHERE ITEM_ID = ?";

        try {
        Utilities.conn.Open();
        pst = Utilities.conn.conn.prepareStatement(query);
        pst.setInt(1, billID);
        pst.setInt(2, mealID);
        pst.setInt(3, itemID);


        pst.executeUpdate();
        
        } catch(SQLException e) {
            e.printStackTrace();
        }
        Utilities.conn.CloseConn();
    %>