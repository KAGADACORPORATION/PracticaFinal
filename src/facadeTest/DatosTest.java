package facadeTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import java.io.File;
import org.junit.After;
import org.junit.Test;
import facade.Datos;
import modelo.Articulo;
import modelo.Cliente;
import modelo.Pedido;
import utiles.Utiles;

public class DatosTest {
	Datos instancia = new Datos();
	Cliente clienteUno = new Cliente("07256204", "Oscar", "calle falsa 2", "11111111P");
	Cliente clienteDos = new Cliente("2", "NombreDos", "calle falsa 2", "22222222P");
	Cliente clienteTres = new Cliente("3", "NombreTres", "calle falsa 3", "33333333P");
	Articulo articuloUno = new Articulo(0, "articuloUno", "descripcion y ...", 11);
	Articulo articuloDos = new Articulo(1, "articuloDos", "descripcionDos y ...", 22);
	Pedido pedidoUno = new Pedido(0, clienteUno);
	Pedido pedidoDos = new Pedido(1, clienteUno);
	Pedido pedidoTres = new Pedido(2, clienteDos);
	Pedido pedidoCuatro = new Pedido(3, clienteDos);
	
	@After
	public void tearDown() throws Exception {
		Utiles.borrarCarpeta(new File("./data"));
	}
	
	
	@Test
	public void testGrabarCliente() {
		assertTrue(instancia.grabar(clienteUno));
		assertEquals(instancia.obtenerCliente(clienteUno.getRazonSocial()),clienteUno);
		assertTrue(instancia.grabar(clienteDos));
		assertEquals(instancia.obtenerCliente(clienteDos.getRazonSocial()),clienteDos);
	}

	@Test
	public void testBorrarCliente() {
		assertTrue(instancia.grabar(clienteUno));
		assertEquals(instancia.obtenerCliente(clienteUno.getRazonSocial()),clienteUno);
		assertTrue(instancia.grabar(clienteDos));
		assertEquals(instancia.obtenerCliente(clienteDos.getRazonSocial()),clienteDos);
		assertTrue(instancia.grabar(clienteTres));
		assertEquals(instancia.obtenerCliente(clienteTres.getRazonSocial()),clienteTres);
		assertTrue(instancia.borrar(clienteUno));
		assertNull(instancia.obtenerCliente(clienteUno.getRazonSocial()));
		assertEquals(instancia.obtenerCliente(clienteDos.getRazonSocial()),clienteDos);
		assertTrue(instancia.borrar(clienteDos));
		assertNull(instancia.obtenerCliente(clienteDos.getRazonSocial()));
		assertTrue(instancia.borrar(clienteTres));
		assertNull(instancia.obtenerCliente(clienteTres.getRazonSocial()));
	}

	@Test
	public void testObtenerCliente() {
		assertTrue(instancia.grabar(clienteUno));
		assertEquals(instancia.obtenerCliente(clienteUno.getRazonSocial()),clienteUno);
		assertTrue(instancia.grabar(clienteDos));
		assertEquals(instancia.obtenerCliente(clienteDos.getRazonSocial()),clienteDos);
	}

	@Test
	public void testGrabarArticulo() {
		assertTrue(instancia.grabar(articuloUno));
		assertEquals(instancia.obtenerArticulo(articuloUno.getNombre()),articuloUno);
		assertTrue(instancia.grabar(articuloDos));
		assertEquals(instancia.obtenerArticulo(articuloDos.getNombre()),articuloDos);
	}

	@Test
	public void testObtenerArticulo() {
		assertTrue(instancia.grabar(articuloUno));
		assertEquals(instancia.obtenerArticulo(articuloUno.getNombre()),articuloUno);
		assertTrue(instancia.grabar(articuloDos));
		assertEquals(instancia.obtenerArticulo(articuloDos.getNombre()),articuloDos);
	}

	@Test
	public void testGrabarPedido() {
		assertTrue(instancia.grabar(pedidoUno));
		assertEquals(instancia.obtenerPedido(String.valueOf(pedidoUno.getNumero()), pedidoUno.getCliente().getRazonSocial()),pedidoUno);
		assertTrue(instancia.grabar(pedidoDos));
		assertEquals(instancia.obtenerPedido(String.valueOf(pedidoDos.getNumero()), pedidoDos.getCliente().getDniCif()).getNumero(),pedidoDos.getNumero());
		assertTrue(instancia.grabar(pedidoTres));
		assertEquals(instancia.obtenerPedido(String.valueOf(pedidoTres.getNumero()), pedidoTres.getCliente().getDniCif()).getNumero(),pedidoTres.getNumero());
		assertTrue(instancia.grabar(pedidoCuatro));
		assertEquals(instancia.obtenerPedido(String.valueOf(pedidoCuatro.getNumero()), pedidoCuatro.getCliente().getDniCif()).getNumero(),pedidoCuatro.getNumero());
	}

	@Test
	public void testObtenerPedido() {
		assertTrue(instancia.grabar(pedidoUno));
		assertEquals(instancia.obtenerPedido(String.valueOf(pedidoUno.getNumero()), pedidoUno.getCliente().getDniCif()).getNumero(),pedidoUno.getNumero());
		assertTrue(instancia.grabar(pedidoDos));
		assertEquals(instancia.obtenerPedido(String.valueOf(pedidoDos.getNumero()), pedidoDos.getCliente().getDniCif()).getNumero(),pedidoDos.getNumero());
		assertTrue(instancia.grabar(pedidoTres));
		assertEquals(instancia.obtenerPedido(String.valueOf(pedidoTres.getNumero()), pedidoTres.getCliente().getDniCif()).getNumero(),pedidoTres.getNumero());
		assertTrue(instancia.grabar(pedidoCuatro));
		assertEquals(instancia.obtenerPedido(String.valueOf(pedidoCuatro.getNumero()), pedidoCuatro.getCliente().getDniCif()).getNumero(),pedidoCuatro.getNumero());
	}

}