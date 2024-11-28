
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedList;

import javax.swing.JOptionPane;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cuenta cuenta = new Cuenta(0,5000,5000);
		Cliente yo = new Cliente("","", LocalDate.of(1, 1, 1), cuenta);
		Movimiento movimiento = new Movimiento(null, "",yo);
		Cuenta cuenta2 = new Cuenta(0,50,50);

		Cliente otro = new Cliente("","", LocalDate.of(1, 1,1), cuenta2);
		JOptionPane.showMessageDialog(null, Usuario.getClientes());
		//Logearse
		int OpcionLogin;
		do {
		
		OpcionLogin = JOptionPane.showOptionDialog(null, "Bienvenido al Banco", null, 0, 0, null, OpcionesLogin.values(), OpcionesLogin.values());
		
		switch (OpcionLogin) {
		case 0:
			//Registrar
			if(yo.getCuenta().getNroCuenta()<1) {
			yo.Register(null, null, cuenta);
			
			}else {
				if(otro.getCuenta().getNroCuenta()==2) {
					JOptionPane.showMessageDialog(null, "No puedes registrar otra cuenta (Maximo 2)");
					
					}else {
				otro.Register(null, null, cuenta2);
					}
				
			}
			break;
		case 1:
			Cliente Logueado = yo.Login();
			if (Logueado!=null) {
				JOptionPane.showMessageDialog(null, "Esto es true");
				
				//ACA IRIA EL MENU PRINCIPAL
				
				int OpcionMenu;
				do {
					OpcionMenu = JOptionPane.showOptionDialog(null, "Bienvenido al Banco " + Logueado.getNombre(), null, 0, 0, null, Opciones.values(), Opciones.values());
					
					switch (OpcionMenu) {
					case 0: {
						//Transferir
						
						if(Logueado.getCuenta().getNroCuenta()==1) {
						JOptionPane.showMessageDialog(null, Logueado.Transferir(yo, otro));
						}else {
							JOptionPane.showMessageDialog(null, Logueado.Transferir(otro, yo));
						}
						break;
					}
					case 1: {
						//Depositar
						JOptionPane.showMessageDialog(null, Logueado.Depositar()); 
						
						break;
					}
					case 2: {
						//Retirar
						JOptionPane.showMessageDialog(null, Logueado.Retirar()); 
						
						break;
					}
					case 3: {
						//Ver saldo
						JOptionPane.showMessageDialog(null, Logueado.verSaldo()); 
						break;
					}
					case 4: {
						//Movimientos
						JOptionPane.showMessageDialog(null, Logueado.Movimientos()); 
						break;
					}
					default:
						break;
					}
					
				} while (OpcionMenu!=5);
				
					
					
			} else {
				JOptionPane.showMessageDialog(null, "Login fallido");
			}
			
			
		default:
			break;
		}
	}while(OpcionLogin!=2);
		
	}
}
