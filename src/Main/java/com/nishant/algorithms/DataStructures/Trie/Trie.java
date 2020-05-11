class Trie {
	class TrieNode {
		public TrieNode[] children;
		public int count;

		public TrieNode() {
			children = new TrieNode[26];
		}
	}

	private TrieNode root;

	public Trie() {
		root = new TrieNode();
	}

	public void insert(String s) {
		TrieNode curr = root;
		char[] chars = s.toCharArray();

		for(int i = 0; i < chars.length; i ++) {
			int index = chars[i] - 'a';

			if(curr.children[index] == null) {
				curr.children[index] = new TrieNode();
			}

			curr = curr.children[index];
		}

		curr.count ++;
	}

	public boolean contains(String s) {
		TrieNode curr = root;
		char[] chars = s.toCharArray();

		for(int i = 0; i < chars.length; i ++) {
			int index = chars[i] - 'a';

			if(curr.children[index] == null) {
				return false;
			}

			curr = curr.children[index];
		}

		return curr.count > 0;
	}

	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("app");
		trie.insert("apple");
		trie.insert("ap");

		System.out.println(trie.contains("app"));
		System.out.println(trie.contains("appl"));
	}


}
