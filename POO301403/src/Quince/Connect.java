package Quince;

import java.security.cert.CertSelector;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.sun.glass.ui.Window.Level;
import com.sun.istack.internal.logging.Logger;

public class Connect {

	String url = "D:\\test.db";
	
	Connection connect;
	
	public void connect() {
		try {
			connect = DriverManager.getConnection("jdbc:sqlite:" + url);
			
			if (connect != null) {
				
				System.out.println("Conectado");
				
			}
			
		} catch (SQLException ex) {
			
			System.err.println("No se ha podido conectar a la base de datos\n" + ex.getMessage());
			
		}
	}

	public void close() {
		try {
			connect.close();
		} catch (SQLException ex) {
			//Logger.getLogger(CertSelector.class.getName(), null).log(Level.NORMAL, "", ex);
		}
	}

}
