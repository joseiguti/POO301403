package Uno;

import java.util.Scanner;

public class Uno {

	public static int valorProducto;
	
	public static int porcentajeIva;
	
	/**
	 * Programa Uno
	 */
	public static void main(String[] args) {

		valorProducto = 0;
		
		porcentajeIva = 0;
		
		Scanner entradaEscaner = new Scanner(System.in);

		
		System.out.println("Digite el valor del producto:");
														
		valorProducto =  Integer.parseInt(entradaEscaner.nextLine()); 

		
		System.out.println("Digite el porcentaje de IVA:");

		porcentajeIva =  Integer.parseInt(entradaEscaner.nextLine());
		
		
		
		
		System.out.println("El valor del producto es: $" + valorProducto);
		
		System.out.println("El porcentaje del IVA es: " + porcentajeIva + "%");
		
		System.out.println("El valor del producto con IVA es: $" + (((valorProducto/100)*porcentajeIva)+valorProducto) ); 
	}

}
