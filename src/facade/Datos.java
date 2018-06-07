package facade;

import modelo.AlmacenIndice;
import modelo.Cliente;
import utiles.Utiles;

public class Datos {
	private AlmacenIndice<Cliente, String> clientes;
	
	public Datos() {
		super();
		clientes = new AlmacenIndice<>(Utiles.RUTACLIENTE,Utiles.RUTAINDICECLIENTES);
	}


	public boolean grabarCliente(Cliente cliente) {
		return clientes.grabar(cliente, cliente.getRazonSocial());
	}
	
	public boolean borrarCliente(Cliente cliente) {
		boolean retorno;
		String clave = new String(cliente.getRazonSocial());
		clientes.obtener(clave);
		return retorno;
	}
	
}
