package interviewquestions;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * See the problem and another solution at: http://www.geeksforgeeks.org/boggle-find-possible-words-board-characters/
 * 
 * @author tsatsni
 * 
 */
public class Boggle {

    public final String[] dictionary = { "GEEKS", "FOR", "QUIZ", "GO" };
    public final char[][] boggle = { { 'G', 'I', 'Z' }, { 'U', 'E', 'K' }, { 'Q', 'S', 'E' } };

    private static class TrieNode {
        public char c;
        public List<TrieNode> children;

        public TrieNode(char c) {
            this.c = c;
            children = new LinkedList<TrieNode>();
        }
    }

    private class Coordinate {
        public int i;
        public int j;

        public Coordinate(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public int hashCode() {
            return i + j * 31;
        }
    }

    private TrieNode newNode(char c) {
        return new TrieNode(c);
    }

    public TrieNode makeTrie(String[] dictionary) {
        // Arrays.sort(dictionary);
        TrieNode root = newNode('\0');
        TrieNode currentNode = null;
        for (String word : dictionary) {
            currentNode = null;
            for (int i = 0; i < word.length(); i++) {
                currentNode = storeCharInTrie(word.charAt(i), currentNode != null ? currentNode : root);
            }
        }
        return root;
    }

    private TrieNode storeCharInTrie(char c, TrieNode root) {
        for (TrieNode child : root.children) {
            if (child.c == c) {
                return child;
            }
        }
        TrieNode newNode = newNode(c);
        root.children.add(newNode);
        return newNode;
    }

    public static void main(String[] args) {
        Boggle b = new Boggle();

        // Step 1: prepare the Trie structure for efficient access to the dictionary
        TrieNode trieRoot = b.makeTrie(b.dictionary);

        // Step 2: solve the boggle using the dictionary
        b.solveBoggle(trieRoot, b.boggle);
    }

    private void solveBoggle(TrieNode trieRoot, char[][] boggle) {
        if (trieRoot == null || trieRoot.children == null || trieRoot.children.isEmpty())
            return;

        Set<String> foundWords = new HashSet<String>();

        Set<Coordinate> coordinates = new HashSet<Coordinate>();
        for (int i = 0; i < boggle.length; i++) {
            for (int j = 0; j < boggle[0].length; j++) {
                for (TrieNode firstLetter : trieRoot.children) {
                    if (firstLetter.c == boggle[i][j]) {
                        solveBoggle(foundWords, "", firstLetter, coordinates, new Coordinate(i, j));
                    }

                }

            }
        }

        for (String word : foundWords)
            System.out.println(word);
    }

    private void solveBoggle(Set<String> foundWords, String runningWord, TrieNode firstLetter,
            Set<Coordinate> coordinates, Coordinate ij) {
        if (ij.i < 0 || ij.j < 0 || ij.i >= boggle.length || ij.j >= boggle[0].length || coordinates.contains(ij)) {
            return;
        }

        if (firstLetter.children == null || firstLetter.children.isEmpty() && boggle[ij.i][ij.j] == firstLetter.c) {
            foundWords.add(runningWord + String.valueOf(firstLetter.c));
            coordinates.clear();
            return;
        }

        for (TrieNode nextLetter : firstLetter.children) {
            solveBoggle(foundWords, runningWord + String.valueOf(firstLetter.c), nextLetter, coordinates,
                    new Coordinate(ij.i, ij.j - 1));
            solveBoggle(foundWords, runningWord + String.valueOf(firstLetter.c), nextLetter, coordinates,
                    new Coordinate(ij.i, ij.j + 1));
            solveBoggle(foundWords, runningWord + String.valueOf(firstLetter.c), nextLetter, coordinates,
                    new Coordinate(ij.i + 1, ij.j + 1));
            solveBoggle(foundWords, runningWord + String.valueOf(firstLetter.c), nextLetter, coordinates,
                    new Coordinate(ij.i + 1, ij.j));
            solveBoggle(foundWords, runningWord + String.valueOf(firstLetter.c), nextLetter, coordinates,
                    new Coordinate(ij.i - 1, ij.j));
            solveBoggle(foundWords, runningWord + String.valueOf(firstLetter.c), nextLetter, coordinates,
                    new Coordinate(ij.i - 1, ij.j - 1));
            solveBoggle(foundWords, runningWord + String.valueOf(firstLetter.c), nextLetter, coordinates,
                    new Coordinate(ij.i + 1, ij.j - 1));
            solveBoggle(foundWords, runningWord + String.valueOf(firstLetter.c), nextLetter, coordinates,
                    new Coordinate(ij.i - 1, ij.j + 1));
        }
    }

}
