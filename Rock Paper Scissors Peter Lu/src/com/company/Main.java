package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // rock=1 paper=2 scissor=3
        System.out.println("Rock! Paper! Scissors! Please type '1' for rock, '2' for paper, '3' for Scissor");
        //this informs the user that rock=1 paper=2 and scissor=3

        //user's choice
        Scanner scan = new Scanner(System.in);

        //this Integer.parseInt converts the string input from the user to a integer
        int user = Integer.parseInt(scan.next());

        /*this code will detect any invalid choice that the user makes. If it detects the number input from the
        is greater than 3 or less than or equal to 0 it will print an error and stop the program*/
        if (user>3||user<=0){
            System.out.println("This answer is invalid please try '1', '2' or '3'");
        }

        //Computer's choice

        // This generates a number ranging from 0-10
        int computer=(int) (Math.random() * 10);

        /*This while loop looks for 0s if it detects a 0 it will run the random number generator code
        until the number generated is not 0
         */
        while(computer==0){
            computer=(int) (Math.random() * 10);
        }



        // to get an even distribution of chances I ranged rock(1) from 1-3, paper(2) from 4-6 and scissor(3) from 7-9

        if(computer>=1&&computer<= 3){ // this line will execute if the program detects 1,2 or 3 and converts the number to 1
            computer= 1;
        }else if (computer<=6&&computer>3){//this line will execute if the program detects 4,5 or 6 and converts the number to 2
            computer= 2;
        }else if (computer>=7){ // this line will execute if the program detects 7,8 or 9 and converts the number to 3
            computer= 3;
        }

        // if the user wins
        // this if statement accounts for all the possibilities for a user win

        if (user==1&&computer==3||user==2&&computer==1||user==3&&computer==2){ //there are three possibilities for a user win
            /* If the statement above is evaluates to true then the user must of won, and now the code below
               will determine what the user won with. And since we know that the user won, the computer's losing choice
               can also be determined based on the what the user won with*/
            if(user==1){ //when the user wins with Rock(1) this line of code will execute
                System.out.println("Hooray!\t"+"You won!\n"+"Computer's Choice:Scissor\tYour Choice:Rock");
            }else if(user==2){ // when the user wins with Paper(2) this line of code will execute
                System.out.println("Hooray!\t"+"You won!\n"+"Computer's Choice:Rock\tYour Choice:Paper");
            }else{ //when the user wins with the without rock or paper which is just scissor(3) this line of code will execute
                System.out.println("Hooray!\t"+"You won!\n"+"Computer's Choice:Paper\tYour Choice:Scissor");
            }
        }
        // if draw
        // this else if statement accounts for all the possibilities for a user draw

        /* For the draw possibilities there only need to be one possibility, if the program detects that
           the user input is equal to the computer then no matter what number it is it will consider it a draw */
        else if(user==computer){
            /* If the user==computer is true then that means there must be a draw. The code below will determine
            what the user used to cause the draw and also determine the computer's choice based off of the user's choice
            (and knowing the fact that it is draw)
             */
            if (user==1){ // this will print if the user draws with Rock(1)
                System.out.println("Draw!\n"+"Computer's Choice:Rock\tYour Choice:Rock");
            }
            else if(user==2){ // this will print if the user draws with Paper(2)
                System.out.println("Draw!\n"+"Computer's Choice:Paper\tYour Choice:Paper");
            }
            else{// this will print if the user draws without using rock(1) or paper(2) which is just scissor(3)
                System.out.println("Draw!\n"+"Computer's Choice:Scissor\tYour Choice:Scissor");
            }
        }

        // if the user loses
        // this else if statement accounts for all the possibilities for a user lose
        else if(user==1&&computer==2||user==2&&computer==3||user==3&&computer==1){//there are 3 possible losing scenarios
            /*If the statement above evaluates to true then the user must of lost. So now the code below can determine
            what the user lost with and what the computer won with */
            if (user==1){// if the user loses to the computer while choosing Rock(1) this will print
                System.out.println("Aww\t"+"You Lose better luck next time\n"+"Computer's Choice:Paper\tYour Choice:Rock");
            }
            else if(user==2){ // if the user loses to the computer while choosing Scissor(2) this will print
                System.out.println("Aww\t"+"You Lose better luck next time\n"+"Computer's Choice:Scissor\tYour Choice:Paper");
            }
            else{ //the user loses to the computer while not choosing Rock(1) or Paper(2), which is just leaves Scissor(3)
                System.out.println("Aww\t"+"You Lose better luck next time\n"+"Computer's Choice:Rock\tYour Choice:Scissor");
            }
        }






    }
}
