package Seis;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.awt.event.ItemEvent;
import java.util.*;

public class Seis {

	private static ArrayList<Object> stock;
	
	public static String codigoProducto;
	
	public static String nombreProducto;
	
	public static int precioProductoCompra;
	
	public static int precioProductoVenta;
	
	public static int cantidadProducto;
	
	public static int posProductFound;
	
	public static Boolean existProduct (String codigoProducto){
		
		Object tmpItem;
		
		Boolean found = false;
		
		int size = stock.size();
		
		 for(int x=0;x < size; x++) {
		    	
			 tmpItem = stock.get(x);
			 
			 if (codigoProducto.equals(((Item) tmpItem).geCodigo() )){
				 
				 found = true;

				 posProductFound = x;
				 
				 break;
			 }
			 
		 }

		
		return found;
	}
	
	public static void main(String[] args) {

		posProductFound = -1;
		
		int size;
		
		int sumaTotal = 0; 
		
		Object tmpItem;
		
		nombreProducto = "";
		
		codigoProducto = "";
		
		precioProductoCompra = 0;
		
		precioProductoVenta = 0;
		
		cantidadProducto = 0;
		
		stock = new ArrayList<Object>();

		Scanner sn = new Scanner(System.in);
		
		Scanner entradaEscaner = new Scanner(System.in);
		
		Boolean salir = false;
		
		Boolean existe;
		
		int opcion;

		System.out.println("...::: Bienvenido al Supermercado :::...");
		
		while (!salir) {

			System.out.println("1. Vender Productos.");
			
			System.out.println("2. Comprar Productos.");
			
			System.out.println("3. Ver utilidad por Producto.");
			
			System.out.println("4. Salir");

			try {

				System.out.println("Escribe una opción...");
				
				opcion = sn.nextInt();

				switch (opcion) {
				
				case 1:
					
					System.out.println("Código de Producto:");
					
					codigoProducto =  entradaEscaner.nextLine();
					
					existe = existProduct(codigoProducto);

					if (existe){
					
						System.out.println("Numero de unidades:");

						cantidadProducto =  Integer.parseInt(entradaEscaner.nextLine());
						
						tmpItem = stock.get(posProductFound);
						
						if (  (((Item) tmpItem).getStock() - ((Item) tmpItem).getVendidas())   > 0 ){
							
							stock.set(posProductFound, new Item(((Item) tmpItem).geCodigo(), ((Item) tmpItem).getNombre(), ((Item) tmpItem).getPrecioCompra(), ((Item) tmpItem).getPrecioVenta(),   ((Item) tmpItem).getStock(), (((Item) tmpItem).getVendidas() + cantidadProducto)   ));
							
						}else{
							
							System.err.println("Error: No hay stock de este producto en Bodega");
							
						}

						
					}else{
						
						System.err.println("Error: Ese producto no existe");
					}
					
					break;
					
				case 2:
					
					System.out.println("Código de Producto:");
					
					codigoProducto =  entradaEscaner.nextLine();
					
					existe = existProduct(codigoProducto);

					if (!existe){
						
						System.out.println("Nombre de Producto:");
						
						nombreProducto =  entradaEscaner.nextLine();
						
						System.out.println("Valor del producto Compra: $");

						precioProductoCompra =  Integer.parseInt(entradaEscaner.nextLine());
						
						System.out.println("Valor del producto Venta: $");

						precioProductoVenta =  Integer.parseInt(entradaEscaner.nextLine());
						
					}else{
						
						System.err.println("Advertencia: El producto ya está registrado. Se agregará Stock");
					}
					
					System.out.println("Numero de unidades:");

					cantidadProducto =  Integer.parseInt(entradaEscaner.nextLine());					
					
					
					if (existe){
						
						tmpItem = stock.get(posProductFound);
						
						stock.set(posProductFound, new Item(((Item) tmpItem).geCodigo(), ((Item) tmpItem).getNombre(), ((Item) tmpItem).getPrecioCompra(), ((Item) tmpItem).getPrecioVenta(),  (((Item) tmpItem).getStock() + cantidadProducto), ((Item) tmpItem).getVendidas()   ));
						
					}else{
						
						stock.add(new Item(codigoProducto,nombreProducto,precioProductoCompra,precioProductoVenta,cantidadProducto,0));
					}
					
					break;
					
				case 3:
					
					System.out.println("...::: Resumen de Utilidades :::...");
					
					sumaTotal = 0;
					
					size = stock.size();
					
				    for(int x=0;x < size; x++) {
				    	
				    	tmpItem = stock.get(x);

				    	System.out.println("Codigo:  "+((Item) tmpItem).geCodigo() +" Stock: "+ ( ((Item) tmpItem).getStock()-((Item) tmpItem).getVendidas())  +" Vendidas: "+ ((Item) tmpItem).getVendidas()+" Utilidad Diaria: $"+   (  ( ((Item) tmpItem).getPrecioVenta() - ((Item) tmpItem).getPrecioCompra() ) * ((Item) tmpItem).getVendidas() ));
				        
				    	sumaTotal += (  ( ((Item) tmpItem).getPrecioVenta() - ((Item) tmpItem).getPrecioCompra() ) * ((Item) tmpItem).getVendidas() ); 
				    	
				    }
				    
				    System.out.println("Utilidad TOTAL Diaria: $"+sumaTotal);
				    
				    System.out.println("...::: Fin :::...");
				    
					break;
					
				case 4:
					
					salir = true;
					
					break;
					
				default:
					
					System.err.println("Escribe solo números entre 1 y 4");
					
				}
				
			} catch (InputMismatchException e) {
				
				System.err.println("Debes digitar un número, otros caracteres no son permitidos.");
				
				sn.next();
			}
		}

	}

}
