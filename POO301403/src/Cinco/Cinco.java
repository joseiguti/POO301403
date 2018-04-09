package Cinco;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.*;

public class Cinco {

	private static ArrayList<Object> registros;
	
	public static String fechaTemperatura;
	
	public static float valorTemperatura;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int size = 0;
		
		fechaTemperatura = "";
		
		valorTemperatura = 0;
		
		registros = new ArrayList<Object>();
		
		Scanner sn = new Scanner(System.in);
		
		Scanner entradaEscaner = new Scanner(System.in);
		
		System.out.println("...::: Instituto Metereológico :::...");
		
		boolean salir = false;
		
		Object tmpItem;
		
		int opcion;
		
		String regex = "^[0-3]?[0-9]/[0-3]?[0-9]/(?:[0-9]{2})?[0-9]{2}$";
		
		Pattern p = Pattern.compile(regex);
		
		while (!salir) {

			System.out.println("1. Agregar registro.");
			
			System.out.println("2. Ver resultados.");
			
			System.out.println("3. Salir");

			try {

				System.out.println("Escribe una opción...");
				
				opcion = sn.nextInt();

				switch (opcion) {
				
				case 1:
					
					System.out.println("Escriba fecha (mm/dd/yy, mm/dd/yyyy, dd/mm/yy, dd/mm/yyyy) de registro de temperatura:");
					
					fechaTemperatura =  entradaEscaner.nextLine(); 

					Matcher matcher = p.matcher(fechaTemperatura);
					
					
					if (!matcher.matches())
						
						System.err.println("NOTA: La fecha NO cumplió con el formato.");
					
					
					System.out.println("Escriba la temperatura registrada en Cº:");

					valorTemperatura =  Float.parseFloat(entradaEscaner.nextLine());
					
					
					registros.add(new Registro(fechaTemperatura,valorTemperatura));	
					
					break;
					
				case 2:

					System.out.println("Mostrando temperaturas mayores a 30º:");
					
					size = registros.size();
					
				    for(int x=0;x < size; x++) {
				    	
				    	tmpItem = registros.get(x);

				    	if (((Registro) tmpItem).getTemperatura() >= 30)
				    	
				    		System.out.println("Fecha:  "+((Registro) tmpItem).getFecha() +" Temperatura: "+ ((Registro) tmpItem).getTemperatura() );
				        
				      }
					
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
