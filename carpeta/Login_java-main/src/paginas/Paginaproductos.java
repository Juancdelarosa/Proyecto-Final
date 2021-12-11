package paginas;

import java.awt.EventQueue;

import conexionbase.MySQLConexion;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import fasesusuarios.Actualizados;

import fasesusuarios.Productos;
import fasesusuarios.Registrados;

import funciones.Actualizar;
import funciones.Eliminar;
import funciones.Registrar;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.Toolkit;

public class Paginaproductos {

	JFrame frmProductos;
	private JTextField txtNombre2;
	private JLabel lblCrear1;
	private JLabel lblCrear2;
	private JLabel lblCrear3;
	private JLabel lblCrear4;
	private JLabel lblCrear5;
	private JTextField txtCategoria;
	private JTextField txtPrecio;
	private JTextField txtMarca;
	private JButton btnGuardar;
	private JButton btnCerrarSeccion;
	private JButton btnNuevo;
	private JButton btnNewButton;
	private JTextField txtCantidad;
	
	private JScrollPane scrollPane;
	private JTable table;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Paginaproductos window = new Paginaproductos();
					window.frmProductos.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Paginaproductos() {
		initialize();
	}

	
	private void initialize() {
		frmProductos = new JFrame();
		frmProductos.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 12));
		frmProductos.getContentPane().setBackground(new Color(218, 165, 32));
		frmProductos.setTitle("Productos");
		frmProductos.setBounds(100, 100, 923, 583);
		frmProductos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 64, 660, 311);


		JLabel lblNewLabel = new JLabel("Lista de Productos.");
		lblNewLabel.setBounds(9, 12, 369, 41);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 34));

		btnNuevo = new JButton("Nuevo");
		btnNuevo.setBounds(719, 86, 119, 34);
		btnNuevo.setForeground(Color.BLACK);
		btnNuevo.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNombre2.setText("");
				txtMarca.setText("");
				txtCategoria.setText("");
				txtCantidad.setText("");
				txtPrecio.setText("");
				btnCerrarSeccion.setVisible(false);
				btnGuardar.setVisible(true);
				

			}
		});

		btnCerrarSeccion = new JButton("Cerrar Sesion");
		btnCerrarSeccion.setBounds(699, 186, 153, 41);
		btnCerrarSeccion.setForeground(Color.BLACK);
		btnCerrarSeccion.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCerrarSeccion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmProductos.dispose();
				Paginalogin window = new Paginalogin();
				window.frmLogin.setVisible(true);
			}
		});

		txtNombre2 = new JTextField();
		txtNombre2.setBounds(27, 447, 132, 20);
		txtNombre2.setColumns(10);

		MySQLConexion con = new MySQLConexion();
		Connection conexion = con.getConexion();

		String sql = "SELECT * FROM productos";
		Statement st;
		String nombreColumnas[] = { "nombre", "marca", "categoria", "precio", "cantidad" };

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {}, nombreColumnas));
		
		// creacion de la tabla
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("nombre");
		model.addColumn("marca");
		model.addColumn("categoria");
		model.addColumn("precio");
		model.addColumn("cantidad");
		table.setModel(model);

		Object[] dato = new Object[5];
		try {
			st = conexion.createStatement();
			ResultSet result = st.executeQuery(sql);

			while (result.next()) {

				dato[0] = result.getString("nombre");
				dato[1] = result.getString("marca");
				dato[2] = result.getString("categoria");
				dato[3] = result.getInt("precio");
				dato[4] = result.getInt("cantidad");
				model.addRow(dato);
			}

		} catch (Exception e) {
			
		}
		
		scrollPane.setViewportView(table);
		frmProductos.getContentPane().setLayout(null);
		frmProductos.getContentPane().add(btnNuevo);
		
		
		frmProductos.getContentPane().add(scrollPane);
		frmProductos.getContentPane().add(txtNombre2);
		frmProductos.getContentPane().add(btnCerrarSeccion);
		frmProductos.getContentPane().add(lblNewLabel);

		lblCrear1 = new JLabel("Nombre:");
		lblCrear1.setBounds(27, 422, 57, 14);
		lblCrear1.setFont(new Font("Tahoma", Font.BOLD, 12));
		frmProductos.getContentPane().add(lblCrear1);

		lblCrear2 = new JLabel("Marca:");
		lblCrear2.setBounds(193, 422, 68, 14);
		lblCrear2.setFont(new Font("Tahoma", Font.BOLD, 12));
		frmProductos.getContentPane().add(lblCrear2);

		lblCrear3 = new JLabel("Categoria:");
		lblCrear3.setBounds(365, 422, 68, 14);
		lblCrear3.setFont(new Font("Tahoma", Font.BOLD, 12));
		frmProductos.getContentPane().add(lblCrear3);

		lblCrear4 = new JLabel("Cantidad Disponible:");
		lblCrear4.setBounds(193, 488, 132, 14);
		lblCrear4.setFont(new Font("Tahoma", Font.BOLD, 12));
		frmProductos.getContentPane().add(lblCrear4);

		lblCrear5 = new JLabel("Precio:");
		lblCrear5.setBounds(27, 488, 57, 14);
		lblCrear5.setFont(new Font("Tahoma", Font.BOLD, 12));
		frmProductos.getContentPane().add(lblCrear5);

		txtCategoria = new JTextField();
		txtCategoria.setBounds(365, 447, 132, 20);
		frmProductos.getContentPane().add(txtCategoria);
		txtCategoria.setColumns(10);

		txtPrecio = new JTextField();
		txtPrecio.setBounds(27, 513, 132, 20);
		frmProductos.getContentPane().add(txtPrecio);
		txtPrecio.setColumns(10);

		txtMarca = new JTextField();
		txtMarca.setBounds(193, 447, 132, 20);
		frmProductos.getContentPane().add(txtMarca);
		txtMarca.setColumns(10);

		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(536, 478, 104, 34);
		btnGuardar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnGuardar.setForeground(Color.BLACK);
		btnGuardar.setVisible(false);

		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String nombre2 = txtNombre2.getText().toString();				
				String marca = txtMarca.getText().toString();
				String categoria = txtCategoria.getText().toString();
				String precio =  txtPrecio.getText().toString();
				String cantidad =  txtCantidad.getText().toString();
				

				MySQLConexion con = new MySQLConexion();
				Connection conexion = MySQLConexion.getConexion();
				con.ingresarRegistro(nombre2, marca, categoria, precio, cantidad);

				String sql = "SELECT * FROM productos";
				
				String nombreColumnas[] = { "nombre", "marca", "categoria", "precio", "cantidad" };
				
				DefaultTableModel model = new DefaultTableModel(null, nombreColumnas);
				
				String[] dato = new String[5];
				try {
					Statement st= conexion.createStatement();
					ResultSet result = st.executeQuery(sql);
					result.next();
					while (result.next()) {

						dato[0] = result.getString("Nombre");
						dato[1] = result.getString("Marca");
						dato[2] = result.getString("Categoria");
						dato[3] = result.getString("Precio");
						dato[4] = result.getString("Cantidad Disponible");
						model.addRow(dato);
					}
					
					table.setModel(model);

				} catch (Exception e3) {
					System.out.println(e3.getMessage());
					
				}
				txtNombre2.setText("");
				txtMarca.setText("");
				txtCategoria.setText("");
				txtCantidad.setText("");
				txtPrecio.setText("");
				
				btnCerrarSeccion.setVisible(false);
				
			

			}
			
		}

	);
		frmProductos.getContentPane().add(btnGuardar);
		
		btnNewButton = new JButton("Volver");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				volver();
			}
		});
		btnNewButton.setBounds(719, 278, 119, 34);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		frmProductos.getContentPane().add(btnNewButton);
		
		txtCantidad = new JTextField();
		txtCantidad.setBounds(193, 513, 132, 20);
		frmProductos.getContentPane().add(txtCantidad);
		txtCantidad.setColumns(10);
		
		
}
protected void volver() {
		

		
		frmProductos.dispose();
		Paginaseleccion window = new Paginaseleccion();
		window.frmSeleccion.setVisible(true);
		
	
	
}
}