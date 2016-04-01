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
        
        int staffID = Integer.parseInt(request.getParameter("staffID")); 
        String password = request.getParameter("password");
        String salt = request.getParameter("salt");
        
        String query = "UPDATE STAFF SET PASSWORD = ?, SALT = ? WHERE STAFF_ID = ?";

        try {
        Utilities.conn.Open();
        pst = Utilities.conn.conn.prepareStatement(query);
        pst.setString(1, password);
        pst.setString(2, salt);
        pst.setInt(3, staffID);
        
        pst.executeUpdate();
        
        } catch(SQLException e) {
            e.printStackTrace();
        }
        Utilities.conn.CloseConn();
    %>