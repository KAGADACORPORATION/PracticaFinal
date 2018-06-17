package vista;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class PanelCliente extends JPanel {

	private JButton BotonCliente;
	private VistaAccederAltaCliente vistaAccederAltaCliente = new VistaAccederAltaCliente();
	private VistaAccederBuscarCliente vistaAccederBuscarCliente = new VistaAccederBuscarCliente();
	private JPanel panel;
	private JLabel lblClientes;

	public PanelCliente() {
		setLayout(new BorderLayout(0, 0));
		panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		BotonCliente = new JButton("");
		panel.add(BotonCliente);
		lblClientes = new JLabel("CLIENTES");
		lblClientes.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblClientes.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblClientes, BorderLayout.SOUTH);
	}

	public VistaAccederAltaCliente getVistaAccederAltaCliente() {
		return vistaAccederAltaCliente;
	}

	public VistaAccederBuscarCliente getVistaAccederBuscarCliente() {
		return vistaAccederBuscarCliente;
	}

	public JPanel getPanel() {
		return panel;
	}

	public JLabel getLblClientes() {
		return lblClientes;
	}

	public JButton getBotonCliente() {
		return BotonCliente;
	}

	public JButton getBtnAltaCliente() {
		return vistaAccederAltaCliente.getBtnAltaCliente();
	}

	public JButton getBtnBuscarCliente() {
		return vistaAccederBuscarCliente.getBtnBuscarCliente();
	}

	public DefaultTableModel getModeloTabla() {
		return vistaAccederBuscarCliente.getModeloTabla();
	}

	public VistaEjecutarAltaCliente getVistaEjecutarAltaCliente() {
		return vistaAccederAltaCliente.getVistaEjecutarAltaCliente();
	}

	public VistaEjecutarBuscarCliente getVistaEjecutarBuscarCliente() {
		return vistaAccederBuscarCliente.getVistaEjecutarBuscarCliente();
	}

	public JTextField getTextFieldTablaCliente() {
		return vistaAccederBuscarCliente.getTextFieldTablaCliente();
	}

	public JTable getTablaCliente() {
		return vistaAccederBuscarCliente.getTablaCliente();
	}

	public JTextField getTxtDireccion() {
		return vistaAccederAltaCliente.getTxtDireccion();
	}

	public JTextField getTxtTelefono() {
		return vistaAccederAltaCliente.getTxtTelefono();
	}

	public JTextField getTxtDNI() {
		return vistaAccederAltaCliente.getTxtDNI();
	}

	public JTextField getTxtNombre() {
		return vistaAccederAltaCliente.getTxtNombre();
	}

	public JButton getBtnValidar() {
		return vistaAccederAltaCliente.getBtnValidar();
	}

}