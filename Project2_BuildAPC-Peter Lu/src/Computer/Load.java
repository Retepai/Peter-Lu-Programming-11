package Computer;

import java.io.*;
import java.util.ArrayList;

public class Load { //this class is dedicated for loading the components back onto the overview
    private static FileReader fr;
    private static BufferedReader br;
    private static ArrayList<Computer> computer = new ArrayList<>(); //this is the arraylist that is going to be written onto
    public static ArrayList loadBuild(String filename) throws IOException {//this is where the file gets read and the pc components get retrieved

        fr = new FileReader(filename); //this reads from the file name that the user has choose
        br = new BufferedReader(fr);
        String line;
        StringBuilder computerString = new StringBuilder();
        while ((line=br.readLine())!=null){ //reads the text file until there is no text
            if(!line.equals("?")){ // when the components are being written into the file there would be a question mark after each component, and so this would check for that question mark to see if the component has ended
                computerString.append(line);
            }
            else{
                parseComputer(computerString.toString());
                computerString = new StringBuilder();
            }
        }
        return computer; // returns the arraylist at the end
    }

    private static void parseComputer(String string) {//this methode mainly retrieves the parameters of each of the components in the pc and adds it to the arraylist
        int prevpos=0;
        int curpos;
        String identifier =""; //this is the identifier. it identifies the components
        //these are temporary Strings that the component's specs parameters will be stored in
        String par1 ="";
        String par2="";
        String par3="";
        String par4="";
        String par5="";
        String par6="";
        String par7="";
        String par8="";
        String par9="";
        String par10="";
        String par11="";
        String par12="";



        for(int i =0;i< string.length();i++) { //this loops through the String passed in from the parameter


            if (string.substring(i, i + 1).equals("+")) { //if the character ++ is detected, then from the started to before that character is the identifier
                curpos = i;
                identifier = string.substring(0, curpos); //this assigns the string to identifier
                prevpos = curpos; //this records the previous position of where a character has occurred


            } else if (string.substring(i, i + 1).equals("<")) { //if the character < is detected, then from one after the previous character to before this character is the first parameter of the pc's component
                curpos = i;
                par1 = string.substring(prevpos + 1, curpos);
                prevpos = curpos;

            } else if (string.substring(i, i + 1).equals("!")) {//if the character ! is detected, then from one after the previous character to before this character is the second parameter of the pc's component
                curpos = i;
                par2 = string.substring(prevpos + 1, curpos);
                prevpos = curpos;

            } else if (string.substring(i, i + 1).equals("@")) {//if the character @ is detected, then from one after the previous character to before this character is the third parameter of the pc's component
                curpos = i;
                par3 = string.substring(prevpos + 1, curpos);
                prevpos = curpos;

            } else if (string.substring(i, i + 1).equals("#")) {//if the character # is detected, then from one after the previous character to before this character is the fourth parameter of the pc's component
                curpos = i;
                par4 = string.substring(prevpos + 1, curpos);
                prevpos = curpos;

            } else if (string.substring(i, i + 1).equals("$")) {//if the character $ is detected, then from one after the previous character to before this character is the fifth parameter of the pc's component
                curpos = i;
                par5 = string.substring(prevpos + 1, curpos);
                prevpos = curpos;

            } else if (string.substring(i, i + 1).equals("%")) {//if the character % is detected, then from one after the previous character to before this character is the sixth parameter of the pc's component
                curpos = i;
                par6 = string.substring(prevpos + 1, curpos);
                prevpos = curpos;

            } else if (string.substring(i, i + 1).equals("^")) {//if the character ^ is detected, then from one after the previous character to before this character is the sixth parameter of the pc's component
                curpos = i;
                par7 = string.substring(prevpos + 1, curpos);
                prevpos = curpos;

            } else if (string.substring(i, i + 1).equals("&")) {//if the character & is detected, then from one after the previous character to before this character is the seventh parameter of the pc's component
                curpos = i;
                par8 = string.substring(prevpos + 1, curpos);
                prevpos = curpos;

            } else if (string.substring(i, i + 1).equals("*")) {//if the character * is detected, then from one after the previous character to before this character is the eighth parameter of the pc's component
                curpos = i;
                par9 = string.substring(prevpos + 1, curpos);
                prevpos = curpos;

            } else if (string.substring(i, i + 1).equals(">")) {//if the character > is detected, then from one after the previous character to before this character is the ninth parameter of the pc's component
                curpos = i;
                par10 = string.substring(prevpos + 1, curpos);
                prevpos = curpos;

            } else if (string.substring(i ,i+1).equals("}")) {//if the character } is detected, then from one after the previous character to before this character is the tenth parameter of the pc's component
                curpos = i ;
                par11 = string.substring(prevpos + 1, curpos);
                prevpos = curpos;
            }else if (string.substring(i,i+1).equals("{")){//if the character { is detected, then from one after the previous character to before this character is the eleventh parameter of the pc's component
                curpos=i;
                par12= string.substring(prevpos+1,curpos);
            }
        }
            switch (identifier) { //this switch statement identifies the type of component, and properly add it to the computer arraylist
                case "CPU": //if component is cpu then the item added to the arraylist will be a cpu
                    computer.add(new CPU(Double.parseDouble(par1), par2, par3, Double.parseDouble(par4), Double.parseDouble(par5), par6, par7, Integer.parseInt(par8), par9,Double.parseDouble(par10), Double.parseDouble(par11),par12));
                    break;
                case "MOBO": // if it's a mobo then it will add a mobo
                    computer.add(new Mobo(Double.parseDouble(par1), par2, par3, par4, Double.parseDouble(par5), par6));
                    break;
                case "RAM":// if it ram then the program will add ram to the arraylist
                    computer.add(new Ram(Double.parseDouble(par1), par2, par3, par4, Integer.parseInt(par5), par6, par7, par8, Double.parseDouble(par9), par10));
                    break;
                case "GPU"://so on...
                    computer.add(new Gpu(Double.parseDouble(par1), par2, par3, par4, par5, Integer.parseInt(par6), par7, par8,Integer.parseInt(par9), Double.parseDouble(par10), par11));
                    break;
                case "SSD":
                    computer.add(new Storage(Double.parseDouble(par1), par2, par3, par4, par5, par6, par7, par8, Double.parseDouble(par9), par10));
                    break;
                case "PSU":
                    computer.add(new Psu(Double.parseDouble(par1), par2, par3, Integer.parseInt(par4), par5, par6, Double.parseDouble(par7), par8));
                    break;
                case "CASE":
                    computer.add(new Case(Double.parseDouble(par1), par2, par3, par4));
                    break;

        }
    }
}


