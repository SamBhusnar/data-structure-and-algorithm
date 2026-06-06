package LinkedList;

import java.util.Scanner;

class Node {
    public int info;
    public Node next;
    public Node prev;
}

public class DoublyLinearLinkedList {
    public static Node list;

    public void ins_beginning(int info) { // only intended to insert element at the beginning of linked list
        Node p, q;
        p = list;
        if (p == null) {
            // create new node
            p = new Node();
            p.info = info;
            p.next = null;
            p.prev = null;
            list = p;
        } else {
            // if node already exists then put newly created node at the beginning of list
            q = new Node();
            q.info = info;
            q.next = p;
            q.prev = null;
            p.prev = q;
            list = q;
        }
    }

    public void ins_end(int info) {
        Node p, q;
        p = list;
        if (p == null) { // if list is empty
            p = new Node();
            p.info = info;
            p.next = null;
            p.prev = null;
            list = p;
        } else {
            while (p.next != null) {
                p = p.next;
            }
            q = new Node();
            q.info = info;
            q.next = null;
            q.prev = p;
            p.next = q;
        }
    }


    public void ins_between(int info, int after) {
        Node p, q;
        p = list;
        if (p == null || (p.next == null && p.prev == null)) {
            System.out.println("Insert between not possible");
        } else {
            // This method only intended to insert element between two nodes
            while (p.next != null) {
                if (p.info == after) {
                    q = new Node();
                    q.info = info;
                    q.next = p.next;
                    q.prev = p;
                    p.next.prev = q;
                    p.next = q;
                    break;
                }
                p = p.next;
            }

        }
    }

    public int rem_beginning() {

        Node p, q;
        p = list;
        if (p == null) {
            System.out.println("List is empty");
            return -1;
        } else if (p.next == null && p.prev == null) {
            list = null;
            return p.info;
        } else {
            q = p.next;
            q.prev = null;
            list = q;
            return p.info;
        }


    }

    public int rem_end() {

        int n;
        Node p, temp;
        p = list;
        if (p == null) {
            System.out.println("list is empty");
            return -1;
        } else if (p.next == null && p.prev == null) {
            list = null;
            return p.info;
        } else {
            while (p.next.next != null) { // traverse to second last node
                p = p.next;
            }
            temp = p.next;
            p.next = null;
            return temp.info;
        }

    }

    public int rem_between(int after) {
        // this method only intended to remove element between two nodes
        // if you try to remove last element using this method then it produce null pointer exception
        Node p, temp;
        p = list;
        if (p == null) {
            System.out.println("list is empty");
            return -1;
        } else if ((p.next == null && p.prev == null) || (p.next.next == null && p.prev == null)) {
            System.out.println("Remove between not possible");
            return -1;
        } else {
            while (p.next != null) {
                if (p.info == after) {
                    temp = p.next;
                    p.next = temp.next;
                    p.next.prev = p;
                    return temp.info;
                }
                p = p.next;
            }
            return -1;
        }
    }

    public void search(int srch) {
        Node p;
        p = list;
        int t=0;

        while (p != null) {
            if (p.info == srch) {
                t=1;
                break;
            }
            p = p.next;
        }
        if(t==1){
            System.out.println("Node is found");
        }else{
            System.out.println("Node is not found");
        }
    }

    public void count() {
        int cnt = 0;
        Node p;
        p = list;
        while (p != null) {
            cnt++;
            p = p.next;
        }
        System.out.println("Total number of nodes in linked list : " + cnt);

    }

    public void display() {
        Node p;
        p = list;
        if (p == null) {
            System.out.println("list is empty");
        } else {
            System.out.print("[");
            while (p != null) {
                System.out.print(p.info + ", ");
                p = p.next;
            }
            System.out.println("]");
        }
    }

    public void reverse() {
        Node t1, t2 = null, t3 = null;
        t1 = list;
        while (t1 != null) {
            t2 = t1.next;
            t1.next = t3;
            t1.prev = t2;
            t3 = t1;
            t1 = t2;
        }
        list = t3;
        System.out.println("Linked list is reversed");

    }



    public static void eventDrivenProgram() {
        Scanner sc = new Scanner(System.in);
        DoublyLinearLinkedList list = new DoublyLinearLinkedList();
        while (true) {
            System.out.println("\n1.Insert at beginning\n2.Insert at end\n3.Insert between\n4.Remove from beginning\n5.Remove from end\n6.Remove between\n7.Search\n8.Count\n9.Reverse\n10.Display\n11.Exit");
            int inp = sc.nextInt();
            switch (inp) {
                case 1:
                    System.out.println("Enter the value to insert");
                    int value = sc.nextInt();
                    list.ins_beginning(value);
                    break;
                case 2:
                    System.out.println("Enter the value to insert");
                    int value1 = sc.nextInt();
                    list.ins_end(value1);
                    break;
                case 3:
                    System.out.println("Enter the value to insert");
                    int value2 = sc.nextInt();
                    System.out.println("Enter the value after which to insert");
                    int after = sc.nextInt();
                    list.ins_between(value2, after);
                    break;
                case 4:
                    int i = list.rem_beginning();
                    if (i != -1) {
                        System.out.println("Removed value:" + i);
                    }
                    break;
                case 5:
                    int j = list.rem_end();
                    if (j != -1) {
                        System.out.println("Removed value:" + j);
                    }
                    break;
                case 6:
                    System.out.println("Enter value of after ");
                    int after1 = sc.nextInt();

                    int i1 = list.rem_between(after1);
                    if (i1 != -1) {
                        System.out.println("Removed value:" + i1);
                    }
                    break;
                case 7:
                    System.out.println("Enter value to search");
                    int src = sc.nextInt();
                    list.search(src);
                    break;
                case 8:
                    list.count();
                    break;
                case 9:
                    list.reverse();
                    break;
                case 10:
                    list.display();
                    break;
                case 11:
                    System.exit(0);
                default:
                    System.out.println("Invalid input");

            }
        }
    }









}
