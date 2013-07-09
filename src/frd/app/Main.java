package frd.app;

import java.sql.SQLException;
import java.util.Date;

import frd.db.UserManager;

public class Main {
	public static void main(String[] args){
		System.out.println("*********** Iniciando ***********");
		try{
			//creo la tabla dbUser (esto se debe hacer sólo una vez)
			UserManager.createDbUserTable();
			System.out.println( "Tabla Users Creada!" );
			
			//cargo dos usuarios
			UserManager.insertUser(1, "Usuario 1", "admin", new Date());
			UserManager.insertUser(2, "Usuario 2", "admin", new Date());

		
		}catch(SQLException ex){
			System.err.println( "ERROR: " + ex.getLocalizedMessage() );
		}
		System.out.println("*********** Fin de app ***********");
	}
}
