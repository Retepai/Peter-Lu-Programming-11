package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	int exit= 0; // this code is for exit and it has been set to zero at every time at the beginning
        System.out.println("Welcome to encryption machine!"); /*This code only need to be shown once to welcome the user
        so i leave it out side the loop */
	do{ // this do while loop runs at least once and checks the condition at the end of each run
        System.out.println("Please type in the word you would like to encrypt below");
	    Scanner scan = new Scanner(System.in);
	    //this code below converts the user input into a string
        String user=scan.nextLine();// the scan nextLine() makes sure no matter how many word the user inputs the program reads it

        if(user.length()>1){ // if the user types more than one letter the code below will run

            /*This line of code move the last letter of the user input to the front and then adds the #d4t(4ga2r^=efq43 to the front of that.
            Then it would assign that string to the string user*/
            user = "#d4t(4ga2r^=efq43" + user.substring(user.length() - 1, user.length()) + user.substring(0, user.length() - 1);


        }else{ // if the user does not type more than one letter then they must of typed one letter, and when that happens the code below will run

            /* This line of code will just add #d4t(4ga2r^=efq43 to front and %3d93!hb3q3kufy*a to the back of the user's
            one letter input  */
            user= "#d4t(4ga2r^=efq43" + user.substring(0, user.length());
        }
        String encrypted= user; /* this assigns the string encrypted to the user's string which is just the encrypted code from the process finished above,
        this allows the user's current value to be safely assigned elsewhere so the code program can scan for user input*/
        System.out.println("...encrypting...\nencrypted code:"+encrypted);


        //if the user doesn't want to decrypt the message and wants to quit the if statement below will allow then to do that
        System.out.println("\nDo you want to decrypt this code? Press c for to continue press x to exit");
        user=scan.nextLine(); //scans for the user's input again
        if(user.equals("c")){ // if the user decides presses 'c' they will continue and the program below will run
            if(encrypted.length()>18) { // this if statement will run if the encrypted length is greater than 18 (if the user types multiple letters)

                /*this code below takes first letter after the #d4t(4ga2r^=efq43 and places it at the back, and place the original (minus the last letter)
                at the front*/
                System.out.println("decrypted code:" + encrypted.substring(18, encrypted.length()) + encrypted.substring(17,18));
            }else{// this statement will be executed if the encrypted length is not great than or equal to 18 (if the user types one letter)

                // this code just takes the letter after #d4t(4ga2r^=efq43 since that is the original
                System.out.println("decrypted code:"+encrypted.substring(17,18));
            }

        }else{ // if the user chooses 'x' wh program will not decode the message
            System.out.println("no problem!");
        }

        //if the user wants to encrypt another message he/she could do so with the following code
        System.out.println("Do you want to encrypt another message? Press c to continue and x to quit."); //this asks the user if he/she wants to encrypt another code
        user=scan.nextLine(); //scans for user input
        if(user.equals("c")){ // if the user chooses to go again, the program will not add one to exit to make the condition false so the loop would continue
            System.out.println("OK right on!");
        }else {// if the user chooses to exit, the program will add one to exit so when at the end when the condition is check it will be false and the loop would stop
            System.out.println("Thank you for using encryption machine see you next time!");
            exit++;
        }
        System.out.println("============================================================================"); // this prints the barrier

    }while(exit==0);
    }
}
