package Catorce;

import javax.swing.JOptionPane;

public class Catorce {

	private static int lado1;
	
	private static int lado2;
	
	private static int lado3;
	
	public static void main(String[] args) {

		inicializar();
		
		lado1 = Integer.parseInt( JOptionPane.showInputDialog(null,"Ingrese el lado 1") );
		
		lado2 = Integer.parseInt( JOptionPane.showInputDialog(null,"Ingrese el lado 2") );
		
		lado3 = Integer.parseInt( JOptionPane.showInputDialog(null,"Ingrese el lado 3") );
		
		ladoMayor();
		
		Equilatero();
		
	}
	public static void inicializar() {
		 
		lado1 = 0;
		
		lado2 = 0;
		
		lado3 = 0;
		
	}
	
	public static void ladoMayor() {
		
		if (lado1 >= lado2 && lado1 >= lado3){
			
			JOptionPane.showMessageDialog(null, "Lado mayor es 1");
			
		}else{
			
			if (lado2 >= lado1 && lado2 >= lado3){
				
				JOptionPane.showMessageDialog(null, "Lado mayor es 2");
				
			}else{
				
				JOptionPane.showMessageDialog(null, "Lado mayor es 3");
			}
			
		}
		
	}
	
	public static void Equilatero() {
		
		if (lado1 == lado2 && lado2 == lado3){
			
			JOptionPane.showMessageDialog(null, "Triangulo Equilatero");
			
		}else{
			
			JOptionPane.showMessageDialog(null, "No es triangulo equilatero");
		}
		
	}
	
}
