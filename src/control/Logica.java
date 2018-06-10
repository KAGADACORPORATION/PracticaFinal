package control;

import java.util.ArrayList;
import java.util.TreeMap;
import javax.swing.JFrame;
import facade.Datos;
import modelo.Articulo;
import modelo.Cliente;
import modelo.Pedido;
import utiles.Utiles;

public class Logica {
	private Datos datos;
	private Validador validador;

	public Logica(Validador validador) {
		super();
		this.datos = new Datos();
		this.validador = validador;
	}

	public Boolean darAltaCliente(Cliente cliente) {
		if (validador.validarCliente(cliente))
			return datos.grabar(cliente);
		else
			return false;
	}

	public Cliente obtenerCliente(String nombre) {
		return datos.obtenerCliente(nombre);
	}
  
	public boolean borrarClientePorNombre(String nombre) {
		return datos.borrar(obtenerCliente(nombre));
	}
  
	public boolean darAlta(Articulo articulo) {

		return datos.grabar(articulo);
	}

	public Articulo buscarArticulo() {
		return null;
	}

	public boolean modificarPrecio() {
		return false;
	}

	public ArrayList consultarHistorico() {
		return null;
	}

	public boolean insertarLineaPedido() {
		return false;
	}

	private Pedido pedidoTemporal;

	public Pedido getPedidoTemporal() {
		return this.pedidoTemporal;
	}

	public void setPedidoTemporal(Pedido pedido) {
		this.pedidoTemporal = pedido;
	}

	public Datos getDatos() {
		return datos;
	}

	public int getIndiceSize() {
		return getDatos().getClientes().getIndice().size();
	}

	public  TreeMap<String, Integer> getIndice() {
		if(getDatos().getClientes().getIndice()!=null)return getDatos().getClientes().getIndice();
		else return new TreeMap<String,Integer>();

	}

	public Object obtenerCliente(int i) {
		return datos.getClientes().getDao().leer(Utiles.RUTACLIENTE, i);
	}

	public boolean grabarPedido(Pedido pedido) {
		if (validador.validarPedido(pedido))
			return datos.grabar(pedido);

		else
			return false;
	}

	public Pedido obtenerPedido(Pedido pedido) {
		return datos.obtenerPedido(String.valueOf(pedido.getNumero()), pedido.getCliente().getDniCif());

	}

  private Cliente clienteTemporal;
  
	public void setClienteTemporal(Cliente cliente) {
		this.clienteTemporal = cliente;
	}

	public Cliente getClienteTemporal() {
		return this.clienteTemporal;
	}

	public boolean darAlta(Cliente cliente) {
		return datos.grabar(cliente);
	}
	private JFrame ventanaAnadirClienteAPedido;

	public void setFrame(JFrame ventana) {
		this.ventanaAnadirClienteAPedido = ventana;

	}

	public JFrame getFrame() {
		return ventanaAnadirClienteAPedido;
	}

	public int getCantidadArticulos() {
		return datos.getCantidadArticulos();
	}

	

}