/**
 * Nombre del paquete
 */
package Once;

/**
 * Inclusión de la libreria swing para llamar funciones de Panel
 */
import javax.swing.*;

/**
 * Nombre de la clase y declaración de la misma 
 */
public class Once {

	/**
	 * Declaracion de la funcion/metodo principal 
	 */
	public static void main(String[] args) {
		
		/**
		 * Variable usada para capturar el valor
		 */
		int valor;

		/**
		 * Do While: El ciclo se ejecutaría al menos una vez.
		 */
		do {
			
			/**
			 * Se captura el valor de la variable que se evaluará en el ciclo. Sin embargo no esta establecido si el numero es mayor que 1000 por ejemplo y no tiene 3 digitos unicamente
			 */
			valor = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese un valor entre 0 y 999 (0 finaliza):"));

			/**
			 * Se evalua la primera condicion
			 */
			if (valor >= 100) {
				
				/**
				 * Se imprime el texto si el numero cumple con la condicion
				 */
				System.out.println("Tiene 3 dígitos.");
				
			} else {
				
				/**
				 * Se evalua si el numero es menor que 100 pero mayor o igual a 10, osea entre 10 y 99
				 */
				if (valor >= 10) {
					
					/**
					 * Se imprime el respectivo mensaje
					 */
					System.out.println("Tiene 2 dígitos.");
					
				/**
				 * En el ultimo caso, el valor de este digito seria 1.	
				 */
				} else {
					
					/**
					 * Se imprime el respectivo mensaje
					 */
					System.out.println("Tiene 1 dígito.");
				}
				
			}

			/**
			 * La condicion del While se encuentra al cerrar precisamente el ciclo, y solo si el numero ingresado es 0 entonces el ciclo acabará 
			 */
		} while (valor != 0);

	}

}
