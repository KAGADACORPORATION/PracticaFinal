package acciones;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JTable;
import control.Puente;
import vista.VistaEjecutarBuscarCliente;

public class ListenerMouseTablaCliente implements MouseListener {
	Puente puente;
	String[] adicion;

	public ListenerMouseTablaCliente(Puente puente) {
		super();
		this.puente = puente;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		VistaEjecutarBuscarCliente vista = puente.getVistaEjecutarBuscarCliente();
		if (e.getButton() == MouseEvent.BUTTON3) {
			int r = vista.getTablaCliente().rowAtPoint(e.getPoint());
			if (r >= 0 && r < vista.getTablaCliente().getRowCount()) {
				vista.getTablaCliente().setRowSelectionInterval(r, r);
			} else {
				vista.getTablaCliente().clearSelection();
			}
			int rowindex = vista.getTablaCliente().getSelectedRow();
			if (rowindex < 0) {
				return;
			}
			if (e.getComponent() instanceof JTable) {
				doPop(e, vista.getTablaCliente(), rowindex);
			}
			puente.getLogica().setClienteTemporal(puente.getLogica().obtenerCliente(String.valueOf(puente.getTablaCliente().getValueAt(rowindex, 0))));
		}
		
	}

	private void doPop(MouseEvent e, JTable table, int row) {
		PopUpTablaClientes menu = new PopUpTablaClientes();
		menu.addOption.addActionListener(new ListenerAddOptionPopUp(puente, row));
		menu.borrarOption.addActionListener(new BorrarCliente(puente, row));
		menu.show(e.getComponent(), e.getX(), e.getY());

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
