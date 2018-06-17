package modelo;

import java.io.Serializable;
import java.util.Vector;

public class Linea implements Serializable{

	private Articulo articulo;
	private int cantidad;

	public Linea(Articulo articulo,int cantidad) {
		super();
		this.cantidad = cantidad;
		this.articulo = articulo;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int cantidad() {
		return cantidad;
	}

	public Articulo getArticulo() {
		return articulo;
	}

	@Override
	public String toString() {
		return articulo.getNombre()+" "+String.valueOf(cantidad);
	}

	public Vector toVector() {
		 Vector vector = new Vector();
		 vector.add(articulo.getNombre());
		 vector.add(articulo.getDescripcion());
		 vector.add(articulo.getCurrentPrice());
		 vector.add(cantidad);
		 vector.add(articulo.getCurrentPrice()*cantidad);
		return vector;
	}
	@Override
	public boolean equals(Object obj) {
		Linea linea = (Linea) obj;
		boolean retorno = super.equals(obj);
		if(!retorno){
			retorno = this.getArticulo().getIdArticulo()==linea.articulo.getIdArticulo()&&this.getCantidad()==linea.cantidad;
		}
		return retorno;
	}
}
