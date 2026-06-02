import java.util.Scanner;

public class Evaluation {
    int item[],top;
    public Evaluation(){
        item = new int[100];
        top = -1;
    }
    // push ,pop,display
    public void push(int element){
        if(top==99){
            System.out.println("stack is overflow!");
        }else{
            top++;
            item[top] = element;
        }
    }
    public int pop(){
        if(top==-1){
            System.out.println("Stack is underflow!");
            return -1;
        }else{
            return item[top--];
        }
    }
    public void display(){
        System.out.print("[");
        for (int i=0;i<top;i++){
            System.out.print(item[i]);
        }
        System.out.println("]");
    }
    public int peek(){
        return top!=-1?item[top]:-1;
    }
    public static void evaluatePostfixExpression() {
        Scanner sc = new Scanner(System.in);
        Evaluation ev=new Evaluation();
        System.out.print("Enter postfix expression:");
        String inpString=sc.nextLine();
        inpString=inpString+"\n";
        char postfix[]=inpString.toCharArray();
        int i=0;
        while (postfix[i]!='\n'){
            if(postfix[i]!='+' && postfix[i]!='-' && postfix[i]!='*' && postfix[i]!='/' && postfix[i]!='$'){
                ev.push(postfix[i]-48);
            }else {
                char op = postfix[i];
                int b = ev.pop();
                int a = ev.pop();
                push(a, b, op,ev);
            }
            i++;
        }
        System.out.println("Evaluated Value:"+(ev.pop()));


    }

    private static void  push(int a, int b, char op, Evaluation ev) {
      switch (op){
          case '+':
            ev.push(a+b);
            break;
          case '-':
              ev.push(a-b);
              break;
          case '*':
              ev.push(a*b);
              break;
          case '/':
              ev.push(a/b);
              break;
          case '$':
              ev.push((int)Math.pow(a,b));
              break;
          default:
              System.out.println("Invalid operator");
              break;

        }

    }
}
