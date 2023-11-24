package chantapinich.pasinee.lab2;

/**
 * this program accept 3 arguments
 * input = <first number> <second number> <operator>
 * if input = 10 2 /
 * output shoud be 10/2=5
 * 
 * Author: Pasinee Chantapinich
 * ID: 663040427-2
 * Sec: 1
 */

public class SimpleCalculator {
    public static void main(String[] args) {

        if (args.length != 3) {
            System.err.println("Error : Please provide exactly three arguments.");
        } else {
            // num1 = <first number> , num2 = <second number>
            Integer num1 = Integer.parseInt(args[0]);
            Integer num2 = Integer.parseInt(args[1]);
            String operator = args[2];

            if (num2.equals(0) && operator.equals("/")) {
                System.err.println("Error: Division by zero is not allowed.");
            } else if (operator.equals("+")) {
                int result1 = num1 + num2;
                System.out.println(num1 + operator + num2 + "=" + result1);
            } else if (operator.equals("-")) {
                int result2 = num1 - num2;
                System.out.println(num1 + operator + num2 + "=" + result2);
            } else if (operator.equals("x")) {
                int result3 = num1 * num2;
                System.out.println(num1 + operator + num2 + "=" + result3);
            } else if (operator.equals("/")) {
                int result4 = num1 / num2;
                System.out.println(num1 + operator + num2 + "=" + result4);
            } else {
                System.err.println("Error: Invalid operator. Please use '+', '-', 'x', or '/'.");
                }
        }

    }
}
