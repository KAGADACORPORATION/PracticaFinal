package acciones;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import control.Puente;
import modelo.Cliente;
import utiles.Utiles;

public class ListenerMouseTablaPedidosLinea implements MouseListener {

	private Puente puente = new Puente();
	private Cliente clienteAux;
	
	public ListenerMouseTablaPedidosLinea(Puente puente, Cliente clienteAux) {
		this.puente = puente;
		this.clienteAux = clienteAux;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1) {
			Utiles.actualizarTablaPedidosTres(puente,puente.getTablaPedidoPedido().rowAtPoint(e.getPoint()),clienteAux);
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
