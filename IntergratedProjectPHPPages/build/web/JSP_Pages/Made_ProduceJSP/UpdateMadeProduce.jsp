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
        
        int madeProduceID = Integer.parseInt(request.getParameter("madeProduceID"));
        String name = request.getParameter("name");
        Double amountMade = Double.parseDouble(request.getParameter("amountMade"));
        
        String query = "UPDATE MADE_PRODUCE SET NAME = ?, AMOUNT_MADE = ?"
                + "WHERE MADE_PRODUCE_ID = ?";

        try {
        Utilities.conn.Open();
        pst = Utilities.conn.conn.prepareStatement(query);
        pst.setString(1, name);
        pst.setDouble(2, amountMade);
        pst.setInt(3, madeProduceID);
        pst.executeUpdate();
        
        } catch(SQLException e) {
            e.printStackTrace();
        }
        Utilities.conn.CloseConn();
    %>