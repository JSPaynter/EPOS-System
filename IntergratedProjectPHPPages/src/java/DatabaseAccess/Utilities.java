package DatabaseAccess;

import java.util.Date;
import java.time.*;

public class Utilities {
    
    public static OracleConnection conn = new OracleConnection();
    
    static public java.sql.Date DateConverter(LocalDate localdate) {
        
        Date utildate = Date.from(localdate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        java.sql.Date sqldate = new java.sql.Date(utildate.getTime());
        return sqldate;
    }
    
}
