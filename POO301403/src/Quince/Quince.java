package Quince;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Quince {

	   static Scanner entradaEscaner = new Scanner(System.in);
	   
	   static Scanner sn = new Scanner(System.in);
	   
	   static boolean salir = false;
		
	   static int opcion;
	   
	   public static String nombrePelicula;
		
	   public static void main( String args[] ) {
		      
		   System.out.println("...::: Bienvenido a la Tienda de video :::...");
		   
		   while (!salir) {

				System.out.println("1. Agregar Peliculas.");
				
				System.out.println("2. Ver Peliculas.");
				
				System.out.println("3. Salir");

				try {

					System.out.println("Escribe una opción...");
					
					opcion = sn.nextInt();

					switch (opcion) {
					
					case 1:
						
						System.out.println("Escriba nombre de la Pelicula:");
						
						nombrePelicula =  entradaEscaner.nextLine(); 
						
						Peliculas pelicula = new Peliculas(nombrePelicula);
						   
						pelicula.save();				
						
						break;
						
					case 2:
						
						Conector con = new Conector();
				        
				        con.connect();
				        
				        con.mostrarPeliculas();
				        
				        con.close();
												
						break;
						
					case 3:
						
						salir = true;
						
						break;
						
					default:
						
						System.out.println("Escribe solo números entre 1 y 3");
						
					}
					
				} catch (InputMismatchException e) {
					
					System.out.println("Debes digitar un número, otros caracteres no son permitidos.");
					
					sn.next();
				}
			}
		   
		   
		      
	   }


}
