package Ecommerce;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class jdbc {
	public static Connection getCon() throws SQLException
	{
		
		String url = "jdbc:mysql://localhost:3306/jdbc";

        String username = "root";

        String pwd = "root";

        

//        String query = "select * from employee";

        try

        {

        Connection con = DriverManager.getConnection(url, username, pwd);//since connection is interface, drivermanager class will create object and return the object to connection

        return con;

        }

        catch(Exception e)

        {

            System.out.println(e);

            return null;

        }



	}

}
