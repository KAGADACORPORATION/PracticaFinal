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
		VistaEjecutarBuscarArticulo vistaBuscar = puente.getVistaEjecutarBuscarArticulo();
		VistaEjecutarAltaPedido vistaPedido = puente.getVistaEjecutarAltaPedido();
		JTable tabla=vistaBuscar.getTable();
		puente.getLogica().setArticuloTemporal(puente.getLogica().obtenerArticulo(tabla.getValueAt(row, 0).toString()));
		System.out.println("ID: "+tabla.getValueAt(row, 0));
        System.out.println("Nombre: "+tabla.getValueAt(row, 1));
        System.out.println("Descripcion: "+tabla.getValueAt(row, 2));
        System.out.println("Precio: "+tabla.getValueAt(row, 3));
        vistaPedido.getButtonBuscarCliente().setText(tabla.getValueAt(row, 0).toString());
        puente.getLogica().getFrame().setVisible(false);
	}
}
