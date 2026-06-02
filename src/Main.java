import stack.*;

public class Main   {
    public static void main(String[] args) {
        // array data structure
         ArrayDS.eventDrivenProgram(); // array
//         stack data structure
        StackLocal.eventDrivenProgram(); // stack
//         infix to postfix
        InfixToPostfix.infixToPostfix(); // infix to postfix
//         infix to prefix
        InfixToPrefix.infixToPrefix(); // infix to prefix
//         matching parenthesis
        MatchingParenthesis.checkExpressionIsValid(); // matching parenthesis
        // evaluate postfix
        Evaluation.evaluatePostfixExpression(); // evaluate postfix
    }
}