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

        int tableNo = Integer.parseInt(request.getParameter("tableNo"));
        
        String query = "INSERT INTO BILL (TABLENO) VALUES (?)";

        try {
        Utilities.conn.Open();
        pst = Utilities.conn.conn.prepareStatement(query);
        pst.setInt(1, tableNo);
        pst.executeUpdate();
        Utilities.conn.CloseConn();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
        query = "SELECT BILL_ID FROM BILL WHERE TABLENO = ? AND ACTIVE = 1";

        try {
        Utilities.conn.Open();
        pst = Utilities.conn.conn.prepareStatement(query);
        pst.setInt(1, tableNo);
        rset = pst.executeQuery();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    %>
            <% while(rset.next()){ %>
                <%= rset.getInt(1) %>break
            <% }
        Utilities.conn.CloseConn(); %>