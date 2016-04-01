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
        
        int staffID = Integer.parseInt(request.getParameter("staffID"));
        
        String query = "SELECT * FROM STAFF WHERE STAFF_ID = ?";

        try {
        Utilities.conn.Open();
        pst = Utilities.conn.conn.prepareStatement(query);
        pst.setInt(1, staffID);
        rset = pst.executeQuery();
        
        
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
    %>
            <% while(rset.next()){ %>
                <%= rset.getInt(1) %>break
                <%= rset.getString(2) %>break
                <%= rset.getString(3) %>break
                <%= rset.getString(4) %>break
                <%= rset.getString(5) %>break
                <%= rset.getString(6) %>break
                <%= rset.getInt(7) %>break
                <%= rset.getString(8) %>break
            <% }
        Utilities.conn.CloseConn(); %>