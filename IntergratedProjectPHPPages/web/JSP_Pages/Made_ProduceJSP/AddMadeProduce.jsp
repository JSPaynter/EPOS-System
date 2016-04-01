<%@page import="DatabaseAccess.*"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.SQLException"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

    <%//MADE_PRODUCE_ID, NAME, AMOUNT_MADE
        Connection conn = null; 
        Statement stmt = null;
        ResultSet rset = null;
        PreparedStatement pst = null;        

        String name = (request.getParameter("name"));
        double amountMade = Double.parseDouble(request.getParameter("amountMade")); 
       
        String query = "INSERT INTO MADE_PRODUCE (NAME, AMOUNT_MADE) VALUES (?, ?)";

        try {
        Utilities.conn.Open();
        pst = Utilities.conn.conn.prepareStatement(query);
        pst.setString(1, name);
        pst.setDouble(2, amountMade);
        pst.executeUpdate();
        Utilities.conn.CloseConn();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
        query = "SELECT MADE_PRODUCE_ID FROM MADE_PRODUCE WHERE NAME = ? AND AMOUNT_MADE = ?";
        
        try {
        Utilities.conn.Open();
        pst = Utilities.conn.conn.prepareStatement(query);
        pst.setString(1, name);
        pst.setDouble(2, amountMade);
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