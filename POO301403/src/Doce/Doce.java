package Doce;

import javax.swing.JOptionPane; // Esta linea hacia falta para poder usar la funcion JOptionPane.showInputDialog

public class Doce {

	public static void main(String[] args) {
		
		int num1; // Esta linea hacia falta para declarar el tipo de variable que será num1
		
		int num2,num3,num4,suma,producto; 
		
		num1=Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese primer valor:"));
		 
		num2=Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese segundo valor:")); 
		
		num3=Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese tercer valor:")); 
		
		num4=Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese cuarto valor:")); 
		
		suma = num1 + num2; // Esta linea se debia modificar porque el operador era la suma, no la resta.
		
		producto = num3 * num4; // Esta linea se debia modificar porque el operador es el producto y no el residuo de una división 
		
		System.out.print("La suma de los dos primero valores es:"); 
		
		System.out.println(suma);
		
		System.out.print("El producto del tercer y cuarto valor es:");
		
		System.out.println(producto); // Esta linea hacia falta para poder imprimir el producto del numero 3 y 4
	}

}
