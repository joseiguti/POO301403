package Seis;

class Item {

	private final String codigo;
	
	private final String nombre;
	
	private final int precioCompra;
	
	private final int precioVenta;
	
	private final int cantidad;
	
	private final int vendidas;
	
	public Item(String codigo, String nombre, int precioCompra, int precioVenta, int cantidad, int vendidas){
	        
		 this.codigo = codigo;
		 
		 this.nombre = nombre;
	     
		 this.precioCompra = precioCompra;
		 
		 this.precioVenta = precioVenta;
		 
		 this.cantidad = cantidad;
		 
		 this.vendidas = vendidas;
		 
	 }
	 
	 public String geCodigo (){
		 
		 return codigo;
	 }
	
	 public String getNombre (){
		 
		 return nombre;
	 }
	 
	 public int getPrecioCompra (){
		 
		 return precioCompra;
	 }
	 
	 public int getPrecioVenta (){
		 
		 return precioVenta;
	 }
	 
	 public int getStock (){
		 
		 return cantidad;
	 }
	 
	 public int getVendidas (){
		 
		 return vendidas;
	 }
	
}
