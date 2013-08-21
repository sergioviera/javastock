package frd.app;

import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import app.ui.MainWindow;

public class Main {
	private static Scanner scanIn = new Scanner(System.in);

	public static void main(String[] args){
		
/*		JFrame frame = new JFrame();
		
		FlowLayout layout = new FlowLayout();
		
		frame.getContentPane().setLayout(layout);
	
		frame.setTitle("Mi primer ventana");
		frame.setSize(300, 200);
		frame.setLocation(100, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel title = new JLabel("Sistema de Stock");
		JButton button = new JButton("soy un boton");
		
		frame.getContentPane().add(title);
		frame.getContentPane().add(button);

		frame.show();
*/
		
		
		
		
		
		(new MainWindow()).setVisible(true);

		
		/*	
	 	System.out.println("*********** Iniciando ***********");
		System.out.println("q:salir, u:listar usuarios, u-add:agregar usuario, u-del:borrar usuario");
		
		String response = scanIn.nextLine();
		while( !"q".equalsIgnoreCase(response) ){

			if( "u".equalsIgnoreCase(response) ){
				UserUI.showAll();
			}
			
			if( "u-add".equalsIgnoreCase(response) ){
				UserUI.add( scanIn );
			}
			
			if( "u-del".equalsIgnoreCase(response) ){
				UserUI.del( scanIn );
			}
			
			System.out.println(">");
			response = scanIn.nextLine();
		}
		
        System.out.println("*********** Fin de app ***********");
        */
	}
}
