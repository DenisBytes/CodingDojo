import java.util.ArrayList;
import java.util.Set;

public class Trie {
    public Node root;

    public Trie() {
        this.root = new Node();
    }

    boolean isPrefixValid(String prefix){
        Character currentLetter;
        Node current = this.root;
        int count= 0;

        for(int i = 0; i < prefix.length(); i++) {
            currentLetter = prefix.charAt(i);

            if (current.children.containsKey(currentLetter)){
                count++;
            }

            current = current.children.get(currentLetter);
        }
        if (count == prefix.length()){
            return true;
        }
        else{
            return false;
        }
    }
    boolean isWordValid(String word){
        Character currentLetter;
        Node current = this.root;

        for(int i = 0; i < word.length(); i++) {
            currentLetter = word.charAt(i);
            if (!current.children.containsKey(currentLetter)){
                return false;
            }
            current = current.children.get(currentLetter);
        }

        return current.isCompleteWord;
    }

    // not done
    public void printAllKeys(){
        Node current = this.root;
        Set<Character> keys;
        for (int i=0; i<Node.getCount(); i++){
            keys = current.children.keySet();
            for (Character key : keys){
                System.out.println(key);
                current = current.children.get(key);
            }
        }
    }
    public void insertWord(String word) {
        // gets the root node;
        Node currentNode = this.root;

        // iterates over every character in the word
        for(int i = 0; i < word.length(); i++) {
            // currentLetter is just the character / letter at the iteration
            Character currentLetter = word.charAt(i);
            // ask if the current letter is in the map of the current node
            Node child = currentNode.children.get(currentLetter);
            if(child == null) {
                child = new Node();
                currentNode.children.put(currentLetter, child);
            }

            currentNode = child;
        }
        currentNode.isCompleteWord = true;
    }
}