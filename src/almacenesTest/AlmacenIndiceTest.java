package almacenesTest;

import static org.junit.Assert.*;
import java.io.File;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import almacenes.AlmacenIndice;
import modelo.Cliente;

public class AlmacenIndiceTest {

	private static final String CLIENTES_DAT = "clientes.dat";
	private static final String INDICE_DAT = "indice.dat";
	AlmacenIndice<Cliente, String> instancia;
	
	@Before
	public void setUp(){
		instancia=new AlmacenIndice<>(INDICE_DAT, CLIENTES_DAT);
		
	}
	
	@Test
	public void testObtener() {
		Cliente cliente=new Cliente("1", "josefo", null, null);
		instancia.grabar(cliente,cliente.getDniCif());
		Cliente cli2=new Cliente("2", "arturo", null, null);
		instancia.grabar(cli2, cli2.getDniCif());
		Cliente cli3=new Cliente("2", "arturo", null, null);
		instancia.grabar(cli3, cli3.getDniCif());
		assertEquals(cli2, instancia.obtener(cli2.getDniCif()));
		assertEquals(cli3, instancia.obtener(cli3.getDniCif()));
		assertNull(instancia.obtener("no"));
	}

	@Test
	public void testGrabar() {
		Cliente cliente=new Cliente("1", "josefo", null, null);
		assertTrue(instancia.grabar(cliente,cliente.getDniCif()));
		Cliente cli2=new Cliente("2", "arturo", null, null);
		assertTrue(instancia.grabar(cli2, cli2.getDniCif()));
		Cliente cli=instancia.obtener(cliente.getDniCif());
		assertEquals(cli,cliente);
	}
	
	@After
	public void tearDown(){
		File file=new File(INDICE_DAT);
		file.delete();
		file=new File(CLIENTES_DAT);
		file.delete();
	}
}
