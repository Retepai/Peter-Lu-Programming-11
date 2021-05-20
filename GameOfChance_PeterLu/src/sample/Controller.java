package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import static java.lang.Math.random;

public class Controller {

    public Label lblbalnc;
    public Label lbluroll;
    public Label lblwins;
    public Label lbllosses;
    public Label lbl$transf;
    public Label lbloproll;
    public Button btnbet;
    public TextField textamt;
    public Button btnroll;
    public Button btn25pcnt;
    public Button btn50pcnt;
    public Button btn100pcnt;
    public double amtwonlost;
    public double amtbet;
    public int yourroll;
    public int opponentroll;
    public int wins=0;
    public int losses=0;
    public int ispressed =0;
    public double originalbalance;
    public double newbalance;

    // at the start the buttons are all disable except for the bet button

    public void betamt(ActionEvent actionEvent) {
        // when bet button is pressed...
        originalbalance=Double.parseDouble(lblbalnc.getText()); // is would get the original account balance and store it

        // in order to keep the original balance for later newbalance will have the same value as original balance but new balance will be changed
        newbalance = originalbalance;

        // the amount that the user bets will be store in amtbet
        amtbet = Double.parseDouble(textamt.getText());
        newbalance -=amtbet; // the amount that your bet will be put on the "betting table" so amtbet will be subtracted from the your balance
        lblbalnc.setText(Double.toString(newbalance)); // updates the account balance with the new balance with the bet amt subtracted
        textamt.clear(); // clears the textfield that the user puts in the bet
        btnbet.setDisable(true); // disables the bet button
        btn25pcnt.setDisable(false);// enables the 25 percent button
        btn50pcnt.setDisable(false);// enables the 50 percent button
        btn100pcnt.setDisable(false);// enables the 100 percent button
    }
    //btn roll is pressed
    public void rolldice(ActionEvent actionEvent) {

        yourroll = (int) (1+random() * 6);// your roll
        opponentroll = (int) (1+random() * 6);// opponent's roll

        // prints the new values in the labels
        lbluroll.setText(String.valueOf(yourroll));
        lbloproll.setText(String.valueOf(opponentroll));

        if(yourroll>opponentroll){ // if your roll was bigger than your opponent's roll (you won)
            lbl$transf.setText(String.valueOf(amtwonlost)); // this updates the money won/lost with a positive amtwonlost
            wins++; //adds a win
            originalbalance+=amtwonlost;//takes the amt won and adds it to the originalbalance
            lblwins.setText(String.valueOf(wins));// updates the number of wins
            lblbalnc.setText(String.valueOf(originalbalance)); // prints the new balance
        }else if (yourroll==opponentroll){ // if your roll is the same as the opponents ( tie)
            lbl$transf.setText(String.valueOf(0)); // there would be no money won or lost
            losses++; // this still counts as a lose but no money will be lost
            lbllosses.setText(String.valueOf(losses)); // updates losses
            lblbalnc.setText(String.valueOf(originalbalance));//the original amount that you started with will be returned
        } else{ // if your opponent's roll is bigger than yours (you lost)

            losses++; //adds a lose
            if(ispressed>0){ //if the 100% percent button was pressed then the amount take away would be the amount that was bet not two time the money that was bet
                originalbalance-=amtbet; // takes the amtbet off of the original balance
                lbl$transf.setText(String.valueOf(-amtbet)); // updates the money won/lost with a negative amtwonlost
            }else { // if the 100% button was not pressed then the 50% or 25% would be lost
                originalbalance -= amtwonlost; // takes the amtwonlost (depending on how much you bet) off the original balance
                lbl$transf.setText(String.valueOf(-amtwonlost));// updates the money won/lost with negative amtwonlost
            }
            lbllosses.setText(String.valueOf(losses));// updates losses
            lblbalnc.setText(String.valueOf(originalbalance));// prints the new balance (which is also the original balance for the next round
        }
        btnroll.setDisable(true); // disables roll
        if (!(originalbalance<=0)){ /*if your account's balance isn't less or equal than 0 you can still bet so bet button will be enabled so you can bet again
        but if your account has zeroed or gone into negative digits the bet button will not be enabled and game is over*/
            btnbet.setDisable(false);
        }
    }

    public void twntyfvpcnt(ActionEvent actionEvent) { // this button will take the 25% of the bet amt and sets it as the money won or lost
        //when the 25 percent button is pressed the  other 2 buttons will be disabled
        btn50pcnt.setDisable(true);
        btn100pcnt.setDisable(true);
        amtwonlost= amtbet*0.25; // this take 25% of the betamt and set it to amtwonlost
        btn25pcnt.setDisable(true); // disables 25 percent button
        btnroll.setDisable(false);// enables roll button

    }

    public void fiftypcnt(ActionEvent actionEvent) { //this button will take 50% if the bet amt and set it as the money won or lost
        // when the 50 percent button is pressed the other 2 buttons will be disabled
        btn25pcnt.setDisable(true);
        btn100pcnt.setDisable(true);
        amtwonlost= amtbet*0.5; // this takes 50% of the betamt and set it to amtwonlost
        btn50pcnt.setDisable(true);// disables 50% button
        btnroll.setDisable(false);//enables roll button
    }

    public void hundredpcnt(ActionEvent actionEvent) { //this button will take all of the bet money and set it to the money won or lost
        // when this button is pressed all the other should be disabled
        btn25pcnt.setDisable(true);
        btn50pcnt.setDisable(true);
        amtwonlost= amtbet*2; //doubles the bet amt and set it to amtwonlost
        ispressed++; // when this is for later if you lost to minus only the bet amt and not double the bet amount
        btn100pcnt.setDisable(true);// disables 100% button
        btnroll.setDisable(false);// enables roll button
    }
}
