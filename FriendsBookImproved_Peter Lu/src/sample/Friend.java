package sample;

import javafx.scene.control.TextField;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Friend {
    public String firstname;
    public String lastname;
    private String gender;
    private String hobbies;


    public String getNumber() {
        return number;
    }

    private String number;

    public String getJobs() {
        return jobs;
    }

    private String jobs;
    public String getGender() {
        return gender;
    }
    public String getHobbies() {
        return hobbies;
    }


    Friend(String firstname,String lastname,String gender,String number, String hobbies,String jobs){ // this is the constructor for the object friend
        this.firstname=firstname; //this sets the object's firstname as the firstname passed through the parameter
        this.lastname=lastname;//this sets the object's lastname as the lastname passed through the parameter
        this.gender=gender; //this sets the object's gender as the gender passed through the parameter
        this.number=number; // this set's their phone number
        this.hobbies=hobbies;//their hobbies
        this.jobs=jobs;// and the jobs as the jobs passed through the parameter upon creation of the object
    }

    public void writeToFile(String txtnameoffile,Boolean append) throws IOException { //this is the write
        FileWriter fw = new FileWriter(txtnameoffile,append);
        BufferedWriter bw = new BufferedWriter(fw); //this calls for the buffered writer
        bw.write(firstname+"!\r"); // this adds a ! to the end each of the item's firstname sent in and writes it to the file that the user chose
        bw.write(lastname+"@\r"); // this adds a @ to the end each of the item's lastname sent in and writes it to the file
        bw.write(gender+"#\r");// this adds a # to the end each of the item's gender sent in and writes it to the file
        bw.write(number+"$\r");// this adds a $ to the end each of the item's number sent in and writes it to the file
        bw.write(hobbies+"%\r");// this adds a % to the end each of the item's hobbies sent in and writes it to the file
        bw.write(jobs+"^\r");// this adds a ^ to the end each of the item's jobs sent in and writes it to the file
        bw.write(".\r");// at the end a period is added to signify the end of one item
        bw.close(); // closes the buffered writer


    }

    @Override
    public String toString() {
        return firstname+" "+lastname; // this overrides the return methode and returns the friend's first and last names
    }

}