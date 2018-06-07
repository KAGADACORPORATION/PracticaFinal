package almacenesTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import facade.Datos;

@RunWith(Suite.class)
@SuiteClasses({ AlmacenIndiceTest.class, AlmacenIndividualListTest.class, AlmacenIndividualSetTest.class,
		AlmacenMapTest.class, almacenRutaMapeadaTest.class,AlmacenRutaDestinoTest.class,Datos.class })
public class AllTests {
}
