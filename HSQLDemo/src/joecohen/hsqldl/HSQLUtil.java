package joecohen.hsqldl;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.hsqldb.util.DatabaseManager;
import org.hsqldb.util.DatabaseManagerSwing;

public class HSQLUtil {

	String database;
    Connection connection;
    

	public HSQLUtil(String database) throws Exception {
		this.database = database;
		try {
			Class.forName("org.hsqldb.jdbcDriver");
		} catch (ClassNotFoundException e) {
			throw new Exception("Can't load jdbcDriver");
		}
		connection = DriverManager.getConnection("jdbc:hsqldb:file:" + database, "sa", "");
	}
	
	public void view(){
		String[] arg = {
				"-url","jdbc:hsqldb:file:" + database, 
				"-user", "sa"};
		DatabaseManagerSwing.main(arg);
	}
	
	public DatabaseMetaData getMetaData() throws SQLException{
		return connection.getMetaData();
	}
	
	public void close(){
		try {
			connection.close();
		} catch (SQLException e) {
			System.err.println("Error closing Connection" + connection);
		}
	}
	
	public ResultSet executeQuery(String sql) throws SQLException{
		
		Statement st;
        st = connection.createStatement();
        ResultSet rs = st.executeQuery(sql);
		st.close();
		
		return rs;
	}
	
	public Boolean execute(String sql) throws SQLException{
		
		Statement st;
        st = connection.createStatement();
        Boolean r = st.execute(sql);
		st.close();
		
		return r;
	}
	
	public String toString(){
		return database;
	}
}
