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
}


const SLL1 = new SLL();

console.log(SLL1.addFront(18)); 
console.log(SLL1.addFront(5));  
console.log(SLL1.addFront(73));

console.log(SLL1.removeFront()); 
console.log(SLL1.removeFront());

console.log(SLL1.front()); 
console.log(SLL1.removeFront()); 
console.log(SLL1.front()); 