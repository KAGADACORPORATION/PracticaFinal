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
	private int idPedido;
	public AddLinea(Puente puente) {
		super();
		this.puente = puente;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {	
		VistaEjecutarAltaPedido vista = puente.getVistaEjecutarAltaPedido();
		Logica logica = puente.getLogica();
		comprobarSiExtistePedido(logica);
		
		Linea linea = new Linea(logica.getArticuloTemporal(), logica.getArticuloTemporal().getIdArticulo());
		
		if (puente.getValidador().validarLineaPedido(linea)) {
			puente.getLogica().insertarLineaPedido(linea);
			vista.getLblMensaje().setText("linea añadida");
			puente.getBtnBuscarCliente().setEnabled(false);
			puente.getBotonArticulo().setText("");
		} else {
			vista.getLblMensaje().setText("error");
		}
		logica.setPedidoTemporal(pedido);
	}

	/**
	 * @param logica
	 */
	private void comprobarSiExtistePedido(Logica logica) {
		if (logica.getPedidoTemporal()== null) {
			logica.setPedidoTemporal(new Pedido(generarIdPedido(), logica.getClienteTemporal()));
			pedido=logica.getPedidoTemporal();
		} else {
			pedido = logica.getPedidoTemporal();
		}
	}

	public int generarIdPedido() {
		return puente.getLogica().getCantidadDePedidosDe(puente.getLogica().getClienteTemporal());
	}

}
