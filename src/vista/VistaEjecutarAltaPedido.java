package vista;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JSlider;
import javax.swing.JSeparator;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.Color;

public class VistaEjecutarAltaPedido extends JPanel {

	private JTextField textIdentificacion;
	private JTextField textCantidad;
	private JButton btnConfirmarPedido;
	private JButton btnAddLinea;
	private JLabel lblMensaje;
	private JButton buttonBuscarCliente;
	private JButton buttonBucarArticulo;
	private JLabel lblPrecioUnidad;

	public VistaEjecutarAltaPedido() {
		setLayout(new BorderLayout(0, 0));

		JLabel lblTitulo = new JLabel("ALTA DE PEDIDOS");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		add(lblTitulo, BorderLayout.NORTH);

		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0, 25, 0, 0, 0, 0, 0 };
		gbl_panel.rowHeights = new int[] { 30, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JLabel lblCliente = new JLabel("N\u00FAmero identificaci\u00F3n:");
		GridBagConstraints gbc_lblCliente = new GridBagConstraints();
		gbc_lblCliente.insets = new Insets(0, 0, 5, 5);
		gbc_lblCliente.anchor = GridBagConstraints.EAST;
		gbc_lblCliente.gridx = 1;
		gbc_lblCliente.gridy = 1;
		panel.add(lblCliente, gbc_lblCliente);

		textIdentificacion = new JTextField();
		GridBagConstraints gbc_textIdentificacion = new GridBagConstraints();
		gbc_textIdentificacion.insets = new Insets(0, 0, 5, 5);
		gbc_textIdentificacion.fill = GridBagConstraints.HORIZONTAL;
		gbc_textIdentificacion.gridx = 2;
		gbc_textIdentificacion.gridy = 1;
		panel.add(textIdentificacion, gbc_textIdentificacion);
		textIdentificacion.setColumns(10);

		JLabel lblNewLabel = new JLabel("Cliente:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 2;
		panel.add(lblNewLabel, gbc_lblNewLabel);

		buttonBuscarCliente = new JButton("...");
		GridBagConstraints gbc_buttonBuscarCliente = new GridBagConstraints();
		gbc_buttonBuscarCliente.insets = new Insets(0, 0, 5, 5);
		gbc_buttonBuscarCliente.gridx = 2;
		gbc_buttonBuscarCliente.gridy = 2;
		panel.add(buttonBuscarCliente, gbc_buttonBuscarCliente);

		JLabel lblArtculo = new JLabel("Art\u00EDculo:");
		GridBagConstraints gbc_lblArtculo = new GridBagConstraints();
		gbc_lblArtculo.anchor = GridBagConstraints.EAST;
		gbc_lblArtculo.insets = new Insets(0, 0, 5, 5);
		gbc_lblArtculo.gridx = 1;
		gbc_lblArtculo.gridy = 4;
		panel.add(lblArtculo, gbc_lblArtculo);

		buttonBucarArticulo = new JButton("...");
		GridBagConstraints gbc_buttonBucarArticulo = new GridBagConstraints();
		gbc_buttonBucarArticulo.insets = new Insets(0, 0, 5, 5);
		gbc_buttonBucarArticulo.gridx = 2;
		gbc_buttonBucarArticulo.gridy = 4;
		panel.add(buttonBucarArticulo, gbc_buttonBucarArticulo);

		JLabel lblCantidad = new JLabel("cantidad");
		GridBagConstraints gbc_lblCantidad = new GridBagConstraints();
		gbc_lblCantidad.anchor = GridBagConstraints.EAST;
		gbc_lblCantidad.insets = new Insets(0, 0, 5, 5);
		gbc_lblCantidad.gridx = 3;
		gbc_lblCantidad.gridy = 4;
		panel.add(lblCantidad, gbc_lblCantidad);

		textCantidad = new JTextField();
		GridBagConstraints gbc_textCantidad = new GridBagConstraints();
		gbc_textCantidad.fill = GridBagConstraints.HORIZONTAL;
		gbc_textCantidad.insets = new Insets(0, 0, 5, 5);
		gbc_textCantidad.gridx = 4;
		gbc_textCantidad.gridy = 4;
		panel.add(textCantidad, gbc_textCantidad);
		textCantidad.setColumns(10);

		JLabel lblPrecio = new JLabel("Precio Unidad:");
		GridBagConstraints gbc_lblPrecio = new GridBagConstraints();
		gbc_lblPrecio.anchor = GridBagConstraints.EAST;
		gbc_lblPrecio.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrecio.gridx = 1;
		gbc_lblPrecio.gridy = 6;
		panel.add(lblPrecio, gbc_lblPrecio);

		lblPrecioUnidad = new JLabel("");
		GridBagConstraints gbc_lblPrecioUnidad = new GridBagConstraints();
		gbc_lblPrecioUnidad.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrecioUnidad.gridx = 2;
		gbc_lblPrecioUnidad.gridy = 6;
		panel.add(lblPrecioUnidad, gbc_lblPrecioUnidad);

		btnAddLinea = new JButton("A\u00F1adir Linea");
		GridBagConstraints gbc_btnAadir = new GridBagConstraints();
		gbc_btnAadir.insets = new Insets(0, 0, 5, 5);
		gbc_btnAadir.gridx = 4;
		gbc_btnAadir.gridy = 6;
		panel.add(btnAddLinea, gbc_btnAadir);

		btnConfirmarPedido = new JButton("Confirmar Pedido");
		GridBagConstraints gbc_btnConfirmarPedido = new GridBagConstraints();
		gbc_btnConfirmarPedido.insets = new Insets(0, 0, 0, 5);
		gbc_btnConfirmarPedido.gridx = 3;
		gbc_btnConfirmarPedido.gridy = 9;
		panel.add(btnConfirmarPedido, gbc_btnConfirmarPedido);

		lblMensaje = new JLabel("");
		lblMensaje.setHorizontalAlignment(SwingConstants.CENTER);
		lblMensaje.setHorizontalTextPosition(SwingConstants.CENTER);
		lblMensaje.setForeground(Color.GREEN);
		add(lblMensaje, BorderLayout.SOUTH);
	}

	public JLabel getLblPrecioUnidad() {
		return lblPrecioUnidad;
	}

	public JButton getButtonBuscarCliente() {
		return buttonBuscarCliente;
	}

	public JButton getButtonBucarArticulo() {
		return buttonBucarArticulo;
	}

	public JLabel getLblMensaje() {
		return lblMensaje;
	}

	public JTextField getTextIdentificacion() {
		return textIdentificacion;
	}

	public JButton getButtonAddLinea() {
		return btnAddLinea;
	}

	public JTextField getTextCantidad() {
		return textCantidad;
	}

	public JButton getBtnConfirmarPedido() {
		return btnConfirmarPedido;
	}

}