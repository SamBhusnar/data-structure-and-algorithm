import java.util.Scanner;

public class StackLocal {
    int item[],top;
    int max=5;
    public StackLocal(){
        item = new int[max];
        top = -1;
    }
    // stack operations , push, pop, display
    public void push(int element){
        if(top==max-1){
            System.out.println("Stack is overflow");
        }else{
            top++;
            item[top] = element;
        }
    }
    public void pop(){
        if(top == -1){
            System.out.println("Stack is underflow");
        }else{
            System.out.println(item[top--]+" removed");
        }
    }
    public void display(){
        System.out.print("[");
        for(int i=0; i<=top; i++){
            System.out.print(item[i]+", ");
        }
        System.out.println("]");
    }
    public void isFull(){
        if(top==max-1){
            System.out.println("Stack is full");
        }else{
            System.out.println("Stack is not full");
        }
    }
    public void isEmpty(){
        if(top == -1){
            System.out.println("Stack is empty");
        }else{
            System.out.println("Stack is not empty");
        }
    }
    public static void eventDrivenProgram(){

        StackLocal stack=new StackLocal();
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("press 1 to push\n2 to pop\n3 to display\n4 to isFull\n5 to isEmpty\n6 to exit");
            int input = sc.nextInt();
            switch (input){
                case 1:
                    System.out.print("Enter element :");
                    int inp=sc.nextInt();
                    stack.push(inp);
                    break;
                case 2:
                    stack.pop();
                    break;
                case 3:
                    stack.display();
                    break;
                case 4:
                    stack.isFull();
                    break;
                case 5:
                    stack.isEmpty();
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid input");

            }
        }
    }

}
