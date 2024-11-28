import java.time.LocalDate;
import java.util.LinkedList;

import javax.swing.JOptionPane;

public abstract class  Usuario {
	private String nombre;
	private String contraseña;
	private LocalDate fecha_de_alta;
	private static LinkedList<Cliente> clientes = new LinkedList<Cliente>();
	
	//
	
	
	public Usuario(String nombre, String contraseña, LocalDate fecha_de_alta) {
		super();
		this.nombre = nombre;
		this.contraseña = contraseña;
		this.fecha_de_alta = fecha_de_alta;
		
		
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	public LocalDate getFecha_de_alta() {
		return fecha_de_alta;
	}
	public void setFecha_de_alta(LocalDate fecha_de_alta) {
		this.fecha_de_alta = fecha_de_alta;
	}
	

	public static LinkedList<Cliente> getClientes() {
		return clientes;
	}

	public static void setClientes(LinkedList<Cliente> clientes) {
		Usuario.clientes = clientes;
	}

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", contraseña=" + contraseña + ", fecha_de_alta=" + fecha_de_alta + "]";
	}
	
	public static void Register(String nombre, String contraseña, Cuenta cuenta) {
		String nombreUsuario = "";
		String contraseñaUsuario = "";
		boolean seguir= false;
	
		
		//NOMBRE
		do {
			seguir=true;
			nombreUsuario = JOptionPane.showInputDialog("Introdusca un nombre de usuario");
			if (nombreUsuario.isEmpty()) {
				JOptionPane.showMessageDialog(null, "No puedes dejar el espacio vacio");
				seguir=false;
			} else {
				for (int i = 0; i < nombreUsuario.length(); i++) {
					if (Character.isDigit(nombreUsuario.charAt(i))) {
						JOptionPane.showMessageDialog(null, "No puedes poner numeros");
						seguir=false;
						break;
					}
					
						
					}
				for (Cliente usuario : Usuario.getClientes()) {
					
					if(nombreUsuario.contains(usuario.getNombre())) {
						JOptionPane.showMessageDialog(null, "Usuario ya existe");
						seguir=false;
						break;
					}
					
				}
			}
			
		} while (seguir!=true);
		seguir=true;
		JOptionPane.showMessageDialog(null, "Nombre introducido");
		
		
		
		//CONTRASEÑA
		do {
			seguir=true;
			contraseñaUsuario = JOptionPane.showInputDialog("Introdusca una contraseña (Debe tener igual o mas de 8 caracteres)");
			if (contraseñaUsuario.isEmpty()) {
				JOptionPane.showMessageDialog(null, "No puedes dejar el espacio vacio");
				seguir=false;
			} else {
				if (contraseñaUsuario.length()<8) {
					JOptionPane.showMessageDialog(null, "No cumple con los caracteres necesarios");
					seguir=false;
				}
			}
			
		} while (seguir!=true);
		JOptionPane.showMessageDialog(null, "Contraseña introducido");
		JOptionPane.showMessageDialog(null, "Usuario creado");
		//"Nombre= " + nombreUsuario + " Contraseña= " + contraseñaUsuario
	
		Cliente nuevo = new Cliente(nombreUsuario, contraseñaUsuario, LocalDate.now(), cuenta);
		nuevo.setNombre(nombreUsuario);
		nuevo.setContraseña(contraseñaUsuario);
		nuevo.setFecha_de_alta(LocalDate.now().plusYears(1));
		cuenta.setSaldo(10000);
		cuenta.setDeposito(5000);
		if(cuenta.getNroCuenta()==0) {
			cuenta.setNroCuenta(1);
		}
		for (Cliente usuario : Usuario.getClientes()) {
			
			if(usuario.getCuenta().getNroCuenta()==usuario.getCuenta().getNroCuenta()) {
				cuenta.setNroCuenta(cuenta.getNroCuenta()+1);
			}
			
		}
		nuevo.setCuenta(cuenta);
		Usuario.getClientes().add(nuevo);
		
		
		
		
	}
	
	public Cliente Login() {
		String nombre,  contraseña;
		
		nombre = JOptionPane.showInputDialog("Introducir nombre");
		if (nombre.isEmpty()) {
			JOptionPane.showMessageDialog(null, "No puedes dejar vacio");
			return null;
		}else {
		contraseña = JOptionPane.showInputDialog("Introducir contraseña");
		for (Cliente usuario : Usuario.getClientes()) {
			if (usuario.getNombre().equals(nombre) && usuario.getContraseña().equals(contraseña)) {
				JOptionPane.showMessageDialog(null, "Login correctamente");
				return usuario;
			}
			
		}
		
		}
		JOptionPane.showMessageDialog(null, "Nombre o Contraseña incorrectos");
		return null;
	}
	

}

