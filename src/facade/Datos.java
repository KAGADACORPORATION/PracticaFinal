package facade;

import java.util.TreeMap;

import javax.rmi.CORBA.Util;

import acceso.DAO;
import almacenes.AlmacenIndice;
import almacenes.AlmacenIndividualList;
import almacenes.AlmacenMap;
import almacenes.AlmacenRutaDestino;
import almacenes.almacenRutaMapeada;
import almacenesTest.AlmacenIndividualListTest;
import modelo.Articulo;
import modelo.Cliente;
import modelo.Linea;
import modelo.Pedido;
import utiles.Utiles;

public class Datos {
	private AlmacenIndice<Cliente, String> clientes;
	private almacenRutaMapeada<Articulo, String> articulos;
	private AlmacenRutaDestino<Pedido> pedidos;

	public Datos() {
		super();
		this.clientes = new AlmacenIndice<>(Utiles.RUTAINDICECLIENTES,Utiles.RUTACLIENTE);
		this.articulos = new almacenRutaMapeada<>(new AlmacenMap<>(new TreeMap<String, Integer>(), Utiles.ARTICULO_MAP), Utiles.ART, Utiles.ARTICULOS, Utiles.DATA);
		this.pedidos = new AlmacenRutaDestino<>(Utiles.PEDIDORUTA, "ped");
	}

	public boolean grabar(Cliente cliente) {
		return clientes.grabar(cliente, cliente.getRazonSocial());
	}

	public boolean borrar(Cliente cliente) {
		return clientes.borrar(cliente.getRazonSocial());
	}

	public Cliente obtenerCliente(String razonSocial) {
		return clientes.obtener(razonSocial);
	}

	public AlmacenIndice<Cliente, String> getClientes() {
		return clientes;
	}

	 public boolean grabar(Articulo articulo) {
		 return articulos.grabar(articulo, articulo.getNombre(),
		 articulo.getIdArticulo());
	 }
	
	 public boolean borrar(Articulo articulo) {
		 boolean retorno=false;
		 if(articulos.borrar(articulo.getNombre()))retorno=true;
		 return retorno;
	 }
	
	 public Articulo obtenerArticulo(String nombreArticulo) {
		 return articulos.obtener(nombreArticulo);
	 }
	
	public boolean grabar(Pedido pedido) {
		return pedidos.grabar(String.valueOf(pedido.getCliente().getRazonSocial()),String.valueOf(pedido.getNumero()),pedido);
	}

//	public boolean borrar(Pedido pedido) {
//		return pedidos.borrar(String.valueOf(pedido.getNumero()), String.valueOf(pedido.getCliente().getDniCif()));
//	}

	public Pedido obtenerPedido(String nombreCliente, String nombrePedido) {
		return pedidos.obtener(nombreCliente, nombrePedido);
	}

	public almacenRutaMapeada<Articulo, String> getArticulos() {
		return articulos;
	}

	public int getCantidadArticulos() {
		return articulos.getCantidadArticulos();
	}

	public int getCantidadClientesConPedidos() {
		return pedidos.getCantidadElementos();
	}

	public int getCantidadDePedidosDe(Cliente cliente) {
		return pedidos.getCantidadElementos(cliente.getRazonSocial());
	}
	
	public Articulo obtenerArticulo(int i) {
		return articulos.obtener(i);
	}

	public boolean insertarLineaPedido(Pedido pedido,Linea linea) {
		return new DAO<>().grabar(Utiles.PEDIDORUTA+"/"+pedido.getNumero()+"/"+pedido.getCliente().getRazonSocial()+pedido.getNumero()+".ped", linea, true);
	}
	
}