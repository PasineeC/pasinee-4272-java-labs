package chantapinich.pasinee.lab4;

import java.util.*;

/*
 * This program provides a menu with options to create matrix using different methods:
 * 1. User Input
 * 2. Random Numbers
 * 3. All Zeros
 * 4. All Ones
 * 5. Diagonal Matrix
 * 
 * After create a matrix, the user can choose from the following operations;
 * 1. Transpose Matrix
 * 2. Row and Column Sum
 * 3. Find Max/Min Value
 * 4. Diagonal Display 
 * 5. Exit
 * 
 * The program runs in an infinite loop until the user chooses to exit.
 * 
 * Author: Pasinee Chantapinich
 * ID: 663040427-2
 * Sec: 1
 * 
 */

public class MatrixOperations {
    static int rows, columns;
    static Scanner input = new Scanner(System.in);
    static int[][] matrix, matrixTran;

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
            int choice1 = input.nextInt();
            if (choice1 == 1) {
                userInput();
            } else if (choice1 == 2) {
                randomMatrix();
            } else if (choice1 == 3) {
                allZeros();
            } else if (choice1 == 4) {
                allOnes();
            } else if (choice1 == 5) {
                diagonalMatrix();
            } else {
                break;
            }
            while (true) {
                System.out.println("Choose an operation: ");
                System.out.println("1. Transpose Matrix" + "\n"
                        + "2. Row and Column Sum" + "\n"
                        + "3. Find Max/Min Value" + "\n"
                        + "4. Diagonal Display" + "\n"
                        + "5. Exit");
                System.out.print("Enter choice: ");
                int choice2 = input.nextInt();
                if (choice2 == 1) {
                    transposeMatrix();
                } else if (choice2 == 2) {
                    sumRowCol();
                } else if (choice2 == 3) {
                    findMinMax();
                } else if (choice2 == 4) {
                    diagonalDisplay();
                } else {
                    break;
                }
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
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = 0;
            }
        }
        display();
    }

    // Method to create a matrix with all ones
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
    static void diagonalMatrix() {
        System.out.print("Enter the number of rows and columns for diagonal matrix: ");
        int diagonalNum = input.nextInt();
        rows = diagonalNum;
        columns = diagonalNum;
        matrix = new int[rows][columns];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (i == j) {
                    matrix[i][j] = 1;
                } else {
                    matrix[i][j] = 0;
                }
            }
        }
        display();
    }

    // Method to transpose the matrix
    static void transposeMatrix() {
        matrixTran = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrixTran[j][i] = matrix[i][j];
            }
        }
        matrix = matrixTran;
        display();
    }

    // Method to calculate and display row and column sums
    static void sumRowCol() {
        System.out.println("Row Sums: ");
        for (int i = 0; i < matrix.length; i++) {
            int sumRows = 0;
            for (int j = 0; j < matrix[0].length; j++) {
                sumRows += matrix[i][j];
            }
            System.out.println("Row " + (i + 1) + ": " + sumRows);
        }
        System.out.println("Column Sums: ");
        for (int i = 0; i < matrix[0].length; i++) {
            int sumCol = 0;
            for (int j = 0; j < matrix.length; j++) {
                sumCol += matrix[j][i];
            }
            System.out.println("Column " + i + ": " + sumCol);
        }
    }

    // Method to find the minimum values in the matrix
    static void findMinMax() {
        int min = matrix[0][0];
        int max = matrix[0][0];
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] < min) {
                    min = matrix[i][j];
                }
                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                }
            }
        }
        System.out.println("Maximum Value: " + max);
        System.out.println("Minimum Value: " + min);
    }

    // Method to display the main diagonal elements
    static void diagonalDisplay() {
        System.out.println("Main Diagonal: ");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == j) {
                    System.out.print(matrix[i][j] + " ");
                }
            }
        }
        System.out.println();
    }
}
