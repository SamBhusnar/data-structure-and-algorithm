package stack;

import java.util.Scanner;

public class InfixToPostfix {
    int item[], top;

    public InfixToPostfix() {
        item = new int[100];
        top = -1;
    }

    // push ,pop,display
    public void push(int element) {
        if (top == 99) {
            System.out.println("stack is overflow!");
        } else {
            top++;
            item[top] = element;
        }
    }

    public int pop() {
        if (top == -1) {
            System.out.println("Stack is underflow!");
            return -1;
        } else {
            return item[top--];
        }
    }

    public void display() {
        System.out.print("[");
        for (int i = 0; i < top; i++) {
            System.out.print(item[i]);
        }
        System.out.println("]");
    }

    public static void infixToPostfix() {
        Scanner sc = new Scanner(System.in);
        InfixToPostfix infixToPostfix = new InfixToPostfix();
        String postfix = "";
        System.out.print("Enter Infix Expression:");
        String inpString = sc.nextLine();
        inpString = inpString.trim() + "\n";
        char[] infix = inpString.toCharArray();
        int i = 0;
        while (infix[i] != '\n') {
            if (infix[i] == '(' || infix[i] == '{' || infix[i] == '[' || infix[i] == '+' || infix[i] == '-' || infix[i] == '*' || infix[i] == '/' || infix[i] == '$') {
                infixToPostfix.push(infix[i]);

            } else if (infix[i] == ')' || infix[i] == '}' || infix[i] == ']') {
                char popped = (char) infixToPostfix.pop();

                while (popped != '(' && popped != '{' && popped != '[') {
                    postfix += popped;
                    popped = (char) infixToPostfix.pop();

                }

            } else {
                postfix += infix[i];
            }
            i++;
        }


        // check stack is empty or not
        while (infixToPostfix.top != -1) {
            char poppedChar = (char) infixToPostfix.pop();
            if (poppedChar != '(' && poppedChar != '{' && poppedChar != '[') {
                postfix += poppedChar;
            }
        }

        System.out.println("Infix :" + infix);
        System.out.println("Postfix:" + postfix);

    }
}
//************************************************************8


/**
 *
 * import java.util.Scanner;
 * <p>
 * public class InfixToPostfix {
 * <p>
 * private char[] stack;
 * private int top;
 * <p>
 * public InfixToPostfix() {
 * stack = new char[100];
 * top = -1;
 * }
 * <p>
 * // Push
 * public void push(char ch) {
 * if (top == stack.length - 1) {
 * System.out.println("Stack Overflow");
 * } else {
 * stack[++top] = ch;
 * }
 * }
 * <p>
 * // Pop
 * public char pop() {
 * if (top == -1) {
 * return '\0';
 * }
 * return stack[top--];
 * }
 * <p>
 * // Peek
 * public char peek() {
 * if (top == -1) {
 * return '\0';
 * }
 * return stack[top];
 * }
 * <p>
 * // Is Empty
 * public boolean isEmpty() {
 * return top == -1;
 * }
 * <p>
 * // Precedence of operators
 * public static int precedence(char ch) {
 * switch (ch) {
 * case '^':
 * return 3;
 * <p>
 * case '*':
 * case '/':
 * case '%':
 * return 2;
 * <p>
 * case '+':
 * case '-':
 * return 1;
 * <p>
 * default:
 * return -1;
 * }
 * }
 * <p>
 * public static String convert(String infix) {
 * <p>
 * InfixToPostfix st = new InfixToPostfix();
 * <p>
 * StringBuilder postfix = new StringBuilder();
 * <p>
 * for (int i = 0; i < infix.length(); i++) {
 * <p>
 * char ch = infix.charAt(i);
 * <p>
 * // Ignore spaces
 * if (ch == ' ') {
 * continue;
 * }
 * <p>
 * // Operand
 * if (Character.isLetterOrDigit(ch)) {
 * postfix.append(ch);
 * }
 * <p>
 * // Opening bracket
 * else if (ch == '(') {
 * st.push(ch);
 * }
 * <p>
 * // Closing bracket
 * else if (ch == ')') {
 * <p>
 * while (!st.isEmpty() && st.peek() != '(') {
 * postfix.append(st.pop());
 * }
 * <p>
 * if (!st.isEmpty() && st.peek() == '(') {
 * st.pop();
 * }
 * }
 * <p>
 * // Operator
 * else {
 * <p>
 * while (!st.isEmpty()
 * && st.peek() != '('
 * && precedence(st.peek()) >= precedence(ch)) {
 * <p>
 * postfix.append(st.pop());
 * }
 * <p>
 * st.push(ch);
 * }
 * }
 * <p>
 * // Pop remaining operators
 * while (!st.isEmpty()) {
 * postfix.append(st.pop());
 * }
 * <p>
 * return postfix.toString();
 * }
 * <p>
 * public static void main(String[] args) {
 * <p>
 * Scanner sc = new Scanner(System.in);
 * <p>
 * System.out.print("Enter Infix Expression: ");
 * String infix = sc.nextLine();
 * <p>
 * String postfix = convert(infix);
 * <p>
 * System.out.println("Infix  : " + infix);
 * System.out.println("Postfix: " + postfix);
 * <p>
 * sc.close();
 * }
 * }
 *
 *
 *
 */