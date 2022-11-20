package leet;

public class WordDictionary {

	public static void main(String[] args) {
		WordDictionary wordDictionary = new WordDictionary();
		wordDictionary.addWord("a");
		wordDictionary.addWord("a");
//		wordDictionary.addWord(".");
		
		boolean ans = wordDictionary.search("."); 
		System.out.println(ans);
		ans =wordDictionary.search("a"); 
		System.out.println(ans);
		ans =wordDictionary.search("aa"); 
		System.out.println(ans);
		ans =wordDictionary.search("a"); 
		System.out.println(ans);
		wordDictionary.search(".a");
		System.out.println(ans);
		ans =wordDictionary.search("a."); 
		System.out.println(ans);
	}

	TrieNode root;

	public WordDictionary() {
		root = new TrieNode();

	}

	public void addWord(String word) {
		if (word == null)
			return;
		TrieNode node = root;
		char[] chs = word.toCharArray();
		node.pass++;
		for (int i = 0; i < chs.length; i++) {
			int idx = chs[i] - 'a';
			if (node.nexts[idx] == null) {
				node.nexts[idx] = new TrieNode();
			}
			node.nexts[idx].pass++;
			node = node.nexts[idx];
		}
		node.end++;

	}

	public boolean search(String word) {
		return helper(word, root);
	}

	public boolean helper(String word, TrieNode node) {
		if (word == null || node == null)
			return false;
		char[] chs = word.toCharArray();
		for (int i = 0; i < chs.length; i++) {
			char c = chs[i];
			if (c == '.') {
				if (i < chs.length - 1) {
					String after = word.substring(i + 1);
					boolean isValid = false;
					for (int x = 0; x < node.nexts.length; x++) {
						isValid = isValid || helper(after, node.nexts[x]);
						if (isValid) {
							node = node.nexts[x];
							return true;
						}	
					}
					return false;
				} else {
					if (node == null)
						return false;
					boolean isValid = false;
					for (int x = 0; x < node.nexts.length; x++) {
						isValid = isValid || (node.nexts[x] == null ? false : node.nexts[x].end > 0);
						if (isValid) {
							node = node.nexts[x];
							return true;
						}	
					}
					return false;
				}

			} else {
				int idx = chs[i] - 'a';
				if (node.nexts[idx] == null) {
					return false;
				}
				node = node.nexts[idx];
			}
		}
		return node == null ? false : node.end > 0;
	}

}
