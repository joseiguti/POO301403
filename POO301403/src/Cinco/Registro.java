package Cinco;

class Registro {

	private final String fecha;
	
	private final float temperatura;
	
	 public Registro(String fecha, float temperatura){
	        
		 this.fecha = fecha;
	     
		 this.temperatura = temperatura;
		 
	 }
	 
	 public String getFecha (){
		 
		 return fecha;
	 }
	 
	 public float getTemperatura (){
		 
		 return temperatura;
	 }
	
}
