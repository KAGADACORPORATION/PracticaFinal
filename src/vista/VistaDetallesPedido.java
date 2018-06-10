package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SwingConstants;

public class VistaDetallesPedido extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldCliente;
	private JTextField textFieldFecha;
	private JTable table;
	private String[][] data;
	private String[] nombresColumnas = { "Nombre", "Descripcion", "Precio" };
	private DefaultTableModel modeloTabla = new DefaultTableModel(data, nombresColumnas);
	private JTextField textFieldPrecioTotal;

	public VistaDetallesPedido() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 697, 472);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 334, 334, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 22, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblIdPedido = new JLabel("Id Pedido:");
		GridBagConstraints gbc_lblIdPedido = new GridBagConstraints();
		gbc_lblIdPedido.anchor = GridBagConstraints.EAST;
		gbc_lblIdPedido.insets = new Insets(0, 0, 5, 5);
		gbc_lblIdPedido.gridx = 1;
		gbc_lblIdPedido.gridy = 0;
		panel.add(lblIdPedido, gbc_lblIdPedido);
		
		JTextField textFieldID = new JTextField();
		textFieldID.setEditable(false);
		GridBagConstraints gbc_textFieldID = new GridBagConstraints();
		gbc_textFieldID.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldID.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldID.gridx = 2;
		gbc_textFieldID.gridy = 0;
		panel.add(textFieldID, gbc_textFieldID);
		textFieldID.setColumns(10);
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblFecha = new GridBagConstraints();
		gbc_lblFecha.fill = GridBagConstraints.BOTH;
		gbc_lblFecha.insets = new Insets(0, 0, 5, 5);
		gbc_lblFecha.gridx = 1;
		gbc_lblFecha.gridy = 1;
		panel.add(lblFecha, gbc_lblFecha);
		
		textFieldFecha = new JTextField();
		textFieldFecha.setEditable(false);
		GridBagConstraints gbc_textFieldFecha = new GridBagConstraints();
		gbc_textFieldFecha.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldFecha.fill = GridBagConstraints.BOTH;
		gbc_textFieldFecha.gridx = 2;
		gbc_textFieldFecha.gridy = 1;
		panel.add(textFieldFecha, gbc_textFieldFecha);
		textFieldFecha.setColumns(10);
		
		JLabel lblCliente = new JLabel("Cliente:");
		GridBagConstraints gbc_lblCliente = new GridBagConstraints();
		gbc_lblCliente.anchor = GridBagConstraints.EAST;
		gbc_lblCliente.insets = new Insets(0, 0, 0, 5);
		gbc_lblCliente.gridx = 1;
		gbc_lblCliente.gridy = 2;
		panel.add(lblCliente, gbc_lblCliente);
		
		textFieldCliente = new JTextField();
		textFieldCliente.setEditable(false);
		GridBagConstraints gbc_textFieldCliente = new GridBagConstraints();
		gbc_textFieldCliente.insets = new Insets(0, 0, 0, 5);
		gbc_textFieldCliente.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldCliente.gridx = 2;
		gbc_textFieldCliente.gridy = 2;
		panel.add(textFieldCliente, gbc_textFieldCliente);
		textFieldCliente.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane, BorderLayout.CENTER);
		table = new JTable(modeloTabla);
		table.setEnabled(false);
		scrollPane.setViewportView(table);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.SOUTH);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JLabel lblPrecioTotal = new JLabel("PrecioTotal:");
		panel_2.add(lblPrecioTotal, BorderLayout.WEST);
		
		textFieldPrecioTotal = new JTextField();
		textFieldPrecioTotal.setEditable(false);
		panel_2.add(textFieldPrecioTotal, BorderLayout.EAST);
		textFieldPrecioTotal.setColumns(10);
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public JTextField getTextFieldCliente() {
		return textFieldCliente;
	}

	public JTextField getTextFieldFecha() {
		return textFieldFecha;
	}

	public JTable getTable() {
		return table;
	}

	public String[][] getData() {
		return data;
	}

	public DefaultTableModel getModeloTabla() {
		return modeloTabla;
	}

	public JTextField getTextFieldPrecioTotal() {
		return textFieldPrecioTotal;
	}

}
