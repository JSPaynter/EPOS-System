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
        
        int orderID = Integer.parseInt(request.getParameter("orderID")); 
        int supplierID = Integer.parseInt(request.getParameter("supplierID"));
        int noOfItems = Integer.parseInt(request.getParameter("noOfItems"));
        double total = Double.parseDouble(request.getParameter("total"));
        int cancelled = Integer.parseInt(request.getParameter("cancelled"));
        Date dateEstimateArrival = Utilities.DateConverter(LocalDate.parse(request.getParameter("dateEstimateArrival")));
        
        String query = "UPDATE ORDERS SET SUPPLIER_ID = ?, NO_OF_ITEMS = ?,"
                + "TOTAL = ?, CANCELLED = ?, DATE_ESTIMATE_ARRIVAL = ? WHERE ORDER_ID = ?";

        try {
        Utilities.conn.Open();
        pst = Utilities.conn.conn.prepareStatement(query);
        pst.setInt(1, supplierID);
        pst.setInt(2, noOfItems);
        pst.setDouble(3, total);
        pst.setInt(4, cancelled);
        pst.setDate(5, dateEstimateArrival);
        pst.setInt(6, orderID);

        pst.executeUpdate();
        
        } catch(SQLException e) {
            e.printStackTrace();
        }
        Utilities.conn.CloseConn();
    %>