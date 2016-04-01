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
        
        String query = "SELECT * FROM MEAL_INGREDIENT";

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
                <%= rset.getInt(5) %>break
                <%= rset.getInt(6) %>break
            <% }
        Utilities.conn.CloseConn(); %>