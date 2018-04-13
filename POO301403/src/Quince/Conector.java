package Quince;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conector {

	String url = "db.db"; // Completar con la ruta de la Base de datos
	
	Connection connect;
	
	public void connect(){
		
		 try {
			 
		     connect = DriverManager.getConnection("jdbc:sqlite:"+url);
		     
		     if (connect!=null) {
		    	 
		         System.out.println("Conectado");
		         
		     }
		     
		 }catch (SQLException ex) {
			 
		     System.err.println("No se ha podido conectar a la base de datos\n"+ex.getMessage());
		     
		 }
		 
		}
		 public void close(){
			 
		        try {
		        	
		            connect.close();
		            
		        } catch (SQLException ex) {
		        	
		        }
		 }
		 
		 public void savePelicula(Peliculas pelicula){
			 
		        try {
		        	
		            PreparedStatement st = connect.prepareStatement("insert into peliculas (nombre) values (?)");
		            
		            st.setString(1, pelicula.getNombre());
		            
		            st.execute();
		            
		        } catch (SQLException ex) {
		        	
		            System.err.println(ex.getMessage());
		        }
		 
		    }
		 
		 public void mostrarPeliculas(){
			 
		        ResultSet result = null;
		        
		        try {
		        	
		            PreparedStatement st = connect.prepareStatement("select * from peliculas");
		            
		            result = st.executeQuery();
		            
		            while (result.next()) {
		            	
		                System.out.print("ID: ");
		                
		                System.out.println(result.getInt("id"));
		 
		                System.out.print("Nombre: ");
		                
		                System.out.println(result.getString("nombre"));
		 
		                System.out.println("=======================");
		            }
		            
		        } catch (SQLException ex) {
		        	
		            System.err.println(ex.getMessage());
		        }
		    }
		 
}
