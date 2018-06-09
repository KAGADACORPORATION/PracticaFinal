package control;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Iterator;

import modelo.Articulo;
import modelo.Cliente;
import modelo.Linea;
import modelo.Pedido;
import utiles.Utiles;
import vista.VistaEjecutarAltaArticulo;
import vista.VistaEjecutarAltaCliente;
import vista.VistaEjecutarAltaPedido;

public class Validador {
	private Puente puente;

	public Validador(Puente puente) {
		super();
		this.puente = puente;
	}

	public boolean validarArticulo(Articulo articulo) {
		boolean retorno = true;
		VistaEjecutarAltaArticulo vista = puente.getVistaEjecutarAltaArticulo();
		if (comprobarVacioArticulo(articulo.getNombre(), articulo.getDescripcion(), articulo.getCurrentPrice())) {
			vista.getLblMensaje().setText("ERROR CAMPO VACIO");
			retorno = false;
		}
		if (comprobarNumeros(String.valueOf(articulo.getCurrentPrice()))) {
			vista.getLblMensaje().setText("ERROR EN EL PRECIO");
			retorno = false;
		}
		// if (comprobarSiExiste(articulo)) {
		// vista.getLblMensaje().setText("ERROR EL ARTICULO YA EXISTE");
		// retorno = false;
		// }
		return retorno;
	}

	public boolean validarCliente(Cliente cliente) {
		boolean retorno = true;
		VistaEjecutarAltaCliente vista = puente.getVistaAccederAltaCliente().getVistaEjecutarAltaCliente();
		if (comprobarVacioCliente(cliente)) {
			vista.getLblComprobacion().setText("ERROR CAMPO VACIO");
			retorno = false;
		}
		if (comprobarSiExiste(cliente)){
			vista.getLblComprobacion().setText("ERROR EL CLIENTE YA EXISTE");
			retorno = false;
		}
		if (!comprobarDni(cliente.getDniCif())) {
			vista.getLblComprobacion().setText("ERROR DNI INCORRECTO");
			retorno = false;
		}
		if (!comprobarTelefono(cliente.getTelefono())) {
			vista.getLblComprobacion().setText("ERROR TELEFONO INCORRECTO");
			retorno = false;
		}
		if (comprobarNombreNoNumeros(cliente.getRazonSocial())) {
			vista.getLblComprobacion().setText("ERROR NUMEROS EN EL NOMBRE");
			retorno = false;
		}
		Utiles.actualizar(puente);
		// Y alguna mas que so os ocurra
		return retorno;
	}


	public boolean validarPedido() {
		return true;
	}

	public boolean validarPedido(Pedido pedido) {
		boolean retorno = true;
		VistaEjecutarAltaPedido vista = puente.getVistaAccederAltaPedido().getVistaEjecutarAltaPedido();
		// if () {
		// vista.getLblMensaje().setText("ERROR ");
		// retorno = false;
		// }
		// if (comprobarSiExiste(articulo)) {
		// vista.getLblMensaje().setText("ERROR EL ARTICULO YA EXISTE");
		// retorno = false;
		// }
		return retorno;
	}

	public boolean validarLineaPedido(Linea linea) {
		boolean retorno = true;
		VistaEjecutarAltaPedido vista = puente.getVistaAccederAltaPedido().getVistaEjecutarAltaPedido();
		if (comprobarVacioLinea(linea)) {
			vista.getLblMensaje().setText("ERROR CANTIDAD VACIO");
			retorno = false;
		}
		return retorno;
	}

	public boolean comprobarVacioArticulo(String nombre, String descripcion, float precio) {
		if (nombre.isEmpty() || descripcion.isEmpty() || String.valueOf(precio).isEmpty()) {
			return true;
		} else
			return false;
	}

	private boolean comprobarVacioCliente(Cliente cliente) {
		if (cliente.getClave().isEmpty() || cliente.getRazonSocial().isEmpty() || cliente.getDireccion().isEmpty()
				|| cliente.getTelefono().isEmpty()) {
			return true;
		} else
			return false;
	}

	private boolean comprobarVacioLinea(Linea linea) {
		if (String.valueOf(linea.getCantidad()).isEmpty()) {
			return true;
		} else
			return false;
	}

	public boolean comprobarNumeros(String precio) {
		char caracter;
		for (int i = 0; i < precio.length(); i++) {
			caracter = precio.charAt(i);

			if (!Character.isDigit(caracter)) {
				return false;
			}
		}
		return true;
	}

	private boolean comprobarSiExiste(Articulo articulo) {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean comprobarSiExiste(Cliente cliente) {
		if( puente.getLogica().obtenerCliente(cliente.getRazonSocial()) != null)return true;
		else return false;
	}

	private boolean comprobarNombreNoNumeros(String razonSocial) {
		if (!comprobarNumeros(razonSocial)) {
			return false;
		} else
			return true;
	}

	public boolean comprobarTelefono(String telefono) {
		if (telefono.length() == 9 && comprobarNumeros(telefono)) {
			return true;
		} else
			return false;
	}

	public boolean comprobarDni(String dni) {
		if (dni.length() == 9 && Character.isLetter(dni.charAt(8)) && comprobarNumeros(dni.substring(0, 7))) {
			return true;
		} else
			return false;
	}

}