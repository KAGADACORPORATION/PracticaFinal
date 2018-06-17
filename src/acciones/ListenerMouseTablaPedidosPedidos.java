package acciones;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import control.Puente;
import utiles.Utiles;

public class ListenerMouseTablaPedidosPedidos implements MouseListener {

	private Puente puente;
	
	public ListenerMouseTablaPedidosPedidos(Puente puente) {
		this.puente = puente;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1) {
			Utiles.actualizarTablaPedidosDos(puente,puente.getTablaPedidoCliente().rowAtPoint(e.getPoint()));
		}

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
