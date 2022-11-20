package leet;

public class TieTree {
	TrieNode root;

	public static void main(String[] args) {
		TieTree t = new TieTree();
		t.insert("apple");
		System.out.println(t.search("apple"));
		System.out.println(t.search("app"));
		System.out.println(t.startsWith("app"));
		t.insert("app");
		System.out.println(t.search("app"));
	}
	
	 /** Initialize your data structure here. */
    public TieTree() {
    	root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
    	if (word == null) return;
    	char[] chs = word.toCharArray();
    	TrieNode node = root;
    	node.pass++;
    	for (int i = 0; i < chs.length; i++) {
    		int index = chs[i] - 'a';
    		if (node.nexts[index] == null) {
    			node.nexts[index] = new TrieNode();
    		}
    		node = node.nexts[index];
    		node.pass++;
    	}
    	node.end++;

    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
    	if (word == null) return false;
    	char[] chs = word.toCharArray();
    	TrieNode node = root;
    	for (int i = 0; i < chs.length; i++) {
    		int index = chs[i] - 'a';
    		if (node.nexts[index] == null) {
    			return false;
    		}
    		node = node.nexts[index];
    	}
    	return node.end > 0;

    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
    	if (prefix == null) return false;
    	char[] chs = prefix.toCharArray();
    	TrieNode node = root;
    	for (int i = 0; i < chs.length; i++) {
    		int idx = chs[i] - 'a';
    		if (node.nexts[idx] == null) {
    			return false;
    		}
    		node = node.nexts[idx];
    	}
    	return node.pass > 0;
    }

}

