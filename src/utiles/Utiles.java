package utiles;

import java.awt.Image;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import control.Puente;

public class Utiles {
	public static final String RUTACLIENTE = "./data/clientes.data";
	public static final int CAMPOSCLIENTE = 4;
	
	public static ImageIcon createScaledIcon(ImageIcon Imagen, int height) {
		return new ImageIcon(Imagen.getImage().getScaledInstance(height - 2, height - 2, Image.SCALE_SMOOTH));
	}
	
	public static int crearRandom(int min,int max) {
		int numeroAleatorio=((int)(Math.random()*((max-min)+1)))+min;
		return numeroAleatorio;
	}
	public static void actualizar(Puente puente){
  		SwingUtilities.updateComponentTreeUI(puente);
  	}
	public static void borrarCarpeta(File carpetaGenerada) {
	    if (carpetaGenerada.isDirectory()) { 
	        for (File f : carpetaGenerada.listFiles()) { 
	        	borrarCarpeta(f);  } 
	    } 
	    carpetaGenerada.delete(); 
	}
}
