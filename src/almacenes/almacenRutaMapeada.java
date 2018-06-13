package almacenes;

import java.io.File;
import java.util.TreeMap;

import acceso.DAO;
import acceso.DAORuta;
import modelo.Articulo;

public class almacenRutaMapeada<T, K> {
	private DAORuta<T> ruta;
	private AlmacenMap<K, Integer> mapa;
	private String extension;
	private String pathDatos, pathPadre;

	public almacenRutaMapeada(AlmacenMap<K, Integer> map, String extension, String pathDatos, String pathPadre) {
		super();
		this.extension = extension;
		this.pathDatos = pathDatos;
		this.pathPadre = pathPadre;
		this.mapa = map;
		assert validate();
		File file = new File(pathPadre + "/" + pathDatos);
		if (!file.exists()) {
			file.mkdirs();
		}
		ruta = new DAORuta<T>();
	}

	private boolean validate() {
		return this.pathDatos != null && extension != null && mapa != null;
	}

	private String estableceRuta(int v) {
		return pathDatos + "/" + String.valueOf(v) + "." + extension;
	}

	public T obtener(K k) {
		Integer v = mapa.obtener(k);
		T t = null;
		if (v != null) {
			t = ruta.obtener(pathPadre, estableceRuta(v));
		}
		return t;
	}

	public boolean grabar(T t, K k, Integer i) {
		boolean retorno = false;
		if (mapa.grabar(k, i)) {
			if (ruta.grabar(t, estableceRuta(i), pathPadre)) {
				retorno = true;
			} else {
				mapa.borrar(k);
			}
		}
		return retorno;
	}

	public int obtenNumero() {
		return mapa.getSize();
	}

	public boolean borrar(String nombre) {
		// TODO Auto-generated method stub
		return false;
	}
	public int getCantidadArticulos() {
		return mapa.getSize();
	}

	public T obtener(int i) {
		return ruta.obtener(pathPadre, estableceRuta(i));
		
	}
	
}
