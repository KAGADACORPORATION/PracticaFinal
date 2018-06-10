package vista;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.ImageIcon;

public class VistaAccederBuscarPedido extends JPanel {
	private JButton btnConsultarPedidos;
	private VistaEjecutarBuscarPedido vistaEjecutarBuscarPedido;
	

	public VistaAccederBuscarPedido() {
		vistaEjecutarBuscarPedido= new VistaEjecutarBuscarPedido();
		btnConsultarPedidos = new JButton("");
		btnConsultarPedidos.setIcon(new ImageIcon(VistaAccederBuscarPedido.class.getResource("/com/sun/javafx/webkit/prism/resources/panIcon.png")));
		btnConsultarPedidos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		setLayout(new BorderLayout(0, 0));
		add(btnConsultarPedidos, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("ConsultarPedidos");
		lblNewLabel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		lblNewLabel.setFont(new Font("David", Font.BOLD, 22));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNewLabel, BorderLayout.SOUTH);
	}

  public VistaEjecutarBuscarPedido getVistaEjecutarBuscarPedido() {
		return vistaEjecutarBuscarPedido;
	}

	public void setVistaEjecutarPedido(VistaEjecutarBuscarPedido vistaEjecutarPedido) {
		this.vistaEjecutarBuscarPedido = vistaEjecutarPedido;
	}

public JButton getBtnConsultarPedidos() {
		return btnConsultarPedidos;
	}

	public void setBtnConsultarPedidos(JButton btnConsultarPedidos) {
		this.btnConsultarPedidos = btnConsultarPedidos;
	}

	public JPanel getVistaAccederPedido() {
		return VistaAccederPedido;
	}

	public void setVistaAccederPedido(JPanel vistaAccederPedido) {
		VistaAccederPedido = vistaAccederPedido;
	}

public JPanel VistaAccederPedido;


public JTextField getTextField() {
	return vistaEjecutarBuscarPedido.getTextField();
}

public DefaultTableModel getModeloTablaPedido() {
	return vistaEjecutarBuscarPedido.getModeloTablaPedido();
}

}