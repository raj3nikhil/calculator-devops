package calculator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
    private static final Logger logger = LogManager.getLogger(Calculator.class);

    public Calculator() {
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        Scanner scan = new Scanner(System.in);
        double num1 = 0, num2 = 0;
        while (true) {
            System.out.println("Scientific Calculator. Enter your choice: ");
            System.out.println("Enter 1 to evaluate square root.\n" +
                    "Enter 2 to evaluate factorial.\n" +
                    "Enter 3 to evaluate natural log (base e).\n" +
                    "Enter 4 to use power function\n" +
                    "Enter any other key to exit\n");
            int c;
            try {
                c = scan.nextInt();
            } catch (InputMismatchException error) {
                return;
            }

            if (c == 1 || c == 2 || c == 3) {
                try {
                    System.out.print("Enter the number : ");
                    num1 = scan.nextDouble();
                } catch (InputMismatchException error) {
                    logger.error("Invalid input");
                    return;
                }
            } else if (c == 4) {
                try {
                    System.out.print("Enter the base : ");
                    num1 = scan.nextDouble();
                    System.out.print("Enter the exponent : ");
                    num2 = scan.nextDouble();
                } catch (InputMismatchException error) {
                    logger.error("Invalid input, Entered input is not a number");
                    return;
                }
            }
            switch (c) {
                case 1: // Sq. root function
                    System.out.println("The sq. root of " + num1 + "  is: " + calc.sqrt(num1)+"\n\n");
                    break;
                case 2: // Factorial function
                    System.out.println("The factorial of " + num1 + " is: " + calc.fact(num1)+"\n\n");
                    break;
                case 3: // Natural log function
                    System.out.println("The natural log of " + num1 + " is: " + calc.nlog(num1)+"\n\n");
                    break;
                case 4: // Power function
                    System.out.println(num1 + " raised to the power of " + num2 + " is: " + calc.pow(num1, num2)+"\n\n");
                    break;
                default:
                    System.out.println("Exiting....");
                    return;
            }
        }
    }

    public double sqrt(double num1){
        double result = 0;
        try{
            logger.info("Evaluating Square root of "+ num1);
            if(num1<0){
                result=Double.NaN;
                throw new ArithmeticException();
            }
            else{
                result = Math.sqrt(num1);
            }
        } catch (ArithmeticException error){
            logger.error("Square root of negative number cannot be found.");
        } finally {
            logger.info("Square root of "+num1+" is: "+result);
        }
        return result;
    }

    public double fact(double num1){
        double result = 1;
        try{
            logger.info("Evaluating factorial of "+ num1);
            if(num1<0){
                result=Double.NaN;
                throw new ArithmeticException();
            }
            else{
                double i;
                for (i=2; i<=num1; i++)
                    result *= i;
                return result;
            }
        } catch (ArithmeticException error){
            logger.error("Factorial of negative number cannot be found.");
        } finally {
            logger.info("Factorial of "+num1+" is: "+result);
        }
        return result;
    }

    public double nlog(double num1){
        double result = 0;
        try{
            logger.info("Evaluating natural log of "+ num1);
            if(num1<=0){
                result=Double.NaN;
                throw new ArithmeticException();
            }
            else{
                result= Math.log(num1);
            }
        } catch (ArithmeticException error){
            logger.error("Natural log of negative number or zero cannot be found.");
        } finally {
            logger.info("Natural log of "+num1+" is: "+result);
        }
        return result;
    }

    public double pow(double num1, double num2){
        double result = 0;
        try{
            logger.info("Evaluating "+ num1+ " raised to the power of "+num2);
            if(num1 == 0 && num2 == 0){
                result=Double.NaN;
                throw new ArithmeticException();
            }
            else{
                result = Math.pow(num1,num2);
            }
        } catch (ArithmeticException error){
            logger.error("0^0 is undefined.");
        } finally {
            logger.info(num1 + " raised to the power of "+ num2 +" is: "+result);
        }
        return result;
    }
}
