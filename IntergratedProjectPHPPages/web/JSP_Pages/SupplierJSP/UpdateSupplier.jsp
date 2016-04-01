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
        
        int supplierID = Integer.parseInt(request.getParameter("supplierID")); 
        String supplierName = request.getParameter("supplierName");
        String address1 = request.getParameter("address1");
        String address2 = request.getParameter("address2");
        String city = request.getParameter("city");
        String postcode = request.getParameter("postcode");
        String phoneNo = request.getParameter("phoneNo");
        String email = request.getParameter("email");
        
        String query = "UPDATE SUPPLIER SET SUPPLIER_NAME = ?, ADDRESS1 = ?,"
                + "ADDRESS2 = ?, CITY = ?, POSTCODE = ?, PHONE_NO = ?,"
                + "EMAIL = ? WHERE SUPPLIER_ID = ?";

        try {
        Utilities.conn.Open();
        pst = Utilities.conn.conn.prepareStatement(query);
        pst.setString(1, supplierName);
        pst.setString(2, address1);
        pst.setString(3, address2);
        pst.setString(4, city);
        pst.setString(5, postcode);
        pst.setString(6, phoneNo);
        pst.setString(7, email);
        pst.setInt(8, supplierID);
        
        pst.executeUpdate();
        
        } catch(SQLException e) {
            e.printStackTrace();
        }
        Utilities.conn.CloseConn();
    %>