<%@page import="DatabaseAccess.*"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.SQLException"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

    <%//MADE_INGREDIENT_ID, MADE_PRODUCE_ID, INGREDIENT_ID, STOCK_USED
        Connection conn = null; 
        Statement stmt = null;
        PreparedStatement pst = null;        

        int madeProduceID = Integer.parseInt(request.getParameter("madeProduceID"));
        int ingredientID = Integer.parseInt(request.getParameter("ingredientID"));
        double stockUsed = Double.parseDouble(request.getParameter("stockUsed"));
        
        String query = "INSERT INTO MADE_INGREDIENT (MADE_PRODUCE_ID, INGREDIENT_ID, STOCK_USED)"
                + "VALUES (?, ?, ?)";

        try {
        Utilities.conn.Open();
        pst = Utilities.conn.conn.prepareStatement(query);
        pst.setInt(1, madeProduceID);
        pst.setInt(2, ingredientID);
        pst.setDouble(3, stockUsed);
        pst.executeUpdate();
        Utilities.conn.CloseConn();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    %>