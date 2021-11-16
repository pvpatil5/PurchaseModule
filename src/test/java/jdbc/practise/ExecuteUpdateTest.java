package jdbc.practise;

import java.sql.Connection;

import java.sql.DriverManager;
//import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class ExecuteUpdateTest {
	@Test
	public void executeUpdateTest() throws Throwable
	{
		Connection con=null;
		try {
//			String expectedData="ram";
			
			Driver dref=new Driver();
			DriverManager.registerDriver(dref);
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "root");
			Statement stmt = con.createStatement();
			
			int res = stmt.executeUpdate("insert into students_info (regno, firstname, middlename, lastname) values('4', 'Akshay','kumar', 'h');");
			if(res==1)
			{
				System.out.println("Data is inserted into database.");
			}
			else {
				System.out.println("Data is not inserted into database.");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally
		{
			con.close();
		}
	}

}
