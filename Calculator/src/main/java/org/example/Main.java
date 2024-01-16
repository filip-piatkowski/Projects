package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();
        UserInterface userInterface = new UserInterface(scanner, calculator);

        userInterface.run();
    }
}