package joecohen.hsqldb;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.hsqldb.util.DatabaseManagerSwing;

/**
 * This utility should make working with HSQLDB easy
 * 
 * @author Joseph Paul Cohen
 *
 */
public class HSQLUtil {

	
	protected String database;
	protected Connection connection;
    
	/**
	 * If the database specified does not exist then it will be created
	 * 
	 * @param Path to database data folder
	 * @throws Exception
	 */
	
	public HSQLUtil(String database) throws Exception {
		this.database = database;
		try {
			Class.forName("org.hsqldb.jdbcDriver");
		} catch (ClassNotFoundException e) {
			throw new Exception("Can't load jdbcDriver");
		}
		connection = DriverManager.getConnection("jdbc:hsqldb:file:" + database, "sa", "");
	}
	
	/**
	 * This will open a windowed utility to edit the database
	 */
	public void view(){
		String[] arg = {
				"-url","jdbc:hsqldb:file:" + database, 
				"-user", "sa"};
		DatabaseManagerSwing.main(arg);
	}
	
    /**
     * Retrieves a <code>DatabaseMetaData</code> object that contains
     * metadata about the database to which this
     * <code>Connection</code> object represents a connection.
     * The metadata includes information about the database's
     * tables, its supported SQL grammar, its stored
     * procedures, the capabilities of this connection, and so on.
     *
     * @return a <code>DatabaseMetaData</code> object for this 
     *         <code>Connection</code> object
     * @exception  SQLException if a database access error occurs 
     * or this method is called on a closed connection
     */
	public DatabaseMetaData getMetaData() throws SQLException{
		return connection.getMetaData();
	}
	
	/**
	 * You need to call this when you are done
	 */
	public void close(){
		try {
			connection.close();
		} catch (SQLException e) {
			System.err.println("Error closing Connection" + connection);
		}
	}
	
	/**
	 * Execute a query that has a side effect such as 
	 * <code>INSERT</code>, <code>CREATE</code>, or <code>UPDATE</code>
	 * 
	 * @param sql
	 * @return
	 * @throws SQLException
	 */
	public ResultSet executeQuery(String sql) throws SQLException{
		
		Statement st;
        st = connection.createStatement();
        ResultSet rs = st.executeQuery(sql);
		st.close();
		connection.commit();
		return rs;
	}
	
	/**
	 * Execute a query that returns records such as
	 * <code>SELECT</code>
	 * @param sql
	 * @return
	 * @throws SQLException
	 */
	public Boolean execute(String sql) throws SQLException{
		
		Statement st;
        st = connection.createStatement();
        Boolean r = st.execute(sql);
		st.close();
		connection.commit();
		return r;
	}
	
	public String toString(){
		return database;
	}
}
