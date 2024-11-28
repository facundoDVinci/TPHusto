import java.util.LinkedList;

public class Cuenta {
	private int nroCuenta;
	private double Saldo;
	private double Deposito;
	private LinkedList<Movimiento> movimientos = new LinkedList<Movimiento>();
	public Cuenta(int nroCuenta, double saldo, double deposito) {
		super();
		this.nroCuenta = nroCuenta;
		Saldo = saldo;
		Deposito = deposito;
		
	}
	public int getNroCuenta() {
		return nroCuenta;
	}
	public void setNroCuenta(int nroCuenta) {
		this.nroCuenta = nroCuenta;
	}
	public double getSaldo() {
		return Saldo;
	}
	public void setSaldo(double saldo) {
		Saldo = saldo;
	}
	public double getDeposito() {
		return Deposito;
	}
	public void setDeposito(double deposito) {
		Deposito = deposito;
	}
	public LinkedList<Movimiento> getMovimientos() {
		return movimientos;
	}
	public void setMovimientos(LinkedList<Movimiento> movimientos) {
		this.movimientos = movimientos;
	}

	
	
	@Override
	public String toString() {
		return "nroCuenta=" + nroCuenta + ", Saldo=" + Saldo + ", Deposito=" + Deposito + ", movimientos="
				+ movimientos + "\n";
	}
	
	
	
}

