package Diez;

import java.util.Scanner;

public class Diez {

	public static float nota1;
	
	public static float nota2;
	
	public static float nota3;
	
	public static float promedio;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		nota1 = 0;
		
		nota2 = 0;
		
		nota3 = 0;
		
		promedio = 0;

		Scanner entradaEscaner = new Scanner(System.in);
		
		System.out.println("Ingrese Nota 1:");
		
		nota1 =  Float.parseFloat(entradaEscaner.nextLine());
		
		System.out.println("Ingrese Nota 2:");
		
		nota2 =  Float.parseFloat(entradaEscaner.nextLine());
		
		System.out.println("Ingrese Nota 3:");
		
		nota3 =  Float.parseFloat(entradaEscaner.nextLine());
		
		promedio = (nota1+nota2+nota3)/3;
		
		if (promedio >= 7){
			
			System.out.println("Promocionado");
			
		}else{
			
			if (promedio >= 4){
				
				System.out.println("Regular");
				
			}else{
				
				System.out.println("Reprobado");
			}
			
		}
		
		
	}

}
