import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class GUI extends JFrame {

	private final int WIDTH = 450;
	private final int HEIGHT = 500;
	
	private final int WIDTH_CONTENT_PANEL = WIDTH - 40;
	private final int HEIGHT_CONTENT_PANEL = 200;
	
	private JPanel bodyPanel;
	private PageBuscar pageBuscar = new PageBuscar(WIDTH_CONTENT_PANEL, HEIGHT_CONTENT_PANEL);
	private PageReemplazar pageReemplazar = new PageReemplazar();
	private PageIrA pageIrA = new PageIrA();
	private JButton btnBuscar;
	private JButton btnReemplazar;
	private JButton btnIrA;
	private JPanel contentPanel;

	public static void main(String[] args) {
		new GUI();
	}

	public GUI() {
		setResizable(false);
		setSize(WIDTH, HEIGHT);
		setTitle("Editor de Texto");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		bodyPanel = new JPanel();
		bodyPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(bodyPanel);
		bodyPanel.setLayout(null);
		
		content();
		
		setVisible(true);		
	}
	
	private void content() {
		JLabel label = new JLabel("Texto:");
		label.setFont(new Font("Roboto Black", Font.PLAIN, 12));
		label.setBounds(10, 11, 83, 23);
		bodyPanel.add(label);
		
		btnBuscar = newJButton("Buscar", 10, 170, 70, 23, null, null);
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showPanel(pageBuscar);
			}
		});
		bodyPanel.add(btnBuscar);
		
		btnReemplazar = newJButton("Reemplazar", 85, 170, 95, 23, null, null);
		btnReemplazar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showPanel(pageReemplazar);
			}
		});
		bodyPanel.add(btnReemplazar);
		
		btnIrA = newJButton("Ir a", 185, 170, 45, 23, null, null);
		btnIrA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showPanel(pageIrA);
			}
		});
		bodyPanel.add(btnIrA);
		
		contentPanel = new JPanel();
		contentPanel.setBounds(10, 200, WIDTH_CONTENT_PANEL, HEIGHT_CONTENT_PANEL);
		bodyPanel.add(contentPanel);
		
		showPanel(pageBuscar);
		
		JTextArea textArea = new JTextArea(5, 20); // 5 filas y 20 columnas
		textArea.setBackground(new Color(255, 255, 255));
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
			
		JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(20, 45, WIDTH_CONTENT_PANEL - 10, 100);
        bodyPanel.add(scrollPane);
	}
	
	private void showPanel(JPanel panel) {
		panel.setSize(WIDTH_CONTENT_PANEL, HEIGHT_CONTENT_PANEL);
		panel.setLocation(0, 0);
		
		contentPanel.removeAll();
		contentPanel.add(panel);
		contentPanel.repaint();
		
		System.out.println(panel);
	}
	
	private JButton newJButton(String text, int x, int y, int width, int height, Color border, Color background) {
		JButton btn = new JButton(text);
		
		btn.setFocusPainted(false);
		btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn.setBorder(new LineBorder((border != null) ? border : new Color (0, 0, 0)));
		btn.setBackground((background != null) ? background : new Color(215, 215, 215));
		btn.setBounds(x, y, width, height);
		
		return btn;		
	}
}
