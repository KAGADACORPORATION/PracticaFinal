package control;

import java.util.ArrayList;
import java.util.TreeMap;

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
		if(validador.validarCliente(cliente))
		return datos.grabar(cliente);
		else return false;
	}

    public Cliente obtenerCliente(String nombre) {
	    return datos.obtenerCliente(nombre);
    }

  public boolean borrarClientePorNombre(String nombre) {
	  return datos.borrar(obtenerCliente(nombre));
  }
//  
//  public Boolean borrarClientePorNif(String nif) {
//	  boolean retorno = false;
//	  for (int i = 0; i < datos.getArrayCliente().size(); i++) {
//		Cliente clienteTemporal = datos.getArrayCliente().get(i);
//		if(clienteTemporal.getDniCif().equals(nif)) {
//			datos.borrar(clienteTemporal);
//			retorno = true;
//		}
//	  }
//	return retorno;
//	  }
//  
//	public Boolean darAltaArticulo(Articulo articulo) {
//		return datos.grabar(articulo);
//	}

	public Articulo buscarArticulo() {
		return null;
	}

	public Boolean modificarPrecio() {
		return null;
	}

	public ArrayList consultarHistorico() {
		return null;
	}

	public Boolean insertarLineaPedido() {
		return null;
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
		if(validador.validarPedido(pedido))
			return datos.grabar(pedido);
			else return false;
		
	}
	public Pedido obtenerPedido(Pedido pedido) {
			return datos.obtenerPedido(String.valueOf(pedido.getNumero()), pedido.getCliente().getDniCif());
		
	}


	Cliente clienteTemporal;
	public void setClienteTemporal(Cliente cliente) {
		this.clienteTemporal=cliente;
	}

	public Cliente getClienteTemporal() {
		return this.clienteTemporal;
	}

}