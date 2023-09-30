import java.util.*;
public class learn4 {

    public static double evaluate(String expression) {
//This initializes a stack object of type Integer to store the operands for the prefix expression.  
        Stack<Double> stack = new Stack<Double>();
//iterates over the characters of the expression in reverse order 
//because operators come before the operands and we process the operators after the operands.
        for (int i = expression.length() - 1; i >= 0; i--) {
//gets the current character from the expression, based on the current index of the loop.      
            char c = expression.charAt(i);
//checks if the current character is a digit. If so, converts character to integer and pushes to stack. 
            if (Character.isDigit(c)) {
                stack.push((double) (c - '0'));
//executed if the current character is not a digit but operator
            } else {
// It pops the two most recent operands from the stack, performs the operation on them using the operator
// and pushes the result back to the stack.                
                
                    double a = stack.pop();
                    double b = stack.pop();
//checks operator and performs corresponding mathematical operation using the two operands.                    
                    switch (c) {
                        case '+':
                            stack.push(b + a);
                            break;
                        case '-':
                            stack.push(b - a);
                            break;
                        case '*':
                            stack.push(b * a);
                            break;
                        case '/':
                            stack.push(b / a);
                            break;
                    }
                } 
                }
//After the loop, the stack should contain a single element, which is the result of the expression    
// returns the final result by popping it from the stack.   
            return stack.pop();       
        }
    public static void main(String[] args) {
        
        String expression = "+23";
        System.out.println("Expression: " + expression);
        System.out.println("Result: " + evaluate(expression)); // prints 5.0
    }
}
