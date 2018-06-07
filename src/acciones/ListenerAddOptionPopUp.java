package acciones;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTable;

import control.Puente;
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
		VistaEjecutarBuscarCliente vista = puente.getVistaAccederBuscarCliente().getVistaEjecutarBuscarCliente();
		JTable tabla=vista.getTable();
		System.out.println("Nombre: "+tabla.getValueAt(row, 0));
        System.out.println("DNI: "+tabla.getValueAt(row, 1));
        System.out.println("Direccion: "+tabla.getValueAt(row, 2));
        System.out.println("Telefono: "+tabla.getValueAt(row, 3));
	}

}
