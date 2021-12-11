package funciones;

import com.mysql.jdbc.PreparedStatement;

import conexionbase.MySQLConexion;
import fasesusuarios.Productos;

public class Registrarproductos {
	public int registrarproductos(Productos producto) {
		int rs = 0;
	
	
	String sql = "INSERT INTO productos values (?,?,?,?,?)";
	try (PreparedStatement ps = (PreparedStatement) MySQLConexion.getConexion().prepareStatement(sql)){
		ps.setString(1, producto.getNombre2().trim());
		ps.setString(2, producto.getMarca());
		ps.setString(3, producto.getCategoria());
		ps.setLong(4, producto.getPrecio());
		ps.setLong(5, producto.getCantidad());
		
		
		rs = ps.executeUpdate();
		
	} catch (Exception e) {
		
	}
	
	return rs;
}


}
