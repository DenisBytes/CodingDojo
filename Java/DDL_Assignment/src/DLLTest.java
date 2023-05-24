public class DLLTest {
    public static void main(String[] args) {
        DLL dll = new DLL();
        Node n1 = new Node(100);
        Node n2 = new Node(20);
        Node n3 = new Node(50);
        Node n4 = new Node(60);
        Node n5 = new Node(50);
        Node n6 = new Node(20);
        Node n7 = new Node(100);

        dll.push(n1);
        dll.push(n2);
        dll.push(n3);
        dll.push(n4);
        dll.push(n5);
        dll.push(n6);
        dll.push(n7);

        //dll.printValuesForward();
        //dll.printValuesBackward();
        //System.out.println(dll.pop().value);
        //System.out.println("-------------");
        //dll.printValuesForward();
        //System.out.println(dll.contains(50));
        //System.out.println(dll.size());

        System.out.println(dll.isPalindrome());
    }
}