package utilities;

import java.sql.DriverManager;

import static java.lang.Class.forName;

public class manageDB extends commonOps
{
   public static void initConnection(String dbURL, String user, String pass)
   {
       try
       {
           Class.forName("com.mysql.jdbc.Driver");
           con = DriverManager.getConnection(dbURL , user, pass);
           stmt = con.createStatement();


       }
       catch (Exception e)
       {
           System.out.println("error to connect DB "+e);
       }

   }

   public static void closeConection()
   {
       try
       {
           con.close();
       }
       catch (Exception e)
       {
           System.out.println("error to close DB "+e);
       }

   }


}
