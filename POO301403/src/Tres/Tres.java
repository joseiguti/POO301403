package Tres;

import java.util.*;

public class Tres {

	private static ArrayList<Integer> itemsLunes, itemsMartes, itemsMiercoles, itemsJueves, itemsViernes;
	
	public static int valor;
	
	public static int sumaTotal;
	
	public static void main(String[] args) {

		Scanner sn = new Scanner(System.in);
		
		Scanner entradaEscaner = new Scanner(System.in);
		
		boolean salir = false;
		
		int opcion;
		
		sumaTotal = valor = 0;
		
		itemsLunes = new ArrayList<Integer>();
				
		itemsMartes = new ArrayList<Integer>();
		
		itemsMiercoles = new ArrayList<Integer>();
		
		itemsJueves = new ArrayList<Integer>();
		
		itemsViernes = new ArrayList<Integer>();

		System.out.println("...::: Asesoramos Al Instante  S.A :::...");
		
		while (!salir) {

			System.out.println("1. Ingresar valor Lunes.");
			
			System.out.println("2. Ingresar valor Martes.");
			
			System.out.println("3. Ingresar valor Miercoles.");
			
			System.out.println("4. Ingresar valor Jueves.");
			
			System.out.println("5. Ingresar valor Viernes.");
			
			System.out.println("6. Consultar valor semana");
			
			System.out.println("7. Salir");

			try {

				System.out.println("Escribe una opción...");
				
				opcion = sn.nextInt();

				switch (opcion) {
				
				case 1:
					
					System.out.println("Ingrese valor de Lunes:");
					
					valor =  Integer.parseInt(entradaEscaner.nextLine()); 
					
					itemsLunes.add(valor);	
					
					System.out.println("Suma de este día: "+sumarDia(itemsLunes));
					
					break;
					
				case 2:
					
					System.out.println("Ingrese valor de Martes:");
					
					valor =  Integer.parseInt(entradaEscaner.nextLine()); 
					
					itemsMartes.add(valor);	
					
					System.out.println("Suma de este día: "+sumarDia(itemsMartes));
					
					break;
					
				case 3:
					
					System.out.println("Ingrese valor de Miercoles:");
					
					valor =  Integer.parseInt(entradaEscaner.nextLine()); 
					
					itemsMiercoles.add(valor);	
					
					System.out.println("Suma de este día: "+sumarDia(itemsMiercoles));
					
					break;
					
				case 4:
					
					System.out.println("Ingrese valor de Jueves:");
					
					valor =  Integer.parseInt(entradaEscaner.nextLine()); 
					
					itemsJueves.add(valor);	
					
					System.out.println("Suma de este día: "+sumarDia(itemsJueves));
					
					break;
					
				case 5:
					
					System.out.println("Ingrese valor de Viernes:");
					
					valor =  Integer.parseInt(entradaEscaner.nextLine()); 
					
					itemsViernes.add(valor);	
					
					System.out.println("Suma de este día: "+sumarDia(itemsViernes));
					
					break;
					
				case 6:
					
					sumaTotal = sumarDia(itemsLunes)+sumarDia(itemsMartes)+sumarDia(itemsMiercoles)+sumarDia(itemsJueves)+sumarDia(itemsViernes);
					
					System.out.println("Acomulado de la semana: $"+ sumaTotal );
					
					break;
				    
				case 7:
					
					salir = true;
					
					break;
					
				default:
					
					System.out.println("Escribe solo números entre 1 y 7");
					
				}
				
			} catch (InputMismatchException e) {
				
				System.out.println("Debes digitar un número, otros caracteres no son permitidos.");
				
				sn.next();
			}
		}

	}
	
	public static int sumarDia(ArrayList<Integer> diaSemana) {
		
		int sumaTotalDia = 0;
		
		int size = diaSemana.size();
		
		System.out.println("Cantidad de sumas este día: "+size);
		
	    for(int x=0;x < size; x++) {
	    	
	    	sumaTotalDia += diaSemana.get(x);
	    	
	      }
		
		return sumaTotalDia;
	}

}