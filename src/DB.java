import java.sql.Connection;
import java.sql.DriverManager;

//import javax.swing.*;
public class DB {
	Connection con = null;
	java.sql.PreparedStatement pst;
	public static Connection dbconnect()
	{
		try {
			String url = "jdbc:mysql://127.0.0.1:3306/libsignup";
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url,"root","");
			//System.out.println("Connected");
			return conn;
		}
		catch(Exception e ) {
			System.out.println(e);
			return null;
			
		}
	}

}
