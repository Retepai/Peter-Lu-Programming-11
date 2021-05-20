package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

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
    private String gender;


    public void malefriend(ActionEvent actionEvent) { //this is the action for when the user presses male
        gender = "male"; //when male is selected the gender would be set to male
    }

    public void femalefriend(ActionEvent actionEvent) { //this is the action for when the user presses female
        gender="female"; //when female is selected the gender would be set female
    }

    public void addfriend(ActionEvent actionEvent) { //when the user presses add friend code below will execute

        //this code will create a friend object with the parameters that has been entered in the text fields
        Friend friend = new Friend(txtfirstname.getText(),txtlastname.getText(),gender,txtnumber.getText(), txthobbies.getText(),txtjobs.getText());
        displayfriends.getItems().add(friend); // this adds the friend object to the list and it would be displayed on the list
        txtfirstname.clear();// clears the firstname text field
        txtlastname.clear();//clears the lastname text field
        txtnumber.clear();//clears the phone number text field
        txthobbies.clear();// clears the hobbies text field
        txtjobs.clear();// clears the jobs text field
    }

    public void deletefriend(ActionEvent actionEvent) { //this is when the user presses the delete friend button
        // when the button is pressed the remove the item by getting the selected item index and deleting the item on that index
        displayfriends.getItems().remove(displayfriends.getSelectionModel().getSelectedIndex());
        lblfirstname.setText("");
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


}