package frd.test;

import java.sql.SQLException;
import java.util.Date;

import frd.db.UserManager;
import frd.model.User;

public class TestDBUser {
	public static void main(String[] args){
		System.out.println("*********** Iniciando TEST DBUSER ***********");
		try{
			//creo la tabla dbUser
			UserManager.createDbUserTable();
			System.out.println( "Tabla Users Creada!" );
			
			//cargo dos usuarios
			UserManager.insertUser(1, "Usuario 1", "admin", new Date());
			UserManager.insertUser(2, "Usuario 2", "admin", new Date());
			System.out.println( "Dos usuarios creados!" );

			//obtengo los usuarios de la bd
			System.out.println( "Listando usuarios:" );
			for( User usr : UserManager.getUsers() ){
				System.out.println( usr );
			}

			//modificando usuario
			UserManager.updateUser(2, "Usuario 2 Modificado", "admin", new Date());
			System.out.println( "Usuario 2 modificado!" );
			
			//obtengo los usuarios de la bd
			System.out.println( "Listando usuarios:" );
			for( User usr : UserManager.getUsers() ){
				System.out.println( usr );
			}

			//borrar usuario
			UserManager.deleteUser(1);
			System.out.println( "Usuario 1 eliminado!" );
			
			//obtengo los usuarios de la bd
			System.out.println( "Listando usuarios:" );
			for( User usr : UserManager.getUsers() ){
				System.out.println( usr );
			}

		}catch(SQLException ex){
			System.err.println( "ERROR: " + ex.getLocalizedMessage() );
		}
		System.out.println("*********** Fin TEST DBUSER ***********");
	}
}
