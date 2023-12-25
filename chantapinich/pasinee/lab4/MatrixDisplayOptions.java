package chantapinich.pasinee.lab4;

import java.util.*;

/*
 * This program provides a menu with options to create matrix using the following methods:
 * 1. User Input
 * 2. Random Numbers
 * 3. All Zeros
 * 4. All Ones
 * 5. Diagonal Matrix
 * 
 * User can choose a method, input the number of rows and columns, and view the resulting matrix.
 * The program includes methods for each matrix, and it runs in an infinite loop until the user chooses to exit.
 * 
 * Author: Pasinee Chantapinich
 * ID: 663040427-2
 * Sec: 1 
 * 
 */

public class MatrixDisplayOptions {
    static Scanner input = new Scanner(System.in);
    static int rows, columns;
    static int[][] matrix;

    public static void main(String[] args) {
        // Main loop to display matrix options
        while (true) {
            System.out.println("Select matrix initialization method: ");
            System.out.println("1. User Input" + "\n"
                    + "2. Random Numbers" + "\n"
                    + "3. All Zeros" + "\n"
                    + "4. All Ones" + "\n"
                    + "5. Diagonal Matrix");
            System.out.print("Enter choice (1-5): ");
            int choice = input.nextInt();
            if (choice == 1) {
                userInput();
            } else if (choice == 2) {
                randomMatrix();
            } else if (choice == 3) {
                allZeros();
            } else if (choice == 4) {
                allOnes();
            } else if (choice == 5) {
                diagonalmatrix();
            } else {
                break;
            }
        }
    }

    // Method to input rows and columns from the user
    static void inputRowsColumns() {
        System.out.print("Enter the number of rows: ");
        rows = input.nextInt();
        while (rows <= 0) {
            System.out.println("Both rows and columns must be greater than 0. Please try again.");
            System.out.print("Enter the number of rows: ");
            rows = input.nextInt();
        }
        System.out.print("Enter the number of columns: ");
        columns = input.nextInt();
        while (columns <= 0) {
            System.out.println("Both rows and columns must be greater than 0. Please try again.");
            System.out.print("Enter the number of columns: ");
            columns = input.nextInt();
        }
    }

    // Method to display the matrix
    static void display() {
        System.out.println("Displaying matrix: ");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Method to create a matrix with user input
    static void userInput() {
        inputRowsColumns();
        matrix = new int[rows][columns];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print("Enter element [" + i + "]" + "[" + j + "]: ");
                matrix[i][j] = input.nextInt();
            }
        }
        display();
    }

    // Method to create a matrix with random numbers
    static void randomMatrix() {
        inputRowsColumns();
        matrix = new int[rows][columns];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int max = 9;
                int min = 0;
                matrix[i][j] = (int) (Math.random() * (max - min + 1) + min);
            }
        }
        display();
    }

    // Method to create a matrix with all zeros
    static void allZeros() {
        inputRowsColumns();
        matrix = new int[rows][columns];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = 0;
            }
        }
        display();
    }

    // Method to create a matrix wtih all ones
    static void allOnes() {
        inputRowsColumns();
        matrix = new int[rows][columns];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = 1;
            }
        }
        display();
    }

    // Method to create a diagonal matrix
    static void diagonalmatrix() {
        System.out.print("Enter the number of rows and columns for diagonal matrix: ");
        int diagonalNum = input.nextInt();
        rows = diagonalNum;
        columns = diagonalNum;
        matrix = new int[rows][columns];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == j) {
                    matrix[i][j] = 1;
                } else {
                    matrix[i][j] = 0;
                }
            }
        }
        display();
    }
}