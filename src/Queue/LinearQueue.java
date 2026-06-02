package Queue;

import java.util.Scanner;

public class LinearQueue {
    int items[],rear,front,max=5;
    public LinearQueue() {
        items = new int[max];
        rear = -1;
        front = -1;
    }
    public void isEmpty(){
          if(front == rear){
              System.out.println("Queue is empty");
          }else{
              System.out.println("Queue is not empty");
          }
    }
    public void isFull(){

        if(rear==max-1){
            System.out.println("Queue is full");
        }else{
            System.out.println("Queue is not full");
        }
    }
    public void insert(int element){
        if(rear==max-1){
            System.out.println("Queue is overflows...");
        }else{
            rear++;
            items[rear] = element;
        }
    }
    public int delete(){
        if(rear==front){
            System.out.println("Queue is underflow...");
        }else{
            return items[++front];
        }
        return -1;
    }
    public void display(){
        System.out.print("[");
        for(int i=front+1;i<=rear;i++){
            System.out.print(items[i]+",");
        }
        System.out.println("]");
    }
    public static  void eventDrivenProgram(){
        LinearQueue queue = new LinearQueue();
        Scanner sc=new Scanner(System.in);
        while (true){
            System.out.println("Enter 1 to insert\n2 to delete\n3 to display\n4 to check if queue is empty\n5 to check if queue is full\n6 to exit");
            int inp = sc.nextInt();
            switch (inp){
                case 1:
                    System.out.print("Enter element:");
                    int input = sc.nextInt();
                    queue.insert(input);
                    break;
                case 2:
                    int delete = queue.delete();
                    if(delete != -1) {
                        System.out.println(delete + " removed");
                    }
                    break;
                case 3:
                    queue.display();
                    break;
                case 4:
                    queue.isEmpty();
                    break;
                case 5:
                    queue.isFull();
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid input");
                    break;

            }
        }
    }
}
