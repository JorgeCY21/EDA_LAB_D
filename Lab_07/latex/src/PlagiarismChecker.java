import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PlagiarismChecker {

	private TrieNode[] tries;
	private ResultChecker resultChecker;

	public PlagiarismChecker(int num) {
		tries = new TrieNode[num];
		resultChecker = new ResultChecker(num);
	}

	// retornar que no hubo error en la lectura
	public boolean loadFiles(String[] paths) {

		for (int i = 0; i < paths.length; i++) {
			TrieNode trie = new TrieNode();

			loadFile(paths[i], trie);

			tries[i] = trie;
		}

		return false;
	}

	public boolean isEmpty() {
		for (TrieNode trie : tries) {
			if (trie == null)
				return true;
		}

		return false;
	}

	private boolean loadFile(String path, TrieNode trie) {

		try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] palabras = line.split("\\s+");

				for (String palabra : palabras) {
					trie.insert(palabra);
				}

			}
			return true;

		} catch (IOException e) {

			return false;
		}
	}

	// path ruta del archivo donde colocamos el texto con/sin plagio.
	public ResultChecker verifyPlagiarism(String path) {
		ResultChecker result = null;

		// retornar resultados del sistema

		return result;

	}

	public ResultChecker verifyPlagiarism(TrieNode trie) {

		for (int i = 0; i < tries.length; i++) {
			System.out.println("Trie N" + (i + 1) + ": " + tries[i]);

			boolean isPlagio = trie.equals(tries[i]);
			resultChecker.setPlagio(i, isPlagio);

		}

		return resultChecker;

	}

}
