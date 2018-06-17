package acciones;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import control.Puente;
import utiles.Utiles;

public class ListenerAccederAltaArticulo implements ActionListener {
	private Puente puente;

	public ListenerAccederAltaArticulo(Puente puente) {
		super();
		this.puente = puente;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		puente.getContentPane().removeAll();
		puente.getContentPane().setLayout(new GridLayout(1, 1, 0, 0));
		puente.getContentPane().add(puente.getVistaEjecutarAltaArticulo());
		Utiles.actualizar(puente);
	}

}
