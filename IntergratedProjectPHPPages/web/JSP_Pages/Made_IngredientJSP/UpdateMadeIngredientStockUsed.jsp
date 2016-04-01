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
        
        int madeIngredientID = Integer.parseInt(request.getParameter("madeIngredientID"));
        double stockUsed = Double.parseDouble(request.getParameter("stockUsed"));
        
        String query = "UPDATE MADE_INGREDIENT SET STOCK_USED = ? WHERE MADE_INGREDIENT_ID = ?";

        try {
        Utilities.conn.Open();
        pst = Utilities.conn.conn.prepareStatement(query);
        pst.setDouble(1, stockUsed);
        pst.setInt(2, madeIngredientID);

        pst.executeUpdate();
        
        } catch(SQLException e) {
            e.printStackTrace();
        }
        Utilities.conn.CloseConn();
    %>