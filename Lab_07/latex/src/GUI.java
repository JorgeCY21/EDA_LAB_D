import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class GUI extends javax.swing.JFrame {

	private final int HEIGHT = 400;
	private final int WIDTH = 700;

	private JPanel bodyPanel;

	private JButton btnVerifPlagio;
	private JButton btnSubirDoc;
	private JButton btnSubirArchivos;

	private JTextArea textArea;
	private JFileChooser fileChooser;
	private PlagiarismChecker plagioChecker;

	private GUI gui;

	public GUI() {
		gui = this;

		this.setTitle("Detector de Plagio");
		this.setSize(WIDTH, HEIGHT);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		bodyPanel = new JPanel();
		bodyPanel.setLayout(null);
		setContentPane(bodyPanel);

		initComponents();
		this.setVisible(true);

	}

	private void initComponents() {

		JLabel lbl = new JLabel("Ingrese su texto aquí o cargue sus archivos");
		lbl.setBounds(40, 23, 326, 40);
		bodyPanel.add(lbl);

		btnVerifPlagio = new JButton("Verificar plagio");
		btnVerifPlagio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					if (plagioChecker.isEmpty()) {

						JOptionPane.showMessageDialog(gui, "Debe de subir archivos a la base antes de comparar",
								"ERROR - BASE DE DATOS VACIA", JOptionPane.ERROR_MESSAGE);

						return;
					}

					gui.setSize(WIDTH, HEIGHT + 150);
					gui.setLocationRelativeTo(null);

					TrieNode aux = new TrieNode();
					String[] palabras = textArea.getText().split("\\s+");

					for (String palabra : palabras) {
						aux.insert(palabra);
					}

					System.out.println("TextArea: " + aux);

					mostrarResultados(plagioChecker.verifyPlagiarism(aux).getResults());

				} catch (Exception error) {
					System.out.println(error.getMessage());
				}
			}
		});
		btnVerifPlagio.setBounds(60, 300, 150, 40);
		bodyPanel.add(btnVerifPlagio);

		btnSubirDoc = new JButton("Cargar Archivo");
		btnSubirDoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				subirArchivoTextArea();
			}
		});
		btnSubirDoc.setBounds(472, 23, 150, 40);
		bodyPanel.add(btnSubirDoc);

		btnSubirArchivos = new JButton("Cargar Archivos");
		btnSubirArchivos.setBounds(472, 300, 150, 40);
		bodyPanel.add(btnSubirArchivos);
		btnSubirArchivos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				mostrarFileChooser();

			}
		});

		textArea = new JTextArea(5, 20);
		textArea.setBackground(new Color(255, 255, 255));
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);

		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(30, 80, WIDTH - 75, 200);
		bodyPanel.add(scrollPane);

	}

	protected void mostrarResultados(boolean[] results) {

		int iniColumna = 20;
		int numArchivo = 1;
		for (boolean bl : results) {
			mostrarColumna(bl, iniColumna, numArchivo);

			numArchivo++;
			iniColumna += 100;
		}
	}

	private void mostrarColumna(boolean bl, int iniColumna, int numArchivo) {
		JLabel lblArchivo = new JLabel("Archivo N" + numArchivo);
		JLabel lblSiNo = new JLabel((bl) ? "Si" : "No");
		JLabel color = new JLabel("      ");

		color.setOpaque(true);
		color.setBackground((bl) ? Color.GREEN : Color.RED);

		lblArchivo.setBounds(iniColumna, 400, 100, 30);
		lblArchivo.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		lblArchivo.setHorizontalAlignment(SwingConstants.CENTER);
		lblArchivo.setOpaque(true);
		lblArchivo.setBackground(Color.WHITE);
		bodyPanel.add(lblArchivo);

		lblSiNo.setBounds(iniColumna, 430, 100, 30);
		lblSiNo.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		lblSiNo.setHorizontalAlignment(SwingConstants.CENTER);
		lblSiNo.setOpaque(true);
		lblSiNo.setBackground(Color.WHITE);
		bodyPanel.add(lblSiNo);

		color.setBounds(iniColumna, 460, 100, 30);
		color.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		bodyPanel.add(color);

	}

	private void subirArchivoTextArea() {
		fileChooser = new JFileChooser();
		fileChooser.setMultiSelectionEnabled(false);

		int resultado = fileChooser.showOpenDialog(this);

		if (resultado == JFileChooser.APPROVE_OPTION) {
			File archivoSeleccionado = fileChooser.getSelectedFile();
			String path = archivoSeleccionado.getAbsolutePath();

			try {
				BufferedReader reader = new BufferedReader(new FileReader(path));
				StringBuilder contenido = new StringBuilder();
				String linea;

				while ((linea = reader.readLine()) != null) {
					contenido.append(linea).append("\n");
				}

				reader.close();

				textArea.setText(contenido.toString());
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

	private void mostrarFileChooser() {
		fileChooser = new JFileChooser();
		fileChooser.setMultiSelectionEnabled(true);

		int resultado = fileChooser.showOpenDialog(this);

		if (resultado == JFileChooser.APPROVE_OPTION) {
			File[] archivosSeleccionados = fileChooser.getSelectedFiles();
			String[] paths = new String[archivosSeleccionados.length];

			plagioChecker = new PlagiarismChecker(archivosSeleccionados.length);

			for (int i = 0; i < archivosSeleccionados.length; i++) {
				paths[i] = archivosSeleccionados[i].getAbsolutePath();
			}

			plagioChecker.loadFiles(paths);

		}
	}

	public static void main(String args[]) {

		mejorandoApariencia();

		new GUI();

	}

	private static void mejorandoApariencia() {
		try {
			for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

}