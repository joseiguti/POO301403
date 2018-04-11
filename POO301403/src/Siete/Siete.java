package Siete;

import java.util.Scanner;

public class Siete {

	public static String apellido1;
	
	public static String apellido2;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		apellido1 = "";
		
		apellido2 = "";
		
		Scanner entradaEscaner = new Scanner(System.in);

		System.out.println("Primer apellido:");
		
		apellido1 =  entradaEscaner.nextLine();
		
		System.out.println("Segundo apellido:");
		
		apellido2 =  entradaEscaner.nextLine();
		
		if(apellido1.equals(apellido2)){
			
			System.out.println("Los dos apellidos son iguales");
			
		}else{
			
			System.out.println("Los dos apellidos son diferentes");
		}
		
	}

}
