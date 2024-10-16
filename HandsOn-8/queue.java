public class Queue {
    private static final int QUEUE_SIZE = 100;
    private int[] data;
    private int head;
    private int tail;
    private int length;

    public Queue() {
        data = new int[QUEUE_SIZE];
        head = 0;
        tail = 0;
        length = QUEUE_SIZE;
    }

    // Enqueue an element into the queue
    public void enqueue(int x) {
        data[tail] = x;
        if (tail == length - 1) {
            tail = 0;
        } else {
            tail++;
        }
    }

    // Dequeue an element from the queue
    public int dequeue() {
        int x = data[head];
        if (head == length - 1) {
            head = 0;
        } else {
            head++;
        }
        return x;
    }

    public static void main(String[] args) {
        Queue queue = new Queue();
        
        queue.enqueue(15);
        queue.enqueue(25);
        queue.enqueue(35);

        System.out.println("Dequeued element: " + queue.dequeue());
        System.out.println("Dequeued element: " + queue.dequeue());
        System.out.println("Dequeued element: " + queue.dequeue());
    }
}

/*
Output :
Dequeued element: 15
Dequeued element: 25
Dequeued element: 35

*/
