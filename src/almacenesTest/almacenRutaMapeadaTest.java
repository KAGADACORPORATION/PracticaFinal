package almacenesTest;

import static org.junit.Assert.*;

import java.io.File;
import java.util.TreeMap;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import acceso.DAO;
import almacenes.AlmacenMap;
import almacenes.almacenRutaMapeada;
import modelo.Articulo;
import utiles.Utiles;

public class almacenRutaMapeadaTest {
	private static final String DATA = "data";
	private static final String ARTICULOS = "articulos";
	private static final String ART = "art";
	private static final String ARTICULO_MAP = "articulo.map";
	almacenRutaMapeada<Articulo, String> instamcia;

	@Before
	public void setUp() throws Exception {
		instamcia=new almacenRutaMapeada<>(new AlmacenMap<>(new TreeMap<String, Integer>(), ARTICULO_MAP), ART, ARTICULOS, DATA);
		
	}

	@After
	public void tearDown() throws Exception {
		new DAO<>().borrar(ARTICULO_MAP);	
		new DAO<>().borrar(DATA+"/"+ARTICULOS+"/"+"0."+ART);
		new DAO<>().borrar(DATA+"/"+ARTICULOS+"/"+"1."+ART);
		Utiles.borrarCarpeta(new File("./data"));
	}

	@Test
	public void test() {
		assertNull(instamcia.obtener("uno"));
		Articulo articulo=new Articulo(instamcia.obtenNumero(),"uno","uno",1f);
		assertTrue(instamcia.grabar(articulo, articulo.getNombre(),articulo.getIdArticulo()));
		assertEquals(articulo, instamcia.obtener(articulo.getNombre()));
		articulo=new Articulo(instamcia.obtenNumero(),"dos","uno",1f);
		assertTrue(instamcia.grabar(articulo, articulo.getNombre(),articulo.getIdArticulo()));
		assertEquals(articulo, instamcia.obtener(articulo.getNombre()));
		articulo=new Articulo(1,"dos","uno",1f);
		assertFalse(instamcia.grabar(articulo, articulo.getNombre(),articulo.getIdArticulo()));
		assertEquals(2, instamcia.obtenNumero());
		assertNull(instamcia.obtener("tres"));
	}

}

