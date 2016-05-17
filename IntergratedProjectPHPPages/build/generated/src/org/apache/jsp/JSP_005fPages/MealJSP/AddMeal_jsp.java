package org.apache.jsp.JSP_005fPages.MealJSP;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import DatabaseAccess.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;

public final class AddMeal_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    ");
//MEAL_ID, NAME, PRICE, DESCRIPTION, MEAL_TYPE_ID, MENU
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
        
        query = "SELECT MEAL_ID FROM MEAL WHERE NAME = ?, PRICE = ?, DESCRIPTION = ?";
        
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
        
        
      out.write("\n");
      out.write("            ");
 while(rset.next()){ 
      out.write("\n");
      out.write("                ");
      out.print( rset.getInt(1) );
      out.write("break\n");
      out.write("            ");
 }

            Utilities.conn.CloseConn();

    
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
