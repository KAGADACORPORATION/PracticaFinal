package vista;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class VistaAccederBuscarArticulo extends JPanel {

	private JButton botonBuscarArticulo;
	private VistaEjecutarBuscarArticulo vistaEjecutarBuscarArticulo = new VistaEjecutarBuscarArticulo();

	public VistaAccederBuscarArticulo() {
		setLayout(new BorderLayout(0, 0));
		JLabel lblBuscarArticulo = new JLabel("Administrar articulos");
		lblBuscarArticulo.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		lblBuscarArticulo.setFont(new Font("David", Font.BOLD, 22));
		lblBuscarArticulo.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblBuscarArticulo, BorderLayout.SOUTH);
		botonBuscarArticulo = new JButton("");
		add(botonBuscarArticulo, BorderLayout.CENTER);
	}

	public JButton getBotonBuscarArticulo() {
		return botonBuscarArticulo;
	}
	
	public VistaEjecutarBuscarArticulo getVistaEjecutarBuscarArticulo() {
		return vistaEjecutarBuscarArticulo;
	}

	public JTextField getTextBuscarBuscarArticulo() {
		return vistaEjecutarBuscarArticulo.getTextBuscarBuscarArticulo();
	}

	public JTextField getTextDescripcionBuscarArticulo() {
		return vistaEjecutarBuscarArticulo.getTextDescripcionBuscarArticulo();
	}

	public JTextField getTextPrecioBuscarArticulo() {
		return vistaEjecutarBuscarArticulo.getTextPrecioBuscarArticulo();
	}

	public DefaultTableModel getModeloTablaArticulo() {
		return vistaEjecutarBuscarArticulo.getModeloTablaArticulo();
	}

	public JTable getTablaArticulo() {
		return vistaEjecutarBuscarArticulo.getTable();
	}
	
}