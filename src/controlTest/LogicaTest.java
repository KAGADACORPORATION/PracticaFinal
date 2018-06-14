package controlTest;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.After;
import org.junit.Test;

import control.Logica;
import control.Puente;
import control.Validador;
import modelo.Articulo;
import modelo.Cliente;
import modelo.Linea;
import modelo.Pedido;
import utiles.Utiles;

public class LogicaTest {
	Logica instancia = new Logica(new Validador(new Puente()));
	Cliente cliente = new Cliente("45454545P", "clienteTest", "calleTest", "912912912");
	Cliente clienteDos = new Cliente("23232323P", "clienteTestDos", "calleTestDos", "934234234");
	Articulo articuloUno = new Articulo(0, "articuloUno", "descripcion y ...", 11);
	Articulo articuloDos = new Articulo(1, "articuloDos", "descripcionDos y ...", 22);
	Pedido pedidoUno = new Pedido(0, cliente);
	Pedido pedidoDos = new Pedido(1, cliente);
	Pedido pedidoTres = new Pedido(2, clienteDos);
	Pedido pedidoCuatro = new Pedido(3, clienteDos);
	Linea linea = new Linea(articuloUno, 2);
	Linea lineaDos = new Linea(articuloUno, 2);
	Linea lineaTres = new Linea(articuloDos, 2);
	Linea lineaCuatro = new Linea(articuloDos, 2);
	
	
	
	@After public void tearDown() throws Exception {
		Utiles.borrarCarpeta(new File("./data"));
	}
	
	@Test
	public void testDarAltaCliente() {
		assertTrue(instancia.darAlta(cliente));
	}

	@Test
	public void testObtenerClienteString() {
		assertTrue(instancia.darAlta(cliente));
		assertEquals(instancia.obtenerCliente(cliente.getRazonSocial()),cliente);
		assertTrue(instancia.darAlta(clienteDos));
	}

	@Test
	public void testBorrarClientePorNombre() {
		instancia.darAlta(cliente);
		instancia.darAlta(clienteDos);
		assertTrue(instancia.borrarClientePorNombre(cliente.getRazonSocial()));
		assertNull(instancia.obtenerCliente(cliente.getRazonSocial()));
		assertTrue(instancia.borrarClientePorNombre(clienteDos.getRazonSocial()));
		assertTrue(instancia.darAlta(cliente));
		assertNull(instancia.obtenerCliente(clienteDos.getRazonSocial()));
		assertEquals(instancia.obtenerCliente(cliente.getRazonSocial()), cliente);
	}

	@Test
	public void testDarAltaArticulo() {
		assertTrue(instancia.darAlta(articuloUno));
	}

	@Test
	public void testObtenerArticuloString() {
		assertTrue(instancia.darAlta(articuloUno));
		assertEquals(instancia.obtenerArticulo(articuloUno.getNombre()),articuloUno);
		assertTrue(instancia.darAlta(articuloDos));
		assertEquals(instancia.obtenerArticulo(articuloDos.getNombre()),articuloDos);
	}


	@Test
	public void testObtenerClienteInt() {
		assertTrue(instancia.darAlta(cliente));
		assertTrue(instancia.darAlta(clienteDos));
		assertEquals(instancia.obtenerCliente(0), cliente);
		assertNotEquals(instancia.obtenerCliente(0), clienteDos);
		assertEquals(instancia.obtenerCliente(1), clienteDos);
	}
	
	@Test
	public void testObtenerArticuloInt() {
		assertTrue(instancia.darAlta(articuloUno));
		assertEquals(instancia.obtenerArticulo(articuloUno.getNombre()),articuloUno);
		assertTrue(instancia.darAlta(articuloDos));
		assertEquals(instancia.obtenerArticulo(articuloDos.getNombre()),articuloDos);
		assertNotNull(instancia.obtenerArticulo(1));
		assertNull(instancia.obtenerArticulo(2));
	}

	@Test
	public void testGrabarPedido() {
		assertTrue(instancia.grabarPedido(pedidoUno));
		assertTrue(instancia.grabarPedido(pedidoDos));
		assertTrue(instancia.grabarPedido(pedidoTres));
		assertTrue(instancia.grabarPedido(pedidoCuatro));
		assertEquals(instancia.obtenerPedido(pedidoUno.getCliente().getRazonSocial(),String.valueOf(pedidoUno.getNumero())), pedidoUno);
		assertEquals(instancia.obtenerPedido(pedidoDos.getCliente().getRazonSocial(),String.valueOf(pedidoDos.getNumero())), pedidoDos);
		assertEquals(instancia.obtenerPedido(pedidoTres.getCliente().getRazonSocial(),String.valueOf(pedidoTres.getNumero())), pedidoTres);
		assertEquals(instancia.obtenerPedido(pedidoCuatro.getCliente().getRazonSocial(),String.valueOf(pedidoCuatro.getNumero())), pedidoCuatro);
	}

	@Test
	public void testObtenerPedido() {
		assertTrue(instancia.grabarPedido(pedidoUno));
		assertTrue(instancia.grabarPedido(pedidoDos));
		assertTrue(instancia.grabarPedido(pedidoTres));
		assertTrue(instancia.grabarPedido(pedidoCuatro));
		assertEquals(instancia.obtenerPedido(pedidoUno.getCliente().getRazonSocial(),String.valueOf(pedidoUno.getNumero())), pedidoUno);
		assertEquals(instancia.obtenerPedido(pedidoDos.getCliente().getRazonSocial(),String.valueOf(pedidoDos.getNumero())), pedidoDos);
		assertEquals(instancia.obtenerPedido(pedidoTres.getCliente().getRazonSocial(),String.valueOf(pedidoTres.getNumero())), pedidoTres);
		assertEquals(instancia.obtenerPedido(pedidoCuatro.getCliente().getRazonSocial(),String.valueOf(pedidoCuatro.getNumero())), pedidoCuatro);
	}

	@Test
	public void testGetCantidadClientesConPedidos() {
		assertEquals(instancia.getCantidadClientesConPedidos(),0);
		assertTrue(instancia.grabarPedido(pedidoUno));
		assertEquals(instancia.getCantidadClientesConPedidos(),1);
		assertTrue(instancia.grabarPedido(pedidoDos));
		assertEquals(instancia.getCantidadClientesConPedidos(),1);
		assertTrue(instancia.grabarPedido(pedidoTres));
		assertEquals(instancia.getCantidadClientesConPedidos(),2);
		assertTrue(instancia.grabarPedido(pedidoCuatro));
		assertEquals(instancia.getCantidadClientesConPedidos(),2);
	}
	
	@Test
	public void testInsertarLineaPedido() {
		assertTrue(pedidoUno.insertarLinea(linea));
		assertTrue(pedidoUno.insertarLinea(lineaDos));
	}


//	@Test
//	public void testModificarPrecio() {
//		fail("Not yet implemented");
//	}
//	@Test
//	public void testConsultarHistorico() {
//		fail("Not yet implemented");
//	}
//

}
