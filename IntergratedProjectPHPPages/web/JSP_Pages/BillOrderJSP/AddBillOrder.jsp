<%@page import="DatabaseAccess.*"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.SQLException"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

    <%//ITEM_ID, BILL_ID, MEAL_ID, COMPLETE
        Connection conn = null; 
        Statement stmt = null;
        PreparedStatement pst = null;        

        int billID = Integer.parseInt(request.getParameter("billID"));
        int mealID = Integer.parseInt(request.getParameter("mealID"));
        int complete = Integer.parseInt(request.getParameter("complete"));
        int course = Integer.parseInt(request.getParameter("course"));
        
        String query = "INSERT INTO BILL_ORDER (BILL_ID, MEAL_ID, COMPLETE, COURSE) VALUES (?, ?, ?, ?)";

        try {
        Utilities.conn.Open();
        pst = Utilities.conn.conn.prepareStatement(query);
        pst.setInt(1, billID);
        pst.setInt(2, mealID);
        pst.setInt(3, complete);
        pst.setInt(4, course);
        pst.executeUpdate();
        Utilities.conn.CloseConn();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    %>