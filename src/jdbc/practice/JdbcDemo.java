package jdbc.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcDemo 
{
	public static void main(String[] args) throws SQLException  
	{
		JdbcDemo j =new JdbcDemo();
		j.retriveData();
		//j.insertData();
		//j.updateData();
		//j.deleteData();
	}

	private void retriveData() throws SQLException  
	{
		/*
		 * import the package 
		 * load and register the driver
		 * establish the connection
		 * create a statement or query
		 * excute the query
		 * process the result
		 * close
		 */
		String url="jdbc:mysql://localhost:3306/tcs";
		String uname="root";
		String password="root";
		String query="select * from employee";
		
		Connection c =DriverManager.getConnection(url,uname,password);
		Statement st=c.createStatement();
		ResultSet rs=st.executeQuery(query);
		
		while(rs.next())
		{
			String user=rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3);
			System.out.println(user);
		}
		c.close();
		st.close();
	
	}
	
	
	private void insertData() throws SQLException 
	{
		String url="jdbc:mysql://localhost:3306/tcs";
		String uname="root";
		String password="root";
		String query="insert into employee value(4,'ragu','madurai')";
		
		Connection c =DriverManager.getConnection(url,uname,password);
		Statement st=c.createStatement();
		int rows =st.executeUpdate(query);
		
			System.out.println("number of rows:"+rows);
		c.close();
		st.close();
		
	}
	
	
	
	private void updateData() throws SQLException 
	{
		String url="jdbc:mysql://localhost:3306/tcs";
		String uname="root";
		String password="root";
		String query="update employee set salary=20000 where id=1";
		
		Connection c =DriverManager.getConnection(url,uname,password);
		Statement st=c.createStatement();
		int rows =st.executeUpdate(query);
		
			System.out.println("number of rows affect:"+rows);
		c.close();
		st.close();
	}
	
	
		private void deleteData() throws SQLException 
		{
			String url="jdbc:mysql://localhost:3306/tcs";
			String uname="root";
			String password="root";
			int id=5;
			String query="delete from employee where name='ragu'";
			
			Connection c =DriverManager.getConnection(url,uname,password);
			Statement st=c.createStatement();
			int rows =st.executeUpdate(query);
			
				System.out.println("number of rows delete affect:"+rows);
			c.close();
			st.close();
	}

}
