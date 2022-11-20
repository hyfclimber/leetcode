package leet;

public class TrieNode {
	
	int pass;
	int end;
	TrieNode[] nexts;

	TrieNode() {
		pass = 0;
		end = 0;
		nexts = new TrieNode[26];
	}

}
