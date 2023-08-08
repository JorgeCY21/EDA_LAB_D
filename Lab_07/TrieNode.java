import java.text.Normalizer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TrieNode {
	private Map<Character, TrieNode> children;
	private boolean isEndWord;

	private static final int MIN_IGUAL = 10;

	public TrieNode() {
		children = new HashMap<>();
		isEndWord = false;
	}

	public void insert(String word) {
		if (word.length() <= 2)
			return;

		TrieNode current = this;
		for (char c : normalizeWord(word).toCharArray()) {
			if (c != 0) {
				current.children.putIfAbsent(c, new TrieNode());
				current = current.children.get(c);
			}
		}
		current.isEndWord = true;
	}

	public boolean search(String word) {
		TrieNode node = searchNode(word);
		return node != null && node.isEndWord;
	}

	private TrieNode searchNode(String word) {
		TrieNode current = this;
		for (char c : normalizeWord(word).toCharArray()) {
			if (c != 0) {
				current = current.children.get(c);
				if (current == null) {
					return null;
				}
			} else {
				return null;
			}
		}
		return current;
	}

	private String normalizeWord(String word) {
		StringBuilder normalizedWord = new StringBuilder();

		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			String normalized = Normalizer.normalize(String.valueOf(c), Normalizer.Form.NFD).replaceAll("\\p{M}", "");

			if (!normalized.isEmpty()) {
				char normalizedChar = Character.toLowerCase(normalized.charAt(0));
				if ((normalizedChar >= 'a' && normalizedChar <= 'z')
						|| (normalizedChar >= '0' && normalizedChar <= '9')) {
					normalizedWord.append(normalizedChar);
				}
			}
		}

		return normalizedWord.toString();
	}

	@Override
	public String toString() {
		List<String> words = new ArrayList<>();
		collectWords(this, new StringBuilder(), words);
		return "words: " + words + "\n";
	}

	public boolean equals(TrieNode datos) {
		List<String> words = new ArrayList<>();
		collectWords(this, new StringBuilder(), words);
		int foundWords = 0;

		for (String word : words) {
			if (datos.search(word)) {
				foundWords++;
			}
		}

		return foundWords >= MIN_IGUAL;
	}

	private void collectWords(TrieNode current, StringBuilder currentWord, List<String> words) {
		if (current.isEndWord) {
			words.add(currentWord.toString());
		}

		for (char c = 'a'; c <= 'z'; c++) {
			TrieNode child = current.children.get(c);
			if (child != null) {
				currentWord.append(c);
				collectWords(child, currentWord, words);
				currentWord.deleteCharAt(currentWord.length() - 1);
			}
		}

		for (char c = '0'; c <= '9'; c++) {
			TrieNode child = current.children.get(c);
			if (child != null) {
				currentWord.append(c);
				collectWords(child, currentWord, words);
				currentWord.deleteCharAt(currentWord.length() - 1);
			}
		}
	}
}