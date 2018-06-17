package acciones;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;

import control.Puente;
import vista.VistaEjecutarAltaPedido;
import vista.VistaEjecutarBuscarArticulo;
import vista.VistaEjecutarBuscarCliente;

public class ListenerAddOptionPopUpArticulo implements ActionListener{
	Puente puente;
	int row;
	
	public ListenerAddOptionPopUpArticulo(Puente puente, int row) {
		super();
		this.puente = puente;
		this.row=row;
	}	

	@Override
	public void actionPerformed(ActionEvent e) {
		puente.getLogica().setArticuloTemporal(puente.getLogica().obtenerArticulo(row));
        puente.getButtonBucarArticulo().setText(puente.getTablaArticulo().getValueAt(row, 0).toString());
        puente.getLogica().getFrame().setVisible(false);
	}
}
