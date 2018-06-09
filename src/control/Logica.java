package control;

import java.util.ArrayList;

import facade.Datos;
import modelo.Articulo;
import modelo.Cliente;
import modelo.Pedido;

public class Logica {
	private Datos datos;
	private Validador validador;
		public Logica(Validador validador) {
		super();
		this.datos = new Datos();
		this.validador = validador;
		}



	public Boolean darAltaCliente(Cliente cliente) {
		if(validador.validarCliente(cliente, datos.getArrayCliente()))
		return datos.grabar(cliente);
		else return false;
	}

	public Cliente buscarCliente() {
		return null;
	}

  public Cliente buscarCliente(String nif) {
	  for (int i = 0; i < datos.getArrayCliente().size(); i++) {
			Cliente clienteTemporal = datos.getArrayCliente().get(i);
			if(clienteTemporal.getDniCif().equals(nif)) {
				return(clienteTemporal);
			}
		  }
	  return null;
  }

  public boolean borrarClientePorNombre(String nombre) {
	  boolean retorno = false;
	  for (int i = 0; i < datos.getArrayCliente().size(); i++) {
		Cliente clienteTemporal = datos.getArrayCliente().get(i);
		if(clienteTemporal.getRazonSocial().equals(nombre)) {
			datos.borrar(clienteTemporal);
			retorno = true;
		}
	  }
	return retorno;
  }
  
  public Boolean borrarClientePorNif(String nif) {
	  boolean retorno = false;
	  for (int i = 0; i < datos.getArrayCliente().size(); i++) {
		Cliente clienteTemporal = datos.getArrayCliente().get(i);
		if(clienteTemporal.getDniCif().equals(nif)) {
			datos.borrar(clienteTemporal);
			retorno = true;
		}
	  }
	return retorno;
	  }
  
	public Boolean darAltaArticulo(Articulo articulo) {
		return datos.grabar(articulo);
	}

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



public void setDatos(Datos datos) {
	this.datos = datos;
}

}