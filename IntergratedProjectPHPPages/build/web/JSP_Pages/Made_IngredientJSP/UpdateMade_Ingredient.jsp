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
        int madeProduceID = Integer.parseInt(request.getParameter("madeProduceID"));
        int ingredientID = Integer.parseInt(request.getParameter("ingredientID"));
        double stockUsed = Double.parseDouble(request.getParameter("stockUsed"));
        
        String query = "UPDATE MADE_INGREDIENT SET MADE_PRODUCE_ID = ?, INGREDIENT_ID = ?,"
                + "STOCK_USED = ? WHERE MADE_INGREDIENT_ID = ?";

        try {
        Utilities.conn.Open();
        pst = Utilities.conn.conn.prepareStatement(query);
        pst.setInt(1, madeProduceID);
        pst.setInt(2, ingredientID);
        pst.setDouble(3, stockUsed);
        pst.setInt(4, madeIngredientID);

        pst.executeUpdate();
        
        } catch(SQLException e) {
            e.printStackTrace();
        }
        Utilities.conn.CloseConn();
    %>