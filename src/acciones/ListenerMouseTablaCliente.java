package acciones;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
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
		VistaEjecutarBuscarCliente vista = puente.getVistaAccederBuscarCliente().getVistaEjecutarBuscarCliente();
		JTable tabla = vista.getTable();
		if (e.getButton() == MouseEvent.BUTTON3) {
			int r = tabla.rowAtPoint(e.getPoint());
			System.out.println(r);
			if (r >= 0 && r < tabla.getRowCount()) {
				tabla.setRowSelectionInterval(r, r);
			} else {
				tabla.clearSelection();
			}
			int rowindex = tabla.getSelectedRow();
			if (rowindex < 0) {
				return;
			}
			if (e.getComponent() instanceof JTable) {
				doPop(e, tabla, rowindex);
			}
		}
	}

	private void doPop(MouseEvent e, final JTable table, final int row) {
		PopUpTabla menu = new PopUpTabla();
		menu.addOption.addActionListener(new ListenerAddOptionPopUp(puente, row));
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
