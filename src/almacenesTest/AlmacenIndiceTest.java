package almacenesTest;

import static org.junit.Assert.*;
import java.io.File;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import almacenes.AlmacenIndice;
import modelo.Cliente;
import utiles.Utiles;

public class AlmacenIndiceTest {

	AlmacenIndice<Cliente, String> instancia;
	
	@Before
	public void setUp(){
		instancia=new AlmacenIndice<>(Utiles.RUTAINDICECLIENTES, Utiles.RUTACLIENTE);
		
	}
	
	@Test
	public void testObtener() {
		Cliente cliente=new Cliente("1", "josefo", "12121212P", "912912912");
		instancia.grabar(cliente,cliente.getClave());
		Cliente cli2=new Cliente("2", "arturo",  "12121212P", "912912912");
		instancia.grabar(cli2, cli2.getClave());
		Cliente cli3=new Cliente("3", "pepe",  "12121212P", "912912912");
		instancia.grabar(cli3, cli3.getClave());
		assertEquals(cliente, instancia.obtener(cliente.getClave()));
		assertEquals(cli3, instancia.obtener(cli3.getClave()));
		assertNull(instancia.obtener("no"));
	}

	@Test
	public void testGrabar() {
		Cliente cliente=new Cliente("1", "josefo", null, null);
		assertTrue(instancia.grabar(cliente,cliente.getClave()));
		Cliente cli2=new Cliente("2", "arturo", null, null);
		assertTrue(instancia.grabar(cli2, cli2.getClave()));
		Cliente cli=instancia.obtener(cliente.getClave());
		assertEquals(cli,cliente);
	}
	
	@After
	public void tearDown(){
		Utiles.borrarCarpeta(new File("./data"));
	}
}
