package conexionbase;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;

public class MySQLConexion {
	String ur1= "jdbc:mysql://localhost/usuarios?characterEncoding=latin1";
	String usuario = "root";
	String contraseña = "ros08jua27";
	Connection con = null;
	public MySQLConexion(){
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			
			con = DriverManager.getConnection(ur1, usuario, contraseña);
			
			System.out.println("Conectado");
			
		} catch (ClassNotFoundException e) {
			System.out.println("Error --> al cargar el Driver");
		
			e.printStackTrace();
		} catch (SQLException e) {
			
			System.out.println("Error --> con la BD");
			e.printStackTrace();
		}
		

	}
	
	public static Connection getConexion() {
		
		Connection con = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String ur1= "jdbc:mysql://localhost/usuarios?characterEncoding=latin1";
			String usuario = "root";
			String contraseña = "ros08jua27";
			
			con = DriverManager.getConnection(ur1, usuario, contraseña);
			
			System.out.println("Conectado");
			
		} catch (ClassNotFoundException e) {
			System.out.println("Error --> al cargar el Driver");
		
			e.printStackTrace();
		} catch (SQLException e) {
			
			System.out.println("Error --> con la BD");
			e.printStackTrace();
		}
		
		
		
		
		return con;
		
	}
	
	public void ingresarRegistro(String nombre, String marca, String categoria, String precio, String cantidad) {
		try {
			PreparedStatement pstm = (PreparedStatement) con.prepareStatement("INSERT INTO productos VALUES (null,?, ?, ?, ?, ?)");
			pstm.setString(1, nombre);
			pstm.setString(2, marca);
			pstm.setString(3, categoria);
			pstm.setString(4, precio);
			pstm.setString(5, cantidad);
			
			pstm.execute();
			JOptionPane.showMessageDialog(null, "Producto agregado");
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			System.out.println(e.getMessage());
		}
	}
	
	

}