import java.util.HashMap;
import java.util.Map;

class Trie {
  TrieNode root;
  
  /** Initialize your data structure here. */
  public Trie() {
      root = new TrieNode();
  }
  
  /** Inserts a word into the trie. */
  public void insert(String word) {
      TrieNode node = root;
      for (char c: word.toCharArray()) {
          if (!node.map.containsKey(c)) {
              node.map.put(c, new TrieNode());
          }
          node = node.map.get(c);
      }
      node.isWord = true;
  }
  
  /** Returns if the word is in the trie. */
  public boolean search(String word) {
      TrieNode node = root;
      for (char c: word.toCharArray()) {
          if (!node.map.containsKey(c)) {
              return false;
          }
          node = node.map.get(c);
      }
      return node.isWord;
  }
  
  /** Returns if there is any word in the trie that starts with the given prefix. */
  public boolean startsWith(String prefix) {
      TrieNode node = root;
      for (char c: prefix.toCharArray()) {
          if (!node.map.containsKey(c)) {
              return false;
          }
          node = node.map.get(c);
      }
      return true;
  }
}


class TrieNode {
  Map<Character, TrieNode> map;
  Boolean isWord;
  
  public TrieNode() {
      map = new HashMap<>();
      isWord = false;
  }
}
/**
* Your Trie object will be instantiated and called as such:
* Trie obj = new Trie();
* obj.insert(word);
* boolean param_2 = obj.search(word);
* boolean param_3 = obj.startsWith(prefix);
*/