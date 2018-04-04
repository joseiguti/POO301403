package Dos;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.*;

public class Dos {

	private static ArrayList<Object> item;
	
	public static String nombreProducto;
	
	public static int precioProducto;
	
	public static void main(String[] args) {

		int size;
		
		int sumaTotal = 0; 
		
		Object tmpItem;
		
		nombreProducto = "";
		
		precioProducto = 0;
		
		item = new ArrayList<Object>();

		Scanner sn = new Scanner(System.in);
		
		Scanner entradaEscaner = new Scanner(System.in);
		
		boolean salir = false;
		
		int opcion;

		System.out.println("...::: Bienvenido a la Tienda de video :::...");
		
		while (!salir) {

			System.out.println("1. Agregar producto/suma.");
			
			System.out.println("2. Ver productos ingreados");
			
			System.out.println("3. Ver suma total");
			
			System.out.println("4. Salir");

			try {

				System.out.println("Escribe una opción...");
				
				opcion = sn.nextInt();

				switch (opcion) {
				
				case 1:
					
					System.out.println("Escriba código o nombre (concepto) producto:");
					
					nombreProducto =  entradaEscaner.nextLine(); 

					
					System.out.println("Escriba valor del producto:");

					precioProducto =  Integer.parseInt(entradaEscaner.nextLine());
					
					
					item.add(new Item(nombreProducto,precioProducto));	
					
					break;
					
				case 2:
					
					size = item.size();
					
				    for(int x=0;x < size; x++) {
				    	
				    	tmpItem = item.get(x);
				    	
				        System.out.println( ((Item) tmpItem).getNombre() +" "+ ((Item) tmpItem).getPrecio() );
				        
				      }
					
					break;
					
				case 3:
					
					size = item.size();
					
				    for(int x=0;x < size; x++) {
				    	
				    	tmpItem = item.get(x);
				    	
				        sumaTotal += ((Item) tmpItem).getPrecio(); 
				        
				      }
				    
				     System.out.println( "La suma total es: " + sumaTotal );
				    
				case 4:
					
					salir = true;
					
					break;
					
				default:
					
					System.out.println("Escribe solo números entre 1 y 4");
					
				}
				
			} catch (InputMismatchException e) {
				
				System.out.println("Debes digitar un número, otros caracteres no son permitidos.");
				
				sn.next();
			}
		}

	}

}
