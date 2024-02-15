import java.util.Stack;

public class learn5 {
 //takes a string parameter and returns an integer 
    public static int evaluate(String infixExpression) {
        // Create two empty stacks to hold the operands and operators
        Stack<Integer> operandStack = new Stack<Integer>();
        Stack<Character> operatorStack = new Stack<Character>();

     
        //iterates through the characters of the infix expression from left to right
        for (int i = 0; i < infixExpression.length(); i++) {
            char currentChar = infixExpression.charAt(i);

            // If the current character is an operand, push it onto the stack
            if (Character.isDigit(currentChar)) {
                operandStack.push(Character.getNumericValue(currentChar));
            }
            // If the current character is an operator
//If it is a digit, it is pushed onto the operand stack as an integer.
//If operator (+, -, *, /), the program checks the operator stack for any operators with greater or equal precedence. 
//If any are found, they are popped from the stack
// and the corresponding operation is performed on the last two operands from the operand stack, 
//and the result is pushed back onto the operand stack. 
//The current operator is then pushed onto the operator stack.            
            else if (currentChar == '+' || currentChar == '-' || currentChar == '*' || currentChar == '/') {
                //while there is an operator on the top of the operator stack with greater or equal precedence
                while (!operatorStack.isEmpty() && hasPrecedence(currentChar, operatorStack.peek())) {
                    int op2 = operandStack.pop();
                    int op1 = operandStack.pop();
                    char operator = operatorStack.pop();
                    int result = performOperation(op1, op2, operator);
                    operandStack.push(result);
                }
                operatorStack.push(currentChar);
            }
        }
        //while there are still operators on the stack
        while (!operatorStack.isEmpty()) {
            int op2 = operandStack.pop();
            int op1 = operandStack.pop();
            char operator = operatorStack.pop();
            int result = performOperation(op1, op2, operator);
            operandStack.push(result);
        }
        // The final result will be the only element left on the stack
       //fter the for loop, the program continues to pop operators and perform corresponding operations until the operator stack is empty. 

//After the for loop, the program continues to pop operators and perform corresponding operations until the operator stack is empty.       
        return operandStack.pop();
    }
//checks the precedence of the current operator and the one in the top of the operator stack, to decide if the operation should be performed or not.
    private static boolean hasPrecedence(char operator1, char operator2) {
        if (operator2 == '(' || operator2 == ')')
            return false;
        if ((operator1 == '*' || operator1 == '/') && (operator2 == '+' || operator2 == '-'))
            return false;
        else
            return true;
    }
//performs the operation corresponding to the operator passed as parameter, and returns the result.
    private static int performOperation(int op1, int op2, char operator) {
        switch (operator) {
            case '+':
                return op1 + op2;
            case '-':
                return op1 - op2;
            case '*':
                return op1 * op2;
            case '/':
                if (op2 == 0)
                    throw new UnsupportedOperationException("Cannot divide by zero");
                return op1 / op2;
        }
//returns 0 in the case that none of the specified operators (+, -, *, /) match the operator 
//passed to the method as a parameter.(cant be reached)        
        return 0;
    }
    public static void main(String[] args) {
        String infixExpression = "2+3*4";
        int result = learn5.evaluate(infixExpression);
        System.out.println("Result: " + result);

    }
}
