package fasesusuarios;

public class Usuario {
	private String usuario;
	private String clave;
	private String nombre;
	private String apellido;
	private String correo;
	private int numero;
	
	private String nombre2;
	private String marca;
	private String categoria;
	private int precio;
	private int cantidad;
	

	public Usuario(String usuario, String clave, String nombre, String apellido, String correo, int numero) {

		this.usuario = usuario;
		this.nombre = nombre;
		this.apellido = apellido;
		this.numero = numero;
		this.correo = correo;
		this.clave = clave;

	}

	public Usuario() {
	
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public Usuario(String nombre2, String marca, String categoria, int precio, int cantidad) {

		this.setNombre2(nombre2);
		this.marca = marca;
		this.setCategoria(categoria);
		this.setPrecio(precio);
		this.setCantidad(cantidad);
		

}


	public String getNombre2() {
		return nombre2;
	}


	public void setNombre2(String nombre2) {
		this.nombre2 = nombre2;
	}
	
	public String getMarca() {
		return marca;
	}


	public void setMarca(String marca) {
		this.marca = marca;
	}


	public String getCategoria() {
		return categoria;
	}


	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}


	public int getPrecio() {
		return precio;
	}


	public void setPrecio(int precio) {
		this.precio = precio;
	}


	public int getCantidad() {
		return cantidad;
	}


	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	

}
