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
	Cliente clienteUno = new Cliente("1", "Nombre Uno", "calle falsa 2", "11111111P");
	Cliente clienteDos = new Cliente("2", "Nombre Dos", "calle falsa 2", "22222222P");
	Articulo articuloUno = new Articulo(0, "articuloUno", "descripcion y ...", 11);
	Articulo articuloDos = new Articulo(0, "articuloDos", "descripcionDos y ...", 22);
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
		assertTrue(instancia.grabarCliente(clienteUno));
		assertEquals(instancia.obtenerCliente(clienteUno.getRazonSocial()),clienteUno);
		assertTrue(instancia.grabarCliente(clienteDos));
		assertEquals(instancia.obtenerCliente(clienteDos.getRazonSocial()),clienteDos);
	}

	@Test
	public void testBorrarCliente() {
		assertTrue(instancia.grabarCliente(clienteUno));
		assertEquals(instancia.obtenerCliente(clienteUno.getRazonSocial()),clienteUno);
		assertTrue(instancia.grabarCliente(clienteDos));
		assertEquals(instancia.obtenerCliente(clienteDos.getRazonSocial()),clienteDos);
		assertTrue(instancia.borrarCliente(clienteUno));
		assertNull(instancia.obtenerCliente(clienteUno.getRazonSocial()));
		assertTrue(instancia.borrarCliente(clienteDos));
		assertNull(instancia.obtenerCliente(clienteDos.getRazonSocial()));
	}

	@Test
	public void testObtenerCliente() {
		assertTrue(instancia.grabarCliente(clienteUno));
		assertEquals(instancia.obtenerCliente(clienteUno.getRazonSocial()),clienteUno);
		assertTrue(instancia.grabarCliente(clienteDos));
		assertEquals(instancia.obtenerCliente(clienteDos.getRazonSocial()),clienteDos);
	}

	@Test
	public void testGrabarArticulo() {
		assertTrue(instancia.grabarArticulo(articuloUno));
		assertEquals(instancia.obtenerArticulo(articuloUno.getNombre()),articuloUno);
		assertTrue(instancia.grabarArticulo(articuloDos));
		assertEquals(instancia.obtenerArticulo(articuloDos.getNombre()),articuloDos);
	}

	@Test
	public void testBorrarArticulo() {
		assertTrue(instancia.grabarArticulo(articuloUno));
		assertEquals(instancia.obtenerArticulo(articuloUno.getNombre()),articuloUno);
		assertTrue(instancia.grabarArticulo(articuloDos));
		assertEquals(instancia.obtenerArticulo(articuloDos.getNombre()),articuloDos);
		assertTrue(instancia.borrarArticulo(articuloUno));
		assertNull(instancia.obtenerArticulo(articuloUno.getNombre()));
		assertTrue(instancia.borrarArticulo(articuloDos));
		assertNull(instancia.obtenerArticulo(articuloDos.getNombre()));
	}

	@Test
	public void testObtenerArticulo() {
		assertTrue(instancia.grabarArticulo(articuloUno));
		assertEquals(instancia.obtenerArticulo(articuloUno.getNombre()),articuloUno);
		assertTrue(instancia.grabarArticulo(articuloDos));
		assertEquals(instancia.obtenerArticulo(articuloDos.getNombre()),articuloDos);
	}

	@Test
	public void testGrabarPedido() {
		assertTrue(instancia.grabarPedido(pedidoUno));
		assertEquals(instancia.obtenerPedido(String.valueOf(pedidoUno.getNumero()), pedidoUno.getCliente().getRazonSocial()),pedidoUno);
		assertTrue(instancia.grabarPedido(pedidoDos));
		assertEquals(instancia.obtenerPedido(String.valueOf(pedidoDos.getNumero()), pedidoDos.getCliente().getRazonSocial()),pedidoDos);
		assertTrue(instancia.grabarPedido(pedidoTres));
		assertEquals(instancia.obtenerPedido(String.valueOf(pedidoTres.getNumero()), pedidoTres.getCliente().getRazonSocial()),pedidoTres);
		assertTrue(instancia.grabarPedido(pedidoCuatro));
		assertEquals(instancia.obtenerPedido(String.valueOf(pedidoCuatro.getNumero()), pedidoCuatro.getCliente().getRazonSocial()),pedidoCuatro);
	}

	@Test
	public void testBorrarPedido() {
		assertTrue(instancia.grabarPedido(pedidoUno));
		assertEquals(instancia.obtenerPedido(String.valueOf(pedidoUno.getNumero()), pedidoUno.getCliente().getRazonSocial()),pedidoUno);
		assertTrue(instancia.grabarPedido(pedidoDos));
		assertEquals(instancia.obtenerPedido(String.valueOf(pedidoDos.getNumero()), pedidoDos.getCliente().getRazonSocial()),pedidoDos);
		assertTrue(instancia.grabarPedido(pedidoTres));
		assertEquals(instancia.obtenerPedido(String.valueOf(pedidoTres.getNumero()), pedidoTres.getCliente().getRazonSocial()),pedidoTres);
		assertTrue(instancia.grabarPedido(pedidoCuatro));
		assertEquals(instancia.obtenerPedido(String.valueOf(pedidoCuatro.getNumero()), pedidoCuatro.getCliente().getRazonSocial()),pedidoCuatro);
		assertTrue(instancia.borrarPedido(pedidoUno));
		assertNull(instancia.obtenerPedido(String.valueOf(pedidoUno.getNumero()), pedidoUno.getCliente().getRazonSocial()));
		assertTrue(instancia.borrarPedido(pedidoDos));
		assertNull(instancia.obtenerPedido(String.valueOf(pedidoDos.getNumero()), pedidoDos.getCliente().getRazonSocial()));
		assertTrue(instancia.borrarPedido(pedidoTres));
		assertNull(instancia.obtenerPedido(String.valueOf(pedidoTres.getNumero()), pedidoTres.getCliente().getRazonSocial()));
		assertTrue(instancia.borrarPedido(pedidoCuatro));
		assertNull(instancia.obtenerPedido(String.valueOf(pedidoCuatro.getNumero()), pedidoCuatro.getCliente().getRazonSocial()));
	}

	@Test
	public void testObtenerPedido() {
		assertTrue(instancia.grabarPedido(pedidoUno));
		assertEquals(instancia.obtenerPedido(String.valueOf(pedidoUno.getNumero()), pedidoUno.getCliente().getRazonSocial()),pedidoUno);
		assertTrue(instancia.grabarPedido(pedidoDos));
		assertEquals(instancia.obtenerPedido(String.valueOf(pedidoDos.getNumero()), pedidoDos.getCliente().getRazonSocial()),pedidoDos);
		assertTrue(instancia.grabarPedido(pedidoTres));
		assertEquals(instancia.obtenerPedido(String.valueOf(pedidoTres.getNumero()), pedidoTres.getCliente().getRazonSocial()),pedidoTres);
		assertTrue(instancia.grabarPedido(pedidoCuatro));
		assertEquals(instancia.obtenerPedido(String.valueOf(pedidoCuatro.getNumero()), pedidoCuatro.getCliente().getRazonSocial()),pedidoCuatro);
	}

}
