package org.apache.jsp.JSP_005fPages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import java.net.HttpURLConnection;
import java.io.DataOutputStream;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import DatabaseAccess.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;

public final class AddBillAndOrder_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("    ");
      
        Connection conn = null;
        Statement stmt = null;
        PreparedStatement pst = null;
        ResultSet rset = null;
        int billID = 0;
        String billURL = "/JSP_Pages/BillJSP/AddBill.jsp";
        String billOrderURL = "/JSP_Pages/BillOrderJSP/AddBillOrder.jsp";
        
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
    
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
