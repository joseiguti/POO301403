package Trece;

import javax.swing.JOptionPane;

public class Persona {

	private String nombre;
	
	private int edad;
	
	public void inicializar() {

		nombre = "";
		
		edad = 0;
		
		nombre = JOptionPane.showInputDialog(null,"Ingrese el nombre");
		
		edad = Integer.parseInt( JOptionPane.showInputDialog(null,"Ingrese la edad") );
		
	}

	public void imprimir() {
		
		if (esMayorEdad().equals(true)){
			
			JOptionPane.showMessageDialog(null, nombre+" es mayor de Edad");
			
		}else{

			JOptionPane.showMessageDialog(null, nombre+" es menor de Edad");
			
		}
		
	}

	public Boolean esMayorEdad() {
		
		Boolean mayor = false;
		
		if (edad >= 18){
			
			mayor = true;
			
		}
		
		return mayor;
	}

	public static void main(String[] ar) {
		
		

	}
}
