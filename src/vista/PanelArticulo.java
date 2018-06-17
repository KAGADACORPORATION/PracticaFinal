package vista;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;

public class PanelArticulo extends JPanel {

	private JButton botonArticulo;
	private VistaAccederAltaArticulo vistaAccederAltaArticulo = new VistaAccederAltaArticulo();
	private VistaAccederBuscarArticulo vistaAccederBuscarArticulo = new VistaAccederBuscarArticulo();
	private JPanel panel;
	private JLabel lblArticulos;

	public PanelArticulo() {
		setLayout(new BorderLayout(0, 0));

		panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		botonArticulo = new JButton("");
		panel.add(botonArticulo);

		lblArticulos = new JLabel("ARTICULOS");
		lblArticulos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblArticulos.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblArticulos, BorderLayout.SOUTH);
	}

	public JButton getBotonArticulo() {
		return botonArticulo;
	}

	public JTextField getTextNombreAltaArticulo() {
		return vistaAccederAltaArticulo.getTextNombreAltaArticulo();
	}

	public JTextField getTextDescripcionAltaArticulo() {
		return vistaAccederAltaArticulo.getTextDescripcionAltaArticulo();
	}

	public JTextField getTextBuscarBuscarArticulo() {
		return vistaAccederBuscarArticulo.getTextBuscarBuscarArticulo();
	}

	public JPanel getPanel() {
		return panel;
	}

	public JLabel getLblArticulos() {
		return lblArticulos;
	}

	public JTextField getTextDescripcionBuscarArticulo() {
		return vistaAccederBuscarArticulo.getTextDescripcionBuscarArticulo();
	}

	public JTextField getTextPrecioBuscarArticulo() {
		return vistaAccederBuscarArticulo.getTextPrecioBuscarArticulo();
	}

	public VistaAccederAltaArticulo getVistaAccederAltaArticulo() {
		return vistaAccederAltaArticulo;
	}

	public VistaEjecutarAltaArticulo getVistaEjecutarAltaArticulo() {
		return vistaAccederAltaArticulo.getVistaEjecutarAltaArticulo();
	}

	public VistaAccederBuscarArticulo getVistaAccederBuscarArticulo() {
		return vistaAccederBuscarArticulo;
	}

	public VistaEjecutarBuscarArticulo getVistaEjecutarBuscarArticulo() {
		return vistaAccederBuscarArticulo.getVistaEjecutarBuscarArticulo();
	}

	public JButton getBotonBuscarArticulo() {
		return vistaAccederBuscarArticulo.getBotonBuscarArticulo();
	}

	public JButton getBotonAltaArticulo() {
		return vistaAccederAltaArticulo.getBotonAltaArticulo();
	}

	public DefaultTableModel getModeloTablaArticulo() {
		return vistaAccederBuscarArticulo.getModeloTablaArticulo();
	}

	public JTable getTablaArticulo() {
		return vistaAccederBuscarArticulo.getTablaArticulo();
	}
}