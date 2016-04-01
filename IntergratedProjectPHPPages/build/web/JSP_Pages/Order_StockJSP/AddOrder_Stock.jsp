<%@page import="DatabaseAccess.*"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.SQLException"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

    <%//ITEM_ID, ORDER_ID, INGREDIENT_ID, UNIT_AMOUNT
        Connection conn = null; 
        Statement stmt = null;
        PreparedStatement pst = null;        

        int orderID = Integer.parseInt(request.getParameter("orderID"));
        int ingredientID = Integer.parseInt(request.getParameter("ingredientID"));
        double unitAmount = Double.parseDouble(request.getParameter("unitAmount"));
        
        
        String query = "INSERT INTO ORDER_STOCK (ORDER_ID, INGREDIENT_ID, UNIT_AMOUNT) VALUES (?, ?, ?)";

        try {
        Utilities.conn.Open();
        pst = Utilities.conn.conn.prepareStatement(query);
        pst.setInt(1, orderID);
        pst.setInt(2, ingredientID);
        pst.setDouble(3, unitAmount);
        pst.executeUpdate();
        Utilities.conn.CloseConn();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
    %>