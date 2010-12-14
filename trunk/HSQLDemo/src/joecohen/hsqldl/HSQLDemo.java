package joecohen.hsqldl;

import java.sql.ResultSet;

public class HSQLDemo {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {

		
		HSQLUtil util = new HSQLUtil("db/testDatabase");
		
		util.view();
		
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
		
		//util.executeQuery("Create")

		//while (resultSet.next()) {
		//    System.out.println(resultSet.getString("title") + " (" +
		///		       resultSet.getString("url") + ")");
		//    
		//}
		
		//resultSet.close();

		
		util.close();
		}
	
}
