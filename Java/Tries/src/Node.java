import java.util.HashMap;
public class Node {
    public HashMap<Character, Node> children;
    public boolean isCompleteWord;
    static int count = 0;

    public Node() {
        this.children = new HashMap<Character, Node>();
        this.isCompleteWord = false;
        count ++;
    }

    public static int getCount() {
        return count;
    }
}