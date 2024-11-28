import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.swing.JOptionPane;

public class Cliente extends Usuario {
	private Cuenta cuenta;

	public Cliente(String nombre, String contraseña, LocalDate fecha_de_alta, Cuenta cuenta) {
		super(nombre, contraseña, fecha_de_alta);
		this.cuenta = cuenta;
	}

	public Cuenta getCuenta() {
		return cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

	@Override
	public String toString() {
		return "Cliente \n cuenta=" + cuenta + ", Usuario= Nombre: " + this.getNombre() + " Alta: "
				+ this.getFecha_de_alta() + " Contraseña: " + this.getContraseña() + " \n";
	}

	public String Transferir(Cliente emisor, Cliente receptor) {
		String nombre = "";
		String InsertarTransferencia;
		int transferencia = 0;

		

		nombre = JOptionPane.showInputDialog("Introducir nombre del usuario al cual quieres transferir dinero");
		for (Cliente usuario : Usuario.getClientes()) {
			if (usuario.getNombre().equals(nombre)) {
				if (usuario.getCuenta().getNroCuenta()==emisor.getCuenta().getNroCuenta()) {
					JOptionPane.showMessageDialog(null, "No puedes transferirte a ti mismo");
					break;
				}
				for (int i = 0; i < nombre.length(); i++) {
					if (Character.isDigit(nombre.charAt(i))) {
						JOptionPane.showMessageDialog(null, "No puedes poner numeros");
						break;
					} 
				}
				
				JOptionPane.showMessageDialog(null, "existe ese usuario");
				InsertarTransferencia = JOptionPane.showInputDialog("Cuanto quieres transferir?");
				if (InsertarTransferencia.isEmpty()) {
					JOptionPane.showMessageDialog(null, "No puede estar vacio");
					break;
				} else {
					
					for (int i = 0; i < InsertarTransferencia.length(); i++) {
						if (Character.isDigit(InsertarTransferencia.charAt(i))) {

						} else {
							JOptionPane.showMessageDialog(null, "Solo pùedes poner numeros");
							break;
						}
					}
					
					
					

					transferencia = Integer.parseInt(InsertarTransferencia);
					if (transferencia < 0) {
						JOptionPane.showMessageDialog(null, "No puedes ingresar numeros negativos");
						break;

					}
					
				}
				
				
				
				emisor.getCuenta().setSaldo(emisor.getCuenta().getSaldo() - transferencia);
				receptor.getCuenta().setSaldo(receptor.getCuenta().getSaldo() + transferencia);
				
				Movimiento movimiento = new Movimiento(LocalDateTime.now(), "Transferencia. Cantidad enviada: $ " + transferencia, this);
				Movimiento movimientoReceptor = new Movimiento(LocalDateTime.now(), "Transferencia. Cantidad recibida: $ " + transferencia, this);
				emisor.getCuenta().getMovimientos().add(movimiento);
				receptor.getCuenta().getMovimientos().add(movimientoReceptor);

				return "transferencia completada";

			} else {
				
			}
		}

		return null;
	}

	public String Depositar() {
		String Insertardeposito;
		double Depositar = 0;
		boolean seguir = true;
		
		if (cuenta.getSaldo() <= 0) {
			return "Tu saldo esta vacio";
		} else {
			do {
				Insertardeposito = JOptionPane.showInputDialog("Cuanto quieres depositar?");
				if (Insertardeposito.isEmpty()) {
					JOptionPane.showMessageDialog(null, "No puede estar vacio");
					seguir = false;
				} else {
					for (int i = 0; i < Insertardeposito.length(); i++) {
						if (Character.isDigit(Insertardeposito.charAt(i))) {
							seguir = true;

						} else {
							JOptionPane.showMessageDialog(null, "Solo pùedes poner numeros");
							seguir = false;
							break;
						}
					}
					if (seguir == true) {
						Depositar = Integer.parseInt(Insertardeposito);
						if (Depositar < 0) {
							JOptionPane.showMessageDialog(null, "No puedes ingresar numeros negativos");
							seguir = false;

						}
					}
				}

				
			} while (seguir != true);
			if (Depositar > cuenta.getSaldo()) {
				Depositar = 0;
				Depositar = Depositar + cuenta.getSaldo();
			}
			Movimiento movimiento = new Movimiento(LocalDateTime.now(), "Deposito $" + Depositar, this);
			this.cuenta.setDeposito(cuenta.getDeposito() + Depositar);
			this.cuenta.setSaldo(cuenta.getSaldo() - Depositar);
			this.cuenta.getMovimientos().add(movimiento);

			if (this.cuenta.getDeposito() < 0) {
				this.cuenta.setDeposito(0);
			}
			if (this.cuenta.getSaldo() < 0) {
				this.cuenta.setSaldo(0);
			}

			return "deposito completado";
		}
	}

	public String Retirar() {
		String Insertarretiro;
		double Retirar = 0;
		boolean seguir = true;
		if (cuenta.getDeposito() <= 0) {
			return "Tu deposito esta vacio";
		} else {
			do {
				Insertarretiro = JOptionPane.showInputDialog("Cuanto quieres retirar?");
				if (Insertarretiro.isEmpty()) {
					JOptionPane.showMessageDialog(null, "No puede estar vacio");
					seguir = false;
				} else {
					for (int i = 0; i < Insertarretiro.length(); i++) {
						if (Character.isDigit(Insertarretiro.charAt(i))) {
							seguir = true;

						} else {
							JOptionPane.showMessageDialog(null, "Solo pùedes poner numeros");
							seguir = false;
							break;
						}
					}
					if (seguir == true) {
						Retirar = Integer.parseInt(Insertarretiro);
						if (Retirar < 0) {
							JOptionPane.showMessageDialog(null, "No puedes ingresar numeros negativos");
							seguir = false;

						}
					}
				}
				
			} while (seguir != true);
			if (Retirar > cuenta.getDeposito()) {
				Retirar = 0;
				Retirar = Retirar + cuenta.getDeposito();
			}
			Movimiento movimiento = new Movimiento(LocalDateTime.now(), "Retirar $" + Retirar, this);
			cuenta.setSaldo(cuenta.getSaldo() + Retirar);
			cuenta.setDeposito(cuenta.getDeposito() - Retirar);
			cuenta.getMovimientos().add(movimiento);

			if (cuenta.getDeposito() < 0) {
				cuenta.setDeposito(0);
			}
			if (cuenta.getSaldo() < 0) {
				cuenta.setSaldo(0);
			}

			return "Retiro completado";
		}
	}

	public String verSaldo() {
		return "Cuenta: " + this.getNombre() + "\n Deposito: $" + this.cuenta.getDeposito() + "\n Saldo: $"
				+ this.cuenta.getSaldo() + "\n";
	}

	public String Movimientos() {
		return "Movimientos: \n" + cuenta.getMovimientos();
	}

}
