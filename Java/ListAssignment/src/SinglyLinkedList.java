import java.util.Objects;

public class SinglyLinkedList {
    public Node head;
    public SinglyLinkedList() {
        this.head = null;
    }
    // SLL methods go here. As a starter, we will show you how to add a node to the list.
    public void remove(){
        Node runner  = head;
         if(head == null){
             return;
         }
         else if (runner.next == null){
             runner = null;
         }
         else{
             while(runner.next.next != null){
                 runner = runner.next;
             }
             runner.next = null;
         }
    }

    public void printValues(){
        Node runner = head;

        System.out.format("Value: %s ----  Next: %s\n",runner.value,runner.next);

        while (runner.next != null){
            runner = runner.next;
            System.out.format("Value: %s ----  Next: %s\n",runner.value,runner.next);
        }
    }

    public void find(int value){
        Node runner = head;

        while (runner.next != null){
            if (runner.value == value ){
                System.out.format("Value: %s ----  Next: %s",runner.value,runner.next);
            }
            runner = runner.next;
        }
    }

    public void removeAt(int value){
        Node runner = head;

        while(runner.next.next != null){
            if(runner.next.value == value){
                runner.next = null;
            }
            else{
                runner = runner.next;
            }
        }
    }

    public void add(int value) {
        Node newNode = new Node(value);
        if(head == null) {
            head = newNode;
        } else {
            Node runner = head;
            while(runner.next != null) {
                runner = runner.next;
            }
            runner.next = newNode;
        }
    }
}