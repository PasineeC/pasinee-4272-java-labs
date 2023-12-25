package chantapinich.pasinee.lab4;

import java.util.*;

/*
 * This program prompts the user to enter the number of rows and columns for a matrix.
 * Then takes user input for each element of the matrix and displays the result matrix.
 * This program uses loops and conditions to ensure that the matrix dimensions are greater than 0.
 * It continues to prompt the user for input and display matrix in an infinite loop.
 * 
 * Author: Pasinee Chantapinich
 * ID: 663040427-2
 * Sec: 1
 * 
 */

public class MatrixDisplay {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        // Main loop to create and display matrix
        while (true) {
            System.out.print("Enter the number of rows: ");
            int a = input.nextInt();

            // Check if the number of rows and columns is greater than 0
            while (a <= 0) {
                System.out.println("Both rows and columns must be greater than 0. Please try again.");
                System.out.print("Enter the number of rows: ");
                a = input.nextInt();
            }
            System.out.print("Enter the number of columns: ");
            int b = input.nextInt();
            while (b <= 0) {
                System.out.println("Both rows and columns must be greater than 0. Please try again.");
                System.out.print("Enter the number of columns: ");
                b = input.nextInt();
            }

            int[][] matrix = new int[a][b];

            // User input for each element of the matrix
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    System.out.print("Enter element [" + i + "]" + "[" + j + "]: ");
                    matrix[i][j] = input.nextInt();
                }
            }
            
            System.out.println("Displaying Matrix: ");
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
