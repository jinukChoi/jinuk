package db.beans;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
   public static Connection getConnection() throws Exception{
      System.out.println("DB����õ�");
      Class.forName("oracle.jdbc.driver.OracleDriver");
      return DriverManager.
      getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","wlsdnr12");
   }
}