package acciones;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTable;

import control.Puente;
import vista.VistaEjecutarAltaPedido;
import vista.VistaEjecutarBuscarCliente;

public class ListenerAddOptionPopUp implements ActionListener{
	Puente puente;
	int row;
	
	public ListenerAddOptionPopUp(Puente puente, int row) {
		super();
		this.puente = puente;
		this.row=row;
	}	

	@Override
	public void actionPerformed(ActionEvent e) {
		puente.getLogica().setClienteTemporal(puente.getLogica().obtenerCliente(puente.getTablaCliente().getValueAt(row, 0).toString()));
        puente.getButtonBuscarCliente().setText(puente.getTablaCliente().getValueAt(row, 0).toString());
        puente.getLogica().getFrame().setVisible(false);
	}

}
