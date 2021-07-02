package sample;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Load { //this class is dedicated for loading the items on to the arraylist
    private static String firstname;
    private static String lastname;
    private static String gender;
    private static String hobbies;
    private static String number;
    private static String jobs;
    private static FileReader fr;
    private static BufferedReader br;
    private static ArrayList<Friend> friend = new ArrayList<>();

    public static ArrayList loadAllFriends (String fileName)throws IOException{ // this is where the file gets red and friend items get retrieved
        fr= new FileReader(fileName); //this reads from the filename that the user has chosen
        br = new BufferedReader(fr);
        String line;
        StringBuilder friendString = new StringBuilder();
        while((line = br.readLine())!= null){ //reads the txt file until there is no text
            if(!line.equals(".")){ // when the items are being written into the file there would be a period after each item, and so this would check for that period to to see if the item has ended
                friendString.append(line);
            }else{
                parseFriend(friendString.toString());
                friendString = new StringBuilder();
            }
        }
        return friend; //returns the arraylist

    }
    private static void parseFriend (String string){ // this method mainly retrieves the parameters of the friend object and adds to the arraylist
        int prevpos = 0;
        int curpos;
        String firstname=""; //these are the temporary Strings that the friend's parameter will be stored in
        String lastname="";
        String gender="";
        String hobbies="";
        String number="";
        String jobs="";
        for(int i =0; i<string.length();i++){ // this loops through the String passed in from the parameter
            if(string.substring(i,i+1).equals("!") ){ //if the character ! is detected then from the start to before that character is the firstname
                curpos = i;
                firstname = string.substring(0,curpos);
                prevpos = curpos; //this records the previous position of where a character has occured
            }else if(string.substring(i,i+1).equals("@")){ //if the character @ is detected then the from one after the previous character to before this character is the lastname
                curpos= i;
                lastname = string.substring(prevpos+1,curpos);
                prevpos = curpos;//this records the previous position of where a character has occured
            }else if (string.substring(i,i+1).equals("#")){//if the character # is detected then the from one after the previous character to before this character is the gender
                curpos= i;
                gender = string.substring(prevpos+1,curpos);
                prevpos = curpos;//this records the previous position of where a character has occured
            }else if (string.substring(i,i+1).equals("$")){//if the character $ is detected then the from one after the previous character to before this character is the hobbies
                curpos= i;
                hobbies = string.substring(prevpos+1,curpos);
                prevpos = curpos;//this records the previous position of where a character has occured
            }else if (string.substring(i,i+1).equals("%")){//if the character % is detected then the from one after the previous character to before this character is the number
                curpos= i;
                number = string.substring(prevpos+1,curpos);
                prevpos = curpos;//this records the previous position of where a character has occured
            }else if (string.substring(i,i+1).equals("^")){//if the character ^ is detected then the from one after the previous character to before this character is the job
                curpos= i;
                jobs = string.substring(prevpos+1,curpos);

            }
        }
        friend.add(new Friend(firstname, lastname, gender, hobbies, number, jobs)); // this then takes all the parameters and creates a friend with them and adds it to the arraylist if friends.

    }


}