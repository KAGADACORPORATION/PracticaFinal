package acciones;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class PopUpTabla extends JPopupMenu {

	JMenuItem addOption;

	public PopUpTabla() {
		addOption = new JMenuItem("A�adir");
		add(addOption);
	}

	public JMenuItem getAddOption() {
		return addOption;
	}

}
