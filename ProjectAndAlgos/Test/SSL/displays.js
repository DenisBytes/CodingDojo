class Node {
    constructor(data) {
        this.data = data;
        this.next = null;
    }
}

class SLL {
    constructor() {
        this.head = null;
    }

    addFront(value) {
        const newNode = new Node(value);
        newNode.next = this.head;
        this.head = newNode;
        return newNode;
    }

    removeFront() {
        if (!this.head) {
            return null;
        }

        const removedNode = this.head;
        this.head = this.head.next;
        return removedNode;
    }

    front() {
        return this.head ? this.head.data : null;
    }

    display() {
        let current = this.head;
        let result = "";

        while (current) {
            result += current.data + (current.next ? ", " : "");
            current = current.next;
        }

        return result;
    }
}


const SLL1 = new SLL();

SLL1.addFront(76);
SLL1.addFront(2);
console.log(SLL1.display()); 

SLL1.addFront(11.41);
console.log(SLL1.display()); 