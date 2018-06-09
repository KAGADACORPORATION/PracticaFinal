package utiles;

import java.awt.Container;
import java.awt.Image;
import java.io.File;
import java.util.TreeMap;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import acciones.ListenerMouseTablaCliente;
import control.Puente;
import modelo.Cliente;
import vista.VistaEjecutarBuscarCliente;

public class Utiles {
	public static final String RUTACLIENTE = "./data/clientes/clientes.data";
	public static final String RUTAINDICECLIENTES = "./data/clientesIndice/clientes.index";
	public static final int CAMPOSCLIENTE = 4;
	public static final String DATA = "data";
	public static final String ARTICULOS = "articulos";
	public static final String ART = "art";
	public static final String ARTICULO_MAP = "articulo.map";
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
		VistaEjecutarBuscarCliente vista = puente.getVistaAccederBuscarCliente().getVistaEjecutarBuscarCliente();
		cadena = vista.getTextField().getText();
		while (puente.getModeloTabla().getRowCount() > 0) {
			puente.getModeloTabla().removeRow(0);
		}
		TreeMap<String, Integer> indiceClientes = puente.getLogica().getIndice();
		for (int i = 0; i < indiceClientes.size(); i++) {
			Cliente clienteAux = (Cliente) puente.getLogica().obtenerCliente(i);
			if(clienteAux.getRazonSocial().toLowerCase().startsWith(cadena)) {
				String adicion[] = { clienteAux.getRazonSocial(), clienteAux.getDniCif(), clienteAux.getDireccion(),
						clienteAux.getTelefono() };
				puente.getModeloTabla().addRow(adicion);
			}
		}
		vista.getTable().addMouseListener(new ListenerMouseTablaCliente(puente));
		Utiles.actualizar(puente.getVistaEjecutarBuscarCliente().getTable().getParent());
	}

	public static void actualizar(JPanel panel) {
	  	SwingUtilities.updateComponentTreeUI(panel);
	}
}
