package acciones;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import control.Logica;
import control.Puente;
import control.Validador;
import modelo.Articulo;
import utiles.Utiles;
import vista.VistaEjecutarAltaArticulo;

public class RegistrarArticulo implements ActionListener {

	private Puente puente;

	public RegistrarArticulo(Puente puente) {
		super();
		this.puente = puente;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		VistaEjecutarAltaArticulo vista = puente.getVistaEjecutarAltaArticulo();

		/*assert !this.validador.validarArticulo(new Articulo(1, vista.getTextNombreAltaArticulo().getText(),
				vista.getTextDescripcionAltaArticulo().getText(),
				Float.valueOf(vista.getTextPrecio().getText()))) : "Error en algun campo";*/

		Articulo articulo = new Articulo(getIdArticulo(),
				vista.getTextNombreAltaArticulo().getText(), vista.getTextDescripcionAltaArticulo().getText(),
				Float.valueOf(vista.getTextPrecio().getText()));

		if (puente.getLogica().darAlta(articulo)) {
			vista.getTextNombreAltaArticulo().setText("");
			vista.getTextDescripcionAltaArticulo().setText("");
			vista.getTextPrecio().setText("");
			vista.getLblMensaje().setText("Articulo creado");
		}
		else {
			vista.getLblMensaje().setText("error al crear");}

		Utiles.actualizar(puente);
	}
	
	public int getIdArticulo() {
		return this.puente.getLogica().getCantidadArticulos();
	}

}