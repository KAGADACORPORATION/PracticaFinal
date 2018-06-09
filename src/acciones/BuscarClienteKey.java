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

	public BuscarClienteKey(Puente puente) {
		super();
		this.puente = puente;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		Utiles.ActualizarTablaCliente(puente);
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
	}

}