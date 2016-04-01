<%@page import="DatabaseAccess.*"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.SQLException"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

    <%//STAFF_ID, FIRST_NAME, SURNAME, PHONE_NUMBER, EMAIL, PASSWORD, MANAGER
        Connection conn = null; 
        Statement stmt = null;
        PreparedStatement pst = null;        

        String firstName = request.getParameter("firstName");
        String surname = request.getParameter("surname");
        String phoneNo = request.getParameter("phoneNo");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        int manager = Integer.parseInt(request.getParameter("manager"));
        String salt = request.getParameter("salt");
        
        String query = "INSERT INTO STAFF (FIRST_NAME, SURNAME, PHONE_NUMBER, EMAIL, PASSWORD, MANAGER, SALT)"
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
        Utilities.conn.Open();
        pst = Utilities.conn.conn.prepareStatement(query);
        pst.setString(1, firstName);
        pst.setString(2, surname);
        pst.setString(3, phoneNo);
        pst.setString(4, email);
        pst.setString(5, password);
        pst.setInt(6, manager);
        pst.setString(7, salt);
        pst.executeUpdate();
        Utilities.conn.CloseConn();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
    %>