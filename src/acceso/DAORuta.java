package acceso;

import java.io.File;

public class DAORuta<T> {
	
	
	public T obtener(String clavePadre,String claveElemento){
		T t=null;
		File archivo=new File(obtenerPath(clavePadre, claveElemento));
		if(archivo.exists()){
			t=new DAO<T>().leer(archivo.getPath());
		}
		return t;
	}

	public boolean grabar(T t,String claveElemento,String pathPadre){
		File carpeta=new File(pathPadre);
		boolean retorno=false;
		if(!carpeta.exists()){
			carpeta.mkdirs();
		}
		File archivo=new File(obtenerPath(pathPadre, claveElemento));
		if(!archivo.exists()){
			retorno = new DAO<>().grabar(archivo.getPath(), t);
		}
		return retorno;
	}
	private String obtenerPath(String clavePadre, String claveElemento) {
		return "./"+clavePadre+"/"+claveElemento;
	};
}
