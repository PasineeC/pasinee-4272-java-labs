package chantapinich.pasinee.lab2;

/**
 * 
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
