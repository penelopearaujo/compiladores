import java.util.*;

public class RPNStackCalculator {
    private static Stack<Integer> stack = new Stack<Integer>();

    public static void main (String[]args) {
        String rpnExpression;
        int result;
        Scanner input = new Scanner(System.in);
        RPNStackCalculator calculator = new RPNStackCalculator();
            
        System.out.println("Enter a RPN expression:");
        rpnExpression = input.nextLine();

        result = calculator.calculateRPNExpr(rpnExpression);
        System.out.println(result);
    }

    // le a entrada char por char
    public int calculateRPNExpr(String expr) {
        int x, y;
        int result = 0;
        String nextChar;
        Scanner parse = new Scanner(expr);

        while(parse.hasNext()) {
            nextChar = parse.next();

            // se for valor, push na stack
            // se for operador, pop os dois ultimos da stack para calcular
            if (!isOperator(nextChar)) {
                stack.push(new Integer(Integer.parseInt(nextChar)));
            } else {
                y = (stack.pop().intValue());
                x = (stack.pop().intValue());
                result = calculateSimpleExpr(nextChar.charAt(0), x, y);
                stack.push(result);
            }
        }
        return result;
    }

    public int calculateSimpleExpr(char operator, int x, int y) {
        int total = 0;

        switch (operator) {
            case '+':
                total = x + y;
                break;
            case '-':
                total = x - y;
                break;
            case '*':
                total = x * y;
                break;
            case '/':
                total = x / y;
                break;
            case '%':
                total = x % y;
                break;
        }

        return total;
    }

    public boolean isOperator(String operator) {
        return ( operator.equals("+") || operator.equals("-") || operator.equals("*") || operator.equals("/") || operator.equals("%") );
    }
}