package vista;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.ListSelectionModel;

public class VistaEjecutarBuscarPedido extends JPanel {

	private JTextField textFieldBuscarPedido;
	private String[][] dataCliente;
	private String [][]dataPedido;
	private String [][]dataLinea;
	private String[] nombresColumnas = { "Nombre", "DNI/CIF", "Dirección", "Teléfono","Cantidad"};
	private String[] nombresColumnasPedido = { "Numero", "Lineas"};
	private String[] nombresColumnasLinea = { "Nombre Articulo", "Precio", "Cantidad", "Total"};
	private DefaultTableModel modeloTablaPedidoCliente;
	private DefaultTableModel modeloTablaPedidoPedido;
	private DefaultTableModel modeloTablaPedidoLinea;
	private JTable tablaPedidoCliente;
	private JTable tablaPedidoPedido;
	private JTable tablaPedidoLinea;
	

	public VistaEjecutarBuscarPedido() {
		modeloTablaPedidoCliente = new DefaultTableModel(dataCliente, nombresColumnas);
		modeloTablaPedidoPedido = new DefaultTableModel(dataPedido, nombresColumnasPedido);
		modeloTablaPedidoLinea = new DefaultTableModel(dataLinea, nombresColumnasLinea);
		setLayout(new BorderLayout(0, 0));

		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(3, 1, 0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane);
		tablaPedidoCliente = new JTable(modeloTablaPedidoCliente);
		tablaPedidoCliente.setEnabled(false);
		scrollPane.setViewportView(tablaPedidoCliente);
		
		JScrollPane scrollPane2 = new JScrollPane();
		panel_1.add(scrollPane2);
		tablaPedidoPedido = new JTable(modeloTablaPedidoPedido);
		scrollPane2.setViewportView(tablaPedidoPedido);
		tablaPedidoPedido.setEnabled(false);
		
		JScrollPane scrollPane3 = new JScrollPane();
		panel_1.add(scrollPane3);
		tablaPedidoLinea = new JTable(modeloTablaPedidoLinea);
		scrollPane3.setViewportView(tablaPedidoLinea);
		tablaPedidoLinea.setEnabled(false);

		JPanel panel_2 = new JPanel();
		add(panel_2, BorderLayout.NORTH);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 30, 30, 30, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 30 };
		gbl_panel.rowHeights = new int[] { 0, 30, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 1.0, 0.0 };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0 };
		panel_2.setLayout(gbl_panel);

		JLabel lblDNI = new JLabel("Nombre");
		lblDNI.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GridBagConstraints gbc_lblDNI = new GridBagConstraints();
		gbc_lblDNI.gridwidth = 3;
		gbc_lblDNI.anchor = GridBagConstraints.EAST;
		gbc_lblDNI.gridx = 2;
		gbc_lblDNI.gridy = 1;
		gbc_lblDNI.insets = new Insets(0, 0, 5, 5);
		panel_2.add(lblDNI, gbc_lblDNI);

		textFieldBuscarPedido = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 5;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 6;
		gbc_textField.gridy = 1;
		panel_2.add(textFieldBuscarPedido, gbc_textField);
		textFieldBuscarPedido.setColumns(10);

		GridBagConstraints gbc_textFieldDescripcion = new GridBagConstraints();
		gbc_textFieldDescripcion.gridheight = 3;
		gbc_textFieldDescripcion.gridwidth = 3;
		gbc_textFieldDescripcion.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldDescripcion.fill = GridBagConstraints.BOTH;
		gbc_textFieldDescripcion.gridx = 4;
		gbc_textFieldDescripcion.gridy = 1;

		GridBagConstraints gbc_textFieldPrecio = new GridBagConstraints();
		gbc_textFieldPrecio.gridwidth = 3;
		gbc_textFieldPrecio.insets = new Insets(0, 0, 0, 5);
		gbc_textFieldPrecio.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldPrecio.gridx = 4;
		gbc_textFieldPrecio.gridy = 5;
	}

	public JTextField getTextFieldBuscarPedido() {
		return textFieldBuscarPedido;
	}

	public DefaultTableModel getModeloTablaPedidoCliente() {
		return modeloTablaPedidoCliente;
	}

	public DefaultTableModel getModeloTablaPedidoPedido() {
		return modeloTablaPedidoPedido;
	}

	public DefaultTableModel getModeloTablaPedidoLinea() {
		return modeloTablaPedidoLinea;
	}

	public JTable getTablaPedidoCliente() {
		return tablaPedidoCliente;
	}

	public JTable getTablaPedidoPedido() {
		return tablaPedidoPedido;
	}

	public JTable getTablaPedidoLinea() {
		return tablaPedidoLinea;
	}

}