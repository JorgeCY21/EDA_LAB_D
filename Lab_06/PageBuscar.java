import javax.swing.JPanel;
import javax.swing.JLabel;

public class PageBuscar extends JPanel {

	public PageBuscar(int width, int height) {
		setSize(width, height);
		setLayout(null);
		
		JLabel label = new JLabel("PANEL BUSCAR");
		label.setBounds(203, 114, 100, 14);
		add(label);

	}

}
