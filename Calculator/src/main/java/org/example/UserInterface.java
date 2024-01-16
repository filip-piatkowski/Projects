package org.example;

import java.util.Scanner;

public class UserInterface {

    private final Scanner scanner;
    private final Calculator calculator;

    public UserInterface(Scanner scanner, Calculator calculator) {
        this.scanner = scanner;
        this.calculator = calculator;
    }
    public void run() {
        double num1 = getNumberInput("Enter the first number: ");
        double num2 = getNumberInput("Enter the second number: ");
        char operator = getOperatorInput("Enter the operator (+, -, *, /): ");

        double result = calculatorResult(num1, num2, operator);

        System.out.printf("%.2f %c %.2f = %.2f%n", num1, operator, num2, result);
    }

    private double getNumberInput(String prompt) {
        System.out.println(prompt);
        return scanner.nextDouble();
    }

    private char getOperatorInput(String prompt) {
        System.out.println(prompt);
        return scanner.next().charAt(0);
    }

    private double calculatorResult(double num1, double num2, char operator) {
        double result;
        switch (operator) {
            case '+':
                result = calculator.add(num1, num2);
                break;
            case '-':
                result = calculator.subtract(num1, num2);
                break;
            case '*':
                result = calculator.multiply(num1, num2);
                break;
            case '/':
                try {
                    result = calculator.divide(num1, num2);
                } catch (ArithmeticException e) {
                    System.out.println(e.getMessage());
                    return 0;
                }
                break;
            default:
                System.out.println("Error: Invalid operator. Please use one of the fallowing: +, -, *, /");
                return 0;
        }
        return result;
    }
}