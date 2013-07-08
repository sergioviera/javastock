package frd.db;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class JDBCManager {

	private static final String DB_DRIVER = "org.postgresql.Driver";
	private static final String DB_CONNECTION = "jdbc:postgresql://127.0.0.1:5432/basededatos";
	private static final String DB_USER = "user";
	private static final String DB_PASSWORD = "password";
	
	protected static final DateFormat dateFormat = new SimpleDateFormat( "yyyy/MM/dd HH:mm:ss" );

	private static Connection getDBConnection() {
		System.out.println("-------- PostgreSQL JDBC Connection Testing ------------");
 
		try {
			Class.forName( DB_DRIVER );
		} catch (ClassNotFoundException e) {
			System.out.println("Descargar el driver PostgreSQL JDBC - http://jdbc.postgresql.org/download.html - e incluirlo en el library path!");
			e.printStackTrace();
		}
 
		System.out.println("PostgreSQL JDBC Driver Registrado!");
		Connection connection = null;
		try {
			connection = DriverManager.getConnection( DB_CONNECTION, DB_USER, DB_PASSWORD);
		} catch (SQLException e) {
			System.out.println("Falla de conecci�n! Ver detalles en consola...");
			e.printStackTrace();
		}
 
		if (connection != null) {
			System.out.println("Hecho, ahora se tiene el control de la base de datos!");
		} else {
			System.out.println("La conecci�n ha fallado!");
		}
		
		return connection;
	}

	protected static void execute(String sql) throws SQLException {
		Connection dbConnection = null;
		Statement statement = null;

		try {
			dbConnection = getDBConnection();
			statement = dbConnection.createStatement();
			System.out.println( "RUNNING >> " + sql );
			statement.execute( sql );
			System.out.println("Query corrida exitosamente!");

		} catch (SQLException e) {
 			System.err.println(e.getMessage());
 		} finally {
 			if (statement != null) statement.close();
 			if (dbConnection != null) dbConnection.close();
 		}
	}

	protected static void executeUpdate(String sql) throws SQLException {
		Connection dbConnection = null;
		Statement statement = null;
 
		try {
			dbConnection = getDBConnection();
			statement = dbConnection.createStatement();
 
			System.out.println( "RUNNING >> " + sql );
			statement.executeUpdate(sql);
			System.out.println("Query corrida exitosamente!");
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		} finally {
 			if (statement != null) statement.close();
 			if (dbConnection != null) dbConnection.close();
		}
 	}
	
	protected static ResultSet executeQuery( String sql ) throws SQLException{
		Connection dbConnection = null;
		Statement statement = null;
		ResultSet rs = null;
		
		try {
			dbConnection = getDBConnection();
			statement = dbConnection.createStatement();
 
			System.out.println( "RUNNING >> " + sql );
			rs = statement.executeQuery( sql );
			System.out.println("Query corrida exitosamente!");

		} catch (SQLException e) {
			System.err.println(e.getMessage());
		} finally {
 			if (statement != null) statement.close();
 			if (dbConnection != null) dbConnection.close();
		}
		
		return rs;

	}
}
