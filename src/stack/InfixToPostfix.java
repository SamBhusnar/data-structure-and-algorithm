package stack;

import java.util.Scanner;

public class InfixToPostfix {
    int item[],top;
    public InfixToPostfix(){
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
    public static void infixToPostfix(){
        Scanner sc = new Scanner(System.in);
        InfixToPostfix infixToPostfix = new InfixToPostfix();
        String postfix = "";
        System.out.print("Enter Infix Expression:");
        String inpString = sc.nextLine();
        inpString = inpString.trim()+"\n";
        char []infix=inpString.toCharArray();
        int i=0;
        while(infix[i]!='\n'){
            if(infix[i]=='(' || infix[i]=='{'||infix[i]=='[' || infix[i]=='+'||infix[i]=='-'||infix[i]=='*'||infix[i]=='/'||infix[i]=='$') {
                infixToPostfix.push(infix[i]);

            }else if(infix[i]==')'||infix[i]=='}'|| infix[i]==']'){
                char popped = (char)infixToPostfix.pop();

                while (popped != '(' && popped != '{' && popped != '[')
                {
                    postfix+=popped;
                    popped = (char)infixToPostfix.pop();

                }

            }else{
                postfix += infix[i];
            }
            i++;
        }


        // check stack is empty or not
        while(infixToPostfix.top != -1){
            char poppedChar = (char)infixToPostfix.pop();
            if(poppedChar!='('&&poppedChar!='{'&&poppedChar!='['){
                postfix+=poppedChar;
            }
        }

        System.out.println("Infix :"+infix);
        System.out.println("Postfix:"+postfix);

    }
}
//************************************************************8


/**
 *
 * import java.util.Scanner;
 *
 * public class InfixToPostfix {
 *
 *     private char[] stack;
 *     private int top;
 *
 *     public InfixToPostfix() {
 *         stack = new char[100];
 *         top = -1;
 *     }
 *
 *     // Push
 *     public void push(char ch) {
 *         if (top == stack.length - 1) {
 *             System.out.println("Stack Overflow");
 *         } else {
 *             stack[++top] = ch;
 *         }
 *     }
 *
 *     // Pop
 *     public char pop() {
 *         if (top == -1) {
 *             return '\0';
 *         }
 *         return stack[top--];
 *     }
 *
 *     // Peek
 *     public char peek() {
 *         if (top == -1) {
 *             return '\0';
 *         }
 *         return stack[top];
 *     }
 *
 *     // Is Empty
 *     public boolean isEmpty() {
 *         return top == -1;
 *     }
 *
 *     // Precedence of operators
 *     public static int precedence(char ch) {
 *         switch (ch) {
 *             case '^':
 *                 return 3;
 *
 *             case '*':
 *             case '/':
 *             case '%':
 *                 return 2;
 *
 *             case '+':
 *             case '-':
 *                 return 1;
 *
 *             default:
 *                 return -1;
 *         }
 *     }
 *
 *     public static String convert(String infix) {
 *
 *         InfixToPostfix st = new InfixToPostfix();
 *
 *         StringBuilder postfix = new StringBuilder();
 *
 *         for (int i = 0; i < infix.length(); i++) {
 *
 *             char ch = infix.charAt(i);
 *
 *             // Ignore spaces
 *             if (ch == ' ') {
 *                 continue;
 *             }
 *
 *             // Operand
 *             if (Character.isLetterOrDigit(ch)) {
 *                 postfix.append(ch);
 *             }
 *
 *             // Opening bracket
 *             else if (ch == '(') {
 *                 st.push(ch);
 *             }
 *
 *             // Closing bracket
 *             else if (ch == ')') {
 *
 *                 while (!st.isEmpty() && st.peek() != '(') {
 *                     postfix.append(st.pop());
 *                 }
 *
 *                 if (!st.isEmpty() && st.peek() == '(') {
 *                     st.pop();
 *                 }
 *             }
 *
 *             // Operator
 *             else {
 *
 *                 while (!st.isEmpty()
 *                         && st.peek() != '('
 *                         && precedence(st.peek()) >= precedence(ch)) {
 *
 *                     postfix.append(st.pop());
 *                 }
 *
 *                 st.push(ch);
 *             }
 *         }
 *
 *         // Pop remaining operators
 *         while (!st.isEmpty()) {
 *             postfix.append(st.pop());
 *         }
 *
 *         return postfix.toString();
 *     }
 *
 *     public static void main(String[] args) {
 *
 *         Scanner sc = new Scanner(System.in);
 *
 *         System.out.print("Enter Infix Expression: ");
 *         String infix = sc.nextLine();
 *
 *         String postfix = convert(infix);
 *
 *         System.out.println("Infix  : " + infix);
 *         System.out.println("Postfix: " + postfix);
 *
 *         sc.close();
 *     }
 * }
 *
 *
 *
 */