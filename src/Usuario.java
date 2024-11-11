import java.time.LocalDate;
import java.util.LinkedList;

public abstract class Usuario {
	private String nombre;
	private String contraseña;
	private LocalDate fecha_de_alta;
	private LinkedList<Usuario> usuarios;
	public Usuario(String nombre, String contraseña, LocalDate fecha_de_alta) {
		super();
		this.nombre = nombre;
		this.contraseña = contraseña;
		this.fecha_de_alta = fecha_de_alta;
		
		private static LinkedList<Usuario> usuarios = new LinkedList<Usuario>;
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
	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", contraseña=" + contraseña + ", fecha_de_alta=" + fecha_de_alta + "]";
	}
	
	public void Login(String nombre, String contraseña, Cliente cliente) {
		for (Usuario usuario : usuarios) {
			if (usuario.getNombre().equals(nombre) && usuario.getContraseña().equals(contraseña)) {
				return
			}
		}
	}
	public voidverHistorial() {
		return null;
	}
	

}

