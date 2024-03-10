import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnectionGhafari {
   static Connection connection = null;

   static void getDBConnection() {
      System.out.println("-------- MySQL JDBC Connection Testing ------------");
      try {
         Class.forName("com.mysql.cj.jdbc.Driver");
      } catch (ClassNotFoundException e) {
         System.out.println("Where is your MySQL JDBC Driver?");
         e.printStackTrace();
         return;
      }
      System.out.println("MySQL JDBC Driver Registered!");

      connection = null;
      try {
         UtilPropGhafari.loadProperty();
         connection = DriverManager.getConnection(getURL(), getUserName(), getPassword());
      } catch (Exception e) {
         System.out.println("Connection Failed! Check output console");
         e.printStackTrace();
         return;
      }

      if (connection != null) {
         System.out.println("You made it, take control your database now!");
      } else {
         System.out.println("Failed to make connection!");
      }
   }

   static String getURL() {
      String url = UtilPropGhafari.getProp("url");
      System.out.println("[DBG] URL\t    :\t" + url);
      return url;
   }

   static String getUserName() {
      String usr = UtilPropGhafari.getProp("user");
      System.out.println("[DBG] User Name     :\t" + usr);
      return usr;
   }

   static String getPassword() {
      String pwd = UtilPropGhafari.getProp("password");
      System.out.println("[DBG] User Password :\t" + pwd);
      return pwd;
   }
}
