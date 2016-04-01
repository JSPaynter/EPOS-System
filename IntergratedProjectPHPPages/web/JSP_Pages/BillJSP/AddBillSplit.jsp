<%@page import="DatabaseAccess.*"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.SQLException"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

    <%//BILL_ID, BILL_DATE, NO_OF_ITEMS, TOTAL, TABLENO, ACTIVE
        Connection conn = null; 
        Statement stmt = null;
        PreparedStatement pst = null; 
        ResultSet rset = null;

        int noItems = Integer.parseInt(request.getParameter("noOfItems"));
        double total = Double.parseDouble(request.getParameter("total"));
        int tableNo = Integer.parseInt(request.getParameter("tableNo"));
        double cash = Double.parseDouble(request.getParameter("cash"));
        double card = Double.parseDouble(request.getParameter("card"));        
        
        String query = "INSERT INTO BILL (NO_OF_ITEMS, TOTAL, TABLENO, ACTIVE, PAIDCASH, PAIDCARD) VALUES ( ?, ?, ?, ?, ?, ?)";

        try {
        Utilities.conn.Open();
        pst = Utilities.conn.conn.prepareStatement(query);
        pst.setInt(1, noItems);
        pst.setDouble(2, total);
        pst.setInt(3, tableNo);
        pst.setInt(4, 0);
        pst.setDouble(5, cash);
        pst.setDouble(6, card);
        pst.executeUpdate();
        Utilities.conn.CloseConn();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
        query = "SELECT BILL_ID FROM BILL WHERE NO_OF_ITEMS = ? AND TOTAL = ? AND TABLENO = ? AND ACTIVE = 0 AND PAIDCASH = ? AND PAIDCARD = ?";

        try {
        Utilities.conn.Open();
        pst = Utilities.conn.conn.prepareStatement(query);
        pst.setInt(1, noItems);
        pst.setDouble(2, total);
        pst.setInt(3, tableNo);
        pst.setDouble(4, cash);
        pst.setDouble(5, card);
        rset = pst.executeQuery();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    %>
            <% while(rset.next()){ %>
                <%= rset.getInt(1) %>break
            <% }
        Utilities.conn.CloseConn(); %>