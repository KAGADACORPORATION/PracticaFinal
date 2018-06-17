package vista;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JButton;

public class VistaEjecutarBuscarCliente extends JPanel {
	private JTextField textField;
	private String[][] data;
	private String[] nombresColumnas = { "Nombre", "DNI/CIF", "Dirección", "Teléfono" };
	private DefaultTableModel modeloTabla = new DefaultTableModel(data, nombresColumnas);
	private JTable table;

	/**
	 * Create the frame.
	 */
	public VistaEjecutarBuscarCliente() {
		setLayout(new BorderLayout(0, 0));

		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane, BorderLayout.CENTER);
		table = new JTable(modeloTabla);
		table.setEnabled(true);
		scrollPane.setViewportView(table);

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

		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 5;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 6;
		gbc_textField.gridy = 1;
		panel_2.add(textField, gbc_textField);
		textField.setColumns(10);

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

	public JTextField getTextFieldTablaCliente() {
		return textField;
	}

	public DefaultTableModel getModeloTabla() {
		return modeloTabla;
	}

	public void setModeloTabla(DefaultTableModel modeloTabla) {
		this.modeloTabla = modeloTabla;
	}

	public JTable getTablaCliente() {
		return table;
	}

}
