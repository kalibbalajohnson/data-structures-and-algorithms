//the Node class is a basic implementation of a singly linked list node.
// It has two instance variables: data to store the value of the node, 
//and next to store the reference to the next node in the list.
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

//The learn2 class is a basic implementation of a queue using a singly linked list
// It has two instance variables: front and rear to keep track of the front and rear nodes of the queue
public class learn2 {
    Node front;
    Node rear;

    // Initialize an empty queue
    public learn2() {
        this.front = this.rear = null;
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return (this.front == null);
    }

    // takes an integer 'data' as input and creates a new node using that data
    // If the queue is empty (rear is null), the new node is set as both the front and rear of the queue
    //Otherwise, the new node is added to the rear of the queue
    public void enqueue(int data) {
        Node newNode = new Node(data);
        if (this.rear == null) {
            this.front = this.rear = newNode;
            return;
        }
        this.rear.next = newNode;
        this.rear = newNode;
    }

    // it removes the front node and return the data of it
    // And it move front to the next front, if it's the last element rear will be null
    public int dequeue() {
        //returns true if empty
        if (this.isEmpty()) {
            System.out.println("Queue is empty");
            return Integer.MIN_VALUE; // if queue is empty,returns Integer.MIN_VALUE to indicate that the dequeue operation failed.
        }
        Node temp = this.front;// if queue is not empty, it saves a reference to the front node of the queue in a temporary variable.
        this.front = temp.next;// moves the front of the queue to the next element in the list.
        if (this.front == null) {
            this.rear = null;
        }
        return temp.data; //returns the data of the front node of the queue which was removed, this is the value that was dequeued
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        Node temp = this.front;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    

    public static void main(String[] args) {
        learn2 ln2 = new learn2();  
        ln2.enqueue(5);
        ln2.enqueue(4);
        ln2.print();
        
    


    }
}
