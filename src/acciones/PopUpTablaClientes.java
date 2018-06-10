package acciones;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class PopUpTablaClientes extends JPopupMenu {

	JMenuItem addOption;
	JMenuItem borrarOption;

	public PopUpTablaClientes() {
		addOption = new JMenuItem("Añadir (solo en pedido please)");
		borrarOption = new JMenuItem("Borrar");
		add(addOption);
		add(borrarOption);
	}

	public JMenuItem getAddOption() {
		return addOption;
	}

	public JMenuItem getBorrarOption() {
		return borrarOption;
	}
}

