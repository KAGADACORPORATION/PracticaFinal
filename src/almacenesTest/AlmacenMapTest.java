package almacenesTest;

import static org.junit.Assert.*;

import java.io.File;
import java.util.TreeMap;
import org.junit.After;
import org.junit.Test;
import acceso.DAO;
import almacenes.AlmacenMap;
import modelo.Cliente;
import utiles.Utiles;

public class AlmacenMapTest {
	private static final String MAPA_MAP = "mapa.map";
	AlmacenMap<String, Cliente> mapa=new AlmacenMap<>(new TreeMap<>(), MAPA_MAP);
	Cliente Cliente=new Cliente("1","uno", "calle 123", "912912912");
	Cliente Cliente2=new Cliente("1","dos", "calle 123", "912912912");
	Cliente Cliente3=new Cliente("2","tres", "calle 123", "912912912");
	Cliente Cliente4=new Cliente("3","cuatro", "calle 123", "912912912");
	Cliente Cliente5=new Cliente("4","cinco", "calle 123", "912912912");

	@After
	public void tearDown() throws Exception {
		new DAO<>().borrar(MAPA_MAP);
		Utiles.borrarCarpeta(new File("./data"));
	}

	@Test
	public void test() {
		assertTrue(mapa.grabar(Cliente.getRazonSocial(), Cliente));
		assertTrue(mapa.grabar(Cliente2.getRazonSocial(), Cliente2));
		assertTrue(mapa.grabar(Cliente3.getRazonSocial(), Cliente3));
		assertTrue(mapa.grabar(Cliente4.getRazonSocial(), Cliente4));
		assertFalse(mapa.grabar(Cliente4.getRazonSocial(), Cliente5));
		assertEquals(Cliente2, mapa.obtener(Cliente2.getRazonSocial()));
	}

}
