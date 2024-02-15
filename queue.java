//FIFO
class learn {
    private int front; //stores the index of the front element in the queue
    private int rear;// stores the index of the rear element in the queue
    private int[] array; //stores the elements of the queue
    private int size; // stores the maximum number of elements that the queue can hold

    
//-------------------------constrctor-----------------------
// initializes the front and rear variables to -1, which indicates an empty queue. 
//It also creates an array with the specified size and assigns it to the array variable.    
    public learn(int size) { 
        front = -1;
        rear = -1;
        this.size = size;
        array = new int[size];
    }

    //isFull() is a method that checks if the queue is full 
    //by comparing the value of the rear variable with the size of the queue minus 1. 
    //If they are equal, it means the queue is full, so it returns true. Otherwise, it returns false.
    public boolean isFull() {
        return (rear == size-1);
    }
    

    //isEmpty() is a method that checks if the queue is empty. 
    //It returns true if the value of the front variable is -1 or greater than the value of the rear variable. 
    //These conditions indicate that the queue is empty. Otherwise, it returns false.
    public boolean isEmpty() {
        return (front == -1 || front > rear);
    }
    
    public void enqueue(int data) {
       //Before adding an element, it checks if the queue is full 
        if(isFull()) {
            System.out.println("Queue is full");
            return;
        }

       //it increments the rear variable by 1
       //assigns the value of the data parameter to the new position in the array, 
       //and if front is -1 , assign 0 to front 
        array[++rear] = data;
        if(front == -1) {
            front = 0;
        }
    }
    
    public int dequeue() {
        if(isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }

    // it retrieves the value of the front element in the queue, increments the front
    // front variable would be incremented to point to the index 1 
        int data = array[front];
        if(front == rear) {
            front = -1;
            rear = -1;
        } else {
            front++;
        }
        return data;
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        for (int i = front; i <= rear; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
    

public static void main(String[] args) {
    
    learn ln = new learn(3);
    ln.enqueue(5);
    ln.enqueue(4);
    ln.enqueue(3);
    ln.print();
    
    
    

}
}
