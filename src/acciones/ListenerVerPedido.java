package acciones;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JTable;

import control.Puente;
import utiles.Utiles;
import vista.VistaDetallesPedido;
import vista.VistaEjecutarBuscarArticulo;

public class ListenerVerPedido implements MouseListener {
	Puente puente;

	public ListenerVerPedido(Puente puente) {
		super();
		this.puente = puente;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getClickCount() == 2) {
		    JFrame ventana= new JFrame();
		    ventana.setBounds(500, 500, 670, 413);
			ventana.getContentPane().removeAll();
			ventana.getContentPane().add(puente.getVistaDetallesPedido());
			VistaDetallesPedido vista = puente.getVistaDetallesPedido();
//			vista.get todo pedido selecionado;
			JTable tabla =vista.getTable();
			Utiles.actualizar(puente);
			ventana.setVisible(true);
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
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
