package vista;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.EtchedBorder;
import java.awt.SystemColor;

public class VistaEjecutarBuscarArticulo extends JPanel {

	private JTextField textBuscarBuscarArticulo;
	private JTextField textDescripcionBuscarArticulo;
	private JTextField textPrecioBuscarArticulo;
	private JTable table;
	private String[] nombresColumnas = { "ID", "Nombre","Desccipcion", "Precio"};
	private String data[][];
	private JLabel lblBuscarArticulo;
	private DefaultTableModel modeloTablaArticulo = new DefaultTableModel(data, nombresColumnas);

	public VistaEjecutarBuscarArticulo() {
		setBackground(SystemColor.activeCaption);
		setLayout(new BorderLayout(0, 0));

		JPanel panel_2 = new JPanel();
		add(panel_2, BorderLayout.SOUTH);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 30, 30, 30, 0, 0, 0, 30, 30, 30 };
		gbl_panel.rowHeights = new int[] { 0, 30, 30, 30, 30, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 1.0, 0.0, 0.0, 0.0 };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 };
		panel_2.setLayout(gbl_panel);

		JLabel lblNewLabel = new JLabel("Descripcion:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		panel_2.add(lblNewLabel, gbc_lblNewLabel);

		textDescripcionBuscarArticulo = new JTextField();
		textDescripcionBuscarArticulo.setEditable(false);
		GridBagConstraints gbc_textFieldDescripcion = new GridBagConstraints();
		gbc_textFieldDescripcion.gridheight = 2;
		gbc_textFieldDescripcion.gridwidth = 5;
		gbc_textFieldDescripcion.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldDescripcion.fill = GridBagConstraints.BOTH;
		gbc_textFieldDescripcion.gridx = 3;
		gbc_textFieldDescripcion.gridy = 1;
		panel_2.add(textDescripcionBuscarArticulo, gbc_textFieldDescripcion);
		textDescripcionBuscarArticulo.setColumns(10);

		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblPrecio = new GridBagConstraints();
		gbc_lblPrecio.anchor = GridBagConstraints.EAST;
		gbc_lblPrecio.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrecio.gridx = 1;
		gbc_lblPrecio.gridy = 4;
		panel_2.add(lblPrecio, gbc_lblPrecio);

		textPrecioBuscarArticulo = new JTextField();
		textPrecioBuscarArticulo.setEditable(false);
		GridBagConstraints gbc_textFieldPrecio = new GridBagConstraints();
		gbc_textFieldPrecio.gridwidth = 3;
		gbc_textFieldPrecio.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldPrecio.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldPrecio.gridx = 4;
		gbc_textFieldPrecio.gridy = 4;
		panel_2.add(textPrecioBuscarArticulo, gbc_textFieldPrecio);
		textPrecioBuscarArticulo.setColumns(10);

		JPanel panel_3 = new JPanel();
		add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel_3.add(panel, BorderLayout.NORTH);

		JLabel lblIntroduceElTexto = new JLabel("Introduce el texto:");
		lblIntroduceElTexto.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(lblIntroduceElTexto);

		textBuscarBuscarArticulo = new JTextField("");
		panel.add(textBuscarBuscarArticulo);
		textBuscarBuscarArticulo.setColumns(10);

		JPanel panel_1 = new JPanel();
		panel_3.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane, BorderLayout.CENTER);
		table = new JTable(modeloTablaArticulo);
		table.setEnabled(false);
		scrollPane.setViewportView(table);

		lblBuscarArticulo = new JLabel("Buscar Articulo");
		lblBuscarArticulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuscarArticulo.setFont(new Font("Gentium Book Basic", Font.BOLD | Font.ITALIC, 36));
		add(lblBuscarArticulo, BorderLayout.NORTH);
	}

	public JLabel getLblBuscarArticulo() {
		return lblBuscarArticulo;
	}

	public JTextField getTextBuscarBuscarArticulo() {
		return textBuscarBuscarArticulo;
	}

	public JTextField getTextDescripcionBuscarArticulo() {
		return textDescripcionBuscarArticulo;
	}

	public JTextField getTextPrecioBuscarArticulo() {
		return textPrecioBuscarArticulo;
	}

	public DefaultTableModel getModeloTablaArticulo() {
		return modeloTablaArticulo;
	}

	public JTable getTable() {
		return table;
	}

}