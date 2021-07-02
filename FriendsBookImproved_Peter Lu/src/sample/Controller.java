package sample;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import java.io.BufferedWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class Controller {


    public TextField txtfirstname;
    public TextField txtlastname;
    public Button btnmale;
    public Button btnfemale;
    public TextField txthobbies;
    public TextField txtjobs;
    public Button btnaddfriend;
    public Label lblfirstname;
    public Label lbllastname;
    public Label lblgender;
    public Label lblhobbies;
    public Label lbljobs;
    public Button btndeletefriend;
    public ListView<Friend> displayfriends =new ListView<>();
    public TextField txtnumber;
    public Label lblnumber;
    public Button btnsave;
    public Button btnload;
    public TextField txtfilename;
    private String gender;
    public boolean append = true;

    public void malefriend(ActionEvent actionEvent) { //this is the action for when the user presses male
        gender = "male"; //when male is selected the gender would be set to male
    }

    public void femalefriend(ActionEvent actionEvent) { //this is the action for when the user presses female
        gender="female"; //when female is selected the gender would be set female
    }

    public void addfriend(ActionEvent actionEvent) { //when the user presses add friend code below will execute

        //this code will create a friend object with the parameters that has been entered in the text fields
        Friend friend = new Friend(txtfirstname.getText(), txtlastname.getText(), gender, txtnumber.getText(), txthobbies.getText(), txtjobs.getText());


        // the code below will check for duplicates and there are only one would be on the list
        if (displayfriends.getItems().size()==0){ // of there is nothing in the list then the checking would be omitted the friend would just be added
            displayfriends.getItems().add(friend); //this adds the friend to the list

        }else{ //if the list is not empty then checking is required
            boolean compfriend = false;
            for (int i = 0; i <displayfriends.getItems().size(); i++) { //this loops through the items in the current list and compares it to the new friend's parameters (first/lastname)
                if (displayfriends.getItems().get(i).toString().contains(friend.firstname+" "+friend.lastname)){
                    // if the first and lastname entered for the friend is already on the listview then the boolean value will go to true
                    compfriend=true;

                }
            }
            if(!compfriend) { //only if the boolean false it would print, mean that if there were no similarities between the new friend and the friends on the list then the friend would be added
                displayfriends.getItems().add(friend);
            }
        }
        txtfirstname.clear();// clears the firstname text field
        txtlastname.clear();//clears the lastname text field
        txtnumber.clear();//clears the phone number text field
        txthobbies.clear();// clears the hobbies text field
        txtjobs.clear();// clears the jobs text field
    }

    public void deletefriend(ActionEvent actionEvent) { //this is when the user presses the delete friend button
        // when the button is pressed the remove the item by getting the selected item index and deleting the item on that index
        displayfriends.getItems().remove(displayfriends.getSelectionModel().getSelectedIndex());
        lblfirstname.setText(""); //this would remove the description of the friend of the delete friend
        lbllastname.setText("");
        lblgender.setText("");
        lblnumber.setText("");
        lblhobbies.setText("");
        lbljobs.setText("");
    }

    public void frienddescription(MouseEvent mouseEvent) { //this is when the user clicks on one of items on listview
        Friend friend;
        friend = displayfriends.getSelectionModel().getSelectedItem(); //this gets the selected object on the list
        lblfirstname.setText(friend.firstname); //this display the firstname by setting the firstname label as the object's firstname
        lbllastname.setText(friend.lastname);//this display the lastname by setting the lastname label as the object's lastname
        lblgender.setText(friend.getGender());// this displays the gender by getting the gender from the object and setting the gender labels as that
        lblnumber.setText(friend.getNumber());// this displays the phone number by getting the phone number from the object and setting the phone number labels as that
        lblhobbies.setText(friend.getHobbies());// this displays the hobbies by getting the hobbies from the object and setting the hobbies labels as that
        lbljobs.setText(friend.getJobs());// this displays the jobs by getting the jobs from the object and setting the jobs labels as that

    }

    public void savelist(ActionEvent actionEvent) throws IOException { // this code executes when the user presses the save button
        FileWriter fw = new FileWriter(txtfilename.getText(),false);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write("");//this erases the things that been previous in the text so there wouldn't be a repeat of items in the list
        ObservableList<Friend> myfriends = displayfriends.getItems(); // this transfers the items on the display friends list to  a Observable array list
        for(Friend f: myfriends){ //this loops through and sends the methode writeTofile each item to write to the file that the user chose.
            f.writeToFile(txtfilename.getText(),append); //in this case I allowed the user to choose and name the file
        }
        displayfriends.getItems().clear(); //clears the list that is being currently displayed in the program to signify that the list has been save into the computer

    }

    public void loadlist(ActionEvent actionEvent) throws IOException { // The code below will execute if the user presses the load button
        ArrayList<Friend> friends = Load.loadAllFriends(txtfilename.getText()); /*This uses the LoadAllFriends methode in the Load class and
        retrieves the items and stores it on an arraylist
        */
        displayfriends.getItems().clear(); // clears the display list just to sure there is nothing on there
        for( Friend f: friends){ // this loops and loads every item in the array list that stores friends on to the display list to display in the program
            displayfriends.getItems().add(f);
        }
        friends.clear();// This clears the friend arraylist to make sure that the second time the load button is used the previous items doesn't also get loaded in

    }




}
