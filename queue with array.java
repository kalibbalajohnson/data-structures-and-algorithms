class queue {
    private int front;
    private int rear;
    private int[] array;
    private int size;
    
    public Queue(int size) {
        front = -1;
        rear = -1;
        this.size = size;
        array = new int[size];
    }
    
    public boolean isFull() {
        return (rear == size-1);
    }
    
    public boolean isEmpty() {
        return (front == -1 || front > rear);
    }
    
    public void enqueue(int data) {
        if(isFull()) {
            System.out.println("Queue is full");
            return;
        }
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
        int data = array[front];
        if(front == rear) {
            front = -1;
            rear = -1;
        } else {
            front++;
        }
        return data;
    }
}
