package Quince;

public class Peliculas {
	 
    private int id;
    
    private String nombre;
 
    public Peliculas(String nombre) {

    	this.nombre = nombre;

    }
 
    public int getId() {
    	
        return id;
    }
 
    public void setId(int id) {
    	
        this.id = id;
    }
 
    public String getNombre() {
    	
        return nombre;
    }
 
    public void setNombre(String nombre) {
    	
        this.nombre = nombre;
    }
    
    public void save(){
    	
        Conector con = new Conector();
        
        con.connect();
        
        con.savePelicula(this);
        
        con.close();
    }
    
}