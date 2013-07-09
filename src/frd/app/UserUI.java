package frd.app;

import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;

import frd.db.UserManager;
import frd.model.User;

public class UserUI {

	public static void showAll() {
		System.out.println( "=================================" );
		System.err.println( "ID | NAME | CREATOR | DATE" );
		try {
			for( User u : UserManager.getUsers() ){
				System.out.println( u.getId() + " | " + u.getUsername() + " | " + u.getCreatedBy() + " | " + u.getCreateDate() );
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println( "=================================" );
	}

	public static void add(Scanner scanIn) {
		System.out.println( "=>AGREGAR USUARIO" );
		System.out.println( ">Ingrese el ID:" );
		String id = scanIn.nextLine();
		System.out.println( ">Ingrese el NOMBRE:" );
		String name = scanIn.nextLine();
		try {
			UserManager.insertUser( Integer.parseInt(id), name, "admin", new Date() );
		} catch (NumberFormatException e) {
			System.err.println("El ID ingresado es incorrecto!");
		} catch (SQLException e) {
			System.err.println("Error al guardar los datos en la base.");
		}
		System.out.println( "=================================" );
	}

	public static void del(Scanner scanIn) {
		System.out.println( "=>BORRAR USUARIO" );
		System.out.println( ">Ingrese el ID:" );
		String id = scanIn.nextLine();
		try {
			UserManager.deleteUser( Integer.parseInt(id) );
		} catch (NumberFormatException e) {
			System.err.println("El ID ingresado es incorrecto!");
		} catch (SQLException e) {
			System.err.println("Error al eliminar el usuario en la base.");
		}
		System.out.println( "=================================" );
	}

}
