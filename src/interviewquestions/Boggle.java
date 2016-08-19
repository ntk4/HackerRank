package interviewquestions;

import java.util.Arrays;

/**
 * See the problem and another solution at: http://www.geeksforgeeks.org/boggle-find-possible-words-board-characters/
 * 
 * @author tsatsni
 *
 */
public class Boggle {

    public final String[] dictionary = { "GEEKS", "FOR", "QUIZ", "GO" };
    public final char[][] boggle   = {{'G','I','Z'},
            {'U','E','K'},
            {'Q','S','E'}};
    
    private static class TrieNode {
        public char c;
        public TrieNode[] children;
        public TrieNode(char c) {
            this.c = c;
        }
    }
    
    private TrieNode newNode(char c) {
        return new TrieNode(c);
    }
    
    public TrieNode makeTrie(String[] dictionary) {
        //Arrays.sort(dictionary);
        TrieNode root = newNode('\0');
        for (String word: dictionary) {
//          for ()  
        }
        return root;
    }
    
    public static void main(String[] args) {
        Boggle boggle = new Boggle();
        TrieNode trieRoot = boggle.makeTrie(boggle.dictionary);
    }
    
    

}
