package jdbc.practise;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
//import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class ExecuteQueryTest {
	

	@Test
	public void executeQueryTest() throws Throwable
	{ 
		//register database
		Driver dref= new Driver();
		DriverManager.registerDriver(dref);
		
		//connect to database
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "root");
		
		//get statement 
		Statement stat = con.createStatement();
		
		//execute query
		ResultSet result = stat.executeQuery("select * from students_info;");
		
		//print
		while(result.next())
		{
			System.out.println(result.getInt(1)+"\t"+result.getString(2)+"\t"+result.getString(3));
		}
		
		//close
		con.close();
			
	
	}
	

}
