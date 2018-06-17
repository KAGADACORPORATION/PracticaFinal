package acciones;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTable;
import control.Logica;
import control.Puente;
import utiles.Utiles;
import vista.VistaEjecutarBuscarCliente;

public class BorrarCliente implements ActionListener{

	public Puente puente;
	private int row;

	public BorrarCliente(Puente puente, int row) {
		this.puente = puente;
		this.row = row;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		VistaEjecutarBuscarCliente vista = puente.getVistaAccederBuscarCliente().getVistaEjecutarBuscarCliente();
		JTable tabla=vista.getTablaCliente();
		this.puente.getLogica().borrarClientePorNombre(String.valueOf(tabla.getValueAt(row, 0)));
		Utiles.ActualizarTablaCliente(puente);
	}

}