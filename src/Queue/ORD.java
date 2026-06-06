package Queue;


public class ORD {
    int items[], left, right;
    int max = 5;

    public ORD() {
        items = new int[max];
        left = -1;
        right = -1;
    }

    // input restricted dequeue
    public void insertRight(int element) {
        if (right == max - 1) {
            System.out.println("Queue is overflow...");
        } else {
            items[++right] = element;
            System.out.println(element + " :Element inserted");
        }
    }

    public void insertLeft(int element) {
        if (right == max - 1) {
            System.out.println("Queue is overflow...");
        } else {
            for (int i = right + 1; i >= left + 2; i--) {
                items[i] = items[i - 1];
            }
            items[left + 1] = element;
            right++;
            System.out.println(element + " :Element inserted");
        }
    }


    public boolean isEmpty() {
        return left == right;
    }

    public boolean isFull() {
        return right == max - 1;
    }


    public int removeLeft() {
        if (left == right) {
            System.out.println("Queue is underflow...");
            return -1;
        } else {
            return items[++left];
        }
    }

    public void display() {
        if (left == right) {
            System.out.println("Queue is empty...");
        } else {
            for (int i = left + 1; i <= right; i++) {
                System.out.print(items[i] + " ");
            }
        }
    }
}
