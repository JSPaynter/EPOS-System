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
        ResultSet rset = null;
        PreparedStatement pst = null;
        
        String query = "SELECT * FROM ORDERS";

        try {
        Utilities.conn.Open();
        pst = Utilities.conn.conn.prepareStatement(query);
        rset = pst.executeQuery();
        
        
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
    %>
            <% while(rset.next()){ %>
                <%= rset.getInt(1) %>break
                <%= rset.getInt(2) %>break
                <%= rset.getInt(3) %>break
                <%= rset.getDouble(4) %>break
                <%= rset.getDate(5) %>break
                <%= rset.getDate(6) %>break
                <%= rset.getInt(7) %>break
                <%= rset.getInt(8) %>break
                <%= rset.getDate(9) %>break
            <% }
        Utilities.conn.CloseConn(); %>