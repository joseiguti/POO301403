/**
 * Paquete al que pertenece la clase
 */
package Nueve; 

/**
 * Importar los paquetes requeridos
 */
import java.util.*;
import javax.swing.*;

public class Nueve {

	/**
	 * Definicion de la clase principal 
	 */
	public static void main(String[] args) {

		/**
		 * Se realiza la captura de los parametros que definiran las dimensiones de la Matriz, tanto como el alto como para el ancho.
		 */
		int filas = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite las Filas: "));
		
		int columnas = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite las columnas: "));

		int i, j;
		
		/**
		 * Instancia un objeto de la clase Ramdon con el objetivo de obtener un numero aletorio entre 0 y 1
		 */
		Random R = new Random();
		
		/**
		 * Se define el arreglo de dos dimensiones con los parametros de alto y ancho capturadas previamente.
		 */
		int A[][] = new int[filas][columnas]; // Lectura()
		
		/**
		 * Se recorre la matriz por filas y columnas para asignarle un numero aleatorio entre 0 y 99, el abs permite obtener el valor absoluto
		 */
		
		for (i = 0; i < filas; i++)
			
			for (j = 0; j < columnas; j++)
				
				A[i][j] = Math.abs(R.nextInt() % 99 + 1);
		
		/**
		 * Se trata de leer la matriz creada
		 */
		System.out.println(" ------ Matriz Leida -------");
		
		for (i = 0; i < filas; i++) {
			
			System.out.println(); // Salto de linea
			
			for (j = 0; j < columnas; j++) {
				
				/**
				 * Si la posicion IJ tiene un valor mayor o igual a 10 entonces se muestra su valor
				 */
				
				if (A[i][j] >= 10)
					
					System.out.print(A[i][j] + " ");
				
				/**
				 * Caso contrario tambien se muestra su valor
				 */
				
				else
					
					System.out.print(A[i][j] + " ");
			}
			
		}
		
		System.out.println();

		System.exit(0);
	}

}
