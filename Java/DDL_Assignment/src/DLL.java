import java.util.ArrayList;

public class DLL {
    public Node head;
    public Node tail;

    public DLL() {
        this.head = null;
        this.tail = null;
    }

    // the push method will add a new node to the end of the list
    public void push(Node newNode) {
        // if there is no head in the list, aka, an empty list, we set the newNode to be the head and tail of the list
        if(this.head == null) {
            this.head = newNode;
            this.tail = newNode;
            return;
        }

        // first find the lastNode in the list
        // then, set the lastNode's next to be the newNode;
        // then, we have to set the previous of the lastNode to the lastNode that we found previously.
        // finally, set the list's tail to be the node that we have added
        Node lastNode = this.tail;
        lastNode.next = newNode;
        newNode.previous = lastNode;
        this.tail = newNode;
    }

    public void printValuesForward() {
        // find the first node, aka head.
        Node current = this.head;

        // while the current node exists...
        while(current != null) {
            // print its value
            System.out.println(current.value);
            // and move on to its next node.
            current = current.next;
        }
    }

    public void printValuesBackward(){
        Node current = this.tail;

        while (current!= null){
            System.out.println(current.value);
            current = current.previous;
        }
    }

    public Node pop(){
        Node preLastNode = this.tail.previous;
        Node popped = preLastNode.next;
        preLastNode.next = null;

        return popped;
    }

    public boolean contains(Integer value){
        Node current = this.head;
        boolean bool = false;

        while(current != null) {
            if (current.value.equals(value)){
                bool = true;
                break;
            }
            else {
                bool =  false;
            }
            current = current.next;
        }
        return bool;
    }

    public int size(){
        int count = 0;
        Node current = this.head;

        while (current != null){
            count++;
            current = current.next;
        }

        return count;
    }

    public void insertAt(Node newNode, int index){
        if(this.head == null) {
            this.head = newNode;
            this.tail = newNode;
            return;
        }


    }
}
