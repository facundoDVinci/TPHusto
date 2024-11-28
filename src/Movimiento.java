import java.time.LocalDateTime;

public class Movimiento{
	private LocalDateTime fecha;
	private String detalle; 
	private Cliente cliente;
	public Movimiento(LocalDateTime fecha, String detalle,Cliente cliente) {
		super();
		this.fecha = fecha;
		this.detalle = detalle;
		this.cliente = cliente;
	}
	public LocalDateTime getFecha() {
		return fecha;
	}
	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}
	public String getDetalle() {
		return detalle;
	}
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	@Override
	public String toString() {
		return "Movimiento [Cuenta= " + cliente.getNombre() + " Fecha= " + fecha + ", detalle= " + detalle + "] \n";
	}
}
