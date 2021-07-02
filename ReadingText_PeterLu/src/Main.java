import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        ArrayList<String> lines = new ArrayList<>(); // The arraylist stores the lines that are read by the reader
        FileReader fr = new FileReader("in.txt");// The file reader is going to read from in.txt which has the programming history txt on it
        BufferedReader br = new BufferedReader(fr);
        String line;// the line that the reader reads will be temporarily stored here
        while ((line=br.readLine())!= null){ // The reader reads each line at a time and stores it to the string which is then transferred into each index position of the array
            lines.add(line); //This adds the line to the array list
            //this process repeats until there is nothing to be read
        }
        br.close(); // the buffered reader closes
        System.out.println("Search for a word:");
        Scanner scanner = new Scanner(System.in); // this prompts the user to type a word to search in the array
        String Text = scanner.nextLine(); // this scans for user input
        int [] a = txtsearch(Text,lines); /*calls the methode and send the word there is going to searched and the array list contain the text
        in lines. The methode will return the occurences of the word searched in a int array*/

        System.out.println("Text Searched:"+Text+"\n"+"occurrences...");
        System.out.println("Line(s):");
        for(int i= 0; i<lines.size();i++) { //this prints the array contain the lines number(s) that the word appeared in
            if(a[i]>=0) { // it would only print the number that are greater than or equal to 0 because if it were less it would mean that the word didn't appear
                System.out.println(a[i]+1);
            }
        }
    }
   public static int[] txtsearch(String Text, ArrayList<String> lines) { // this methode checks each line to see if the word in matches the searched word
       int[] arrline= new int[lines.size()]; // this array is used to store all the line number that the text occurred on
       for(int i= 0; i<lines.size();i++){ // this goes through each line
           if(lines.get(i).contains(Text)){ //this see if the line contain the text searched
               arrline[i]= i; // if the line its on did contain the word the array would save this line number
           }else{
               arrline[i]=-1; // if it didn't then then the array would save the number as -1 to signify that the word was not found
           }
       }
    return arrline; //the array contain the lines numbers would be returned

    }
}


