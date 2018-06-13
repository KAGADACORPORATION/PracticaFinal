package acciones;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.rmi.CORBA.Util;

import control.Puente;
import utiles.Utiles;

public class ListenerAccederBuscarArticulo implements ActionListener {
	
	private Puente puente;

	public ListenerAccederBuscarArticulo(Puente puente) {
		super();
		this.puente = puente;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		puente.getContentPane().removeAll();
		puente.getContentPane().setLayout(new GridLayout(1, 1, 0, 0));
		puente.getContentPane().add(puente.getVistaEjecutarBuscarArticulo());
		Utiles.ActualizarTablaArticulos(puente);
	}

}
