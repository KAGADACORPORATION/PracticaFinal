package almacenesTest;

import static org.junit.Assert.*;
import java.io.File;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import acceso.DAO;
import almacenes.AlmacenRutaDestino;
import modelo.Cliente;
import modelo.Pedido;
import utiles.Utiles;

public class AlmacenRutaDestinoTest {

	AlmacenRutaDestino<Pedido> instancia;
	Cliente cliente=new Cliente("1", "nose", "calle falsa 123", "921921921");
	@Before
	public void setUp() throws Exception {
		instancia=new AlmacenRutaDestino<>("data/pedidos", "ped");		
	}

	@After
	public void tearDown() throws Exception {
		new DAO<>().borrar("data/pedidos/1/1.ped");
		new DAO<>().borrar("data/pedidos/1/2.ped");
		new DAO<>().borrar("data/pedidos/1/3.ped");
		Utiles.borrarCarpeta(new File("./data"));
	}

	@Test
	public void test() {
		Pedido pedido=new Pedido(1, cliente);
		assertTrue(instancia.grabar(cliente.getClave(), String.valueOf(pedido.getNumero()), pedido));
		assertEquals(pedido.getNumero(), instancia.obtener(cliente.getClave(), String.valueOf(pedido.getNumero())).getNumero());
		pedido=new Pedido(2, cliente);
		assertTrue(instancia.grabar(cliente.getClave(), String.valueOf(pedido.getNumero()), pedido));
		assertEquals(pedido.getNumero(), instancia.obtener(cliente.getClave(), String.valueOf(pedido.getNumero())).getNumero());
		pedido=new Pedido(3, cliente);
		assertTrue(instancia.grabar(cliente.getClave(), String.valueOf(pedido.getNumero()), pedido));
		assertEquals(pedido.getNumero(), instancia.obtener(cliente.getClave(), String.valueOf(pedido.getNumero())).getNumero());
		assertNotEquals(7, instancia.obtener(cliente.getClave(), String.valueOf(pedido.getNumero())).getNumero());
		assertNull(instancia.obtener(cliente.getClave(), String.valueOf(7)));
		}

}
