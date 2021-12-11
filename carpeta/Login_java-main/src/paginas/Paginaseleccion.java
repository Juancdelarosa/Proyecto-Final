package paginas;
import java.awt.EventQueue;
import funciones.Login;
import fasesusuarios.Usuario;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JPasswordField;
import java.awt.Toolkit;
import javax.swing.SwingConstants;

public class Paginaseleccion {

	JFrame frmSeleccion;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Paginaseleccion window = new Paginaseleccion();
					window.frmSeleccion.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Paginaseleccion() {
		initialize();
	}

	private void initialize() {
		frmSeleccion = new JFrame();
		frmSeleccion.getContentPane().setBackground(new Color(218, 165, 32));
		frmSeleccion.setBackground(Color.ORANGE);
		frmSeleccion.setFont(new Font("Times New Roman", Font.BOLD, 12));
		frmSeleccion.setForeground(Color.BLACK);
		frmSeleccion.getContentPane().setForeground(Color.BLACK);
		frmSeleccion.setTitle("Tarea 4");
		frmSeleccion.setBounds(100, 100, 464, 262);
		frmSeleccion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSeleccion.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel((String) null);
		lblNewLabel.setBounds(0, 0, 434, 0);
		frmSeleccion.getContentPane().add(lblNewLabel);

		JLabel Titulo = new JLabel("Elija una Opcion.");
		Titulo.setForeground(Color.BLACK);
		Titulo.setFont(new Font("Tahoma", Font.BOLD, 34));
		Titulo.setBounds(83, 29, 295, 50);
		frmSeleccion.getContentPane().add(Titulo);

		JButton btnNewButton = new JButton("Gestion de Productos");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				entrar();
			}
		});
		btnNewButton.setBounds(251, 116, 187, 33);
		frmSeleccion.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Gestion de Usuarios");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registrar();

			}
		});
		btnNewButton_1.setBounds(10, 116, 187, 33);
		frmSeleccion.getContentPane().add(btnNewButton_1);
	}

	protected void registrar() {
		
		frmSeleccion.dispose();
		Usuariosregistrados window = new Usuariosregistrados();
		window.frmRegistrados.setVisible(true);
		
	}


	protected void entrar() {
		
		
			
		frmSeleccion.dispose();
			Paginaproductos window = new Paginaproductos();
			window.frmProductos.setVisible(true);
		}
		
			
		
	}

