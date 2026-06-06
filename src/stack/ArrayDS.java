package stack;

import java.util.Scanner;

public class ArrayDS {
    private int[] items;
    private int size;

    // methods
    public ArrayDS() {
        items = new int[10];
        size = -1;
    }

    public void insert(int item) {
        if (size == items.length - 1) {
            System.out.println("Array is full");
        } else {
            items[++size] = item;
            System.out.println("size : " + size);

        }
    }

    public void display() {
        if (size != -1) {
            System.out.print("[");
            for (int i = 0; i <= size; i++) {
                System.out.print(items[i] + " ");
            }
            System.out.println("]");
        } else {
            System.out.println("Array is empty");
        }
    }

    public void delete(int element) {
        // find first occurrence of element and left shift all elements
        // first occurrence of element
        if (size >= 0) {
            int index = -1;
            for (int i = 0; i <= size; i++) {
                if (items[i] == element) {
                    index = i;
                    break;
                }
            }
            // left shift all element from index+1 to size-1
            if (index != -1) {
                for (int i = index; i < size; i++) {
                    items[i] = items[i + 1];
                }
                size--;
            } else {
                System.out.println("Element not found : " + element);
            }
        } else {
            System.out.println("Array is empty");
        }

    }

    public void reverseDisplay() {
        if (size != -1) {
            System.out.print("[");
            for (int i = size; i >= 0; i--) {

                System.out.print(items[i] + " ");
            }
            System.out.println("]");
        } else {
            System.out.println("Array is empty");
        }

    }

    // event driven program
    public static void eventDrivenProgram() {
        Scanner sc = new Scanner(System.in);
        ArrayDS arrayDS = new ArrayDS();
        while (true) {
            System.out.println("1. Insert\n2. Display\n3. Reverse Display\n4. Delete\n5. Exit");

            int input = sc.nextInt();
            switch (input) {
                case 1:
                    System.out.println("Enter element");
                    int inpVal = sc.nextInt();
                    arrayDS.insert(inpVal);
                    break;
                case 2:
                    arrayDS.display();
                    break;
                case 3:
                    arrayDS.reverseDisplay();
                    break;
                case 4:
                    System.out.println("Enter element to delete");
                    int delElement = sc.nextInt();
                    arrayDS.delete(delElement);
                    break;
                case 5:
                    System.exit(0);

                default:
                    System.out.println("Invalid input");

            }
        }
    }
}
