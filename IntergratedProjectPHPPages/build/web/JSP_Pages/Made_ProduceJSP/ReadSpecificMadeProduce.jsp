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
        
        int produceID = Integer.parseInt(request.getParameter("produceID"));
        
        String query = "SELECT * FROM MADE_PRODUCE WHERE MADE_PRODUCE_ID = ?";

        try {
        Utilities.conn.Open();
        pst = Utilities.conn.conn.prepareStatement(query);
        pst.setInt(1, produceID);
        rset = pst.executeQuery();
        
        
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
    %>
            <% while(rset.next()){ %>
                <%= rset.getInt(1) %>break
                <%= rset.getString(2) %>break
                <%= rset.getDouble(3) %>break
            <% }
        Utilities.conn.CloseConn(); %>