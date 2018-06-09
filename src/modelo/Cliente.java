package modelo;

import java.io.Serializable;

public class Cliente implements Serializable,Comparable<Cliente>,Indexable{
	private String dniCif;
	private String razonSocial;
	private String direccion;
	private String telefono;

	public Cliente(String dniCif, String razonSocial, String direccion, String telefono) {
		super();
		this.dniCif = dniCif;
		this.razonSocial = razonSocial;
		this.direccion = direccion;
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	@Override
	public boolean equals(Object obj) {
		Cliente cliente = (Cliente) obj;
		boolean retorno = super.equals(obj);
		if(!retorno){
			retorno = this.razonSocial.equals(cliente.razonSocial);
		}
		return retorno;
	}

	
	
	@Override
	public int hashCode() {
		return dniCif.hashCode();
	}

	@Override
	public String toString() {
		return razonSocial;
	}

	@Override
	public int compareTo(Cliente cliente) {
		return this.getRazonSocial().compareTo(cliente.getRazonSocial());
	}

	@Override
	public String getClave() {
		return this.razonSocial;
	}

	public String getDniCif() {
		return dniCif;
	}
}