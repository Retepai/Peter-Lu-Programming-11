package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int Wins= 0;
        int Losses= 0;
        int exit= 0;

        do{ // this do while statement will run as long as the int exit remains 0
            //Rock=1 Paper=2 Scissor=3
            System.out.println("Rock! Paper! Scissors! Choose '1' for rock, '2' for paper, '3' for scissor and press '4' to escape ");
            Scanner scan = new Scanner(System.in); // This code scans for user input
            System.out.println("user's choice:");

            //this Integer.parseInt converts the string input from the user to a integer
            int user = Integer.parseInt(scan.next());

        /*this code will detect any invalid choice that the user makes. If it detects the number input from the
        is greater than 3 or less than or equal to 0 it will print an error and stop the program*/

            //Computer's choice

            // This generates a number ranging from 0-10
            int computer=(int) (Math.random() * 10);

        /*This while loop looks for 0s if it detects a 0 it will run the random number generator code
        until the number generated is not 0
         */
            while(computer==0){
                computer=(int) (Math.random() * 10);
            }



            // To get an even distribution of chances I ranged rock(1) from 1-3, paper(2) from 4-6 and scissor(3) from 7-9

            if(computer>=1&&computer<= 3){ // this line will execute if the program detects 1,2 or 3 and converts the number to 1
                computer= 1;
            }else if (computer<=6&&computer>3){//this line will execute if the program detects 4,5 or 6 and converts the number to 2
                computer= 2;
            }else if (computer>=7){ // this line will execute if the program detects 7,8 or 9 and converts the number to 3
                computer= 3;
            }

            // I recoded this part because I felt like this method im using is more clear

            // This if statement deals with all the scenarios where the user input is rock(1)
            if(user==1){

                if(computer==1){
                    /* if the computer's randomly generated choice was rock(1) then it would be a user draw and the line of
                    code below will execute*/
                    System.out.println("Draw!\nuser's choice: Rock\tcomputer's choice: Rock");
                }
                else if(computer==2){
                    // if the computer's choice was paper(2) the user would of lost so the code below will execute
                    System.out.println("You Lose\nuser's choice: Rock\tcomputer's choice: Paper");
                    Losses++; // This will increase the integer Losses by one because the user lost one round
                }
                else{ /* if the computer's choice wasn't rock(1) or paper(2) then that only leaves 3 which in this case the user
                would have won so code below will run*/
                    System.out.println("You Win!\nuser's choice: Rock\tcomputer's choice: Scissor");
                    Wins++; //This line of code will increase the integer Wins by one since the user won a round
                }

                //This else if statement will cover all scenarios where the user picks paper(2)
            } else if (user==2){

                if (computer==1){
                    // if the computer's choice was rock(1) the user wins so the line below will print
                    System.out.println("You Win!\nuser's choice: Paper\tcomputer's choice: Rock");
                    Wins++; // Because the user has won the int win will increase by one
                }
                else if (computer==2){
                    //if the computer decided to go with paper(2) the it would be a draw and the code below will run
                    System.out.println("Draw!\nuser's choice: Paper\tcomputer's choice: Paper");
                }
                else{
                    /*if the computer choice was not rock(1) or paper(2) then it must be 3then the user would have
                    lost and in this case so the code below would print
                     */
                    System.out.println("You Lose\nuser's choice: Paper\tcomputer's choice: Scissor");
                    Losses++;// since the user lost the int Losses will go up by one
                }
            }
            // this else if statement will deal with all the scenarios where the user picks 3
            else if(user==3) {

                if(computer==1){
                    /* if the computer picks rock(1) the user would lose because the user chose scissors(3) so the
                    line below will print
                     */
                    System.out.println("You Lose\nuser's choice: Scissor\tcomputer's choice: Rock");
                    Losses++; // This would increase the Losses by one since the user lost
                }
                else if (computer==2){
                    // if the computer's choice is paper(2) the user would win because the user chose scissor(3)
                    System.out.println("You Win!\nuser's choice: Scissor\tcomputer's choice: Paper");
                    Wins++; // this would increase the wins by one
                }
                else{ /*if the computer didn't rock(1) or paper(2) the computer must of chosen scissor(3) and the user
                and the computer would have drew*/
                    System.out.println("Draw!\nuser's choice: Scissor\tcomputer's choice: Paper");
                }
            }
            else if(user==4){ // if the user presses escape(4) then the code the code below will execute
                System.out.println("Thank you for playing, see you next time!");
                exit++; /* This code will add one to the int exit, which in the end when the do while loop checks
                if the int exit is 0 it will become false therefore breaking out of the loop */


            }
            else { // This else statement detects of invalid statements (inputs other than 1,2,3,4)
                System.out.println("This answer is invalid please try '1', '2' or '3' or '4' to escape");
            }

            //This line of code below will print barrier between every game to separate them
            System.out.println("\n*************************************************************************************\n");
            /*This line of code will print out the wins and losses the player has accumulated and if the user choose to
            stop the game the score will print one last time at the barrier
             */
            System.out.println("Wins:"+Wins+"\t"+"Losses:"+Losses);
        }while(exit==0);// This do while loop (mentioned above) checks the condition after a run has been completed.
    }
}
