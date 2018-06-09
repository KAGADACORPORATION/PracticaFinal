package acciones;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeMap;

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
	public void keyReleased(KeyEvent e) {
		VistaEjecutarBuscarCliente vista = puente.getVistaAccederBuscarCliente().getVistaEjecutarBuscarCliente();
		cadena = vista.getTextField().getText();
		limpiarTabla();
		llenarTabla();
	}

	
	/**
	 * 
	 */
	private void llenarTabla() {
		TreeMap<String, Integer> indiceClientes = puente.getLogica().getIndice();
		for (int i = 0; i < indiceClientes.size(); i++) {
			Cliente clienteAux = (Cliente) this.puente.getLogica().obtenerCliente(i);
			if(clienteAux.getRazonSocial().toLowerCase().startsWith(cadena)) {
				String adicion[] = { clienteAux.getRazonSocial(), clienteAux.getDniCif(), clienteAux.getDireccion(),
						clienteAux.getTelefono() };
				this.puente.getModeloTabla().addRow(adicion);
			}
		}
	}

	/**
	 * 
	 */
	private void limpiarTabla() {
		while (this.puente.getModeloTabla().getRowCount() > 0) {
			this.puente.getModeloTabla().removeRow(0);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
	}

}