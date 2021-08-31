package Computer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Case extends Computer{ //this is the case class it extends computer
    private double price;

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public String getManu() {
        return manu;
    }

    public String getPhotoid() {
        return photoid;
    }

    private String name;
    private String manu;
    private String photoid;

    public Case(double price, String name, String manu, String photoid){ //this is the constructor for the case
        //it takes in the parameters and creates the object case with it
        this.price=price;
        this.name=name;
        this.manu=manu;
        this.photoid=photoid;
    }
    public void writetofile(String txtfilename) throws IOException { //this write to file methode overrides the writetofile in computer.And it writes the case portion of computer
        FileWriter fw = new FileWriter(txtfilename,true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write("CASE+"); //this is the identifier for when the pc's components get loaded back
        bw.write(price +"<\r"); //this writes the case's price onto the file with the symbol < to identify it as the first parameter for case
        bw.write(name +"!\r"); //this is similar, except the symbol identifies it as the second parameter
        bw.write(manu +"@\r"); //the symbol identifies it as the third parameter
        bw.write(photoid+"#\r");
        bw.write("?\r");
        bw.close();

    }

    @Override
    public String toString() {
        return name+" $"+price;
    } //this is the return methode, it returns name and price
}
