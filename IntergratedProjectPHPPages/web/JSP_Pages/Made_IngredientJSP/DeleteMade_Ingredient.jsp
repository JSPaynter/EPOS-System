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
        
        String query = "DELETE FROM MADE_INGREDIENT WHERE MADE_INGREDIENT_ID = ?";

        try {
        Utilities.conn.Open();
        pst = Utilities.conn.conn.prepareStatement(query);
        pst.setInt(1, madeIngredientID);
        
        pst.executeUpdate();
        
        } catch(SQLException e) {
            e.printStackTrace();
        }
        Utilities.conn.CloseConn();
    %>