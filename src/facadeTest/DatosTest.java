package facadeTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import java.io.File;
import org.junit.After;
import org.junit.Ignore;
import org.junit.Test;
import facade.Datos;
import modelo.Cliente;
import modelo.Pedido;
import utiles.Utiles;

public class DatosTest {
	Datos instancia = new Datos();
	Cliente clienteUno = new Cliente("1", "NombreUno", "calle falsa 2", "11111111P");
	Cliente clienteDos = new Cliente("2", "NombreDos", "calle falsa 2", "22222222P");
	Cliente clienteTres = new Cliente("3", "NombreTres", "calle falsa 3", "33333333P");
//	Articulo articuloUno = new Articulo(0, "articuloUno", "descripcion y ...", 11);
//	Articulo articuloDos = new Articulo(0, "articuloDos", "descripcionDos y ...", 22);
	Pedido pedidoUno = new Pedido(0, clienteUno);
	Pedido pedidoDos = new Pedido(1, clienteUno);
	Pedido pedidoTres = new Pedido(2, clienteDos);
	Pedido pedidoCuatro = new Pedido(3, clienteDos);
	
	@After
	public void tearDown() throws Exception {
		Utiles.borrarCarpeta(new File("./data"));
	}
	
	
	@Ignore
	public void testGrabarCliente() {
		assertTrue(instancia.grabar(clienteUno));
		assertEquals(instancia.obtenerCliente(clienteUno.getRazonSocial()),clienteUno);
		assertTrue(instancia.grabar(clienteDos));
		assertEquals(instancia.obtenerCliente(clienteDos.getRazonSocial()),clienteDos);
	}

	@Ignore
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

	@Ignore
	public void testObtenerCliente() {
		assertTrue(instancia.grabar(clienteUno));
		assertEquals(instancia.obtenerCliente(clienteUno.getRazonSocial()),clienteUno);
		assertTrue(instancia.grabar(clienteDos));
		assertEquals(instancia.obtenerCliente(clienteDos.getRazonSocial()),clienteDos);
	}

////	@Test
//	public void testGrabarArticulo() {
//		assertTrue(instancia.grabarArticulo(articuloUno));
//		assertEquals(instancia.obtenerArticulo(articuloUno.getNombre()),articuloUno);
//		assertTrue(instancia.grabarArticulo(articuloDos));
//		assertEquals(instancia.obtenerArticulo(articuloDos.getNombre()),articuloDos);
//	}
//
////	@Test
//	public void testBorrarArticulo() {
//		assertTrue(instancia.grabarArticulo(articuloUno));
//		assertEquals(instancia.obtenerArticulo(articuloUno.getNombre()),articuloUno);
//		assertTrue(instancia.grabarArticulo(articuloDos));
//		assertEquals(instancia.obtenerArticulo(articuloDos.getNombre()),articuloDos);
//		assertTrue(instancia.borrarArticulo(articuloUno));
//		assertNull(instancia.obtenerArticulo(articuloUno.getNombre()));
//		assertTrue(instancia.borrarArticulo(articuloDos));
//		assertNull(instancia.obtenerArticulo(articuloDos.getNombre()));
//	}
//
////	@Test
//	public void testObtenerArticulo() {
//		assertTrue(instancia.grabarArticulo(articuloUno));
//		assertEquals(instancia.obtenerArticulo(articuloUno.getNombre()),articuloUno);
//		assertTrue(instancia.grabarArticulo(articuloDos));
//		assertEquals(instancia.obtenerArticulo(articuloDos.getNombre()),articuloDos);
//	}
//
	@Test
	public void testGrabarPedido() {
		assertTrue(instancia.grabar(pedidoUno));
		assertEquals(instancia.obtenerPedido(String.valueOf(pedidoUno.getNumero()), pedidoUno.getCliente().getRazonSocial()).getCliente(),pedidoUno.getCliente());
		assertTrue(instancia.grabar(pedidoDos));
		assertEquals(instancia.obtenerPedido(String.valueOf(pedidoDos.getNumero()), pedidoDos.getCliente().getRazonSocial()),pedidoDos);
		assertTrue(instancia.grabar(pedidoTres));
		assertEquals(instancia.obtenerPedido(String.valueOf(pedidoTres.getNumero()), pedidoTres.getCliente().getRazonSocial()),pedidoTres);
		assertTrue(instancia.grabar(pedidoCuatro));
		assertEquals(instancia.obtenerPedido(String.valueOf(pedidoCuatro.getNumero()), pedidoCuatro.getCliente().getRazonSocial()),pedidoCuatro);
	}

	@Test
	public void testBorrarPedido() {
		assertTrue(instancia.grabar(pedidoUno));
		assertEquals(instancia.obtenerPedido(String.valueOf(pedidoUno.getNumero()), pedidoUno.getCliente().getRazonSocial()),pedidoUno);
		assertTrue(instancia.grabar(pedidoDos));
		assertEquals(instancia.obtenerPedido(String.valueOf(pedidoDos.getNumero()), pedidoDos.getCliente().getRazonSocial()),pedidoDos);
		assertTrue(instancia.grabar(pedidoTres));
		assertEquals(instancia.obtenerPedido(String.valueOf(pedidoTres.getNumero()), pedidoTres.getCliente().getRazonSocial()),pedidoTres);
		assertTrue(instancia.grabar(pedidoCuatro));
		assertEquals(instancia.obtenerPedido(String.valueOf(pedidoCuatro.getNumero()), pedidoCuatro.getCliente().getRazonSocial()),pedidoCuatro);
		assertTrue(instancia.borrar(pedidoUno));
		assertNull(instancia.obtenerPedido(String.valueOf(pedidoUno.getNumero()), pedidoUno.getCliente().getRazonSocial()));
		assertTrue(instancia.borrar(pedidoDos));
		assertNull(instancia.obtenerPedido(String.valueOf(pedidoDos.getNumero()), pedidoDos.getCliente().getRazonSocial()));
		assertTrue(instancia.borrar(pedidoTres));
		assertNull(instancia.obtenerPedido(String.valueOf(pedidoTres.getNumero()), pedidoTres.getCliente().getRazonSocial()));
		assertTrue(instancia.borrar(pedidoCuatro));
		assertNull(instancia.obtenerPedido(String.valueOf(pedidoCuatro.getNumero()), pedidoCuatro.getCliente().getRazonSocial()));
	}
//
////	@Test
//	public void testObtenerPedido() {
//		assertTrue(instancia.grabarPedido(pedidoUno));
//		assertEquals(instancia.obtenerPedido(String.valueOf(pedidoUno.getNumero()), pedidoUno.getCliente().getRazonSocial()),pedidoUno);
//		assertTrue(instancia.grabarPedido(pedidoDos));
//		assertEquals(instancia.obtenerPedido(String.valueOf(pedidoDos.getNumero()), pedidoDos.getCliente().getRazonSocial()),pedidoDos);
//		assertTrue(instancia.grabarPedido(pedidoTres));
//		assertEquals(instancia.obtenerPedido(String.valueOf(pedidoTres.getNumero()), pedidoTres.getCliente().getRazonSocial()),pedidoTres);
//		assertTrue(instancia.grabarPedido(pedidoCuatro));
//		assertEquals(instancia.obtenerPedido(String.valueOf(pedidoCuatro.getNumero()), pedidoCuatro.getCliente().getRazonSocial()),pedidoCuatro);
//	}

}