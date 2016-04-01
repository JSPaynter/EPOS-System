<%@page import="java.util.List"%>
<%@page import="java.net.HttpURLConnection"%>
<%@page import="java.io.DataOutputStream"%>
<%@page import="java.net.URL"%>
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
        ResultSet rset = null;
        int billID = 0;
        String billURL = "/IntergratedProjectPHPPages/JSP_Pages/BillJSP/AddBill.jsp";
        String billOrderURL = "/IntergratedProjectPHPPages/JSP_Pages/BillOrderJSP/AddBillOrder.jsp";
        
        String noItems = "1";//request.getParameter("noOfItems");
        String total = "15.95";//(request.getParameter("total");
        String tableNo = "5";//(request.getParameter("tableNo");
        String[] mealID = {"22"};//(String[])request.getParameterValues("mealID");        
        
        RequestDispatcher request1 = request.getRequestDispatcher(billURL);
        RequestDispatcher request2 = request.getRequestDispatcher(billOrderURL);
        
        request.setAttribute("noItems", noItems);
        request.setAttribute("total", total);
        request.setAttribute("tableNo", tableNo);
        request1.forward(request, response); //not putting value in database
        String getBillID = "SELECT BILL_ID FROM BILL WHERE TABLENO = ? AND ACTIVE = 1"; //get active bill for id

        try {
        Utilities.conn.Open();
        pst = Utilities.conn.conn.prepareStatement(getBillID);
        pst.setInt(1, Integer.parseInt(tableNo));
        rset = pst.executeQuery();
        
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
        while (rset.next()) { //set bill id
            billID = rset.getInt(0); //doesn't recieve a value
        }
        Utilities.conn.CloseConn();
        
        //for(String id : mealID) { //insert each meal into the order
            request.setAttribute("mealID", Integer.parseInt(mealID[0]));
            request2.forward(request, response); //need a new request for each meal or some way to clear it
        //}
    %>