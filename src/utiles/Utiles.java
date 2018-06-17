package utiles;

import java.awt.Container;
import java.awt.Image;
import java.io.File;
import java.util.TreeMap;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import acciones.ListenerMouseTablaArticulos;
import acciones.ListenerMouseTablaCliente;
import acciones.ListenerMouseTablaPedidosCliente;
import acciones.ListenerMouseTablaPedidosLinea;
import acciones.ListenerMouseTablaPedidosPedidos;
import control.Puente;
import modelo.Articulo;
import modelo.Cliente;
import modelo.Linea;
import modelo.Pedido;
import vista.VistaEjecutarBuscarArticulo;
import vista.VistaEjecutarBuscarCliente;
import vista.VistaEjecutarBuscarPedido;

public class Utiles {
	public static final String RUTACLIENTE = "./data/clientes/clientes.data";
	public static final String RUTAINDICECLIENTES = "./data/clientesIndice/clientes.index";
	public static final int CAMPOSCLIENTE = 4;
	public static final String DATA = "data";
	public static final String ARTICULOS = "articulos";
	public static final String ART = "art";
	public static final String ARTICULO_MAP = "./data/articulos/articulo.map";
	public static final String PEDIDORUTA = "./data/pedidos";
	private static String cadena;
	
	
	public static ImageIcon createScaledIcon(ImageIcon Imagen, int height) {
		return new ImageIcon(Imagen.getImage().getScaledInstance(height - 2, height - 2, Image.SCALE_SMOOTH));
	}
	
	public static int crearRandom(int min,int max) {
		int numeroAleatorio=((int)(Math.random()*((max-min)+1)))+min;
		return numeroAleatorio;
	}
	public static void actualizar(Container container){
  		SwingUtilities.updateComponentTreeUI(container);
  	}
	public static void borrarCarpeta(File carpetaGenerada) {
	    if (carpetaGenerada.isDirectory()) { 
	        for (File f : carpetaGenerada.listFiles()) { 
	        	borrarCarpeta(f);  } 
	    } 
	    carpetaGenerada.delete(); 
	}
	
	public static void ActualizarTablaCliente(Puente puente) {
		cadena = puente.getTextFieldTablaCliente().getText();
		while (puente.getModeloTabla().getRowCount() > 0) {
			puente.getModeloTabla().removeRow(0);
		}
		TreeMap<String, Integer> indiceClientes = puente.getLogica().getIndice();
		for (int i = 0; i < indiceClientes.size(); i++) {
			Cliente clienteAux = (Cliente) puente.getLogica().obtenerCliente(i);
			if(clienteAux.getRazonSocial().toLowerCase().startsWith(cadena)) {
				String adicion[] = { clienteAux.getRazonSocial(),
						clienteAux.getDniCif(), clienteAux.getDireccion(),
						clienteAux.getTelefono() };
				puente.getModeloTabla().addRow(adicion);
			}
		}
		puente.getTablaCliente().addMouseListener(new ListenerMouseTablaCliente(puente));
		actualizar(puente.getTablaCliente().getParent());
	}
	
	public static void ActualizarTablaArticulos(Puente puente) {
		cadena = new String(puente.getTextBuscarBuscarArticulo().getText());
		while (puente.getModeloTablaArticulo().getRowCount() > 0) {
			puente.getModeloTablaArticulo().removeRow(0);
		}
		for (int i = 0; i < puente.getLogica().getCantidadArticulos(); i++) {
			Articulo articuloAux = (Articulo) puente.getLogica().obtenerArticulo(i);
			if(articuloAux.getNombre().toLowerCase().startsWith(cadena)) {
				String adicion[] = { String.valueOf(articuloAux.getIdArticulo()), articuloAux.getNombre(), articuloAux.getDescripcion(),
						String.valueOf(articuloAux.getCurrentPrice())};
				puente.getModeloTablaArticulo().addRow(adicion);
			}
		}
		puente.getTablaArticulo().addMouseListener(new ListenerMouseTablaArticulos(puente));
		actualizar(puente.getTablaArticulo().getParent());
	}

	public static void ActualizarTablaPedidos(Puente puente) {
		cadena = puente.getTextFieldBuscarPedido().getText();
		while (puente.getModeloTablaPedidoCliente().getRowCount() > 0) {
			puente.getModeloTablaPedidoCliente().removeRow(0);
		}
		int i = 0;
		while((Cliente) puente.getLogica().obtenerCliente(i)!=null) {
			Cliente clienteAux = (Cliente) puente.getLogica().obtenerCliente(i);
			if(puente.getLogica().getCantidadDePedidosDe(clienteAux)>0) {
				String adicion[] = { clienteAux.getRazonSocial(), clienteAux.getDniCif(), clienteAux.getDireccion(),
						clienteAux.getTelefono(),String.valueOf(puente.getLogica().getCantidadDePedidosDe(clienteAux)) };
				puente.getModeloTablaPedidoCliente().addRow(adicion);
			}
			i++;
		}
		puente.getTablaPedidoCliente().addMouseListener(new ListenerMouseTablaPedidosPedidos(puente));
		actualizar(puente);
	}
	
	public static void actualizar(JPanel panel) {
	  	SwingUtilities.updateComponentTreeUI(panel);
	}

	public static void actualizarTablaPedidosDos(Puente puente, int rowindex) {
		while (puente.getModeloTablaPedidoPedido().getRowCount() > 0) {
			puente.getModeloTablaPedidoPedido().removeRow(0);
		}
		Cliente clienteAux = puente.getLogica().obtenerCliente(String.valueOf(puente.getTablaPedidoCliente().getValueAt(rowindex, 0)));
		for (int i = 0; i < puente.getLogica().getCantidadDePedidosDe(clienteAux); i++) {
			Pedido pedidoAux = puente.getLogica().obtenerPedido(clienteAux.getRazonSocial(),String.valueOf(i));
			String adicion[] = { String.valueOf(pedidoAux.getNumero()),String.valueOf(pedidoAux.getLineas().size())};
				puente.getModeloTablaPedidoPedido().addRow(adicion);
		}
		puente.getTablaPedidoPedido().addMouseListener(new ListenerMouseTablaPedidosLinea(puente,clienteAux));
		actualizar(puente.getTablaPedidoPedido().getParent());
	}
	
	public static void actualizarTablaPedidosTres(Puente puente, int rowindex,Cliente cliente) {
		while (puente.getTablaPedidoLinea().getRowCount() > 0) {
			puente.getModeloTablaPedidoLinea().removeRow(0);
		}
		Pedido pedidoAux = puente.getLogica().obtenerPedido(cliente.getRazonSocial(), String.valueOf(puente.getTablaPedidoPedido().getValueAt(rowindex,0)));
		int i = 0;
		while(puente.getLogica().obtenerLineaPedido(pedidoAux, i)!=null) {
			String adicion[] = { pedidoAux.getLinea(i).getArticulo().getNombre(), String.valueOf(pedidoAux.getLinea(i).getArticulo().getCurrentPrice()),
					String.valueOf(pedidoAux.getLinea(i).getCantidad()),
				String.valueOf(pedidoAux.getLinea(i).getArticulo().getCurrentPrice()*pedidoAux.getLinea(i).getCantidad()) };
				puente.getModeloTablaPedidoLinea().addRow(adicion);
				i++;
			}
		actualizar(puente.getTablaPedidoLinea());
	}
}
