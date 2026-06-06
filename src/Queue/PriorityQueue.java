package Queue;

public class PriorityQueue {
    int items[], priority[], rear, front, max = 5;

    public PriorityQueue() {
        items = new int[max];
        priority = new int[max];
        rear = -1;
        front = -1;
    }

    public boolean isFull() {
        return rear == max - 1;
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public void insert(int element, int priority) {
        if (isFull()) {
            System.out.println("Queue is overflow...");
        } else {
            ++rear;
            items[rear] = element;
            this.priority[rear] = priority;
            System.out.println(element + " :Element inserted");
        }
    }

    public void remove() {
        if (isEmpty()) {
            System.out.println("Queue is underflow...");
        } else {
            int pos = 0;
            int m = priority[0];
            for (int i = 0; i <= rear; i++) {
                if (m < priority[i]) {
                    m = priority[i];
                    pos = i;
                }
            }
            int removedElement = items[pos];
            for (int i = pos; i < rear; i++) {
                priority[i] = priority[i + 1];
                items[i] = items[i + 1];
            }
            --rear;
            System.out.println(removedElement + " :Element removed");
        }
    }

    public void display() {
        System.out.print("priority : [");
        for (int i = front + 1; i <= rear; i++) {
            System.out.print(priority[i] + ",");
        }
        System.out.println("]");
        System.out.print("items : [");
        for (int i = front + 1; i <= rear; i++) {
            System.out.print(items[i] + ",");
        }
        System.out.println("]");
    }
}
