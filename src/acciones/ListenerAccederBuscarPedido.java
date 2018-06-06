package acciones;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import control.Puente;
import utiles.Utiles;

public class ListenerAccederBuscarPedido implements ActionListener {

	public ListenerAccederBuscarPedido(Puente puente) {
		super();
		this.puente = puente;
	}

	private Puente puente;

	@Override
	public void actionPerformed(ActionEvent e) {
		puente.getContentPane().removeAll();
		puente.getContentPane().setLayout(new GridLayout(1, 1, 0, 0));
		puente.getContentPane().add(puente.getVistaAccederPedido().getVistaEjecutarBuscarPedido());
		Utiles.actualizar(puente);
	}

}
