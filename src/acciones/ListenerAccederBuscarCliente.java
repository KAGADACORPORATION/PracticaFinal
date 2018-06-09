package acciones;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.TreeMap;

import javax.rmi.CORBA.Util;
import javax.swing.table.DefaultTableModel;

import control.Puente;
import modelo.Cliente;
import utiles.Utiles;
import vista.VistaEjecutarBuscarCliente;

public class ListenerAccederBuscarCliente implements ActionListener {

	private Puente puente;

	public ListenerAccederBuscarCliente(Puente puente) {
		super();
		this.puente = puente;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		puente.getContentPane().removeAll();
		puente.getContentPane().setLayout(new GridLayout(1, 1, 0, 0));
		puente.getContentPane().add(puente.getVistaEjecutarBuscarCliente());
		Utiles.ActualizarTablaCliente(puente);
	}

	public VistaEjecutarBuscarCliente getVistaEjecutarBuscarCliente() {
		return this.getVistaEjecutarBuscarCliente();
	}

}
