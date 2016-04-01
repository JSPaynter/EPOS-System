<%@page import="DatabaseAccess.*"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.SQLException"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

    <%//ITEM_ID, MEAL_ID, INGREDIENT_ID, STOCK_USED, PRODUCE_INGREDIENT
        Connection conn = null; 
        Statement stmt = null;
        PreparedStatement pst = null;        

        int mealID = Integer.parseInt(request.getParameter("mealID"));
        int ingredientID = Integer.parseInt(request.getParameter("ingredientID"));
        double stockUsed = Double.parseDouble(request.getParameter("stockUsed"));
        int produceIngredient = Integer.parseInt(request.getParameter("produceIngredient"));
        
        String query = "INSERT INTO MEAL_INGREDIENT (MEAL_ID, PRODUCE_ID, STOCK_USED, PRODUCE_INGREDIENT)"
                + "VALUES (?, ?, ?, ?)";

        try {
        Utilities.conn.Open();
        pst = Utilities.conn.conn.prepareStatement(query);
        pst.setInt(1, mealID);
        pst.setInt(2, ingredientID);
        pst.setDouble(3, stockUsed);
        pst.setInt(4, produceIngredient);
        pst.executeUpdate();
        Utilities.conn.CloseConn();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
    %>