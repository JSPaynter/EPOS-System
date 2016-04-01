package DatabaseAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleConnection {
    
    public static Connection conn = null;
    private static String userid = "JordanPaynter";
    private static String password = "ProjectDBAccess";
    private static String dbURL = "jdbc:oracle:thin:@larry.uopnet.plymouth.ac.uk:1521:ORCL";
    
    public static void Open() throws SQLException {
        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        conn = DriverManager.getConnection(dbURL, userid, password);       
    }
    
    public static void CloseConn() throws SQLException {
       conn.close();
    }

    public OracleConnection() { //constructor for connection class       
    }
}
