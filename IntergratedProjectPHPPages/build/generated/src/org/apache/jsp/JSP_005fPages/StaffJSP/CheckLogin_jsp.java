package org.apache.jsp.JSP_005fPages.StaffJSP;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import DatabaseAccess.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;

public final class CheckLogin_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      
        Connection conn = null; 
        Statement stmt = null; 
        ResultSet rset = null;
        PreparedStatement pst = null;
        
        int staffID = 61;//Integer.parseInt(request.getParameter("staffID"));
        
        String query = "SELECT * FROM STAFF WHERE STAFF_ID = ?";

        try {
        Utilities.conn.Open();
        pst = Utilities.conn.conn.prepareStatement(query);
        pst.setInt(1, staffID);
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
      out.write("                ");
      out.print( rset.getString(2) );
      out.write("break\n");
      out.write("                ");
      out.print( rset.getString(3) );
      out.write("break\n");
      out.write("                ");
      out.print( rset.getString(4) );
      out.write("break\n");
      out.write("                ");
      out.print( rset.getString(5) );
      out.write("break\n");
      out.write("                ");
      out.print( rset.getString(6) );
      out.write("break\n");
      out.write("                ");
      out.print( rset.getInt(7) );
      out.write("break\n");
      out.write("                ");
      out.print( rset.getString(8) );
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
