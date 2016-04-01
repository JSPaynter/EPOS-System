<%@page import="DatabaseAccess.*"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.time.*"%>
<%@page import="java.util.Date"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

    <%//ORDER_ID, SUPPLIER_ID, NO_OF_ITEMS, TOTAL, DATE_ORDERED, DATE_ARRIVAL, ARRIVED, CANCELLED, DATE_ESTIMATE_ARRIVAL
        Connection conn = null; 
        Statement stmt = null;
        PreparedStatement pst = null;
        ResultSet rset = null;

        int supplierID = Integer.parseInt(request.getParameter("supplierID"));
        int noOfItems = Integer.parseInt(request.getParameter("noOfItems"));
        double total = Double.parseDouble(request.getParameter("total"));
        java.sql.Date dateEstimateArrival = Utilities.DateConverter(LocalDate.parse(request.getParameter("dateEstimateArrival")));
        
        String query = "INSERT INTO ORDERS (SUPPLIER_ID, NO_OF_ITEMS, TOTAL, DATE_ESTIMATE_ARRIVAL)"
                + "VALUES (?, ?, ?, ?)";

        try {
        Utilities.conn.Open();
        pst = Utilities.conn.conn.prepareStatement(query);
        pst.setInt(1, supplierID);
        pst.setDouble(2, noOfItems);
        pst.setDouble(3, total);
        pst.setDate(4, dateEstimateArrival);
        pst.executeUpdate();
        Utilities.conn.CloseConn();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
        query = "SELECT ORDER_ID FROM ORDERS WHERE SUPPLIER_ID = ? AND NO_OF_ITEMS = ? AND TOTAL = ? AND DATE_ESTIMATE_ARRIVAL = ?";
        
        try {
        Utilities.conn.Open();
        pst = Utilities.conn.conn.prepareStatement(query);
        pst.setInt(1, supplierID);
        pst.setInt(2, noOfItems);
        pst.setDouble(3, total);
        pst.setDate(4, dateEstimateArrival);
        rset = pst.executeQuery();
        
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
            %>
            <% while(rset.next()){ %>
                <%= rset.getInt(1) %>break
            <% }

        Utilities.conn.CloseConn();
        
    %>