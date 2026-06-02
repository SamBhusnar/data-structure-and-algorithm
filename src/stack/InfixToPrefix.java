package stack;

import java.util.Scanner;

public class InfixToPrefix {
    int item[],top;
    public InfixToPrefix(){
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
    public static void infixToPrefix() {
        Scanner sc = new Scanner(System.in);
        // opsStack,oprndStack
        InfixToPrefix opsStack = new InfixToPrefix();
        InfixToPrefix oprndStack = new InfixToPrefix();
        String infixArray= sc.nextLine();
        infixArray="\n"+infixArray.trim();
        System.out.println("infixArray:"+infixArray);
        String reverseInfixArray="";
        for(int i=infixArray.length()-1;i>=0;i--){
            reverseInfixArray+=infixArray.charAt(i);
        }
        String prefix="";
        char []infix= reverseInfixArray.toCharArray();
        int i=0;
        while (infix[i]!='\n'){
            if(infix[i]==')' || infix[i]=='+' || infix[i]=='-' || infix[i]=='*' || infix[i]=='/' || infix[i]=='$')
            {
                opsStack.push(infix[i]);
            }else if(infix[i]=='('){
                while(opsStack.top!=-1){
                    int popped = opsStack.pop();
                    if(popped!=')'){
                        oprndStack.push(popped);
                    }
                }
            }else{
                oprndStack.push(infix[i]);
            }
            i++;
        }
        if(opsStack.top!=-1){
            while(opsStack.top!=-1){
                int popped = opsStack.pop();
                if(popped!=')') {
                    oprndStack.push(popped);
                }
            }
        }

        if(oprndStack.top!=-1){
            while(oprndStack.top!=-1){
                prefix+=(char)oprndStack.pop();
            }
        }

        System.out.println("Infix :"+infixArray);
        System.out.println("Prefix :"+prefix);

    }
}
