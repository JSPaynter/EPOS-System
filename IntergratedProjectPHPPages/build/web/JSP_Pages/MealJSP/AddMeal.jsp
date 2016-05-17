<%@page import="DatabaseAccess.*"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.SQLException"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

    <%//MEAL_ID, NAME, PRICE, DESCRIPTION, MEAL_TYPE_ID, MENU
        Connection conn = null; 
        Statement stmt = null;
        PreparedStatement pst = null;
        ResultSet rset = null;

        String name = request.getParameter("name");
        Double price = Double.parseDouble(request.getParameter("price"));
        String description = request.getParameter("description");
        int mealTypeID = Integer.parseInt(request.getParameter("mealTypeID"));
        int menu = Integer.parseInt(request.getParameter("menu"));
        
        String query = "INSERT INTO MEAL (NAME, PRICE, DESCRIPTION, MEAL_TYPE_ID, MENU)"
                + "VALUES (?, ?, ?, ?, ?)";

        try {
        Utilities.conn.Open();
        pst = Utilities.conn.conn.prepareStatement(query);
        pst.setString(1, name);
        pst.setDouble(2, price);
        pst.setString(3, description);
        pst.setInt(4, mealTypeID);
        pst.setInt(5, menu);
        pst.executeUpdate();
        Utilities.conn.CloseConn();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
        query = "SELECT MEAL_ID FROM MEAL WHERE NAME = ? AND PRICE = ? AND DESCRIPTION = ?";
        
        try {
        Utilities.conn.Open();
        pst = Utilities.conn.conn.prepareStatement(query);
        pst.setString(1, name);
        pst.setDouble(2, price);
        pst.setString(3, description);
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