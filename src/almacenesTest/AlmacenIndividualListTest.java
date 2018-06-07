package almacenesTest;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import acceso.DAO;
import almacenes.AlmacenIndividualList;
import modelo.Cliente;
import utiles.Utiles;

public class AlmacenIndividualListTest {
	private static final String CLIENTES_LIST = "clientes.list";
	Cliente cliente = new Cliente("1", "uno", "cafe asd", "434343434");
	Cliente clienteDos = new Cliente("2", "dos", "cafe asd", "434343434");
	ArrayList<Cliente> clientes = new ArrayList<>();
	AlmacenIndividualList<Cliente> almacenClientes;
	

	@Before
	public void setUp() throws Exception {
		almacenClientes = new AlmacenIndividualList<>(new ArrayList<>(), CLIENTES_LIST);
		
	}

	@After
	public void tearDown() throws Exception {
		new DAO<>().borrar(CLIENTES_LIST);
		Utiles.borrarCarpeta(new File("./data"));
	}

	@Test
	public void testObtner() {
		assertNull(almacenClientes.obtener(0));
		assertTrue(almacenClientes.grabar(cliente));
		assertNotNull(almacenClientes.obtener(0));
		assertNull(almacenClientes.obtener(1));
	}
	@Test
	public void testGrabar() {
		assertTrue(almacenClientes.grabar(cliente));
		assertTrue(almacenClientes.grabar(cliente));
		assertEquals(almacenClientes.obtener(0), almacenClientes.obtener(1));
		
		//TODO no deberia grabar nulos
//		assertFalse(almacenClientes.grabar(null));
	}
	
}
