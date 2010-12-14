package joecohen.hsqldb;

import java.sql.ResultSet;
import java.sql.SQLException;

public class HSQLDemo {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {

		
		HSQLUtil util = new HSQLUtil("db/testDatabase");
		
		// uncomment to see the visual HSQLDB viewer
		//util.view();
		
		// This will create the table if it doesn't already exist
		
		ResultSet resultSet = util.getMetaData().getTables(null, null, "EMAILS", null);
		try{
			resultSet.next();
			if (!"EMAILS".equals(resultSet.getString("TABLE_NAME")))
					throw new Exception("no table");
		}catch (Exception e){
			//create table
			System.out.println("Creating Table");
			util.execute("CREATE TABLE EMAILS (" +
					"email VARCHAR(50) NOT NULL UNIQUE, " +
					"name VARCHAR(50) NOT NULL)");
			System.out.println("Table Created");
		}
		
		// insert record and catch if it's already in there
		
		try{
			util.execute("INSERT INTO EMAILS (email, name) VALUES ('someone@somewhere.com', 'somebody')");
		}catch (SQLException e){
			System.out.println("Record already exists");
		}
		
		try{
			util.execute("INSERT INTO EMAILS (email, name) VALUES ('someoneelse@somewhere.com', 'someone else')");
		}catch (SQLException e){
			System.out.println("Record already exists");
		}
		
		// display the contents
		
		ResultSet rs = util.executeQuery("SELECT email, name from EMAILS");
		while (rs.next()){
			System.out.println(rs.getString("email") + " :: " + rs.getString("name"));
			
		}

		util.close();
		}
}
