package Queue;

import java.util.Scanner;

public class CircularQueue {
    int items[],front,rear;
    int max=10;
    public CircularQueue(){
        items = new int[max];
        front = -1;
        rear = -1;
    }
    // isEmpty condition front is -1
    public boolean isEmpty(){
        return front == -1;
    }
    // isFull condition rear is at max-1
    public boolean isFull(){
        if((front==0 && rear==max-1)||(front==rear+1)){
            return  true;
        }
        return  false;
    }
    public void insert(int element){
        if((front==0 && rear==max-1)||(front==rear+1)){
            System.out.println("Queue is overflow");
        }else{
            if(front==-1){
                rear=front=0;
            }else{
                rear=(rear+1)%max;
            }
            items[rear] = element;
            System.out.println(element+"Element inserted successfully");

        }
    }
    public void delete(){
        if(front==-1){
            System.out.println("Queue is underflow...");
        }else{
            int deleted = items[front];
            if(rear==front){
                front=rear=-1;
            }else {
                front = (front + 1) % max;
            }
            System.out.println(deleted+":Element deleted successfully");
        }
    }
    public void display(){
        System.out.print("[");
        for(int i=front;i!=rear;i=(i+1)%max){
            System.out.print(items[i]+", ");
        }
        if(rear!=-1) {
            System.out.print(items[rear]);
        }
        System.out.println("]");
    }

    public static void eventDrivenProgram(){
        CircularQueue queue = new CircularQueue();
        Scanner sc=new Scanner(System.in);
        while(true){
            System.out.println("Press 1 to insert\n2 to delete\n3 to display\n4 to check if queue is empty\n5 to check if queue is full\n6 to exit");
            int inp=sc.nextInt();
            switch (inp){
                case 1:
                    System.out.print("Enter element:");
                    int input=sc.nextInt();
                    queue.insert(input);
                    break;
                case 2:
                    queue.delete();
                    break;
                case 3:
                    queue.display();
                    break;
                case 4:
                    System.out.println("Queue is empty or not : "+queue.isEmpty());
                    break;
                case 5:
                    System.out.println("Queue is full or not : "+queue.isFull());
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
