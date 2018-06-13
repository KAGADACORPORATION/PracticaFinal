package acciones;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import control.Puente;
import modelo.Cliente;
import utiles.Utiles;
import vista.VistaEjecutarBuscarArticulo;

public class BuscarArticulo implements KeyListener {

	private	 Puente puente;

	public BuscarArticulo(Puente puente) {
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
		Utiles.ActualizarTablaArticulos(puente);
	}
}