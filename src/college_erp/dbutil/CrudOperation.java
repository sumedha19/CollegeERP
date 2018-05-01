package college_erp.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CrudOperation {

	private static Connection con=null;
	private static ResultSet rs=null;
	private static PreparedStatement ps=null;
	
	public static Connection createConnection()
	{
		
		try
		{
			
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/college_erp","root","root");
			
		}
		
		catch(SQLException|ClassNotFoundException e)
		{
			System.out.println(e);
		}
		return con;
	}
public static ResultSet getData(String str,String userid)
	
	{
		con=createConnection();
		try{
			
			
			ps=con.prepareStatement(str);//query dbms and gets complied
			
			ps.setString(1,userid);
			
			
			rs=ps.executeQuery();
		}
		catch(SQLException se)
		{
			
		System.out.println(se);	
		}
		
		return rs;
		
	}
	

	
public static ResultSet getValue(String str)

{
	con=createConnection();
	try{
		
		
		ps=con.prepareStatement(str);//query dbms and gets conplied
		
	
		
		
		rs=ps.executeQuery();
	}
	catch(SQLException se)
	{
		
	System.out.println(se);	
	}
	
	return rs;
	
}

}


