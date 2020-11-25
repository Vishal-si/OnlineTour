package ConnectionManagement;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionClass 
{
	  Connection conn;
	
	public ConnectionClass()
	{
		conn = null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			conn= DriverManager.getConnection("jdbc:mysql://localhost:3307/onlinetour","root","root");		
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
			System.out.println(this.getClass().getName());
		}
	}
	public Connection getConn()
	{
		return conn;
	}
	
}
