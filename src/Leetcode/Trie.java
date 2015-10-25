/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Leetcode;

/**
 *
 * @author Wu
 */
public class Trie {

    class TrieNode {

        // Initialize your data structure here.

        char val;
        boolean isWord;
        TrieNode[] children = new TrieNode[26];

        public TrieNode() {
        }

        public TrieNode(char val) {
            this.val = val;
        }
    }

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        int _length = word.length();
        TrieNode parent = root;
        for (int i = 0; i < _length; i++) {
            char c = word.charAt(i);
            if (parent.children[c - 'a'] == null) {
                parent.children[c - 'a'] = new TrieNode(c);
            }
            parent = parent.children[c - 'a'];
        }
        parent.isWord = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        int _length = word.length();
        TrieNode parent = root;
        for (int i = 0; i < _length; i++) {
            char c = word.charAt(i);
            if (parent.children[c - 'a'] == null) {
                return false;
            }
            parent = parent.children[c - 'a'];
        }
        return parent.isWord;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        int _length = prefix.length();
        TrieNode parent = root;
        for (int i = 0; i < _length; i++) {
            char c = prefix.charAt(i);
            if (parent.children[c - 'a'] == null) {
                return false;
            }
            parent = parent.children[c - 'a'];
        }
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("hello");
        trie.insert("hell");
        trie.search("helloa");
        trie.search("hello");
        trie.startsWith("hell");
        trie.startsWith("helloa");
        trie.startsWith("hello");

    }
}
