package acciones;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class PopUpTabla extends JPopupMenu {

	JMenuItem addOption;
	JMenuItem borrarOption;

	public PopUpTabla() {
		addOption = new JMenuItem("A�adir");
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
