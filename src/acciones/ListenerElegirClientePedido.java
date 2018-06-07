package acciones;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;

import control.Puente;
import modelo.Cliente;
import utiles.Utiles;
import vista.VistaEjecutarBuscarCliente;

public class ListenerElegirClientePedido implements ActionListener {

	private Puente puente;

	public ListenerElegirClientePedido(Puente puente) {
		this.puente = puente;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		JFrame ventana = new JFrame();
		ventana.setBounds(500, 500, 670, 413);
		ventana.getContentPane().removeAll();
		ventana.getContentPane().add(puente.getVistaEjecutarBuscarCliente());
		VistaEjecutarBuscarCliente vista = puente.getVistaAccederBuscarCliente().getVistaEjecutarBuscarCliente();

		ArrayList<Cliente> clientes = this.puente.getLogica().getDatos().getClientes();
		while (this.puente.getModeloTabla().getRowCount() > 0) {
			this.puente.getModeloTabla().removeRow(0);
		}
		for (int i = 0; i < clientes.size(); i++) {
			Cliente clienteAux = this.puente.getLogica().getDatos().getClientes().get(i);
			String adicion[] = { clienteAux.getRazonSocial(), clienteAux.getDniCif(), clienteAux.getDireccion(),
					clienteAux.getTelefono() };
			// addrow al default
			this.puente.getModeloTabla().addRow(adicion);

			Utiles.actualizar(puente);
		}
		vista.getTable().addMouseListener(new ListenerMouseTablaCliente(puente));
		Utiles.actualizar(puente);
		ventana.setVisible(true);

	}
}
