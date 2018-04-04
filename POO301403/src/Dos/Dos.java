package Dos;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Dos {

	public static void main(String[] args) {

		Scanner sn = new Scanner(System.in);
		
		boolean salir = false;
		
		int opcion;

		System.out.println("...::: Bienvenido a la Tienda de video :::...");
		
		while (!salir) {

			System.out.println("1. Agregar suma");
			
			System.out.println("2. Ver suma total");
			
			System.out.println("3. Salir");

			try {

				System.out.println("Escribe una opción...");
				
				opcion = sn.nextInt();

				switch (opcion) {
				
				case 1:
					System.out.println("Has seleccionado la opcion 1");
					break;
				case 2:
					System.out.println("Has seleccionado la opcion 2");
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
