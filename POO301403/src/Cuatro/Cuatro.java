package Cuatro;

import java.util.Arrays;
import java.util.Scanner;

public class Cuatro {
	
    public static void main(String[] args){

        // Definimos un array de valores enteros
    	
    	Scanner x = new Scanner (System.in);
    	
        int num[] =  new int[20];

        int l = num.length;

        int i,j,t;

        System.out.println ("...::: Edades de Estudiantes :::...");
        
        for ( i= 0; i<20; i++){
            
        	System.out.println ("Digite la edad para el estudiante "+i);
        	
        	num[i]= x.nextInt();
            
        }
        

        System.out.print("Ordenado de menor a mayor: ");

        // Ordenamos el array utilizando la funcion sort() de java.util.*

        Arrays.sort(num);

        // Recorremos el array mostrando los valores ordenados

        for(i = 0;i < l;i++){

            System.out.print("  " + num[i]);

        }

    }
}
