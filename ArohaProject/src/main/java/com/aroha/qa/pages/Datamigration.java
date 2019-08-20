package com.aroha.qa.pages;

	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Test;

	import com.mysql.jdbc.Connection;
	import com.mysql.jdbc.PreparedStatement;

	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.SQLException;

	import org.testng.Assert;


	public class Datamigration {
		String url="jdbc:mysql://192.168.1.254:3306/sayantika";
		String userid="sayantika";
		String passwd="sayantika";
		java.sql.Connection con=null;

		java.sql.PreparedStatement pstmt=null;
	    PreparedStatement pstmt1=null;
	ResultSet res=null;
	int sourcecount=0;
	int Targetcount=0;
	@BeforeMethod
	public void setUp()
	{
	try{
	Class.forName("com.mysql.jdbc.Driver");
	System.out.println("driver loaded");
	}
	catch(ClassNotFoundException e1)
	{
	System.out.println("driver not loaded");
	}
	try{
	con=DriverManager.getConnection(url,userid,passwd);
	System.out.println("connection established");
	}
	catch(SQLException e11)
	{
	System.out.println("connection cannot established");
	}
	}
	@Test
	public void Database_Reconciliation_test() {
	try
	{
	pstmt=con.prepareStatement("Select count(*) from cust_source_inc");


	res=pstmt.executeQuery();
	while(res.next()==true)
	{
	sourcecount=res.getInt(1);
	System.out.println(" "+ sourcecount);
	}
	pstmt=con.prepareStatement("Select count(*) from cust_tgt");
	res=pstmt.executeQuery();
	while(res.next()==true)
	{
	Targetcount=res.getInt(1);
	System.out.println(" "+ Targetcount);
	}
	}
	catch(SQLException e){
	System.out.println("data table doesn't exists ");
	}
	Assert.assertEquals(sourcecount,Targetcount,"Count between source and target not matching");

	}
	@AfterMethod
	public void finalcall()
	{
	 
	try{
	con.close();
	pstmt.close();
	res.close();
	}
	catch(Exception e)
	{
	System.out.println("Please enter valid table name");
	}
	}
	  
	 
	}
