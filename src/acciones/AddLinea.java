package acciones;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import control.Logica;
import control.Puente;
import control.Validador;
import modelo.Articulo;
import modelo.Cliente;
import modelo.Linea;
import modelo.Pedido;
import vista.VistaEjecutarAltaCliente;
import vista.VistaEjecutarAltaPedido;

public class AddLinea implements ActionListener {
	private Puente puente;
	private Pedido pedido;

	public AddLinea(Puente puente) {
		super();
		this.puente = puente;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {	
		VistaEjecutarAltaPedido vista = puente.getVistaEjecutarAltaPedido();
		Logica logica = puente.getLogica();
		if (logica.getPedidoTemporal()== null) {
			logica.setPedidoTemporal(new Pedido(getIdPedido(), logica.getClienteTemporal()));
			pedido=logica.getPedidoTemporal();
		} else {
			pedido = logica.getPedidoTemporal();
		}
		Articulo articulo=new Articulo(99, "cama", "mu buena", 150);
		Linea linea = new Linea(articulo, Integer.valueOf(vista.getTextCantidad().getText()));
		if (puente.getValidador().validarLineaPedido(linea)) {
			pedido.insertarLinea(linea);
			vista.getLblMensaje().setText("linea a�adida");
		} else {
			vista.getLblMensaje().setText("error");
		}
		logica.setPedidoTemporal(pedido);
	}

	private int idPedido = 0;

	public int getIdPedido() {
		this.idPedido = this.idPedido + 1;
		return idPedido;
	}

	public int disminuirId() {
		this.idPedido = this.idPedido - 1;
		return idPedido;
	}

}
