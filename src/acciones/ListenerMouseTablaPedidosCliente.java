package acciones;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import control.Puente;
import utiles.Utiles;

public class ListenerMouseTablaPedidosCliente implements MouseListener {

	private Puente puente;
	
	public ListenerMouseTablaPedidosCliente(Puente puente) {
		this.puente = new Puente();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1) {
			Utiles.actualizarTablaPedidosDos(puente,puente.getTablaPedidoCliente().rowAtPoint(e.getPoint()));
		}
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
		
	}

}
