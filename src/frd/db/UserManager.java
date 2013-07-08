package frd.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class UserManager extends JDBCManager {
	public static void createDbUserTable() throws SQLException {
		String createTableSQL = "CREATE TABLE DBUSER("
				+ "USER_ID NUMBER(5) NOT NULL, "
				+ "USERNAME VARCHAR(20) NOT NULL, "
				+ "CREATED_BY VARCHAR(20) NOT NULL, "
				+ "CREATED_DATE DATE NOT NULL, " + "PRIMARY KEY (USER_ID) "
				+ ")";

		execute( createTableSQL );
	}
	
	public static void insertUser(int userId, String username, String creator, Date creation) throws SQLException{
		String insertTableSQL = "INSERT INTO DBUSER"
			+ "(USER_ID, USERNAME, CREATED_BY, CREATED_DATE) " + "VALUES"
			+ "("+userId+", '"+username+"', '"+creator+"', " + "to_date('"
			+ dateFormat.format(creation.getTime()) + "', 'yyyy/mm/dd hh24:mi:ss'))";
		
		executeUpdate( insertTableSQL );
	}
 
	public static void updateUser(int userId, String username, String creator, Date creation) throws SQLException{
		String updateTableSQL = "UPDATE DBUSER"
			+ " SET USERNAME = '"+username+"' "
			+ " WHERE USER_ID = "+userId;
		
		execute( updateTableSQL );

	}
	
	public static void deleteUser(int userId) throws SQLException{
		String deleteTableSQL = "DELETE DBUSER WHERE USER_ID = 1";
		
		execute( deleteTableSQL );
	}
	
	public static void getUsers() throws SQLException{
		String selectTableSQL = "SELECT USER_ID, USERNAME from DBUSER";
		 
		ResultSet rs = executeQuery( selectTableSQL );
		
		while (rs.next()) {
			String userid = rs.getString("USER_ID");
			String username = rs.getString("USERNAME");

			System.out.println("userid : " + userid);
			System.out.println("username : " + username);
		}
	}
}
