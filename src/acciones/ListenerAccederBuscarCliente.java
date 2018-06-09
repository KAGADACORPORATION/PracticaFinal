package acciones;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.TreeMap;

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
		VistaEjecutarBuscarCliente vista = puente.getVistaEjecutarBuscarCliente();
		while (this.puente.getModeloTabla().getRowCount() > 0) {
			this.puente.getModeloTabla().removeRow(0);
		}
		TreeMap<String, Integer> indiceClientes = puente.getLogica().getIndice();
		for (int i = 0; i < indiceClientes.size(); i++) {
			Cliente clienteAux = (Cliente) this.puente.getLogica().obtenerCliente(i);
			if(clienteAux.getRazonSocial().toLowerCase().startsWith("")) {
				String adicion[] = { clienteAux.getRazonSocial(), clienteAux.getDniCif(), clienteAux.getDireccion(),
						clienteAux.getTelefono() };
				this.puente.getModeloTabla().addRow(adicion);
			}
		}
		vista.getTable().addMouseListener(new ListenerMouseTablaCliente(puente));
		Utiles.actualizar(puente);

	}

	public VistaEjecutarBuscarCliente getVistaEjecutarBuscarCliente() {
		return this.getVistaEjecutarBuscarCliente();
	}

}
