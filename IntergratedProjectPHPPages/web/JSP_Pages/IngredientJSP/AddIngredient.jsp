<%@page import="DatabaseAccess.*"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.SQLException"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

    <%//INGREDIENT_ID, SUPPLIER_ID, NAME, UNIT_VALUE, CURRENT_STOCK, BUY_IN_LIMIT, COST_PER_UNIT
        Connection conn = null; 
        Statement stmt = null;
        PreparedStatement pst = null;        

        int supplierID = Integer.parseInt(request.getParameter("supplierID"));
        String name = (request.getParameter("name"));
        double unitValue = Double.parseDouble(request.getParameter("unitValue"));
        double buyInLimit = Double.parseDouble(request.getParameter("buyInLimit"));
        double costPerUnit = Double.parseDouble(request.getParameter("costPerUnit"));
        
        String query = "INSERT INTO INGREDIENT (SUPPLIER_ID, NAME, UNIT_VALUE,"
                + "BUY_IN_LIMIT, COST_PER_UNIT)"
                + "VALUES (?, ?, ?, ?, ?)";

        try {
        Utilities.conn.Open();
        pst = Utilities.conn.conn.prepareStatement(query);
        pst.setInt(1, supplierID);
        pst.setString(2, name);
        pst.setDouble(3, unitValue);
        pst.setDouble(4, buyInLimit);
        pst.setDouble(5, costPerUnit);
        
        pst.executeUpdate();
        Utilities.conn.CloseConn();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
    %>