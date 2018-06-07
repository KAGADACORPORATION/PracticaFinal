package acciones;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import control.Logica;
import control.Puente;
import facade.Datos;
import modelo.Cliente;
import utiles.Utiles;
import vista.VistaEjecutarBuscarArticulo;
import vista.VistaEjecutarBuscarCliente;

public class BuscarClienteKey implements KeyListener {

	private Puente puente;
	private String cadena;

	public BuscarClienteKey(Puente puente) {
		super();
		this.puente = puente;
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
		VistaEjecutarBuscarCliente vista = puente.getVistaAccederBuscarCliente().getVistaEjecutarBuscarCliente();
		cadena = vista.getTextField().getText();
		while (this.puente.getModeloTabla().getRowCount() > 0) {
			this.puente.getModeloTabla().removeRow(0);
		}
		
		ArrayList<Cliente> clientes = this.puente.getLogica().getDatos().getClientes();
		for (int i = 0; i < clientes.size(); i++) {
			Cliente clienteAux = this.puente.getLogica().getDatos().getClientes().get(i);
			String adicion[] = { clienteAux.getRazonSocial(), clienteAux.getDniCif(), clienteAux.getDireccion(),
					clienteAux.getTelefono() };
			if (adicion[0].toLowerCase().startsWith(cadena.toString())) {
				this.puente.getModeloTabla().addRow(adicion);
			}

		}
	}

}