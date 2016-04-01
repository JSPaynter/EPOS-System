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
        
        int ingredientID = Integer.parseInt(request.getParameter("ingredientID"));
        int supplierID = Integer.parseInt(request.getParameter("supplierID"));
        String name = request.getParameter("name");
        double unitValue = Double.parseDouble(request.getParameter("unitValue"));
        double currentStock = Double.parseDouble(request.getParameter("currentStock"));
        double buyInLimit = Double.parseDouble(request.getParameter("buyInLimit"));
        double costPerUnit = Double.parseDouble(request.getParameter("costPerUnit"));
        
        String query = "UPDATE INGREDIENT SET SUPPLIER_ID = ?, NAME = ?,"
                + "UNIT_VALUE = ?, CURRENT_STOCK = ?, BUY_IN_LIMIT = ?,"
                + "COST_PER_UNIT = ? WHERE INGREDIENT_ID = ?";

        try {
        Utilities.conn.Open();
        pst = Utilities.conn.conn.prepareStatement(query);
        pst.setInt(1, supplierID);
        pst.setString(2, name);
        pst.setDouble(3, unitValue);
        pst.setDouble(4, currentStock);
        pst.setDouble(5, buyInLimit);
        pst.setDouble(6, costPerUnit);
        pst.setInt(7, ingredientID);

        pst.executeUpdate();
        
        } catch(SQLException e) {
            e.printStackTrace();
        }
        Utilities.conn.CloseConn();
    %>