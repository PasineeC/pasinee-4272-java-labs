package chantapinich.pasinee.lab2;

/**
 * this program accept 3 arguments
 * input = <patient's name> <patient's age> <patient's gender>
 * the output should be 
 * Patient's name: <patient's name>
 * Age: <patient's age>
 * Gender: <patient's gender>
 * 
 * Author: Pasinee Chantapinich
 * ID: 663040427-2
 * Sec: 1
 */

public class Patient {
    public static void main(String[] args) {
        if (args.length == 3){
            System.out.println("Patient's Name: " + args[0] );
            System.out.println("Age: " + args[1]);
            System.out.println("Gender: " + args[2]);
    }
        else if ( args.length != 3){
            System.err.println("Error: Invalid number of arguments. Please provide exactly three arguments.");
        }
        }
       
    }
