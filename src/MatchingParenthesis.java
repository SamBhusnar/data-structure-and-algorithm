import java.util.Scanner;

public class MatchingParenthesis {
    int item[],top;
    public MatchingParenthesis(){
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

    public static void checkExpressionIsValid() {
        Scanner sc = new Scanner(System.in);
        MatchingParenthesis mt=new MatchingParenthesis();
        System.out.print("Enter infix expression:");
        String inpString=sc.nextLine();
        inpString=inpString+"\n";
        char infix[]=inpString.toCharArray();
        int i=0;
        int t=0;
        while(infix[i]!='\n'){
            if(infix[i]=='(' || infix[i]=='{'|| infix[i]=='['){
                mt.push(infix[i]);
            }else if(infix[i]==')' || infix[i]=='}' || infix[i]==']'){
                    if(mt.top==-1){
                        t=1;
                        break;
                    }
                    char ch=(char)mt.pop();
                if(((ch=='(')!=(infix[i]==')'))||((ch=='[')!=(infix[i]==']'))||((ch=='{')!=(infix[i]=='}'))){
                    t=1;
                    break;
                }
            }
            i++;
        }

        if(mt.top!=-1 || t==1){
            System.out.println("Invalid Expression");
        }else{
            System.out.println("Valid Expression");
        }
    }
}
