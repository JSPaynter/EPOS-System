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
        
        int billID = Integer.parseInt(request.getParameter("billID"));
        int noOfItems = Integer.parseInt(request.getParameter("noOfItems"));
        double total = Double.parseDouble(request.getParameter("total"));
        double paidCash = Double.parseDouble(request.getParameter("cash"));
        double paidCard = Double.parseDouble(request.getParameter("card"));
        
        String query = "UPDATE BILL SET NO_OF_ITEMS = ?,"
                + "TOTAL = ?, PAIDCASH = ?, PAIDCARD = ? WHERE BILL_ID = ?";

        try {
        Utilities.conn.Open();
        pst = Utilities.conn.conn.prepareStatement(query);
        
        pst.setInt(1, noOfItems);
        pst.setDouble(2, total);
        pst.setDouble(3, paidCash);
        pst.setDouble(4, paidCard);
        pst.setInt(5, billID);        
        
        pst.executeUpdate();
        
        } catch(SQLException e) {
            e.printStackTrace();
        }
        Utilities.conn.CloseConn();
    %>