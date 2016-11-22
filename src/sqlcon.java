
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.jdbc.PreparedStatement;
public class sqlcon{ 
	public String[] inputs=new String[100];
	public String[] passwords=new String[100];
	public int[] slot_no=new int[100];
	static Connection c;
	static Statement s;
	
	public void update_sn(String id,int sn)
	{
		try
		{
		String sql = "update user_info set sn = ? where id = ? ";
		  java.sql.PreparedStatement sm=c.prepareStatement(sql);
		  sm.setInt(1,sn);
		  sm.setString(2,id);
		  sm.executeUpdate();
		}
		catch(Exception e){ System.out.println(e);} 
		
	}
	public void update_pwd(String id,String pwd)
	{
		try
		{
		String sql = "update user_info set pwd = ? where id = ? ";
		  java.sql.PreparedStatement sm=c.prepareStatement(sql);
		  sm.setString(1,pwd);
		  sm.setString(2,id);
		  sm.executeUpdate();
		}
		catch(Exception e){ System.out.println(e);} 
		
	}
	public void input_userid(String id)
	{
		try
		{
		String query = " insert into user_info (id,pwd,sn)"
		        + " values (?, ?, ?)";
		      java.sql.PreparedStatement preparedStmt =c.prepareStatement(query);
		      preparedStmt.setString (1, id);
		      preparedStmt.setString (2, null);
		      preparedStmt.setInt (3, 0);
		      preparedStmt.execute();
		}
		catch(Exception e){ System.out.println(e);}
	}
	
public void initialize_connection()
{

try{  
Class.forName("com.mysql.jdbc.Driver");  
c=DriverManager.getConnection("jdbc:mysql://localhost:3306/login_info?useSSL=false","root","password");   
  
s=c.createStatement();  
  
ResultSet rs=s.executeQuery("select * from user_info");

ResultSetMetaData md = rs.getMetaData();
inputs=new String[100]; 
passwords=new String[100]; 
slot_no=new int[100];
int i=0;
while(rs.next())
{
		inputs[i]=rs.getString(1);
		passwords[i]=rs.getString(2);
		slot_no[i]=rs.getInt(3);
		i++;
}
 
  
}catch(Exception e){ System.out.println(e);} 
}
}
  
