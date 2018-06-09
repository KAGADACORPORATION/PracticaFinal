package almacenes;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.TreeMap;

import acceso.DAO;
import modelo.Indexable;

public class AlmacenIndice<T, K> {
	private String pathIndice;
	private String pathDatos;
	private TreeMap<K, Integer> indice;
	DAO<Object> dao;

	public AlmacenIndice(String pathIndice, String pathDatos) {
		super();
		this.pathIndice = pathIndice;
		this.pathDatos = pathDatos;
		assert validate();
		this.indice = new TreeMap<>();
		dao = new DAO<>();
	}

	private boolean validate() {
		return this.pathIndice != null && this.pathDatos != null;
	}

	public T obtener(K k) {
		leerIndice();
		if (indice == null) {
			indice = new TreeMap<>();
			dao.grabar(pathIndice, indice);
		}
		T retorno = null;
		Integer posicion = indice.get(k);
		if (posicion != null) {
			retorno = (T) dao.leer(pathDatos, posicion);
		}
		return retorno;
	}

	/**
	 * Almacen el elemnto de clase T con Clave K, hay que pasarla
	 * 
	 * @param t
	 *            el objeto a grabar
	 * @param k
	 *            la propiedad clave o indice del objeto t
	 * @return true si ha almacenado y false en caso contrario
	 */
	public boolean grabar(T t, K k) {
		boolean retorno = false;
		Integer value = indice.size();
		if (indice.put(k, value) == null) {
			// si se almacena bien en el archivo de datos
			if (dao.grabar(pathDatos, t, true)) {
				retorno = true;
				dao.grabar(pathIndice, indice);
			} else {
				//Si no se graba bien actualizamos el indice con la version grabada
				leerIndice();
			}
		}
		return retorno;
	}

	private void leerIndice() {
		indice = (TreeMap<K, Integer>) dao.leer(pathIndice);
	}
	
	public boolean borrar(K k){
		Integer posicion = null;
		leerIndice();
		boolean retorno=false;
		if(indice.containsKey(k)){
			posicion=indice.remove(k);
			if(posicion!=null){
				retorno=dao.borrarElemtento(pathDatos,posicion);
				if(!retorno){
					leerIndice();
				}
			}
		}
		actualizarIndiceDespuesDeBorrar(posicion);
		dao.grabar(pathIndice, indice);
		return retorno;
	}

	private void actualizarIndiceDespuesDeBorrar(Integer posicion) {
		assert posicion != null;
		for (int i = 0; i < indice.size(); i++) {
			if(indice.get(getClave(i))>=posicion.intValue()) {
				indice.replace((K) getClave(i), indice.get(getClave(i)), indice.get(getClave(i))-1);
			}
		}
	}

	/**
	 * @param i
	 * @return
	 */
	private String getClave(int i) {
		return ((Indexable)dao.leer(pathDatos, i)).getClave();
	}

	public TreeMap<K, Integer> getIndice() {
		leerIndice();
		return indice;
	}

	public void setIndice(TreeMap<K, Integer> indice) {
		this.indice = indice;
	}

	public DAO<Object> getDao() {
		return dao;
	}
}