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
        String firstName = request.getParameter("firstName");
        String surname = request.getParameter("surname");
        String phoneNo = request.getParameter("phoneNo");
        String email = request.getParameter("email");
        int manager = Integer.parseInt(request.getParameter("manager"));
        
        String query = "UPDATE STAFF SET FIRST_NAME = ?, SURNAME = ?,"
                + "PHONE_NUMBER = ?, EMAIL = ?, MANAGER = ?"
                + "WHERE STAFF_ID = ?";

        try {
        Utilities.conn.Open();
        pst = Utilities.conn.conn.prepareStatement(query);
        pst.setString(1, firstName);
        pst.setString(2, surname);
        pst.setString(3, phoneNo);
        pst.setString(4, email);
        pst.setInt(5, manager);
        pst.setInt(6, staffID);
        
        pst.executeUpdate();
        
        } catch(SQLException e) {
            e.printStackTrace();
        }
        Utilities.conn.CloseConn();
    %>